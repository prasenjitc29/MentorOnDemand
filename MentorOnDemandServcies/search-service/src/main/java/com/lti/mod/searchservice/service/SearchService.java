package com.lti.mod.searchservice.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Delete;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;
import io.searchbox.indices.CreateIndex;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.mod.searchservice.dto.CourseIndexDTO;
import com.lti.mod.searchservice.dto.CourseUpdateIndexDTO;
import com.lti.mod.searchservice.dto.TrainingEnrollmentDTO;
import com.lti.mod.searchservice.exception.IndexFailed;

@Service
public class SearchService {
	
	private static final String TYPE = "_doc";
	private static final String INDEX_NAME = "courses";
	@Autowired
	JestClient jestClient;

	public void createUpdateIndex(CourseIndexDTO course) throws Exception  {
			
			JestResult jestResult = 
					jestClient.execute(new Index.Builder(course).index(INDEX_NAME).type(TYPE).build());
			if (jestResult.isSucceeded()) {
			    System.out.println(jestResult);
			}
			else {
			    System.out.println("Error: " + jestResult.getErrorMessage());
			    throw new IndexFailed(jestResult.getErrorMessage());
			}

	}
	
	public List<CourseIndexDTO> getAllCourses() throws Exception  {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.size(10000);
//		searchSourceBuilder.query(QueryBuilders.matchQuery("user", "kimchy"));
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		Search search = new Search.Builder(searchSourceBuilder.toString())
		                                .addIndex(INDEX_NAME)
		                                .addType(TYPE)
		                                .build();

		SearchResult result = jestClient.execute(search);
		return result.getHits(CourseIndexDTO.class)
					.stream()
					.map(hit -> hit.source)
					.collect(Collectors.toList());

	}
	
	public void updateTraineeDetails(CourseUpdateIndexDTO course) throws Exception  {
		
		CourseIndexDTO oldCourse = getCourseById(course.getCourseId());
		
		List<TrainingEnrollmentDTO> trainees = oldCourse.getTrainees();
		
		if(trainees!=null) {
			trainees.add(course.getTrainee());
		}else {
			trainees=new ArrayList<TrainingEnrollmentDTO>();
			trainees.add(course.getTrainee());
		}
		oldCourse.setTrainees(trainees);
		
		createUpdateIndex(oldCourse);

}
	
	public CourseIndexDTO getCourseById(String id) throws Exception  {
		Get get = new Get.Builder(INDEX_NAME, id).type(TYPE).build();

		JestResult result = jestClient.execute(get);

		return result.getSourceAsObject(CourseIndexDTO.class);
	}
	
	
	public void createIndexSetup(String corename) throws IOException {
		JestResult jestResult = 
		jestClient.execute(new CreateIndex.Builder(corename).build());
		if (jestResult.isSucceeded()) {
		    System.out.println("Success!");
		}
		else {
		    System.out.println("Error: " + jestResult.getErrorMessage());
		    throw new IndexFailed(jestResult.getErrorMessage());
		}

	}
	
	public void deleteIndex(String id) throws IOException{
		JestResult jestResult = jestClient.execute(new Delete.Builder(id).index(INDEX_NAME).type(TYPE).build());
		 System.out.println(jestResult);
		if (jestResult.isSucceeded()) {
		    System.out.println("Success!");
		}
		else {
			 throw new IndexFailed(jestResult.getErrorMessage());
		}
	}

}
