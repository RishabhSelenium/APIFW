package org.testing.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

public class LoadJsonFile {

	public static String handleJsonFile(String path) throws FileNotFoundException
	{
		File f = new File(path);
		FileReader fr = new FileReader(f);
		JSONTokener js = new JSONTokener(fr);
		JSONObject jb = new JSONObject(js);

		return jb.toString();
		}


}
