package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ProfileDTO;

@Repository
public class ProfileDAOImpl extends BaseDAOImpl<ProfileDTO> implements ProfileDAOInt {

	@Override
	public Class<ProfileDTO> getDTOClass() {
		return ProfileDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ProfileDTO dto, CriteriaBuilder builder, Root<ProfileDTO> qRoot) {
		List<Predicate> whereConditon = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getFullName())) {
			whereConditon.add(builder.like(qRoot.get("fullName"), dto.getFullName() + "%"));
		}

		if (!isEmptyString(dto.getGender())) {
			whereConditon.add(builder.like(qRoot.get("gender"), dto.getGender() + "%"));
		}

		if (isNotNull(dto.getDob())) {
			whereConditon.add(builder.equal(qRoot.get("dob"), dto.getDob()));
		}

		if (!isEmptyString(dto.getFullName())) {
			whereConditon.add(builder.like(qRoot.get("fullName"), dto.getFullName() + "%"));
		}
		return whereConditon;
	}

}
