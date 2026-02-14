package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.DeviceDTO;
import com.rays.form.DeviceForm;
import com.rays.service.DeviceServiceInt;

@RestController
@RequestMapping(value = "Device")
public class DeviceCtl extends BaseCtl<DeviceForm, DeviceDTO, DeviceServiceInt> {

}
