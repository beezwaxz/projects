package test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class FindTheFactors {
	private static final int MAX_RANGE = 1000;
	private static final int MIN_RANGE = 0;
	
	public static void main(String[] args) {
		
		InputStreamReader cin = new InputStreamReader( System.in );		
		BufferedReader reader = new BufferedReader( cin );
		Set<Integer> factors = null;
		int userNumber = -1;
		while ( userNumber != 0 )
		{
			userNumber = getNumberFromUser( reader );
			if ( userNumber > MIN_RANGE ) {
				try {
					factors = getFactorsForNumber(userNumber );
					if ( factors != null)
					{
						if ( !factors.isEmpty()) {
							System.out.printf("The factors for the number %d are:\n", userNumber);
							for( Integer factor:factors ) {
								System.out.printf("%d\n", factor);
							}
						} else {
							System.out.printf("The number %d is prime", userNumber);
						}
					}					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.print("Thanks for playing!\n");
	}

	private static Set<Integer> getFactorsForNumber(int userNumber) throws Exception {
		Set<Integer> factors = new HashSet<Integer>();
		int maxVal = userNumber; 
		for( int i=2; i < maxVal; i++ ) {
			if ( userNumber % i == 0 )
			{
				Set<Integer> childFactors = getFactorsForNumber(i);
				if ( childFactors.isEmpty()) {
					factors.add(i);
				}
			}
		}
		
		return factors;
	}

	private static int getNumberFromUser( BufferedReader reader ) {
		
		System.out.printf("\nGive me a number\n",  new Object());
		int retVal = -1;
		
		try {
			String input = reader.readLine();
			retVal = validateUserInput(input);
		} catch (IOException e) {
			e.printStackTrace();
			retVal= 0;
		}
					
		return retVal;
	}

	private static int validateUserInput(String input ) {
		int retVal = -1;
		try {
			retVal = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			retVal = 0;
		}

		if ( retVal > MAX_RANGE || retVal < MIN_RANGE ) {
			System.out.printf("The number %d is out of the accepted range (0-100)", retVal );
			retVal = 0;
		}
		return retVal;
	}
}
