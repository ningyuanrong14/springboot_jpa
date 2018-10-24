package com.gzzn.omms.adminapi.exception.handler;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzzn.omms.adminapi.dto.ResponseDto;
import com.gzzn.omms.adminapi.enums.ResultCode;



@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
	 
	
	
	
	
	/**
	 * 通用未知异常捕获处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseDto exceptionHandle(Exception e)
	{
		logger.error("[未知系统异常]",e);
		
		String reponseErrMsg = "";
		String requestId = (String) MDC.get("request_id");
        String errorMessage = e.getMessage();
        if(errorMessage!=null)
        {
        	reponseErrMsg = "requestId:"+requestId + ",errorMsg:" + errorMessage;
        }
        else
        {
        	reponseErrMsg = "requestId:"+requestId + ",errorMsg:null";
        }
        
		return ResponseDto.failure(ResultCode.SYSTEM_INNER_ERROR,reponseErrMsg);
	}
}
