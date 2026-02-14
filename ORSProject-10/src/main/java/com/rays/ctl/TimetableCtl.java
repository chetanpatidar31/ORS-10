package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;
import com.rays.dto.TimetableDTO;
import com.rays.form.TimetableForm;
import com.rays.service.CourseServiceInt;
import com.rays.service.SubjectServiceInt;
import com.rays.service.TimetableServiceInt;

@RestController
@RequestMapping("Timetable")
public class TimetableCtl extends BaseCtl<TimetableForm, TimetableDTO, TimetableServiceInt> {

	@Autowired
	CourseServiceInt courseService;

	@Autowired
	SubjectServiceInt subjectService;

	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse resp = new ORSResponse(true);

		List<DropdownList> courseList = courseService.search(new CourseDTO(), userContext);
		resp.addResult("courseList", courseList);

		List<DropdownList> subjectList = subjectService.search(new SubjectDTO(), userContext);
		resp.addResult("subjectList", subjectList);

		return resp;

	}

}
