#include <stdio.h>
#define MAX 20
int main()
{
    int n,i,element,index,a[MAX];
    printf("Enter the number of elements you want: ");
    scanf("%d",&n);
    printf("The entered elements are: ");
    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    printf("Enter the index at which you want to add the element: ");
    scanf("%d",&index);
    printf("Enter the element that you want to add: ");
    scanf("%d",&element);
    for(i=n-1;i>=index;i--)
    {
       a[i+1]=a[i];
    }
    a[index]=element;
    printf("The resultant array is: ");
    for(i=0;i<=n;i++)
    {
       printf("%d ",a[i]);
    }
}
