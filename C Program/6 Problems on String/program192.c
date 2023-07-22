//Accept two string from User Concate the containt of first string at the end of second string 
//just concate Number of letter specified by the user

#include<stdio.h>

void strncatX(char *src, char *dest, int iLength)
{
    // 1 : travel till end of dest
    while(*dest != '\0')
    {
        dest++;
    }

    // 2 : copy the data from src to dest
    while((*src != '\0') && (iLength != 0))
    {
        *dest = *src;
        dest++;
        src++;
        
        iLength--;
    }
    
    // 3 : write '\0' at the end of dest
    *dest = '\0';
}

int main()
{
    char Arr[20];
    char Brr[20] = "Demo";
    int iNo = 0;

    printf("Enter string : \n");
    scanf("%[^'\n']s",Arr);

    printf("Enter the number of letters that you want to concate\n");
    scanf("%d",&iNo);

    strncatX(Arr,Brr,iNo);

    printf("String after concatenation is : %s\n",Brr);

    return 0;
}