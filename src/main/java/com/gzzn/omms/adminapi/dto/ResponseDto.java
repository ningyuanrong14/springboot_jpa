package com.gzzn.omms.adminapi.dto;

import com.gzzn.omms.adminapi.enums.ResultCode;

/**
 * 
 * @author xiunai
 *
 * @date 2018年5月16日
 * 
 * 
 */
public class ResponseDto {
	private Boolean is_success; 
	private Integer err_code;
	private String err_msg;
	
	private Object body;
	
	public ResponseDto() {}

    public ResponseDto(Integer code, String msg) {
    	this.setIs_success(false);
        this.setErr_code(code);
        this.setErr_msg(msg);
    }

    public static ResponseDto success() {
    	ResponseDto result = new ResponseDto();
    	result.setIs_success(true);
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static ResponseDto success(Object data) {
    	ResponseDto result = new ResponseDto();
    	result.setIs_success(true);
        result.setResultCode(ResultCode.SUCCESS);
        result.setBody(data);
        return result;
    }

    public static ResponseDto failure(ResultCode resultCode) {
    	ResponseDto result = new ResponseDto();
    	result.setIs_success(false);
        result.setResultCode(resultCode);
        return result;
    }

    public static ResponseDto failure(ResultCode resultCode, Object data) {
    	ResponseDto result = new ResponseDto();
    	result.setIs_success(false);
        result.setResultCode(resultCode);
        result.setBody(data);
        return result;
    }

    public void setResultCode(ResultCode code) {
        this.setErr_code(code.code());
        this.setErr_msg(code.message());
    }

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public Boolean getIs_success() {
		return is_success;
	}

	public void setIs_success(Boolean is_success) {
		this.is_success = is_success;
	}

	public Integer getErr_code() {
		return err_code;
	}

	public void setErr_code(Integer err_code) {
		this.err_code = err_code;
	}

	public String getErr_msg() {
		return err_msg;
	}

	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}
}
