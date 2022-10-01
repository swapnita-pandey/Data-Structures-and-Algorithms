#include <stdio.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node *next;
} * head, *temp;
void creatLL(int);
void display();
int findElement(int);
int main()
{
    int n, f, place;
    printf("enter the numbe rof node");
    scanf("%d", &n);
    creatLL(n);
    display();
    printf("\nenter the element to be searched");
    scanf("%d", &f);
    place = findElement(f);
    if (place <= n)
    {
        printf("element is at node of pos %d", place);
    }
    else
    {
        printf("element not found");
    }
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
    while (tmp != NULL)
    {
        printf("%d\t", tmp->data);
        tmp = tmp->next;
    }
}
int findElement(int f)
{
    int count = 1;
    struct node *tmp;
    tmp = head;
    while (tmp->next != NULL)
    {
        if (tmp->data == f)
        {
            break;
        }
        else
        {
            count++;
            tmp = tmp->next;
        }
    }
    return count;
}
