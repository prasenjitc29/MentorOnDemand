package com.mentorondemand.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.mentorondemand.training.domain.Course;
import com.mentorondemand.training.dto.CourseDTO;
import com.mentorondemand.training.dto.CourseIndexDTO;
import com.mentorondemand.training.feign.SearchFeign;
import com.mentorondemand.training.mapping.CourseMapper;
import com.mentorondemand.training.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	private static final String SEARCH_SERVICE = "http://localhost:9090/api/search/courses";

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private SearchFeign searchFeign;

	public CourseDTO createCourse(CourseDTO courseDTO) {
		Course course = courseMapper.courseDtoToCourse(courseDTO);
		course = courseRepository.save(course);
		indexCourse(course);
		return courseMapper.courseToCourseDto(course);
	}

	@Async
	private  void indexCourse(Course course)
	{
		try {
			CourseIndexDTO courseIndexDTO = new CourseIndexDTO();
			courseIndexDTO.setCouseId(course.getId().toString());
			courseIndexDTO.setCourseName(course.getCourseName());
			courseIndexDTO.setStudentFee(course.getStudentFee());
			courseIndexDTO.setMentorShare(course.getMentorShare());
			courseIndexDTO.setBatchName(batchService.getBatch(course.getBatchId()).getBatchName());
			courseIndexDTO.setSkillName(skillService.getSkill(course.getSkillId()).getSkillName());
			courseIndexDTO.setBatchId(course.getBatchId());
			courseIndexDTO.setSkillId(course.getSkillId());
			searchFeign.updateCourseSearch(courseIndexDTO);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public CourseDTO updateCourse(CourseDTO courseDTO) {
		Course course = courseMapper.courseDtoToCourse(courseDTO);
		course = courseRepository.save(course);
		indexCourse(course);
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
		deleteCourseIndex(courseId);
	}
	
	@Async
	public void deleteCourseIndex(Integer courseId) {
		searchFeign.deleteCourse(courseId.toString());
		
	}

}
