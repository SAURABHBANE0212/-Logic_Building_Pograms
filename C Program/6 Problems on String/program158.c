//Display Name with space

#include<stdio.h>

int main()
{
    char Arr[10];

    printf("Enter your name : \n");
    scanf("%[^'\n']s",Arr);    

    printf("Your name is : %s\n",Arr);

    return 0;
}