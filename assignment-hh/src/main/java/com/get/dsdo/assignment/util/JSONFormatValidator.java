package com.get.dsdo.assignment.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;


public class JSONFormatValidator {
	
	public static void ProcessUserInfoJSON(String passingJSON) throws Exception {
		
		JSONObject genreJsonObject = (JSONObject) JSONValue.parseWithException(passingJSON);
		EmailValidator emailValidator = new EmailValidator();
		
		// get the email
		String eMail = (String)genreJsonObject.get("EMail");
		System.out.println(eMail);
		
		boolean invalidEmail = emailValidator.validateEmail(eMail);
		
		if (!invalidEmail) {
			throw new Exception("Invalid emai!");
		}
		
		/**
		@SuppressWarnings("deprecation")
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(passingJSON);

        JSONObject jsonObject = (JSONObject) obj;
        System.out.println(jsonObject);

        String lastName = (String) jsonObject.get("Last_Name");
        System.out.println(lastName);
        
        String fistName = (String) jsonObject.get("First_Name");
        System.out.println(fistName);

        String email = (String) jsonObject.get("EMail");
        System.out.println(email);
        
        String phoneNumber = (String) jsonObject.get("Phone_Number");
        System.out.println(email);
        */
        
	}

}

