package com.rays.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_profile")
public class ProfileDTO extends BaseDTO {

	@Column(name = "full_name", length = 50)
	private String fullName;

	@Column(name = "gender", length = 50)
	private String gender;

	@Column(name = "dob", length = 50)
	private LocalDate dob;

	@Column(name = "profile_status", length = 50)
	private String profileStatus;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getProfileStatus() {
		return profileStatus;
	}

	public void setProfileStatus(String profileStatus) {
		this.profileStatus = profileStatus;
	}

	@Override
	public String getValue() {
		return fullName;
	}

	@Override
	public String getUniqueKey() {
		return "fullName";
	}

	@Override
	public String getUniqueValue() {
		return fullName;
	}

	@Override
	public String getLabel() {
		return "Name";
	}

	@Override
	public String getTableName() {
		return "Profile";
	}

}
