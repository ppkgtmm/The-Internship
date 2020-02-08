import java.util.Scanner;

public class Q2Tester
{
    public static boolean isPrime(int n)
    {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean lengthCounter(String num)
    {
        int len = 0;
        boolean ret = false;
        String[] temp = String.valueOf(num).split("\\.");
        for(String str :temp)
        {
            len += str.length();
        }
        if(len>0 && len <13)
        {
            ret = true;
        }
        return ret;
    }
    public static int afterPoint(double num)
    {
        String[] temp = String.valueOf(num).split("\\.");
        return temp[1].length();
    }
    public  static void main(String[] arguments)
    {
        try {
            String number  = null;
            boolean bCont = true;
            Scanner in = new Scanner(System.in);
            while(true)
            {
                System.out.println("Enter a decimal number: ");
                number = in.nextLine();
                if(number.compareTo("0.0")==0)
                {
                    break;
                }
                boolean test = Q2Tester.lengthCounter(number);
                if(test)
                {
                    double num = Double.parseDouble(number);
                    if(num>1.0 && num<10.0)
                    {
                        int len = afterPoint(num);
                        int count = 0;
                        for(int i=1;i<=3;i++)
                        {
                            if(i>len)
                            {
                                break;
                            }
                            int round = (int) (num * Math.pow(10, i));
                            if (!Q2Tester.isPrime(round))
                            {
                                count++;
                            }
                        }
                        if((len<3 && count==len)|(count==3))
                        {
                            System.out.println("FALSE");
                        }
                        else
                        {
                            System.out.println("TRUE");
                        }
                    }
                    else if(num==0.0)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Decimal input must be between 1.0 and 10.0");
                    }
                }
                else
                {
                    System.out.println("Total digits of number entered must not exceed 12 digits ");
                }
            }

        }
        catch (Exception e)
        {
            if(e instanceof NumberFormatException)
            {
                System.out.println("Error - Please enter a decimal number");
            }
            else
            {
                e.printStackTrace();
            }
        }
    }
}
