// lab2.java
// caroline smith
// September 5, 2025
// calculates primes using Sieve of Eratosthenes
// demonstrates command line arguments and methods
// Q: What is the maximum prime number you can find using your program?
//  A: The last prime you can find in this program is 997. This is because it is the largest prime numbe before 1000. Since the program ends at 1000, 997 will be the largest prime number shown. This is how it is set up as default. If you were to enter a number from the command line, you could get any largest prime number, as long as it is less than or equal to N (number entered).
// Q: How does printing vs. not printing the numbers affect performance?
//  A: If you print every number, it will slow down the run time. If there is a large quanity of numbers, then it will take a long time to run. If there are only a few numebrs, for example an array such as 1, 2, 3, 4, 5, 6, then it will not take as long as it would 1-15000.
// Q: What factors limit your program from finding larger prime numbers?
//  A: The fact that we asked it to stop at 1000, limits it so that it can't find any prime numbers after 1000. 


public class lab2 {

	public static void main(String[] args) 
	{
        int N;
		
		//add code to get num from command line argument
		if (args.length > 0)
        {
            N = Integer.parseInt(args[0]);
            System.out.println( "N = " + N);
        }
        else 
        {
            N = 1000;
            System.out.println("Missing argument");
        }
        
        boolean[] nums = new boolean[N + 1];
        nums[0] = false;
        nums[1] = false;

        for (int i = 2; i <= N; i++) {
            nums[i] = true;
        }

        for (int i = 2; i <= (int)Math.sqrt(N); i++) 
        {
            if (nums[i])
            { 
                for (int j = i * i; j <= N; j += i)
                {
                    nums[j] = false;
                }

            }
            //showPrimes(nums)
        }

        //for (int i = 2; i <= N; i++) 
   //     {
          //  if (nums[i])
            //    System.out.println(i);
    //    }

	//call showPrimes;
        showPrimes( N, nums );
		
	}//main
	
    public static void showPrimes(int N, boolean[] nums)
	{
        System.out.println("Primes up to " + N + ":"); 
        for (int i = 2; i <= N; i++) 
        {
            if (nums[i]) 
            {
                System.out.println(i);
            }
        }
         
		//add code to display primes		
	}//showPrimes
}	
//lab2