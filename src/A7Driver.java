import java.util.Arrays;

public class A7Driver {

	public static void main(String[] args) {
		int N = 10;
		Integer[][] matrix = new Integer[N][N];
		int c = 1;
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++, c+=2)
			{
				matrix[i][j] = c;
			}
		}
		System.out.println("Matrix");
		System.out.println(Arrays.deepToString(matrix).replaceAll("], ", "],\n"));
		System.out.println("Contains 5: "+A7Work.contains(5, matrix));
		System.out.println("Correct: true");
		System.out.println("Contains 6: "+A7Work.contains(6, matrix));
		System.out.println("Correct: false");
		
		String[] words = new String[]{"abc", "z", "abzf", "12", " a b c"};
		System.out.println("Before Sort");
		System.out.println(Arrays.toString(words));
		A7Work.radixSortStrings(words);
		System.out.println("After Sort");
		System.out.println(Arrays.toString(words));
	}

}
