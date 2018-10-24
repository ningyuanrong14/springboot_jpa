package com.gzzn.omms.adminapi.domain.secondary.entity.baiscdata;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * 航站楼
 * @author nyr
 * @date 2018-10-23
 */
@Entity
@Table(name="ORMS_TERMINAL")
@NamedQuery(name="OrmsTerminal.findAll", query="SELECT o FROM OrmsTerminal o")
public class OrmsTerminal  {
	@Id
	@SequenceGenerator(name="ORMS_TERMINAL_TERMINALCODE_GENERATOR", sequenceName="ORMS_TERMINAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORMS_TERMINAL_TERMINALCODE_GENERATOR")
	@Column(name="TERMINAL_CODE")
	private String terminalCode;//航站楼代码

	private BigDecimal operate;//操作标识 1-使用    0-删除标识

	@Column(name="TERMINAL_NAME")
	private String terminalName;//航站楼名称

	public OrmsTerminal() {
	}

	public String getTerminalCode() {
		return this.terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	public BigDecimal getOperate() {
		return this.operate;
	}

	public void setOperate(BigDecimal operate) {
		this.operate = operate;
	}

	public String getTerminalName() {
		return this.terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

}