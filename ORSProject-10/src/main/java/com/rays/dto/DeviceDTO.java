package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO; 

@Entity
@Table(name = "st_device")
public class DeviceDTO extends BaseDTO {

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "type", length = 50)
	private String type;

	@Column(name = "operating_system", length = 50)
	private String operatingSystem;
	
	@Column(name = "active")
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
	public String getValue() {
		return name;
	}

	@Override
	public String getUniqueKey() {
		return "name";
	}

	@Override
	public String getUniqueValue() {
		return name;
	}

	@Override
	public String getLabel() {
		return "Device Name";
	}

	@Override
	public String getTableName() {
		return "Device";
	}

}
