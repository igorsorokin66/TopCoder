import java.util.ArrayList;
import java.util.Arrays;


public class LargestSubsequence
{

	public static void main(String[] args)
	{
		System.out.println(getLargest("zyyyyyyyyyyyyooooooooooog"));
	}
	
	public static String getLargest(String s)
	{
		ArrayList al = new ArrayList();
		byte[] b = s.getBytes();
		for (byte b1 : b) al.add(b1);
		Arrays.sort(b); 

		String x = "";
		int prev = 0;
		for (int i = b.length-1; i >= 0; i--)
		{
			if (prev > b.length-1) break;
			int loc = al.subList(prev, al.size()).indexOf(b[i])+prev;
			x+=s.charAt(loc);
			prev = loc+1;
		}
		return x;
	}

}
