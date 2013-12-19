import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class BinPacking
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(minBins(new int[]{157, 142, 167, 133, 135, 157, 143, 160, 141, 123, 162, 159, 165, 137, 138, 152}));
	}
	
	static int minBins(int[] x)
	{
		Arrays.sort(x);
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int c : x) al.add(c);
		//Collections.reverse(al);
		int count = 0;
		for (int i = 0; i < al.size(); i++)
		{
			int find = 300 - al.get(i);
			int biggest = 0;
			for (int n = i+1; n < al.size(); n++) if (al.get(n) <= find && al.get(n) > biggest) biggest = al.get(n);
			
			if (biggest != 0)
			{
				al.add(i, al.get(i)+biggest); 
				al.remove(i+1);
				al.remove((Object)biggest); 
				i--;
				//count++;
			}
			else count++;
		}
		
		return al.size();
	}

}
