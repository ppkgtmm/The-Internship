import java.util.Scanner;

public class Utils{
    public static String getInput(String message, Scanner in ) {
        System.out.println("Enter number of inputs: ");
        return in.nextLine();
    }

    // public static void main(String[] args){
    //     try{
    //         System.out.println(Utils.ParseInt("123a"));
    //     }
    //     catch(Exception error){
    //         System.out.println("error");
    //     }
    // }
}