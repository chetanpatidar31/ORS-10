package com.rays.dto;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_slot")
public class SlotDTO extends BaseDTO {
	
	@Column(name = "slot_code")
	private String slotCode;
	
	@Column(name = "start_time")
	private LocalTime startTime;
	
	@Column(name = "end_time")
	private LocalTime endTime;
	
	@Column(name = "status")
	private String status;
	
	

	public String getSlotCode() {
		return slotCode;
	}

	public void setSlotCode(String slotCode) {
		this.slotCode = slotCode;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getValue() {
		return slotCode;
	}

	@Override
	public String getUniqueKey() {
		return "slotCode";
	}

	@Override
	public String getUniqueValue() {
		return slotCode;
	}

	@Override
	public String getLabel() {
		return "Slot Code";
	}

	@Override
	public String getTableName() {
		return "Slot";
	}

}
