package org.testing.Utility;

import org.json.JSONObject;

public class JsonParsing {

	public static String parseJson(String data, String keyName)//method to parse json
	{
	  JSONObject ob = new JSONObject();
	  return ob.get(keyName).toString();
	}

}
