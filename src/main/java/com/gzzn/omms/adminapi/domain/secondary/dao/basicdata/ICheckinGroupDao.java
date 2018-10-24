package com.gzzn.omms.adminapi.domain.secondary.dao.basicdata;

import org.springframework.data.repository.CrudRepository;

import com.gzzn.omms.adminapi.domain.secondary.entity.baiscdata.CheckinGroup;

public interface ICheckinGroupDao extends CrudRepository<CheckinGroup,String> {
   
}
