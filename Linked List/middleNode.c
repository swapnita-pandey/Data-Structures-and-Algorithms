#include <stdio.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node *next;
} * temp, *head;

void createDCLL(int);                   // creating a list
void display();                         // displaying the lsit
struct node *middleNode(struct node *); // finding middle part and resturning middle node of linked list
int main()
{
    int n;
    printf("enter the no of node");
    scanf("%d", &n);
    createDCLL(n);
    head = middleNode(head); // updating head of the linked list ( pointing it to middle node of linked list )
    display();
}
void createDCLL(int n)
{
    int i, num;
    struct node *newnode;
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
        }
        for (i = 2; i <= n; i++)
        {
            newnode = (struct node *)malloc(sizeof(struct node));
            if (newnode != NULL)
            {
                printf("enter the data");
                scanf("%d", &num);
                newnode->data = num;
                temp->next = newnode;
                newnode->next = NULL;
                temp = newnode;
            }
        }
    }
}
void display()
{
    temp = head;
    while (temp != 0)
    {
        printf("%d\t", temp->data);
        temp = temp->next;
    }
}
struct node *middleNode(struct node *head)
{
    int c = 0, i = 0;
    struct node *current;
    current = head;
    while (current != NULL)
    {
        c++; // c = length of linked list
        current = current->next;
    }
    c = c / 2;
    current = head;
    while (i < c)
    {
        current = current->next;
        i++;
    }
    return current;
}
