
public class Rochambo
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(wins("PSRRPS"));
	}
	
	static int wins(String opp)
	{
		int count = 0;
		int firstTwo = 0;
		
		for (int i = 0; i < opp.length(); i++)
		{
			String s = opp.split("")[i];
			if (firstTwo < 2) {firstTwo++; if (who("R",s).equals("win")) count++;}
			else 
			{
				if (!opp.substring(i-2,i).contains("R")) 	  if (who("P",s).equals("win")) count++;
				else if (!opp.substring(i-2,i).contains("P")) if (who("S",s).equals("win")) count++;
				else if (!opp.substring(i-2,i).contains("S")) if (who("R",s).equals("win")) count++;
			}
		}
		
		return count;
	}
	
	static String who(String x, String y)
	{
		switch (x)
		{
			case "R" : 
			{
				switch (y)
				{
					case "R" : return "tie";
					case "P" : return "loss";
					case "S" : return "win";
				}
			}
			case "P" :
			{
				switch (y)
				{
					case "R" : return "win";
					case "P" : return "tie";
					case "S" : return "loss";
				}
			}
			case "S" :
			{
				switch (y)
				{
					case "R" : return "loss";
					case "P" : return "win";
					case "S" : return "tie";
				}
			}
		}
		return "";
	}
}
