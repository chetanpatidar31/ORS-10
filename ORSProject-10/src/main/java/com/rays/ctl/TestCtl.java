package com.rays.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;

@RestController
@RequestMapping(value = "Test")
public class TestCtl {

	@GetMapping("add")
	public ORSResponse testAdd() {

		ORSResponse resp = new ORSResponse();

		resp.addInputError("Input Error");
		resp.addData("Some object data");
		resp.addMessage("ORSResponse run successfully");
		resp.addResult("Custom Key", "Custom Response");

		return resp;
	}
}
