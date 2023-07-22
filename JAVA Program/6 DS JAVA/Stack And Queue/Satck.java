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

class StackX
{
    public Node first;
    public int iCount;

    public StackX()
    {
        this.first = null;
        this.iCount =0;
    }

    public void Display()
    {
        System.out.println("Element of list are : ");

        Node temp = first;
        for(int iCnt =0;iCnt<iCount;iCnt++)
        {
            System.out.print("| "+temp.data+" |-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int Count()
    {
        return iCount;
    }

    public void push(int No) //InsertLast
    {
        Node newn = new Node(No);
    
        if(first == null)
        {
            first = newn;
        }
        else
        {
            Node temp = first;

            while(temp.next != null)
            {
                temp=temp.next;
            }

            temp.next = newn;
        }
        iCount++;
    }

    public void pop() //DeleteLast
    {
        if(first == null)
        {
            return;
        }
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            Node temp = first;

            while(temp.next.next != null)
            {
                temp = temp.next;
            }

            temp.next = null;
        }
        iCount--;
    }
}

class Stack
{
    public static void main(String arg[])
    {
        StackX obj = new StackX();

        obj.push(121);
        obj.push(131);
        obj.push(141);

        obj.Display();
        System.out.println("Number of element in list are : "+obj.Count());

        obj.pop();
        obj.Display();
        System.out.println("Number of element in list are : "+obj.Count());

        obj.push(151);
        obj.Display();
        System.out.println("Number of element in list are : "+obj.Count());

        obj.pop();
        obj.Display();
        System.out.println("Number of element in list are : "+obj.Count());
    }
}