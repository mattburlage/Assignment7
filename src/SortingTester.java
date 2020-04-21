import java.util.Arrays;

public class SortingTester {

	public static void main(String[] args) {
//		Integer[] originalList1 = new Integer[]{34, 8, 64, 51, 32, 21};
//		System.out.println(originalList1.length+" items in originalList1 Inversions:"+SortingMethods.inversionCounter(originalList1));
//		Integer[] originalList2 = new Integer[]{81, 94, 11, 96, 12, 35, 17, 95, 28, 58, 41, 75, 15};
//		System.out.println(originalList2.length+" items in originalList2 Inversions:"+SortingMethods.inversionCounter(originalList2));
//		Integer[] originalList3 = new Integer[]{0,5,7,5,4,2,3,4,6,9,8,1,2,0,1,5,7,6,9,4,8,2,3,4,1,5};
//		System.out.println(originalList3.length+" items in originalList3 Inversions:"+SortingMethods.inversionCounter(originalList3));
//		Integer[] originalRevList = new Integer[]{16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
//		System.out.println(originalRevList.length+" items in originalRevList Inversions:"+SortingMethods.inversionCounter(originalRevList));
//		Integer[] originalInOrderList = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
//		System.out.println(originalInOrderList.length+" items in originalInOrderList Inversions:"+SortingMethods.inversionCounter(originalInOrderList));
		
		//arrObject.clone() returns a copy of the array in a new memory location
		//remember, pass-by-reference updates the original memory location of the array being passed
		//copies made to prevent modifying the original list
		Integer[] originalList1 = {9, 5, 8, 2, 4, 3, 1, 7, 6, 0};
		Integer[] arrToSort;

		System.out.println("Insertion count: " + SortingMethods.inversionCounter(originalList1));

		arrToSort = originalList1.clone();
		System.out.println("\nInsertion Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.insertionSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		/* INSERTION SORT * /
		arrToSort = originalList1.clone();
		System.out.println("\nInsertion Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.insertionSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		/** /
		arrToSort = originalList2.clone();
		System.out.println("\nInsertion Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.insertionSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		/** /
		arrToSort = originalList3.clone();
		System.out.println("\nInsertion Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.insertionSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		/** /
		arrToSort = originalRevList.clone();
		System.out.println("\nInsertion Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.insertionSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		/** /
		arrToSort = originalInOrderList.clone();
		System.out.println("\nInsertion Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.insertionSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		/**/
		
		arrToSort = originalList1.clone();
		System.out.println("\nShell Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.shellSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		/*
		arrToSort = originalList2.clone();
		System.out.println("\nShell Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.shellSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		/** /
		arrToSort = originalList3.clone();
		System.out.println("\nShell Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.shellSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		/** /
		arrToSort = originalRevList.clone();
		System.out.println("\nShell Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.shellSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		/** /
		arrToSort = originalInOrderList.clone();
		System.out.println("\nShell Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.shellSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		/**/
		

		arrToSort = originalList1.clone();
		System.out.println("\nHeap Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.heapSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		

		arrToSort = originalList1.clone();
		System.out.println("\nMerge Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.mergeSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		
		arrToSort = originalList1.clone();
		System.out.println("\nQuick Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.quickSort(arrToSort);
		System.out.println(Arrays.toString(arrToSort));
		
		/* BUCKET SORT* /
		arrToSort = originalList1.clone();
		System.out.println("\nBucket Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.bucketSort(arrToSort, 8, 64);
		System.out.println(Arrays.toString(arrToSort));
		/** /
		arrToSort = originalList2.clone();
		System.out.println("\nBucket Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.bucketSort(arrToSort, 11, 96);
		System.out.println(Arrays.toString(arrToSort));
		/** /
		arrToSort = originalList3.clone();
		System.out.println("\nBucket Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.bucketSort(arrToSort, 0, 9);
		System.out.println(Arrays.toString(arrToSort));
		/** /
		arrToSort = originalRevList.clone();
		System.out.println("\nBucket Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.bucketSort(arrToSort, 1, 16);
		System.out.println(Arrays.toString(arrToSort));
		/** /
		arrToSort = originalInOrderList.clone();
		System.out.println("\nQuick Sort");
		System.out.println(Arrays.toString(arrToSort));
		SortingMethods.bucketSort(arrToSort, 1, 16);
		System.out.println(Arrays.toString(arrToSort));
		/**/
		
		/* RADIX SORT*/
//		String[] wordsToSort = new String[]{"ccc", "ccb", "cca", "cbc", "cbb", "cba", "cac", "cab", "caa",
//											"bcc", "bcb", "bca", "bbc", "bbb", "bba", "bac", "bab", "baa",
//											"acc", "acb", "aca", "abc", "abb", "aba", "aac", "aab", "aaa"
//										};
//		System.out.println("\nRadix Sort");
//		System.out.println(Arrays.toString(wordsToSort));
//		SortingMethods.radixSort(wordsToSort, 3);
//		System.out.println(Arrays.toString(wordsToSort));
		/**/
	}

}
