package com.gzzn.omms.adminapi.controller.basicdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzzn.omms.adminapi.domain.secondary.dao.basicdata.ICheckinGroupDao;
import com.gzzn.omms.adminapi.domain.secondary.entity.baiscdata.CheckinGroup;
import com.gzzn.omms.adminapi.dto.ResponseDto;

/**
 *  值机岛
 * @author zhouxiunai
 *
 */
@RestController
public class CheckinGroupController {

	
	@Autowired
	private ICheckinGroupDao checkinGroupDao;
	
	/**
	 * 获取所有值机岛数据
	 * @return
	 */
	@GetMapping(value="/basicdata/checkinGroups")
	public ResponseDto getCheckinGroup() {
		List<CheckinGroup> ls = (List<CheckinGroup>) checkinGroupDao.findAll();
		return ResponseDto.success(ls);
	}
}
