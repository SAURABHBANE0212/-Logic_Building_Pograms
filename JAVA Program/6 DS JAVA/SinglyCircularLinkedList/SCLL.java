// Singly Circular linked list

class Node
{
    public int data;
    public Node next;

    public Node(int No)
    {
        this.data = No;
        this.next = null;
    }
}

class SinglyCL
{
    public Node first;
    public Node last;
    public int iCount;

    public SinglyCL()
    {
        this.first = null;
        this.last = null;
        this.iCount =0;
    }

    public void Display()
    {
        System.out.println("Element in List are : ");
        Node temp = first;
        for(int iCnt =0;iCnt<iCount;iCnt++)
        {
            System.out.print("| "+temp.data+" |-> ");
            temp= temp.next;
        }
        System.out.println("null");
    }

    public int Count()
    {
        return iCount;
    }

    public void InsertFirst(int No)
    {
        Node newn = new Node(No);

        if(first == null && last == null)
        {
            first = newn;
            last = newn;
        }
        else
        {
            newn.next = first;
            first = newn;
        }
        last.next = first;
        iCount++;
    }
    public void InsertLast(int No)
    {
        Node newn = new Node(No);

        if(first == null && last == null)
        {
            first.next = newn;
            last.next = newn;
        }
        else
        {
            newn.next = last.next;
            last.next = newn;
            last = newn;

        }
        last.next = first;
        iCount++;
    }

    public void DeleteFirst()
    {
        if(iCount==0)
        {
            System.out.println("Linked List is empty");
            return;
        }
        else if(iCount ==1)
        {
            first = null;
            last = null;
        }
        else
        {
            first= first.next;
        }
        last.next = first;
        iCount--;
    }

    public void DeleteLast()
    {
        if(iCount==0)
        {
            System.out.println("Linked List is empty");
            return;
        }
        else if(iCount ==1)
        {
            first = null;
            last = null;
        }
        else
        {
            Node temp = first;

            while(temp.next != last)
            {
                temp= temp.next;
            }
            last = temp;
        }
        last.next = first;
        iCount--;
    }

    public void InsertAtPos(int No, int iPos)
    {
        if(iPos<1 || iPos>iCount+1)
        {
            System.out.println("Invalide position");
            return;
        }

        if(iPos ==1)
        {
            InsertFirst(No);
        }
        else if(iPos == iCount+1)
        {
            InsertLast(No);
        }
        else
        {
            Node temp = first;

            for(int iCnt =1;iCnt<iPos-1;iCnt++)
            {
                temp= temp.next;
            }

            Node newn = new Node(No);

            newn.next = temp.next;
            temp.next = newn;
            last.next = first;
            iCount++;
        }
        
    }

    public void DeleteAtPos(int iPos)
    {
        if(iPos<1 || iPos>iCount)
        {
            System.out.println("Invalide position");
            return;
        }

        if(iPos ==1)
        {
            DeleteFirst();
        }
        else if(iPos == iCount)
        {
            DeleteLast();
        }
        else
        {
            Node temp = first;

            for(int iCnt =1;iCnt<iPos-1;iCnt++)
            {
                temp= temp.next;
            }
            
            temp.next = temp.next.next;
            last.next = first;
            iCount--;
        }
        
    }

}

class SCLL
{
    public static void main(String arg[])
    {
        SinglyCL obj = new SinglyCL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.Display();
        System.out.println("Number of element in list is : "+obj.Count());

        obj.InsertLast(101);
        obj.InsertLast(111);
        obj.Display();
        System.out.println("Number of element in list is : "+obj.Count());

        obj.InsertAtPos(55,4);
        obj.Display();
        System.out.println("Number of element in list is : "+obj.Count());

        obj.DeleteAtPos(4);
        obj.Display();
        System.out.println("Number of element in list is : "+obj.Count());
        
        obj.DeleteFirst();
        obj.DeleteLast();
        obj.Display();
        System.out.println("Number of element in list is : "+obj.Count());
       
    }
}