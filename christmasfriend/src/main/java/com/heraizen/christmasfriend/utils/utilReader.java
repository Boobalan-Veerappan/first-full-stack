package com.heraizen.christmasfriend.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heraizen.christmasfriend.domain.X_masDetails;




public class utilReader {

	static List<X_masDetails> result = new ArrayList<>();
	private static final String fileNmae = "FriendsDetails.json";
	
	
	  utilReader() throws JsonParseException, JsonMappingException, IOException
	{
		 
		
		
		
	}
	
	  public static List<X_masDetails> loaderclass() throws Exception
	  {
		  
		  ObjectMapper obj = new ObjectMapper();
			result = obj.readValue(new File(System.getProperty("java.io.tmpdir")+"/upload/"+fileNmae),
					new TypeReference<List<X_masDetails>>() {
					});
			
			System.out.println("datas"+result);
		  return result;
	  }
	
}
