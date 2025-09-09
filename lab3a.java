// lab3a.java
// lehman
// fall 2025
// power and GCD recursive functions
//caroline smith 

public class lab3a {
    public static void main(String[] args) {

        // call to power function
        System.out.println(power(2, 3));
        System.out.println();

        //add 2 additional function calls to the power function
        System.out.println(power(3, 4));
        System.out.println();

        System.out.println(power(4, 5));
        System.out.println();



        
        // call to gcd function
        System.out.println(gcd(10, 45));
        System.out.println();

        //add 2 additional function calls to the gcd function
        System.out.println(gcd(11, 50));
        System.out.println();

        System.out.println(gcd(12, 72));
        System.out.println();

    }

    public static int power(int x, int y) {
        System.out.println("power(" + x + "," + y + ")");
        if (y == 0)
            return 1;
        else if (y == 1)
            return x;
        else
            return x * power(x, y - 1);
    }

    public static int gcd(int x, int y) {
        System.out.println("gcd(" + x + "," + y + ")");
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

}