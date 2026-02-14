package com.rays.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ProfileDTO;

public class ProfileForm extends BaseForm {

	@NotEmpty(message = "Full Name is required")
	private String fullName;

	@NotEmpty(message = "Gender is required")
	private String gender;

	@NotNull(message = "DOB is required")
	private LocalDate dob;

	@NotEmpty(message = "Profile Status is required")
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
	public BaseDTO getDTO() {
		ProfileDTO dto = initDTO(new ProfileDTO());

		dto.setFullName(fullName);
		dto.setGender(gender);
		dto.setDob(dob);
		dto.setProfileStatus(profileStatus);

		return dto;
	}

}
