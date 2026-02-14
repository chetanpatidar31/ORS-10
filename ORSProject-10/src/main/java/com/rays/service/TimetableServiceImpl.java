package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.TimetableDAOInt;
import com.rays.dto.TimetableDTO;

@Service
public class TimetableServiceImpl extends BaseServiceImpl<TimetableDTO, TimetableDAOInt> implements TimetableServiceInt{

}
