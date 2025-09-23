/// palindrome2.java 
//
// fall 2025
// lab4b assignment
//
// caroline smith
//
// Use for paindrome.java

public class palindrome2 {
    
    public static void main(String[] args) {

        //single call to test
        System.out.println( palindrome("racecar") ); //true
        System.out.println( palindrome("sass") ); //false
        
        System.out.println( palindrome("hannah"));

        //uncomment to test additional words
        /*
        String words[] = { "a", "racecar", "noon", "hannah", "abcba", "abbca", "nope", "ab" };

        for (int i = 0; i < words.length; i++) {

            if (palindrome(words[i]) == true)
                System.out.println( words[i] + " IS a palindrome");
            else
                System.out.println( words[i] + " IS NOT a palindrome");
        }
        */
        
    }// main

    // *** use StackCharArray and QueueCharArray here to determine Palindrome
    private static boolean palindrome(String word) {

        //assume status is true
        boolean status = true;

		// *** add code here


        StackCharArray stack = new StackCharArray(100);
        QueueCharArray queue = new QueueCharArray(100);

        int i = 0;
        while (i < word.length()) {
            stack.push(word.charAt(i));
            i++;
        }

        System.out.println(stack);

        int j = 0;
        while (j < word.length()) {
            queue.add(word.charAt(j));
            j++;
        }

        System.out.println(queue);


        while (stack.size() != 0 && status == true) {
            if (stack.top() != queue.front())
                status = false;
            else {
                stack.pop();
                queue.remove();
            }
            
        }

        return status;
        
    }// palindrome method

}//class
