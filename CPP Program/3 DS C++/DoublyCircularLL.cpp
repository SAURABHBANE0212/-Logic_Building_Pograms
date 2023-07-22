#include<iostream>
using namespace std;

typedef class node
{
    public:
        int data;
        node *next;
        node *prev;

        node(int value)
        {
            data = value;
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
            iCount = 0;
        }

        virtual void InsertFirst(int ino) = 0;
        virtual void InsertLast(int ino) = 0;
        virtual void InsertAtPos(int ino, int ipos) = 0;

        virtual void DeleteFirst() = 0;
        virtual void DeleteLast() = 0;
        virtual void DeleteAtPos(int ipos) = 0;

        void Display()
        {
            PNODE temp = First;

            cout<<"Elements of Linked List are : "<<"\n";

            for(int icnt = 1; icnt <= iCount; icnt++)
            {
                cout<<"| "<<temp->data<<" |-> ";
                temp = temp -> next;
            }
            cout<<"NULL"<<"\n";
        }

        int Count()
        {
            return iCount;
        }
};

class DoublyCL : public LinkedList
{
    private:
        PNODE Last;

    public:
        DoublyCL();

        void InsertFirst(int ino);
        void InsertLast(int ino);
        void InsertAtPos(int ino, int ipos);

        void DeleteFirst();
        void DeleteLast();
        void DeleteAtPos(int ipos);
};

DoublyCL:: DoublyCL()
{
    Last = NULL;
}

void DoublyCL::InsertFirst(int ino)
{
    PNODE newn = new NODE(ino);

    if(First == NULL && Last == NULL)
    {
        First = newn;
        Last = newn;
    }
    else
    {
        newn->next = First;
        First -> prev = newn;
        First = newn;
    }

    Last -> next = First;
    First -> prev = Last;

    iCount++;
}

void DoublyCL::InsertLast(int ino)
{
    PNODE newn = new NODE(ino);

    if(First == NULL && Last == NULL)
    {
        First = newn;
        Last = newn;
    }
    else
    {
        Last -> next = newn;
        newn->prev = Last;
        Last = Last -> next;
    }

    Last -> next = First;
    First -> prev = Last;
    
    iCount++;
}

void DoublyCL::DeleteFirst()
{
    if(iCount == 0)      
    {
        return; 
    }
    else if(iCount == 1)    
    {
        delete First;
        First = NULL;
        Last = NULL;
    }
    else     
    {
        First = First->next;
        delete Last->next; 

        First->prev = Last;
        Last->next = First;
    }

    iCount--;
}

void DoublyCL::DeleteLast()
{
    if(iCount == 0)        
    {
        return; 
    }
    else if(iCount == 1)      
    {
        delete First;
        First = NULL;
        Last = NULL;
    }
    else       
    {
        Last = Last -> prev;
        delete Last->next;

        First->prev = Last;
        Last->next = First;
    }

    iCount--;
}

void DoublyCL::DeleteAtPos(int ipos)
{
    if((ipos < 1) || (ipos > iCount))
    {
        cout<<"Invalid position\n";
        return;
    }
    
    if(ipos == 1)
    {
        DeleteFirst();
    }
    else if(ipos == iCount)
    {
        DeleteLast();
    }
    else
    {
        PNODE temp = First;

        for(int icnt = 1; icnt < ipos -1; icnt++)
        {
            temp = temp->next;
        }

        temp->next = temp->next->next;
        delete temp->next->prev;
        temp->next->prev = temp;

        iCount--;
    }
}

void DoublyCL::InsertAtPos(int ino, int ipos)
{
    if((ipos < 1) || (ipos > iCount+1))
    {
        cout<<"Invalid position\n";
        return;
    }
    
    if(ipos == 1)
    {
        InsertFirst(ino);
    }
    else if(ipos == iCount+1)
    {
        InsertLast(ino);
    }
    else
    {
        PNODE temp = First;

        for(int icnt = 1; icnt < ipos -1; icnt++)
        {
            temp = temp->next;
        }

        PNODE newn = new NODE(ino);

        newn->next = temp->next;
        temp->next->prev = newn;

        temp->next = newn;
        newn->prev = temp;

        iCount++;
    }
}


int main()
{
    DoublyCL obj;
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