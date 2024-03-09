/*
 * Author: Adam Michael Wood
 * 
 */

 import java.util.Scanner;
 import java.util.Stack;
 
 /**
  * A Java program that reads a list of Integer numbers from the scanned input 
  * and saves them into a Stack sorted from the smallest to the largest. 
  * The program asks for integers one at a time from the terminal and
  * stops when the user presses enter without typing a number. 
  * Each number is saved into the stack when it is received.
  * If the user types something other than an integer,
  * a short error/correction message is displayed.
  * When the user is done, the stack is printed to the console.
  */
 public class App {
 
     /**
      * Main method to execute the program.
      */
     public static void main(String[] args) {
         Stack<Integer> sortedStack = new Stack<>();
 
         System.out.println("Enter integers (press Enter without typing a number to finish):");
 
         try (Scanner scanner = new Scanner(System.in)) {
             while (true) {
                 String input = scanner.nextLine().trim();
 
                 if (input.isEmpty()) {
                     break; // If user presses Enter without typing a number, exit loop
                 }
 
                 try {
                     int num = Integer.parseInt(input);
                     insertSorted(sortedStack, num); // Insert the number into the sorted stack
                 } catch (NumberFormatException e) {
                     System.out.println("Invalid input, please try again."); // Error message for invalid input
                 }
             }
         }
 
         System.out.println("Sorted Stack: " + sortedStack);
     }
 
     /**
     * Helper method to insert a number into the sorted stack.
     * @param stack The sorted stack.
     * @param num The number to insert into the stack.
     */
    private static void insertSorted(Stack<Integer> stack, int num) {
        Stack<Integer> tempStack = new Stack<>();

        // Pop elements smaller than num from stack to tempStack
        while (!stack.isEmpty() && stack.peek() > num) {
            tempStack.push(stack.pop());
        }

        // Push num onto stack
        stack.push(num);

        // Push elements from tempStack back to stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}