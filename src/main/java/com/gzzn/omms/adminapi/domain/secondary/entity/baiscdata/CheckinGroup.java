package com.gzzn.omms.adminapi.domain.secondary.entity.baiscdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 值机岛
 * @author zhouxiunai
 *
 */
@Entity
@Table(name="ORMS_CHECKIN_GROUP")
public class CheckinGroup {

	@Id
	@Column(name = "CHECKIN_GROUP_CODE")
	private String checkinGroupCode; //航站楼代码
	
	

	@Column(name = "CHECKIN_GROUP_NAME")
	private String checkinGroupName; //航站楼名称
	
	public String getCheckinGroupCode() {
		return checkinGroupCode;
	}


	public void setCheckinGroupCode(String checkinGroupCode) {
		this.checkinGroupCode = checkinGroupCode;
	}


	public String getCheckinGroupName() {
		return checkinGroupName;
	}


	public void setCheckinGroupName(String checkinGroupName) {
		this.checkinGroupName = checkinGroupName;
	}
}
