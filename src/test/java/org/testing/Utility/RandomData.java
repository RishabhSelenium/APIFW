package org.testing.Utility;

import java.util.Random;

public class RandomData {
	public static String randomvalue()
	{

		Random r = new Random();
		Integer i = r.nextInt();
		return i.toString();

	}


}