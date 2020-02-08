import java.util.ArrayList;
import java.util.Scanner;

public class Q3Tester
{
    public static String addSpace(Integer[] num)
    {
        String ret = "";
        for(int i=0;i<num.length;i++)
        {
            if(i>0)
            {
                ret = ret + " " + num[i];
            }
            else
            {
                ret = ret + num[i];
            }
        }
        return ret;

    }
    public static ArrayList<Integer> returnPos(String str,ArrayList<Integer> num)
    {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<str.length();i++)
        {
            for(int k=0;k<num.size();k++)
            {
                String tmp = Integer.toString(num.get(k));
                if(tmp.compareTo(String.valueOf(str.charAt(i))) == 0)
                {
//                    System.out.println("---"+str.charAt(i)+"---");
                    res.add(i);
                }
            }
        }
        return res;
    }
    public static void printGuess(String question,ArrayList<Integer> indices,ArrayList<Integer> wrong) {
        int j = 0;
        String result = "";
        for (int i = 0; i < question.length(); i++)
        {
            int tester = 0;
            if (j < indices.size())
            {
                if (i == indices.get(j))
                {
                    result = result + question.charAt(i);
                    j++;
                    tester = 1;
                }
            }
                if (question.charAt(i) != ' ' && tester==0)
                {
                    result = result + "_";
                }
                else if(question.charAt(i) == ' ')
                {
                    result = result + " ";
                }
        }
        if(wrong.size()>0)
        {
            result = result + "  ";
            for(int i=0;i<wrong.size();i++)
            {
                result = result + wrong.get(i) + " ";
            }
        }
        System.out.println(result);
    }
    public static void main(String[] arguments)
    {
        try
        {
            Scanner in = new Scanner(System.in);
            Integer[] question = new Integer[12];
            int score = 0;
            ArrayList<Integer> guess = new ArrayList<>();
            ArrayList<Integer> wrong = new ArrayList<>();
            for(int i=0;i<12;i++)
            {
                System.out.println("Enter an integer:");
                String inp = in.nextLine();
                int num = Integer.parseInt(inp);
                if(num>=0 && num<10)
                {
                    question[i] = num;
                }
                else
                {
                    System.out.println("Integer should be from 0 to 9");
                    i--;
                }
            }
            String res = Q3Tester.addSpace(question);
            System.out.println(res);
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
            ArrayList<Integer> ret = new ArrayList<>();
            for(int i=0;i<5;i++)
            {
                System.out.println("Chance "+(i+1));
                String inp2 = in.nextLine();
                int num2 = Integer.parseInt(inp2);
                if(num2>=0 && num2<10)
                {
                    if(!guess.contains(num2))
                    {
                        guess.add(num2);
                        if(!res.contains(String.valueOf(num2)))
                        {
                            wrong.add(num2);
                        }
                        ret = Q3Tester.returnPos(res,guess);
                    }
                    printGuess(res,ret,wrong);
                    if(i==4)
                    {
                        score = ret.size();
                    }
                }
                else
                {
                    System.out.println("Integer should be from 0 to 9");
                    i--;
                }

            }
            System.out.println("Score: "+score);
        }
        catch(Exception e)
        {
            if(e instanceof NumberFormatException)
            {
                System.out.println("Error - Please enter an integer");
            }
            else
            {
                e.printStackTrace();
            }
        }
    }
}
