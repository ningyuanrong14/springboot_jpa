package com.gzzn.omms.adminapi.domain.secondary.entity.baiscdata;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * 登机门
 * @author nyr
 * @date 2018-10-23
 */
@Entity
@Table(name="ORMS_GATE")
@NamedQuery(name="OrmsGate.findAll", query="SELECT o FROM OrmsGate o")
public class OrmsGate  {
	
	@Id
	@SequenceGenerator(name="ORMS_GATE_GATECODE_GENERATOR", sequenceName="ORMS_GATE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORMS_GATE_GATECODE_GENERATOR")
	@Column(name="GATE_CODE")
	private String gateCode; //登机门代码

	@Column(name="ACTION_ORDER")
	private BigDecimal actionOrder;//资源使用序号

	@Column(name="GATE_CATEGORY")
	private String gateCategory;//I = International/国际;D = Domestic/国内

	@Column(name="GATE_NAME")
	private String gateName; //登机门名称

	@Column(name="GATE_STATUS")
	private BigDecimal gateStatus; //登机门状态（可用、在用、锁定、禁用、预分...）

	@Column(name="GATE_TYPE")
	private String gateType;//'0'-到港门，'1'-离港门，'2'-混合

	private String gtml;//航站楼代码

	@Column(name="ICON_LENGTH")
	private BigDecimal iconLength;//资源图标长度（单位：像素）

	@Column(name="ICON_WIDTH")
	private BigDecimal iconWidth;//资源图标宽度（单位：像素）

	private BigDecimal operate;

	@Column(name="PIER_CODE")
	private String pierCode;//指廊代码

	@Column(name="POS_X")
	private BigDecimal posX;//坐标位置的X值

	@Column(name="POS_Y")
	private BigDecimal posY;//坐标位置的Y值

	@Column(name="STAND_LAYOUTED")
	private BigDecimal standLayouted;//资源已布局标志 1-已布局 0-未布局

	@Column(name="TERMINAL_AREA_CODE")
	private String terminalAreaCode;//航站楼区域代码

	public OrmsGate() {
	}

	public String getGateCode() {
		return this.gateCode;
	}

	public void setGateCode(String gateCode) {
		this.gateCode = gateCode;
	}

	public BigDecimal getActionOrder() {
		return this.actionOrder;
	}

	public void setActionOrder(BigDecimal actionOrder) {
		this.actionOrder = actionOrder;
	}

	public String getGateCategory() {
		return this.gateCategory;
	}

	public void setGateCategory(String gateCategory) {
		this.gateCategory = gateCategory;
	}

	public String getGateName() {
		return this.gateName;
	}

	public void setGateName(String gateName) {
		this.gateName = gateName;
	}

	public BigDecimal getGateStatus() {
		return this.gateStatus;
	}

	public void setGateStatus(BigDecimal gateStatus) {
		this.gateStatus = gateStatus;
	}

	public String getGateType() {
		return this.gateType;
	}

	public void setGateType(String gateType) {
		this.gateType = gateType;
	}

	public String getGtml() {
		return this.gtml;
	}

	public void setGtml(String gtml) {
		this.gtml = gtml;
	}

	public BigDecimal getIconLength() {
		return this.iconLength;
	}

	public void setIconLength(BigDecimal iconLength) {
		this.iconLength = iconLength;
	}

	public BigDecimal getIconWidth() {
		return this.iconWidth;
	}

	public void setIconWidth(BigDecimal iconWidth) {
		this.iconWidth = iconWidth;
	}

	public BigDecimal getOperate() {
		return this.operate;
	}

	public void setOperate(BigDecimal operate) {
		this.operate = operate;
	}

	public String getPierCode() {
		return this.pierCode;
	}

	public void setPierCode(String pierCode) {
		this.pierCode = pierCode;
	}

	public BigDecimal getPosX() {
		return this.posX;
	}

	public void setPosX(BigDecimal posX) {
		this.posX = posX;
	}

	public BigDecimal getPosY() {
		return this.posY;
	}

	public void setPosY(BigDecimal posY) {
		this.posY = posY;
	}

	public BigDecimal getStandLayouted() {
		return this.standLayouted;
	}

	public void setStandLayouted(BigDecimal standLayouted) {
		this.standLayouted = standLayouted;
	}

	public String getTerminalAreaCode() {
		return this.terminalAreaCode;
	}

	public void setTerminalAreaCode(String terminalAreaCode) {
		this.terminalAreaCode = terminalAreaCode;
	}

}