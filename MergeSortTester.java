/*======================================
  class MergeSortTester

  ALGORITHM:
  If the array does not have length of one, split it into two separate arrays with about-equal amount of items inside. If the array
  has length of one, return it. When you recieve the arrays that you split, merge them.
  
  BIG-OH CLASSIFICATION OF ALGORITHM:
  Splitting and resplitting the arrays seems to be O(n). Merging is also O(n). Even with more arrays and more calls, the arrays get
  smaller. The first split might be O(n) and the next two O(n - x) and O(x), so lets assume that all levels of splitting are O(n)
  each. Log(n) levels. You merge the same number of times. Log(n) * n + Log(n) * n results in O(nlogn).
  O(nLogn)

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 171
  n=10      time: 12272
  n=100     time: 119353
  n=1000    time: 454790
  n=10000   time: 277360
  n=100000  time: 13710177
  n=1000000 time: 122245233
  ...
  n=<huge>  time: time(n - 1) * 10 or less

  ANALYSIS:
  When n increases by a factor of 10, the time it takes to run multplies by
  a factor less than 10, but sometimes close to 10. It seems to get close to
  10 every other factor increase (10 to 100, 1000 to 10000, 100000 to 1000000).
  
  Fix this I am terrible at data analysis.
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
	//long a = 0;
	for (int x = 0; x < 10; x++){
	    avg += timeThing(n);
	    /*a = timeThing(n);
	    System.out.println("raw: " + a);
	    avg += a;*/
	}
	return avg/10;
    }
    
    /******************************
     * execution time analysis 
     the meanTime method calculates the average time using timeThing over the 
span of 10 runs. 
     ******************************/
    public static void main( String[] args ) {


	timeThing(1);
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
