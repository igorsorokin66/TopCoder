import java.util.Arrays;


public class HuffmanDecoding
{
	
	public static void main(String[] args)
	{
		String[] d = {"00","10","01","11"};
		System.out.println(decode("101101", d));
	}

	static String decode(String x, String[] d)
	{
		String decode = "";
		for (int start = 0; start < x.length();)
		{
			for (int end = start+1; end < x.length()+1; end++)
			{
				if (Arrays.asList(d).contains(x.substring(start, end)))
				{
					decode += (char)(Arrays.asList(d).indexOf(x.substring(start, end))+65);
					start = end; 
					break;
				}
			}
		}
		return decode;
	}
}
