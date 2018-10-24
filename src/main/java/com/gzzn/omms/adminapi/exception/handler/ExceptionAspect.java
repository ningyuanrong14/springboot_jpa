package com.gzzn.omms.adminapi.exception.handler;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzzn.omms.adminapi.utils.JsonUtil;

@Aspect
@Component
public class ExceptionAspect {
	private final static Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);

    @Pointcut("execution(public * com.gzzn.zdgov.controller.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        ContentCachingRequestWrapper wrapperRequest = new ContentCachingRequestWrapper(request);
      
        MDC.clear();
        MDC.put("request_id", getRequestId(request));
        
        //url
        try {
			logger.info("request={url={},method={},content_type={},body={},params={},remoteip={}}",
					request.getRequestURL(),
					request.getMethod(),
					request.getContentType(),
					JsonUtil.getString(joinPoint.getArgs()),
					getRequestParams(wrapperRequest),
					request.getRemoteAddr()
					);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

  
    @AfterReturning(pointcut = "log()",returning = "object")//打印输出结果
    public void doAfterReturing(Object object){
       ObjectMapper objectMapper = new ObjectMapper();
       String jsonStr;
		try 
		{
			jsonStr = objectMapper.writeValueAsString(object);
		} 
		catch (JsonProcessingException e) 
		{
			jsonStr = "[unknown]";
		}
        		
        logger.info("response={}",jsonStr);
    }
    
    /**
     * 
     * @param response
     */
    private String getResponseBody(ContentCachingResponseWrapper response) {
        ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        if(wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if(buf.length > 0) {
                String payload;
                try {
                    payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
                } catch (UnsupportedEncodingException e) {
                    payload = "[unknown]";
                }
                return payload;
            }
        }
        return "";
    }
    
    /**
     * 打印请求参数
     * @param request
     */
    private String getRequestBody(ContentCachingRequestWrapper request) {
        ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
        if(wrapper != null) {
            byte[] buf = wrapper.getContentAsByteArray();
            if(buf.length > 0) {
                String payload;
                try {
                    payload = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
                } catch (UnsupportedEncodingException e) {
                    payload = "[unknown]";
                }
                return payload.replaceAll("\\n","");
            }
        }
        return "";
    }



    /**
     * 获取请求地址上的参数
     * @param request
     * @return
     */
    public static String getRequestParams(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Enumeration<String> enu = request.getParameterNames();
        //获取请求参数
        while (enu.hasMoreElements()) {
            String name = enu.nextElement();
            sb.append(name + "=").append(request.getParameter(name));
            if(enu.hasMoreElements()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
    
    
    private String getRequestId(HttpServletRequest request) 
    { 
        String requestId = null; 
        String parameterRequestId = request.getParameter("requestId"); 
        String headerRequestId = request.getHeader("requestId");
        if (parameterRequestId == null && headerRequestId == null) 
        { 
          requestId = UUID.randomUUID().toString(); 
        }
        else
        { 
            requestId = parameterRequestId != null ? parameterRequestId : headerRequestId; 
        } 

        return requestId; 
    }
}
