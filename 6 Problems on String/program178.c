//Problem Statement= Accept string from user and replace every capital letter from that string with '*' 
//                    and replace every small letter from that string with '$' 


#include<stdio.h>

void EditString(char *str)
{
    while(*str != '\0')
    {
        if((*str >= 'A') && (*str <= 'Z'))
        {
            *str = '*';
        }
        else if((*str >= 'a') && (*str <= 'z'))
        {
            *str = '$';
        }
        str++;
    }
}

int main()
{
    char Arr[20];

    printf("Enter string : \n");
    scanf("%[^'\n']s",Arr);

    EditString(Arr);

    printf("String after editing is : %s\n",Arr);

    return 0;
}