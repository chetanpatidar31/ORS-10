package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.DeviceDAOInt;
import com.rays.dto.DeviceDTO;

@Service
@Transactional
public class DeviceServiceImpl extends BaseServiceImpl<DeviceDTO, DeviceDAOInt> implements DeviceServiceInt {

}
