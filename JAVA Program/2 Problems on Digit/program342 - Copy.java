// find the armstrong Number in Array

import java.util.Scanner;

class ArrayX
{
    public int Arr[];

    public ArrayX(int iSize)
    {
        Arr = new int[iSize];
    }

    public void Accept()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter element of array : ");
        for(int iCnt =0;iCnt<Arr.length;iCnt++)
        {
            Arr[iCnt]= sobj.nextInt();
        }
    }

    public void Display()
    {
        System.out.println("Element of array are : ");
        for(int iCnt =0;iCnt<Arr.length;iCnt++)
        {
            System.out.print(Arr[iCnt]+"\t");
        }
        System.out.println("\n");
    }
}

class Numbers extends ArrayX
{
    public Numbers(int iSize)
    {
        super(iSize);
    } 

    public void ChkArmstrong()
    {
        System.out.println("Armstrong anUmber is : ");
        int iCnt =0;
        for(iCnt =0;iCnt<Arr.length;iCnt++)
        {
            int iTemp =0;
            iTemp=Arr[iCnt];
            int iCount =0;

            while(iTemp != 0)
            {
                iCount++;
                iTemp= iTemp/10;
            }

            iTemp = Arr[iCnt];
            int iDigit =0;
            int iSum =0;
            int iMul =1;
            while(Arr[iCnt] != 0)
            {
                iDigit = Arr[iCnt]%10;
                int i =0;
                for(i =1;i<=iCount;i++)
                {
                    iMul = iMul*iDigit;
                }
                iSum = iSum+iMul;
                iMul =1;
                Arr[iCnt] = Arr[iCnt]/10;
            }
            if(iSum == iTemp)
            {
                System.out.print(iTemp+"\t");
                iSum =0;
            }
            else
            {
                iSum =0;
            }
        }

    }
}

class Demo
{
    public static void main(String arg[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter size of element : ");
        int iSize = sobj.nextInt();

        Numbers nobj = new Numbers(iSize);

        nobj.Accept();
        nobj.Display();

        nobj.ChkArmstrong();
    }

}