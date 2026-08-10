import java.util.*;
public class stacks{
    public static void main(String[] args){
    Stack<String> lol= new Stack<String>();
    String [] laugh={"lmao","lol","hahahah"};
    System.out.println("PUSHING ELEMENTS INTO STACK");
    for(String a: laugh){
        lol.push(a);
        
    }
    System.out.println(lol);
    System.out.println("PEEKING ELEMENTS FROM STACK");
    System.out.println(lol.peek());
    System.out.println("POPPING ELEMENTS FROM STACK");
    do {

        System.out.println(lol.pop());
    }while(!lol.isEmpty());
    System.out.println("STACK IS EMPTY: " + lol.isEmpty());

}
}

