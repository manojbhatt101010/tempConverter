/*
Temperature converter from fahrenheit to celsius
and vice-versa
*/

import java.util.*;

class TempConverter {

	static char identifyUnit(String unit) {
		String f = "farnhtFARNHT";
		String c = "ccclsuCCCLSU";

		int countF = 0, countC = 0;
		for(int i = 0; i < unit.length(); i++) 
			for(int j = 0; j < 12; j++) 
				if(unit.charAt(i) == f.charAt(j)) {
					countF++;
					break;
				}
				else if(unit.charAt(i) == c.charAt(j)) {
					countC++;
					break;
				}

		if(countF > countC)
			return 'F';
		else if(countC > countF)
			return 'C';
		else
			return 'A';
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		System.out.print("\nEnter the Temperature: ");
		String temperature = read.next();

		int unitStartingIndex = temperature.length();
		for(int i = 0; i < temperature.length(); i++)
			if(!Character.isDigit(temperature.charAt(i))) {
				unitStartingIndex = i;
				break;
			}

		double temp = Double.parseDouble(temperature.substring(0, unitStartingIndex));
		String unit = temperature.substring(unitStartingIndex);

		if(unitStartingIndex == 0)
			System.out.println("\nNo value entered");

		else if(identifyUnit(unit) == 'F') {
			double converted = (temp - 32) * 5 / 9;
			System.out.println("\nEntered Temperature: " + temp + " \u00B0F");
			System.out.println("Temperature in Celsius: " + converted + " \u00B0C\n");
		}

		else if(identifyUnit(unit) == 'C') {
			double converted = (temp * 9 / 5) + 32;
			System.out.println("\nEntered Temperature: " + temp + " \u00B0C");
			System.out.println("Temperature int Fahrenheit: " + converted + " \u00B0F\n");
		}

		else
			System.out.println("\nCouldn't Identify Unit");
	}
}
