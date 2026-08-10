package Strings;
import java.util.*;
public class stringreversal{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the string to be reversed");
        StringBuilder str = new StringBuilder (sc.nextLine()); 
        System.out.println("The reversed string is: "+ str.reverse());
    }
}//palindrome