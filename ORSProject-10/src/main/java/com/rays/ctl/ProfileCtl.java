package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.ProfileDTO;
import com.rays.form.ProfileForm;
import com.rays.service.ProfileServiceInt;

@RestController
@RequestMapping(value = "Profile")
public class ProfileCtl extends BaseCtl<ProfileForm, ProfileDTO, ProfileServiceInt>{

}
