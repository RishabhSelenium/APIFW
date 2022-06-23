package org.testing.utilities;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParsingUsingOrgJson {

	public static String parseJason(String data, String KeyName)
	{
	
		JSONObject ob = new JSONObject(data);
		return ob.get(KeyName).toString();
				
	}
	public static void parseAllIds(String data,String keyName)
	{
		
	 JSONArray array = new JSONArray(data);
	 int L = array.length();
	 for(int i=0;i<L;i++)
	 {
		 JSONObject ob = array.getJSONObject(i);
		 System.out.println(ob.get(keyName));
	 }
		
	}
}
