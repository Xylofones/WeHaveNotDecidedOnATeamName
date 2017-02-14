//Joanna Zhou
//APCS2 pd4
//HW6 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
//2017-02-10
/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: The merging algorithm makes a new array and then uses
  three ints to keep track of where one is in the three arrays. If the element
  one is on is int one array is greater than the other, then that first element
  is placed in the next part of the new array, and the int of the relevant place
  holder is increased. And so on. The sorting algorithm breaks down the array
  until it is one element per call for the sort method. Then since a one element
  array is already sorted, everything is merge, two at a time.
  ======================================*/

public class MergeSort {
   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) {
	int[] retArr= new int[a.length + b.length];
	int x = 0;
	int y = 0;
	int z = 0;
	while (x < a.length && y < b.length){
	    if (a[x] < b[y]) {
		retArr[z] = a[x];
		x += 1;
	    }
	    else {
		retArr[z] = b[y];
		y += 1;
	    }
	    z += 1;
	}
	for (int p = x; p < a.length; p += 1) {
	    retArr[z] = a[p];
	    z += 1;
	}
	for (int q = y; q < b.length; q += 1) {
	    retArr[z] = b[q];
	    z += 1;
	}
	return retArr;
    }//end merge()
    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) {
	if (arr.length == 1) {
	    return arr;
	}
	else {
	    int[] one = new int[arr.length / 2];
	    int[] two = new int[(arr.length + 1) / 2];
	    for (int x = 0; x < arr.length / 2; x += 1) {
		one[x] = arr[x];
	    }
	    for (int y = 0; y < (arr.length + 1) / 2; y += 1) {
		two[y] = arr[y + (arr.length / 2)];
	    }
	    return merge(sort(one), sort(two));
	}
    }//end sort()

    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }
    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------

    //main method for testing
    public static void main( String [] args ) {

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );
	
	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()
}//end class MergeSort

