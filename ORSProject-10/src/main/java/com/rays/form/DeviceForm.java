package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.DeviceDTO;

public class DeviceForm extends BaseForm {

	@NotEmpty(message = "Device Name is required")
	private String name;

	@NotEmpty(message = "Device Type is required")
	private String type;

	@NotEmpty(message = "Operating System is required")
	private String operatingSystem;

	@NotNull(message = "active is required")
	private Boolean active;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	@Override
	public BaseDTO getDTO() {

		DeviceDTO dto = initDTO(new DeviceDTO());

		dto.setName(name);
		dto.setType(type);
		dto.setOperatingSystem(operatingSystem);
		dto.setActive(active);

		return dto;
	}

}
