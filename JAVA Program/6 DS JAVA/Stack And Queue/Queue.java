
class Node
{
    public int data;
    public Node next;

    public Node(int No)
    {
        this.data =No;
        this.next = null;
    }
}

class QueueX
{
    public Node first;
    public int iCount;

    public QueueX()
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

    public void Enqueue(int No)   // Insert Last
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
                temp = temp.next;
            }
            temp.next = newn;
        }
        iCount++;
    }

    public void Dequeue()   //Delete First
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
            first = first.next;
        }
        iCount--;
    }

}

class Queue
{
    public static void main(String arg[])
    {
        QueueX obj = new QueueX();

        obj.Enqueue(121);
        obj.Enqueue(131);
        obj.Enqueue(141);

        obj.Display();
        System.out.println("Number of element in list are : "+obj.Count());

        obj.Dequeue();
        obj.Display();
        System.out.println("Number of element in list are : "+obj.Count());

        obj.Enqueue(151);
        obj.Display();
        System.out.println("Number of element in list are : "+obj.Count());

        obj.Dequeue();
        obj.Display();
        System.out.println("Number of element in list are : "+obj.Count());

    }
}