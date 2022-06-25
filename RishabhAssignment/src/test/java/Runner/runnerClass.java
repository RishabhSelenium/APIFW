package Runner;

import java.io.IOException;

import org.testing.TestScript.TestCases;

public class runnerClass {

	public static void main(String[] args) throws IOException {
		TestCases tc = new TestCases();
		tc.userFieldsMissing();
	}

}
