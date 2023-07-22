#include<iostream>
using namespace std;

typedef class node
{
    public:
        int data;
        node *next;
        node *prev;

        node(int Value)
        {
            data =Value;
            next = NULL;
            prev = NULL;
        }
}NODE, *PNODE;

class LinkedList
{
    public:
        PNODE First;
        int iCount;

        LinkedList()
        {
            First = NULL;
            iCount =0;
        }

        virtual void InsertFirst(int iNo)=0;
        virtual void InsertLast(int iNo)=0;
        virtual void InsertAtPos(int iNo, int iPos)=0;

        virtual void DeleteFirst()=0;
        virtual void DeleteLast()=0;
        virtual void DeleteAtPos(int iPos)=0;

        void Display()
        {
            PNODE temp= First;

            cout<<"Element of Linked List are : "<<"\n";

            for(int icnt =1;icnt<= iCount;icnt++)
            {
                cout<<"| "<<temp->data<<" |-> ";
                temp = temp->next;
            }
            cout<<"NULL"<<"\n";
        }

        int Count()
        {
            return iCount;
        }

};

class DoublyLL : public LinkedList
{
    public:

        void InsertFirst(int iNo);
        void InsertLast(int iNo);
        void InsertAtPos(int No,int iPos);

        void DeleteFirst();
        void DeleteLast();
        void DeleteAtPos(int iPos);

};

void DoublyLL :: InsertFirst(int iNo)
{
    PNODE newn= new NODE(iNo);

    if(First == NULL)
    {
        First = newn;
    }
    else
    {
        newn->next = First;
        First->prev = newn;
        First = newn;
    }
    iCount++;
}
void DoublyLL :: InsertLast(int iNo)
{
    PNODE newn= new NODE(iNo);

    if(First == NULL)
    {
        First = newn;
    }
    else
    {
        PNODE temp = First;
        while(temp->next != NULL)
        {
            temp= temp->next;
        }
        newn->prev = temp;
        temp->next = newn;
    }
    iCount++;
}

void DoublyLL :: DeleteFirst()
{
    if(iCount ==0)
    {
        return;
    }
    else if(iCount == 1)
    {
        delete First;
        First = NULL;
    }
    else
    {
        First= First->next;
        delete First->prev;
        First->prev = NULL;
    }
    iCount--;
}
void DoublyLL :: DeleteLast()
{
    if(iCount ==0)
    {
        return;
    }
    else if(iCount == 1)
    {
        delete First;
        First = NULL;
    }
    else
    {
        PNODE temp= First;
        while(temp->next->next != NULL)
        {
            temp= temp->next;
        }
        delete temp->next;
        temp->next = NULL;
    }
    iCount--;
}

void DoublyLL :: InsertAtPos(int No,int iPos)
{
    if((iPos<1) || (iPos>iCount+1))
    {
        cout<<"Invalide Position\n";
        return;
    }

    if(iPos==1)
    {
        InsertFirst(No);
    }
    else if(iPos == iCount+1)
    {
        InsertLast(No);
    }
    else
    {
        PNODE temp = First;

        for(int icnt=1; icnt<iPos-1;icnt++)
        {
            temp= temp->next;
        }

        PNODE newn = new NODE(No);
        newn->next = temp->next;
        temp->next->prev = newn;
        newn->prev = temp;
        temp->next = newn;
        iCount++;
    }
}
void DoublyLL :: DeleteAtPos(int iPos)
{
        if((iPos<1) || (iPos>iCount))
    {
        cout<<"Invalide Position\n";
        return;
    }

    if(iPos==1)
    {
        DeleteFirst();
    }
    else if(iPos == iCount)
    {
        DeleteLast();
    }
    else
    {
        PNODE temp = First;
        PNODE tempX = NULL;

        for(int icnt=1; icnt<iPos-1;icnt++)
        {
            temp= temp->next;
        }

        tempX = temp->next;

        temp->next = temp->next->next;
        temp->next->prev = temp;
        delete tempX;
        iCount--;
    }
}

int main()
{
    DoublyLL obj;
    int iRet =0;

    obj.InsertFirst(51);
    obj.InsertFirst(21);
    obj.InsertFirst(11);

    obj.Display();
    iRet = obj.Count();
    cout<<"Length of Linked List is : "<<obj.Count()<<"\n";

    obj.InsertLast(101);
    obj.InsertLast(111);

    obj.Display();
    iRet = obj.Count();
    cout<<"Length of Linked List is : "<<obj.Count()<<"\n";

    obj.InsertAtPos(55,4);
    obj.Display();
    iRet = obj.Count();
    cout<<"Length of Linked List is : "<<obj.Count()<<"\n";

    obj.DeleteAtPos(4);
    obj.Display();
    iRet = obj.Count();
    cout<<"Length of Linked List is : "<<obj.Count()<<"\n";

    obj.DeleteFirst();
    obj.DeleteLast();

    obj.Display();
    iRet = obj.Count();
    cout<<"Length of Linked List is : "<<obj.Count()<<"\n";

    return 0;
}