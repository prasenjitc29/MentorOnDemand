package com.mentorondemand.mentor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mentorondemand.mentor.domain.MentorTraining;
import com.mentorondemand.mentor.dto.CourseIndexDTO;
import com.mentorondemand.mentor.dto.MentorTrainingDTO;
import com.mentorondemand.mentor.dto.StudentTrainingDTO;
import com.mentorondemand.mentor.feign.StudentFeign;
import com.mentorondemand.mentor.mapper.MentorTraingMapper;
import com.mentorondemand.mentor.repository.MentorTrainingRepository;

@Component
public class MentorServiceImpl implements MentorService{
	
	private static final String SEARCH_SERVICE = "http://localhost:9090/courses";
	
	@Autowired
	private MentorTrainingRepository repository;
	
	@Autowired
	private MentorTraingMapper mapper;
	
	@Autowired
	private StudentFeign studentFeign;
	
	@Autowired
	RestTemplate restTemplate;
	

	public MentorTrainingDTO createMentorTraining(MentorTrainingDTO trainingDto) {
		MentorTraining training = mapper.dtoToTraining(trainingDto);
		training = repository.save(training);
		indexCourse(training);
		System.out.println(training);
		return mapper.trainigToDto(training);
	}
	
	@Async
	private  void indexCourse(MentorTraining training)
	{
		CourseIndexDTO courseIndexDTO = new CourseIndexDTO();
		courseIndexDTO.setCouseId(training.getCourseId().toString());
		courseIndexDTO.setUserName(training.getUserId().toString());
//		courseIndexDTO.setMentorName(mentorName);
	    restTemplate.postForObject( SEARCH_SERVICE, courseIndexDTO, ResponseEntity.class);
	 
	}

	public MentorTrainingDTO updateMentorTraining(MentorTrainingDTO trainingDto) {
		MentorTraining training = mapper.dtoToTraining(trainingDto);
		training = repository.save(training);
		return mapper.trainigToDto(training);
	}

	public MentorTrainingDTO getMentorTraining(Integer id) {
		MentorTraining training = repository.findById(id);
		return mapper.trainigToDto(training);
	}

	public List<MentorTrainingDTO> getMentorTrainings(String status) {
		List<MentorTraining> trainings = repository.findByCourseStatus(status);
		return null;
	}

	public List<StudentTrainingDTO> getApprovalTraining(Integer userId) {
		List<StudentTrainingDTO> trainings = studentFeign.getPendingApprovals("Proposed",userId);
		return trainings;
	}
	
}
