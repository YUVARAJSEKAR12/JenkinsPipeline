package com.app.pojo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


public class UEXE {
	
	public static void main(String[] args) {
		try {
		ObjectMapper mapper = new ObjectMapper();
	     
			
				 User user = mapper.readValue(new File("C:\\Users\\HP\\eclipse-workspace\\Develop\\new\\new\\oct\\API_Cucumber"
						+ "\\src\\test\\resources\\Payload\\user.json"), User.class);
				 System.out.println(user.getId());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	       
	}

}
