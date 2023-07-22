// count number of digit 
import java.util.*;

class Digits
{
    int CountDigits(int iValue)
    {
        int iCount = 0;

        while(iValue != 0)
        {
            iCount++;
            iValue = iValue / 10;
        }
        return iCount;
    }
}

class program337
{
    public static void main(String arg[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter number : ");
        int iNo = sobj.nextInt();

        Digits dobj = new Digits();
        int iRet = dobj.CountDigits(iNo);
        System.out.println("Number of digits are : "+iRet);
    }
}