package com.mentorondemand.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mentorondemand.admin.domain.Course;
import com.mentorondemand.admin.dto.CourseDTO;
import com.mentorondemand.admin.dto.CourseIndexDTO;
import com.mentorondemand.admin.mapping.CourseMapper;
import com.mentorondemand.admin.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	private static final String SEARCH_SERVICE = "http://localhost:9090/courses";

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private SkillService skillService;

	public CourseDTO createCourse(CourseDTO courseDTO) {
		Course course = courseMapper.courseDtoToCourse(courseDTO);
		course = courseRepository.save(course);
		indexCourse(course);
		return courseMapper.courseToCourseDto(course);
	}

	@Async
	private  void indexCourse(Course course)
	{
		CourseIndexDTO courseIndexDTO = new CourseIndexDTO();
		courseIndexDTO.setCouseId(course.getId().toString());
		courseIndexDTO.setCourseName(course.getCourseName());
		courseIndexDTO.setStudentFee(course.getStudentFee());
		courseIndexDTO.setMentorShare(course.getMentorShare());
		//BatchDTO batch= batchService.getBatch(course.getBatchId());
		//SkillDTO skill= skillService.getSkill(course.getSkillId());
		courseIndexDTO.setBatchId(course.getBatchId());
		//courseIndexDTO.setBatchName(batch.getBatchName());
		courseIndexDTO.setSkillId(course.getSkillId());
		//courseIndexDTO.setSkillName(skill.getSkillName());
	    restTemplate.postForObject( SEARCH_SERVICE, courseIndexDTO, ResponseEntity.class);
	 
	}

	public CourseDTO updateCourse(CourseDTO courseDTO) {
		Course course = courseMapper.courseDtoToCourse(courseDTO);
		course = courseRepository.save(course);
		return courseMapper.courseToCourseDto(course);
	}

	public CourseDTO getCourse(Integer courseId) {
		Course course = courseRepository.findById(courseId);
		return courseMapper.courseToCourseDto(course);
	}

	public List<CourseDTO> getCourses() {
		List<Course> courses = courseRepository.findAll();
		return courseMapper.courseToCourseDtos(courses);
	}

	public void deleteCourse(Integer courseId) {
		Course course = courseRepository.findById(courseId);
		courseRepository.delete(course);
		
	}

}
