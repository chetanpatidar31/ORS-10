package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TimetableDTO;

public class TimetableForm extends BaseForm {

	@NotNull(message = "Course is required")
	@Min(1)
	private Long courseId = 0L;

	@NotNull(message = "Subject is required")
	@Min(1)
	private Long subjectId = 0L;

	@NotNull(message = "Exam Date is required")
	private Date examDate;

	@NotEmpty(message = "Exam Time is required")
	private String examTime;

	@NotEmpty(message = "Semester is required")
	private String semester;

	@NotEmpty(message = "Description is required")
	private String description;

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public BaseDTO getDTO() {

		TimetableDTO dto = initDTO(new TimetableDTO());
		dto.setCourseId(courseId);
		dto.setSubjectId(subjectId);
		dto.setExamDate(examDate);
		dto.setExamTime(examTime);
		dto.setSemester(semester);
		dto.setDescription(description);

		return dto;
	}
}
