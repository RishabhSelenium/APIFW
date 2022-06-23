package org.testing.utilities;

import java.util.regex.Pattern;

public class JsonVariableReplacement {
	
	public static String jsonReplace(String Data, String VariableName, String VariableValue)
	{
		Data = Data.replaceAll(Pattern.quote("{{"+VariableName+"}}"), VariableValue);
		return Data;
	}

}
