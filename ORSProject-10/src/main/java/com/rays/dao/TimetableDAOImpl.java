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
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.dto.TimetableDTO;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;

@Repository
public class TimetableDAOImpl extends BaseDAOImpl<TimetableDTO> implements TimetableDAOInt {

	@Autowired
	SubjectServiceInt subjectService;

	@Autowired
	CourseServiceInt courseService;

	@Override
	public Class<TimetableDTO> getDTOClass() {
		return TimetableDTO.class;
	}

	@Override
	protected void populate(TimetableDTO dto, UserContext userContext) {

		SubjectDTO subjectDto = subjectService.findById(dto.getSubjectId(), userContext);
		if (subjectDto != null) {
			dto.setSubjectName(subjectDto.getName());
		}

		CourseDTO courseDto = courseService.findById(dto.getCourseId(), userContext);
		if (courseDto != null) {
			dto.setCourseName(courseDto.getName());
		}
	}

	@Override
	protected List<Predicate> getWhereClause(TimetableDTO dto, CriteriaBuilder builder, Root<TimetableDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getSubjectName())) {

			whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName() + "%"));
		}
		if (!isEmptyString(dto.getCourseName())) {

			whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));
		}
		return whereCondition;
	}

}
