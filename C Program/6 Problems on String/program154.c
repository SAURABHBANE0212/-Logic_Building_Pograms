// problem statement : Except character from user check whether character is capital or not

#include<stdio.h>
#include<stdbool.h>

bool CheckCapital(char cValue)
{
    if((cValue >= 'A') && (cValue <= 'Z'))
    {
        return true;
    }
    else
    {
        return false;
    }
}

int main()
{
    char ch = '\0';
    bool bRet = false;

    printf("Enter character : \n");
    scanf("%c",&ch);

    bRet = CheckCapital(ch);

    if(bRet == true)
    {
        printf("%c is a capital letter\n",ch);
    }
    else
    {
        printf("%c is not a captial letter\n",ch);
    }

    return 0;
}