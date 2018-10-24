package com.gzzn.omms.adminapi.controller.basicdata;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzzn.omms.adminapi.domain.secondary.dao.basicdata.OrmsTerminalDao;
import com.gzzn.omms.adminapi.domain.secondary.entity.baiscdata.OrmsTerminal;
import com.gzzn.omms.adminapi.dto.ResponseDto;

/**
 * 航站楼
 * @author nyr
 * @date 18-10-23
 *
 */
@RestController
public class OrmsTerminalController {
	
	/**
	 * 航站楼接口
	 */
	@Autowired
	private OrmsTerminalDao ormsTerminalDao;
	
	/**
	 * 获取所有航站楼数据
	 * @return
	 */
	@GetMapping(value="/basicdata/ormsTerminals")
	public ResponseDto getOrmsTerminal() {
		List<OrmsTerminal> ormsTerminalslist = (List<OrmsTerminal>) ormsTerminalDao.findAll();
		return ResponseDto.success(ormsTerminalslist);
	}
}
