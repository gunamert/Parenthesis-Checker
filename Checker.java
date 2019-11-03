
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The Mert_Gunay program represents a basic parenthesis checker which use
 * myStack class for mathematic expression. Program ask the user to enter the
 * name of the input mathematic expression and print the stack content at each
 * push operation. If there has any problem on parentheses, program output
 * “Parentheses do not match!” message otherwise it output "Parentheses are
 * correct!".
 *
 *
 *
 * @author Mert Gunay 
 * @since 2018-10-30
 */
public class Checker {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.print("Enter a mathematical expression: ");

        Scanner keyboard = new Scanner(System.in);

        myStack<Character> counter = new myStack<Character>();
        ArrayList<Character> myList = new ArrayList<Character>();

        String a = "";
        String b = "string";
        int x = 0;
        StringBuilder sb = new StringBuilder(a);
        String line = keyboard.nextLine();

        for (int i = 0; i < line.length(); i++) {
            char letter;
            letter = line.charAt(i);
            //if char is ( this push the stack  
            if (letter == '(') {
                myList.add('(');
                counter.push('(');
                sb.append('(');
                sb.reverse();
                b = sb.toString();
                x++;
                System.out.println("Stack Contents: [top] " + b + " [bottom]");
            }
            //if char is [ this push the stack  
            if (letter == '[') {
                myList.add('[');
                counter.push('[');
                sb.append('[');
                b = sb.toString();
                sb.reverse();
                x++;
                System.out.println("Stack Contents: [top] " + b + " [bottom]");
            }
            //if char is ) this push the stack 
            if (letter == ')') {
                x--;
                if (counter.isEmpty()) {
                    counter.push(')');
                    x = 0;
                    break;
                } else {
                    if (counter.peek() == '(') {
                        for (int j = 0; j < myList.size(); j++) {
                            if (myList.get(j).equals('(')) {
                                sb.deleteCharAt(j);
                                myList.remove(j);
                            }
                        }
                        counter.pop();
                    } else {
                        counter.push(')');
                        x = 0;
                        break;
                    }
                }
            }
            //if char is ] this push the stack 
            if (letter == ']') {
                x--;
                if (counter.isEmpty()) {
                    counter.push(']');
                    x = 0;
                    break;
                } else {
                    if (counter.peek() == '[') {

                        for (int j = 0; j < myList.size(); j++) {
                            if (myList.get(j).equals('[')) {
                                //    System.out.println(sb.toString());
                                sb.deleteCharAt(j);
                                myList.remove(j);
                            }
                        }
                        counter.pop();
                    } else {
                        counter.push(']');
                        x = 0;
                        break;
                    }
                }
            }
        }
        //checking the stack size and print the results.
        if (counter.isEmpty()) {
            System.out.println("Parentheses are correct!");
            //System.out.println(x);
        } else {
            if (x == 0) {
                System.out.println("Parentheses do not match!");
                // System.out.println(x);
            } else {
                System.out.println("Parentheses do not match: Final stack is not empty!");
                // System.out.println(x);
            }
        }
        keyboard.close();
    }
}
