import java.util.*;

public class twoDarrays{
    // This program takes a 2D array as input and finds the indices of a given element in the array.
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int [][] twod= new int[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                twod[i][j]=sc.nextInt();
            }
         }
        System.out.println("Enter the element to find indices");
        int x = sc.nextInt();
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (twod[i][j]==x){
                    System.out.println("Element found at index: "+i+","+j);
                }
            }
            System.out.println();
        }
    }
    
}
