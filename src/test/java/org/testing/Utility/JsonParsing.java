package org.testing.Utility;

import org.json.JSONObject;

public class JsonParsing {

	//method to parse json
	
	public static String parseJson(String data, String keyName)
	{
	  JSONObject ob = new JSONObject();
	  return ob.get(keyName).toString();
	}

}
