package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.CollegeDTO;
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;
import com.rays.service.CollegeServiceInt;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;

@Repository
public class FacultyDAOImpl extends BaseDAOImpl<FacultyDTO> implements FacultyDAOInt {

	@Autowired
	CollegeServiceInt collegeService;

	@Autowired
	CourseServiceInt courseService;

	@Autowired
	SubjectServiceInt subjectService;

	@Override
	public Class<FacultyDTO> getDTOClass() {
		return FacultyDTO.class;
	}

	@Override
	protected void populate(FacultyDTO dto, UserContext userContext) {

		if (dto.getCollegeId() > 0) {
			CollegeDTO collegeDTO = collegeService.findById(dto.getCollegeId(), userContext);
			dto.setCollegeName(collegeDTO.getName());
		}

		if (dto.getCourseId() > 0) {
			CourseDTO courseDTO = courseService.findById(dto.getCourseId(), userContext);
			dto.setCourseName(courseDTO.getName());
			;
		}

		if (dto.getSubjectId() > 0) {
			SubjectDTO subjectDTO = subjectService.findById(dto.getSubjectId(), userContext);
			dto.setSubjectName(subjectDTO.getName());
		}

	}

	@Override
	protected List<Predicate> getWhereClause(FacultyDTO dto, CriteriaBuilder builder, Root<FacultyDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getFirstName())) {
			whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
		}

		if (!isEmptyString(dto.getEmail())) {
			whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
		}

		if (!isEmptyString(dto.getCollegeName())) {
			whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
		}

		if (!isEmptyString(dto.getCourseName())) {
			whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
		}

		if (!isEmptyString(dto.getSubjectName())) {
			whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName() + "%"));
		}

		return whereCondition;

	}

}
