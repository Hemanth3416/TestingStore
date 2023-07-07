package DataGenerators;

import java.util.Date;

public class Generators 
{
	public static String emailTimeStamp()
	{
		Date date = new Date();
		return "avhemanthkumar"+ date.toString().replace(" ", "_").replace(":","_")+"@gmail.com";
	}
	public static String passwordTimeStamp()
	{
		Date date = new Date();
		return "av@"+ date.toString().replace(" ", "_").replace(":","_");
	}
}
