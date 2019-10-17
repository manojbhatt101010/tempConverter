/*
Temperature converter from fahrenheit to celcius
and vice-versa
*/


import java.util.Scanner;

class TempConverter
{
	static char identifyUnit(char[] unit)
	{
		char[] f = "farnhtFARNHT".toCharArray(), c = "clsuCLSU0000".toCharArray();

		int countF = 0, countC = 0;
		for(int i = 0; i < unit.length; i++)
			for(int j = 0; j < 12; j++)
				if(unit[i] == f[j])
					countF++;
				else if(unit[i] == c[j])
					countC++;

		if(countF > countC)
			return 'F';
		else if(countC > countF)
			return 'C';
		else
			return 'A';
	}

	public static void main(String[] args)
	{
		Scanner read = new Scanner(System.in);

		System.out.print("\nEnter the Temperature: ");
		String currentTemp = read.next();
		char cTemp[] = currentTemp.toCharArray();

		int unitIndex = currentTemp.length();
		for(int i = 0; i < currentTemp.length(); i++)
			if(!Character.isDigit(cTemp[i]))
			{
				unitIndex = i;
				break;
			}

		if(unitIndex == 0)
		{
			System.out.println("\nNo value entered");
			return;
		}

		if(identifyUnit(currentTemp.substring(unitIndex).toCharArray()) == 'F')
			System.out.println("\nEntered Temperature: " + Double.parseDouble(currentTemp.substring(0, unitIndex)) + " \u00B0F\nTemperature after change: " + ((Double.parseDouble(currentTemp.substring(0, unitIndex)) - 32) * 5) / 9 + " \u00B0C\n");

		else if(identifyUnit(currentTemp.substring(unitIndex).toCharArray()) == 'C')
			System.out.println("\nEntered Temperature: " + Double.parseDouble(currentTemp.substring(0, unitIndex)) + " \u00B0C\nTemperature after change: " + ((Double.parseDouble(currentTemp.substring(0, unitIndex)) * 9) / 5) + 32 + " \u00B0F\n");

		else
			System.out.println("\nCouldn't Identify Unit");
	}
}
