#include <stdio.h>
#include <string.h>

struct Employee
{
    int id;
    char name[50];
    float salary;
    char designation[50];
}emp;

int main()
{
    printf("Enter employee id: ");
    scanf("%d", &emp.id);

    printf("Enter employee name: ");
    scanf("%s", &emp.name);

    printf("Enter employee salary: ");
    scanf("%f", &emp.salary);

    printf("Enter employee designation: ");
    scanf("%s", &emp.designation);

    printf("\nEmployee id: %d", emp.id);
    printf("\nEmployee name: %s", emp.name);
    printf("\nSalary: %f", emp.salary);
    printf("\nDesignation: %s", emp.designation);

}
