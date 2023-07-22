// Doubly Circular linked list


class Node
{
    public int data;
    public Node next;
    public Node prev;

    public Node(int No)
    {
        this.data = No;
        this.next = null;
        this.prev = null;
    }
}

class DoublyCL
{
    public Node first;
    public Node last;
    public int iCount;

    public DoublyCL()
    {
        this.first = null;
        this.last = null;
        this.iCount =0;
    }

    void Display()
    {
        System.out.println("Element of list are : ");
        Node temp = first;
        for(int icnt = 1; icnt <= iCount; icnt++)
        {
            System.out.print("| "+temp.data+" |<=> ");
            temp = temp.next;
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
            first= newn;
            last = newn;
        }
        else
        {
            newn.next =first;
            first.prev = newn;
            first = newn;
        }
        last.next = first;
        first.prev = last;
        iCount++;
    }
    public void InsertLast(int No)
    {
        Node newn = new Node(No);
        if(first == null && last == null)
        {
            first= newn;
            last = newn;
        }
        else
        {
            newn.prev = last;
            last.next = newn;
            last = newn;
        }
        last.next = first;
        first.prev = last;
        iCount++;
    }

    public void DeleteFirst()
    {
        if(iCount==0)
        {
            return;
        }
        else if(iCount==1)
        {
            first = null;
            last = null;
        }
        else
        {
            first= first.next;
        }
        last.next = first;
        first.prev = last;
        iCount--;
    }

    public void DeleteLast()
    {
        if(iCount ==0)
        {
            return;
        }
        else if(iCount ==1)
        {
            first = null;
            last = null;
        }
        else
        {
            last = last.prev;

        }
        last.next = first;
        first.prev = last;
        iCount--;
    }

    public void InsertAtPos(int No,int iPos)
    {
        if((iPos < 1) || (iPos > iCount+1))
        {
            System.out.println("Invalid position");
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

            for(int iCnt=1;iCnt<iPos-1;iCnt++)
            {
                temp = temp.next;
            }
            Node newn = new Node(No);

            newn.next = temp.next;
            temp.next.prev = newn;
            newn.prev = temp;
            temp.next = newn;
            iCount++;
        }
    }

    public void DeleteAtPos(int iPos)
    {
        if((iPos < 1) || (iPos > iCount))
        {
            System.out.println("Invalid position");
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

            for(int iCnt=1;iCnt<iPos-1;iCnt++)
            {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            iCount--;
        }
    }
}

class DCLL
{
    public static void main(String arg[])
    {
        DoublyCL obj = new DoublyCL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.InsertLast(101);
        obj.InsertLast(111);

        obj.InsertAtPos(55,4);
        obj.Display();
        
        System.out.println("Number of elements are : "+obj.Count()); 

        obj.DeleteAtPos(4);

        obj.Display();

        System.out.println("Number of elements are : "+obj.Count()); 

        obj.DeleteFirst();               
        obj.DeleteLast();

        obj.Display();

        System.out.println("Number of elements are : "+obj.Count()); 
    }
}