import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A7Work {
	/*
	 * Grading: 
	 * Search the two-dimensional array for the value and return if it exists in the matrix or not - 2pt
	 * The matrix is guaranteed to have each row/column sorted, and the number of rows/columns are equal (NxN) - see driver for example
	 * f(N) - 0.5pts
	 * O(N) - 0.5pts
	 * opCounts - 0.5pts
	 * compareCounts - 0.5pts
	 * No more than 2N-1 compares - 2pt
	 * No more than Ceiling(log(N^2)) compares - Bonus 1pt
	 */
	public static <E extends Comparable<? super E>> boolean contains(E val, E[][] matrix)
	{
		long opCount = 0;
		long compareCount = 0;
		//Determine if the val exists in the matrix as efficiently as possible
		//increment compareCounts every time you compare val to an position in the matrix
		//for notation, consider the number of rows/columns to be N, so the matrix contains N^2 values (rows/columns always equal)

		E[][] tempArray = matrix;
		opCount++;

		opCount++;
		compareCount++;
		while (tempArray.length > 1) { // f(N) = 10logN

			int length = tempArray.length;
			int midpoint = length / 2;
			E[] midArr = tempArray[midpoint];
			opCount+=4;

			opCount++;
			compareCount++;
			if (midArr[0].compareTo(val) > 0) {
				tempArray = Arrays.copyOfRange(tempArray, 0, midpoint);
				opCount++;
			} else if (midArr[length - 1].compareTo(val) < 0) {
				compareCount++;
				opCount+=2;

				opCount+=2;
				tempArray = Arrays.copyOfRange(tempArray, midpoint + 1, length);
			} else {
				compareCount++;
				opCount++;

				opCount+=2;
				tempArray = Arrays.copyOfRange(tempArray, midpoint, midpoint + 1);
			}

			opCount++;
			compareCount++;
		}

		E[] finalArray = tempArray[0];
		opCount++;

		opCount++;
		compareCount++;
		while (finalArray.length > 1) { // f(N) = 9logN

			int length = finalArray.length;
			int midpoint = length / 2;
			E midVal = finalArray[midpoint];
			opCount+=4;


			opCount++;
			compareCount++;
			if (midVal.compareTo(val) > 0) {
				opCount++;
				finalArray = Arrays.copyOfRange(finalArray, 0, midpoint);
			} else if (midVal.compareTo(val) < 0) {
				compareCount++;
				opCount++;

				opCount+=2;
				finalArray = Arrays.copyOfRange(finalArray, midpoint + 1, length);
			} else {
				// account for 2nd if
				compareCount++;
				opCount++;

				opCount+=2;
				finalArray = Arrays.copyOfRange(finalArray, midpoint, midpoint + 1);
			}

			opCount++;
			compareCount++;
		}

		boolean result = finalArray[0].compareTo(val) == 0;
		compareCount++;
		opCount+=2;

		System.out.println("f(N) = 19logN + 6");
		System.out.println("O(N) = logN");
		System.out.println("opCount = "+opCount);
		System.out.println("compareCounts = "+compareCount);
		return result;
	}

	/*
	 * Grading: 
	 * Modify the String radix sort for same length strings to work for multiple length strings - 2pts
	 * Do not add any additional data structures to the sort
	 * It is ok to determine the max length of strings in the array, but no other variables should be added
	 */
	public static void radixSortStrings(String[] arr)
	{
		//Configure this method to perform a radix sort on an array of Strings of various lengths
		//use the version below that requires all the strings to be the same length as a starting point
		//very little should need to be modified for this to work

		//number of buckets = 256 (characters in the character set)
		int bucketCount = 256;
		//if you were doing a case insensitive sort, and you knew everything was single words, you could use 26 as your size

		//Buckets need to be lists instead of counters
		List<String>[] buckets = new LinkedList[bucketCount];
		//create array of lists and initialize each object
		for(int i = 0; i < buckets.length; i++)
		{
			buckets[i] = new LinkedList<>();
		}

		int stringLen = 0;
		for (String s : arr) {
			if (s.length() > stringLen) stringLen = s.length();
		}

		//loop from end of string to beginning
		for(int strpos = stringLen-1; strpos >= 0; strpos--)
		{
			//loop through each string
			for (String item : arr) {
				//add to appropriate bucket
				if (item.length() - 1 > strpos) {

					buckets[item.charAt(strpos)].add(item);
				} else {
					buckets[0].add(item);
				}

			}
			//pointer for position in original list
			int pos = 0;
			//loop through buckets
			for (List<String> bucket : buckets) {
				//loop through items in each buck
				for (String item : bucket) {
					//add each string back to original array in new order
					arr[pos] = item;
					pos++;
				}
				//clear the bucket
				bucket.clear();//O(1)
			}
			System.out.println("Sorted on "+strpos+" : "+Arrays.toString(arr));
		}
	}
	
	/*DO NOT MODIFY*/
	public static void radixSortStrings(String[] arr, int stringLen)
	{
		//number of buckets = 256 (characters in the character set)
		int bucketCount = 256;
		//if you were doing a case insensitive sort, and you knew everything was single words, you could use 26 as your size

		//Buckets need to be lists instead of counters
		List<String>[] buckets = new LinkedList[bucketCount];
		//create array of lists and initialize each object
		for(int i = 0; i < buckets.length; i++)
		{
			buckets[i] = new LinkedList<>();
		}

		//loop from end of string to beginning
		for(int strpos = stringLen-1; strpos >= 0; strpos--)
		{
			//loop through each string
			for(String item : arr)
			{
				//add to appropriate bucket
				buckets[item.charAt(strpos)].add(item);
				//item.charAt(strpos) converts to int automatically
				//A = 65, a = 97, 0 = 48, space = 32
			}
			//pointer for position in original list
			int pos = 0;
			//loop through buckets
			for(int i = 0; i < buckets.length; i++)
			{
				//loop through items in each buck
				for(String item : buckets[i])
				{
					//add each string back to original array in new order
					arr[pos] = item;
					pos++;
				}
				//clear the bucket
				buckets[i].clear();//O(1)
			}
			System.out.println("Sorted on "+strpos+" : "+Arrays.toString(arr));
		}
	}
}
