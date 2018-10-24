package com.gzzn.omms.adminapi.controller.basicdata;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gzzn.omms.adminapi.domain.secondary.dao.basicdata.OrmsGateDao;
import com.gzzn.omms.adminapi.domain.secondary.entity.baiscdata.OrmsGate;
import com.gzzn.omms.adminapi.dto.ResponseDto;

/**
 * 登机门
 * @author nyr
 */
@RestController
public class OrmsGateController {

	/**
	 * 登机门接口
	 */
	@Autowired
	private OrmsGateDao ormsGateDao;
	
	/**
	 * 获取所有登机门数据
	 * @return
	 */
	@GetMapping(value="/basicdata/ormsGates")
	public ResponseDto getOrmsGate() {
		List<OrmsGate> ormsGatelist = (List<OrmsGate>) ormsGateDao.findAll();
		return ResponseDto.success(ormsGatelist);		
	}
}
