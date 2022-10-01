#include <stdio.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node *next;
} * head, *temp;
void creatLL(int);
void display();
void sortThell(int);
int main()
{
    int n, f, place;
    printf("enter the numbe rof node");
    scanf("%d", &n);
    creatLL(n);
    sortThell(n);
    display();
}
void creatLL(int n)
{
    int i, num;
    struct node *newNode;
    if (n >= 1)
    {
        head = (struct node *)malloc(sizeof(struct node));
        if (head != NULL)
        {
            printf("enter the data");
            scanf("%d", &num);
            head->data = num;
            head->next = NULL;
            temp = head;

            for (i = 2; i <= n; i++)
            {
                newNode = (struct node *)malloc(sizeof(struct node));
                printf("entet the data");
                scanf("%d", &num);
                newNode->data = num;
                temp->next = newNode;
                newNode->next = NULL;
                temp = newNode;
            }
        }
    }
}
void display()
{
    struct node *tmp;
    tmp = head;
    printf("after sorting elements are :\n");
    while (tmp != NULL)
    {
        printf("%d\t", tmp->data);
        tmp = tmp->next;
    }
}
void sortThell(int n)
{
    struct node *nextNode;
    struct node *prevNode;
    for (int i = 0; i < n; i++)
    {
        prevNode=head;
        nextNode=prevNode->next;
        for(int j=i+1;j<n;j++)
        {
            if(prevNode->data>nextNode->data)                
            {
                int t=prevNode->data;
                prevNode->data=nextNode->data;
                nextNode->data=t;
            }
            prevNode=nextNode;
            nextNode=nextNode->next;
        }
    }
}
