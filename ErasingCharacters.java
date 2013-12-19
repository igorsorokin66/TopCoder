
public class ErasingCharacters
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(simulate("eel"));
	}
	
	public static String simulate(String s)
	{
		for (int i = 0; i < s.length(); i++)
		{
			if (i >= 0 && i+1 < s.length() && s.charAt(i) == s.charAt(i+1))
			{
				s = s.substring(0,i) + s.substring(i+2,s.length()); i-=2;
			}
		}
		return s;
	}

}
