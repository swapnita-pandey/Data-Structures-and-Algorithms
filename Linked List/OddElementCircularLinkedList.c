#include <stdio.h>
#include <stdlib.h>
struct node
{
    int data;
    struct node *next;
} * head, *temp;
void creatLinkList(int n);
void display();
int main()
{
    int n;
    printf("enter the number of nodes");
    scanf("%d", &n);
    creatLinkList(n);
    display();
}
void creatLinkList(int n)
{
    int i, num;
    struct node *newNode;
    if (n >= 1)
    {
        head = (struct node *)malloc(sizeof(struct node));
        if (head != 0)
        {
            printf("enter the data");
            scanf("%d", &num);
            head->data = num;
            head->next = NULL;
            temp = head;

            for (i = 2; i <= n; i++)
            {
                newNode = (struct node *)malloc(sizeof(struct node));
                if (newNode != 0)
                {
                    printf("enter the data");
                    scanf("%d", &num);
                    newNode->data = num;
                    temp->next = newNode;
                    newNode->next = NULL;
                    temp = newNode;
                }
                temp->next = head;
            }
        }
    }
}
void display()
{
    struct node *tmp;
    tmp = head;
    printf("\ndisplay odd element of the Circular Linked List\n");
    while (tmp->next != head)
    {
        if (tmp->data % 2 != 0)
        {
            printf("%d\t", tmp->data);
        }
        tmp = tmp->next;
    }
    if(tmp->data%2!=0)
    {
    printf("%d", tmp->data); // checking if last element is odd or not
    }
}
