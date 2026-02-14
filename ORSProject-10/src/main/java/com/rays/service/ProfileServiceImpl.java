package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ProfileDAOInt;
import com.rays.dto.ProfileDTO;

@Service
@Transactional
public class ProfileServiceImpl extends BaseServiceImpl<ProfileDTO, ProfileDAOInt> implements ProfileServiceInt{

}
