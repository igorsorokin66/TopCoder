
public class PalindromeDecoding
{

	public static void main(String[] args)
	{
		System.out.println(decode("XY", new int[]{0, 0, 0, 0}, new int[]{2, 4, 8, 16}));
	}
	
	public static String decode(String code, int[] posi, int[] leng)
	{
		for (int n = 0; n < posi.length; n++)
		{
			int p = posi[n];
			int l = leng[n];
			String cut = code.substring(p, p+l);
			StringBuilder s = new StringBuilder(cut);
			s.reverse();
			cut = s.toString();
			String before = code.substring(0,p+l);
			String after = code.substring(p+l,code.length());
			code =  before + cut + after;
		}
		return code;
	}

}
