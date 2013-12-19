import java.util.Arrays;


public class BinaryCode
{
	public static void main(String[] args)
	{
		//123210122
		//011100011
		
		//11
		//01 10
		
		//22111
		//11001
		
		//123210120
		
		//12221112222221112221111111112221111
		//01101001101101001101001001001101001 10110010110110010110010010010110010
		System.out.println(Arrays.toString(decode("12221112222221112221111111112221111")));
	}
	
	public static void repeat(String[] c, int i)
	{
		int cc = 0;
		for (int k = 0; k < 3; k++)
		{
			if (rez[i-1][k] != null)
			{
				for (int n = 0; n < c.length; n++)
				{
					if (rez[i-1][k].length() == 2)
					{
						if (rez[i-1][k].equals(c[n].substring(0, 2))) {rez[i][cc] = c[n]; cc++;}
					}
					else if (rez[i-1][k].substring(1, 3).equals(c[n].substring(0, 2))) {rez[i][cc] = c[n]; cc++;}	
				}
			}
		}
		if (rez[i][1] == null && rez[i-1][1] != null) replace(i);
	}
	
	public static void replace(int i)
	{
		for (int x = 0; x < 3; x++)
		{
			for (int y = 0; y < 3; y++)
			{
				if (i != 0 && rez[i][x] != null && rez[i-1][y] != null)
				{
					if (rez[i-1][y].length() == 3)
					{
						if (!rez[i-1][y].substring(1, 3).equals(rez[i][x].substring(0, 2))) 
						{
							rez[i-1][y] = null;
							if (i-1 >= 0) replace(i-1);
						}
					}
					else if (!rez[i-1][y].equals(rez[i][x].substring(0, 2))) 
					{
						rez[i-1][y] = null;
						if (i-1 >= 0) replace(i-1);
					}
					System.out.println("FOUND!");
				}
			}
		}
	}
	
	static String[][] rez = new String[1][1];
	public static String[] decode(String x)
	{
		rez = new String[x.length()][3];
		for (int i = 0; i < x.length(); i++)
		{
			if (x.charAt(i) == '0') rez[i][0] = "000";
			else if (i == 0) //first char
			{
				if (x.charAt(i) == '1') {rez[i][0] = "10"; rez[i][1] = "01";}
				else rez[i][0] = "11";
			}
			else if (i == x.length()-1) //last char
			{
				if (x.charAt(i) == '1') repeat(new String[]{"01","10"}, i);
				else rez[i][0] = "11";
			}
			else //middle chars
			{
				if (x.charAt(i) == '1')      repeat(new String[]{"100", "010", "001"}, i);
				else if (x.charAt(i) == '2') repeat(new String[]{"110", "101", "011"}, i);
				else rez[i][0] = "111";
			}
		}
		
		String[] f = new String[x.length()];
		for (int i = 0; i < x.length(); i++)
		{
			for (int k = 0; k < 3; k++)
			{
				if (rez[i][k] != null)
				{
					if (i == 0) f[i] = String.valueOf(rez[i][k].charAt(0));
					else f[i] = String.valueOf(rez[i][k].charAt(1));
				}
			}
		}
		return f;
	}
}