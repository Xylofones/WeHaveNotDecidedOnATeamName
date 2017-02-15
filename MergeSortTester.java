/*======================================
  class MergeSortTester

  ALGORITHM:
  If the array does not have length of one, split it into two separate arrays with about-equal amount of items inside. If the array
  has length of one, return it. When you recieve the arrays that you split, merge them.
  
  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester 
{
    public static int stepCalc(int n) {
	if (n == 1) {
	    return 2;
	}
	else {
	    return (7 * n) + 10 + stepCalc(n / 2) + stepCalc(n - (n / 2));
	}
    }

    public static long timeThing(int n) {
	int[] arr = new int[n];
	for (int x = 0; x < n; x += 1) {
	    arr[x] = n - x;
	}
	long retLong = System.nanoTime();
	MergeSort.sort(arr);
	retLong = System.nanoTime() - retLong;
	return retLong;
    }
    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/
    public static void main( String[] args ) {
	/*for (int x = 1; x < 20; x += 1) {
	    System.out.println(stepCalc(x));
	    }*/

	System.out.println(timeThing(100));

    }//end main

}//end class
