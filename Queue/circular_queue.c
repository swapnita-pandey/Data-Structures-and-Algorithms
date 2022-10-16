#include <stdio.h>
int enqueue(int[],int);
int dequeue(int[],int);
void display(int[],int,int);
#define MAX 5

int main(){
    int a[MAX],front=-1,rear=-1;
    printf("Enter 1 for Enqueue\nEnter 2 for Dequeue\nEnter 3 for Display\nEnter 4 for Exit\n");
    int choice;
    do{
        printf("\nEnter your choice: ");
        scanf("%d",&choice);
        switch(choice){
            case 1: if((rear+1)%MAX==front){
                printf("Queue is Full");
                break;
            }
            else{
                rear=enqueue(a,rear);
                if(front==-1){
                    front++;
                }
                break;
            }
            case 2: if(front==-1 && rear==-1){
                printf("Queue is Empty");
                break;
            }
            else{
                front=dequeue(a,front);
                if(front==MAX){
                    front=rear=-1;
                }
                break;
            }
            case 3: display(a,front,rear);
            break;
            case 4: break;
        }
    }while(choice!=4);
}

int enqueue(int a[],int rear){
    int x;
    printf("Enter the element: ");
    scanf("%d",&x);
    rear=(rear+1)%MAX;
    a[rear]=x;
    return rear;
}
int dequeue(int a[],int front){
    printf("The element that is dequeued is %d\n",a[front]);
    front=(front+1)%MAX;
    return front;
}
void display(int a[],int front,int rear){
    int temp=front;
    if(front==-1 && rear==-1){
        printf("Queue is Empty");
    }
    else{
        printf("The elements in the stack are: ");
        do{
            printf("%d ",a[temp]);
            temp=(temp+1)%MAX;
        }while(temp!=rear);
        printf("%d",a[temp]);
    }
}
