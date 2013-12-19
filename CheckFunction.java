import java.util.HashMap;


public class CheckFunction
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(checkFunction("13579"));
	

	}
	
	static int checkFunction(String x)
	{
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("0", 6);
		hm.put("1", 2);
		hm.put("2", 5);
		hm.put("3", 5);
		hm.put("4", 4);
		hm.put("5", 5);
		hm.put("6", 6);
		hm.put("7", 3);
		hm.put("8", 7);
		hm.put("9", 6);
		
		int total = 0;
		for (int i = 0; i < x.length(); i++)
		{
			total += hm.get(String.valueOf(x.charAt(i)));
		}
		return total;
	}

}
