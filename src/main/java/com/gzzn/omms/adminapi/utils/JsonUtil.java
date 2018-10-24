package com.gzzn.omms.adminapi.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonUtil {
  public static String getString(Object object) throws JsonProcessingException
  {
	  ObjectMapper mapper = new ObjectMapper();
      ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
      java.lang.String jsonStr = ow.writeValueAsString(object);
      
      return jsonStr;
  }
  
  
  public static <T>  T getObject(String str,Class<T> valueType) throws JsonParseException, JsonMappingException, IOException
  {
	  ObjectMapper mapper = new ObjectMapper();
	  T obj = mapper.readValue(str, valueType);
	  
	  return obj;
  }
}
