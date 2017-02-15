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

    public static long meanTime(int n){
	long avg = 0;
	for (int x = 0; x < 10; x++){
	    avg += timeThing(n);
	}
	return avg/10;
    }
    
    /******************************
     * execution time analysis 
     the meanTime method calculates the average time using timeThing over the 
span of 10 runs. 
     ******************************/
    public static void main( String[] args ) {


	
        System.out.println(meanTime(1));
	System.out.println(meanTime(10));
	System.out.println(meanTime(100));
	System.out.println(meanTime(1000));
	System.out.println(meanTime(10000));
	System.out.println(meanTime(100000));
	System.out.println(meanTime(1000000));

	
	/*
	for (int x = 1; x < 100; x += 1) {
	    System.out.println(timeThing(x));
	    }
	*/
    }//end main

}//end class
