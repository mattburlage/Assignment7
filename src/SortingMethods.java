import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SortingMethods {
	
	public static void radixSort(String[] arr, int stringLen)
	{
		//number of buckets
		int bucketCount = 256;
		
		//lists instead of counters
		List<String>[] buckets = new LinkedList[bucketCount];
		
		//finish list setup
		for(int i = 0; i < buckets.length; i++)
		{
			buckets[i] = new LinkedList<>();
		}
		
		//loop from the end of the string to the beginning
		for(int i = stringLen-1; i >= 0; i--)
		{
			//loop through each item
			for(int j = 0; j < arr.length; j++)//O(N)
			{
				buckets[arr[j].charAt(i)].add(arr[j]);
				//A = 65, a = 97, 0 = 48, space = 32
			}
			
			for(int j = 0, pos = 0; j < buckets.length; j++)//through each bucket
			{
				for(String item : buckets[j])//through each item
				{
					arr[pos] = item;
					pos++;
				}
				//clear the bucket for reuse
				buckets[j].clear();//O(1)
			}
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static void bucketSort(Integer[] arr, int min, int max)//O(N+M), with expectation that M <= N and can be dropped
	{
		//determine the number of buckets needed
		int bucketCount = max-min+1;
		
		//create buckets
		int[] buckets = new int[bucketCount];
		
		//loop through items and increment the correct bucket
		for(int i = 0; i < arr.length; i++)//runs N times
		{
			buckets[arr[i]-min]++;
		}
		
		//System.out.println(Arrays.toString(buckets));
		
		//loop through the buckets and put the values back into the original array
		for(int i = 0, pos = 0; i < buckets.length; i++)//runs M times
		{
			for(int j = 0; j < buckets[i]; j++, pos++)//runs zero to N times, note: runs exactly N times by completion of outer loop
			{
				arr[pos] = i+min;
			}
		}
	}

	public static <E extends Comparable<? super E>> void quickSort(E[] arr)
	{
		quickSortHelper(arr, 0, arr.length-1);
	}
	private static <E extends Comparable<? super E>> void quickSortHelper(E[] arr, int start, int end)
	{
		//set pivot point location
		int pivotLoc = ((end-start)/2)+start;
		E pivot = arr[pivotLoc];
		
		int tempStart = start;
		//loop through all items that need to be sorted
		for(int i = tempStart; i <= end; i++)
		{
			if(arr[i].compareTo(pivot) < 0)//smaller than pivot
			{
				E temp = arr[tempStart];
				arr[tempStart] = arr[i];
				arr[i] = temp;
				if(pivotLoc == tempStart)//just swapped pivot towards the end
				{
					pivotLoc = i;
				}
				tempStart++;
			}
		}
		E temp = arr[tempStart];
		arr[tempStart] = pivot;
		arr[pivotLoc] = temp;
		pivotLoc = tempStart;
		
		//System.out.println(start+":"+end);
		//System.out.println(pivotLoc+":"+pivot);
		//System.out.println(Arrays.toString(arr));
		
		if(pivotLoc-1 > start)//more than 1 item before pivot needs to be sorted
		{
			quickSortHelper(arr, start, pivotLoc-1);//sort values smaller than pivot value
		}
		if(pivotLoc+1 < end)//more than 1 item after pivot needs to be sorted
		{
			quickSortHelper(arr, pivotLoc+1, end);//sort values larger than pivot value
		}
	}
	
	public static <E extends Comparable<? super E>> void quickSortAsList(E[] arr)
	{
		//convert array to list
		List<E> temp = Arrays.asList(arr);//O(N)
		//call quickSort with converted to list
		quickSort(temp);//O(N logN)
		//copy values back into array
		for(int i = 0; i < arr.length; i++)//O(N)
		{
			arr[i] = temp.get(i);
		}
	}
	public static <E extends Comparable<? super E>> void quickSort(List<E> arr)
	{
		//if list has more than 1 item
		if(arr.size() > 1)
		{
			//create 3 lists (smaller, equal, larger)
			List<E> smaller = new ArrayList<>(arr.size());
			List<E> equal = new ArrayList<>(arr.size());
			List<E> larger = new ArrayList<>(arr.size());
			//pick pivot value
			E first = arr.get(0);
			E middle = arr.get(arr.size()/2);
			E last = arr.get(arr.size()-1);
			E pivot = first;
			if(first.compareTo(middle) > 0 && first.compareTo(last) > 0)
			{
				if(middle.compareTo(last) > 0)
				{
					pivot = middle;
				}
				else
				{
					pivot = last;
				}
			}
			//loop through list
			for(E t : arr)
			{
				//put items into correct list
				int compare = pivot.compareTo(t);
				if(compare > 0)
				{
					smaller.add(t);
				}
				else if(compare < 0)
				{
					larger.add(t);
				}
				else
				{
					equal.add(t);
				}
			}

			//recursively sort smaller/larger
			quickSort(smaller);
			quickSort(larger);
			//put all items into original list [.clear(), .addAll()]
			arr.clear();
			arr.addAll(smaller);
			arr.addAll(equal);
			arr.addAll(larger);
		}
	}
	
	private static int compareCount;
	public static <E extends Comparable<? super E>> void mergeSort(E[] arr)
	{
		compareCount = 0;
		mergeSortHelper(arr, (E[]) new Comparable[arr.length], 0, arr.length-1);
		System.out.println("Compare Count:"+compareCount);
	}
	private static <E extends Comparable<? super E>> void mergeSortHelper(E[] arr, E[] temp, int leftStart, int rightEnd)
	{
		//make sure start less than end
		if(leftStart < rightEnd)
		{
			//find middle/center
			int middle = ((rightEnd-leftStart)/2)+leftStart;
			
			//mergeSort the left side
			mergeSortHelper(arr, temp, leftStart, middle);
			//mergeSort the right side
			mergeSortHelper(arr, temp, middle+1, rightEnd);
			
			//merge sorted sections
			merge(arr, temp, leftStart, middle+1, rightEnd);
			System.out.println("merge: " + Arrays.toString(arr));
			//System.out.println(Arrays.toString(arr));
			//System.out.println("Start:"+leftStart+" End:"+rightEnd+" Inversions Remaining:"+SortingMethods.inversionCounter(arr));
		}
	}
	private static <E extends Comparable<? super E>> void merge(E[] arr, E[] temp, int leftStart, int rightStart, int rightEnd)
	{
		//determine leftEnd
		int leftEnd = rightStart-1;
		//temp position of left start
		int tempStart = leftStart;
		//determine number of items being merged
		int count = rightEnd-leftStart+1;
		
		//loop while items in both lists
		while(leftStart <= leftEnd && rightStart <= rightEnd)
		{
			//compare the smallest remaining from both lists
			compareCount++;
			int comparison = arr[leftStart].compareTo(arr[rightStart]);
			if(comparison <= 0)
			{
				temp[tempStart] = arr[leftStart];
				leftStart++;
				tempStart++;
			}
			else
			{
				temp[tempStart] = arr[rightStart];
				rightStart++;
				tempStart++;
			}
		}
		
		//loop while items in left list
		while(leftStart <= leftEnd)
		{
			temp[tempStart] = arr[leftStart];
			leftStart++;
			tempStart++;
		}
		
		//loop while items in right list
		while(rightStart <= rightEnd)
		{
			temp[tempStart] = arr[rightStart];
			rightStart++;
			tempStart++;
		}
		
		//copy from temp back to original array
		for(int i = 0; i < count; i++, rightEnd--)
		{
			arr[rightEnd] = temp[rightEnd];
		}
	}
	
	/*
	 * O(N*log(N))
	 */
	public static <E extends Comparable<? super E>> void heapSort(E[] arr)
	{
		PriorityQueue<E> heap = new PriorityQueue<>();
		
		heap.addAll(Arrays.asList(arr));//O(N)

		System.out.println(heap.toString());

		//N*log(N)
		for(int i = 0; i < arr.length; i++)//runs N times
		{
			arr[i] = heap.poll();//poll = deleteMin, log(N)
		}
	}
	
	/*
	 * Using N/2 for shells is O(N^2)
	 * Using (2^k)-1 for shells is O(N^(2/3))
	 */
	public static <E extends Comparable<? super E>> void shellSort(E[] arr)
	{
		/*
		 * List is size 10
		 * 	First Shell is 5
		 * 		0, 5
		 *		1, 6
		 *		2, 7
		 *		3, 8
		 *		4, 9
		 *	Second Shell is 2
		 *		0, 2, 4, 6, 8
		 *		1, 3, 5, 7, 9
		 *	Final Shell is 1
		 *		SAME AS INSERTION SORT
		 */
		int moveCount = 0;
		int compareCount = 0;
		//loop through each shell
		for(int shell = arr.length/2; shell > 0; shell /= 2)//not an N loop
		{
			//for each sublist
			for(int sublist = shell; sublist < arr.length; sublist++)
			{
				E temp = arr[sublist];
				int hole = sublist;
				compareCount++;
				for(;hole >= shell && temp.compareTo(arr[hole-shell]) < 0; hole-=shell)
				{
					arr[hole] = arr[hole-shell];
					moveCount++;
					if(hole-shell >= shell)
					{
						compareCount++;
					}
				}
				arr[hole] = temp;
			}
			System.out.println("thing: " + Arrays.toString(arr));
		}
		System.out.println("Move Count:"+moveCount);
		System.out.println("Compare Count:"+compareCount);
	}
	
	/*
	 * O(N^2) if perfectly reversed
	 * O(N) if perfectly in order
	 * Our actual is O(I+N), where is I is number of inversions
	 * So, we usually consider this O(N^2)
	 * 
	 */
	public static <E extends Comparable<? super E>> void insertionSort(E[] arr)
	{
		/*
		 * Has two parts of the array
		 * Part 1: sorted list
		 * Part 2: unsorted list
		 * Initially part 1 is only 1 item (left most item, index 0)
		 * Take an item from part 2 and put it into the correct position of part 1
		 */
		
		int moveCount = 0;
		int compareCount = 0;
		//loop through part 2 items
		for(int i = 1; i < arr.length; i++)//runs about N times
		{
			//store the item we are putting into part 1
			E temp = arr[i];
			//this frees up a hole in the list that is now part of part 1
			int hole = i;
			
			compareCount++;
			for(;hole > 0 && temp.compareTo(arr[hole-1]) < 0; hole--)//runs about N times, but as few as zero
			{
				//move hole over place
				arr[hole] = arr[hole-1];
				moveCount++;
				if(hole != 1)
				{
					compareCount++;
				}
			}
			arr[hole] = temp;
		}
		System.out.println("Move Count:"+moveCount);
		System.out.println("Compare Count:"+compareCount);
	}

	/*
	 * Returns the number of inversions in a given array of Comparable objects
	 * Runs in O(N^2)
	 */
	public static <E extends Comparable<? super E>> int inversionCounter(E[] arr)
	{
		int inversioncount = 0;
		for(int i = 0; i < arr.length; i++)//check each value
		{
			for(int j = i+1; j < arr.length; j++)//check all values to the right
			{
				if(arr[i].compareTo(arr[j]) > 0)//value to the right is larger
					inversioncount++;
			}
		}
		return inversioncount;
	}
}
