/*======================================
  class MergeSortTester

  ALGORITHM:
  The merge method we used, given two arrays with a total of n elements, takes
  6 + 5n steps. The sort method uses 2 + 2n steps to split an array, and adds
  one to make sure the array doesn't have only one element, and one to call
  merge. Add the steps of merge, and that gives you 7n + 10, and plus whatever
  the next two sort methods return. Unless there's only one element, in which
  case the method only takes two steps.

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

    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/
    public static void main( String[] args ) {
	for (int x = 1; x < 20; x += 1) {
	    System.out.println(stepCalc(x));
	}

    }//end main

}//end class
