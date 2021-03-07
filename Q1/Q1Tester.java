import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q1Tester {

    public static ArrayList<String> getFirstUpper(List<String> inputs)
    {
        ArrayList<String> result = new ArrayList<>();
        for(String str: inputs)
        {
            String[] temp = str.split("\\s+");
            StringBuilder arr = new StringBuilder();
            for(String st:temp)
            {
                if(st.length()>0)
                {
                    if(Character.isUpperCase(st.charAt(0)))
                    {
                        arr.append(st.charAt(0));
                    }
                }
            }
            result.add(arr.toString());
        }
        return result;
    }

    public static void printReverse(String[] toPrint)
    {
        for(int i = toPrint.length-1;i>=0;i--)
        {
            if(toPrint[i].length()>0)
            {
                System.out.println(toPrint[i]);
            }
        }
    }

    public static void main(String arguments[])
    {
        try
        {
            ArrayList<String> result = new ArrayList<>();
            System.out.println("Enter number of inputs: ");
            Scanner in = new Scanner(System.in);
            List<String> inputs = null;
            int inp = Integer.parseInt(in.nextLine());
            for(int i = 0;i < inp;i++)
            {
                System.out.println("Enter input no. "+ (i+1) +" ");
                String tmp = in.nextLine();
                if(inputs==null)
                {
                    inputs = new ArrayList<>();
                }
                inputs.add(tmp);
            }
            result = Q1Tester.getFirstUpper(inputs);
            String[] res = new String[result.size()];
            res = result.toArray(res);
            Arrays.sort(res, (y, x) -> x.compareTo(y));
            Arrays.sort(res,(x,y) -> Integer.compare(x.length(),y.length()));
            printReverse(res);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
