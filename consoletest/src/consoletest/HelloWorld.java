package consoletest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloWorld {
	public static void main(String[] args) {
		InputStreamReader cin = new InputStreamReader( System.in );		
		BufferedReader reader = new BufferedReader( cin );
		
		System.out.printf("Give me a number",  new Object());
		String input = null;
		try {
			input = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.printf("You entered the number '%s'", input);
	}
}
;