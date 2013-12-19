import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MovieRating
{

	public static void main(String[] args)
	{
		calculate(new int[]{1,2,3,4,5},2,2);
	}
	
	public static double calculate(int[] marks, int lowCount, int highCount) 
	{
		Arrays.sort(marks);
		ArrayList x = new ArrayList(Arrays.asList(marks));
		//ArrayList al = new ArrayList(marks).subList(lowCount, marks.length()-highCount);
		int total = 0;
		
		for (Object m : x.subList(1,3))//lowCount, marks.length-highCount))
		{
			int m1 = (Integer) m;
			total += m1;
		}
		return total/marks.length-2;
	}

}
