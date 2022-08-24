#include <stdio.h>
#include <stdlib.h>

int main()
{
    int p, r;
    printf("Enter the values of number of processes p and r: ");
    scanf("%d", &p);
    scanf("%d", &r);
    int max[p][r];
    int allocation[p][r];
    printf("Enter the max matrix: ");
    for(int i = 0; i < p; i++)
    {
        for(int j = 0; j < r; j++)
        {
            scanf("%d", &max[i][j]);
        }
    }

    printf("Enter the allocation matrix: ");
    for(int i = 0; i < p; i++)
    {
        for(int j = 0; j < r; j++)
        {
            scanf("%d", &allocation[i][j]);
        }
    }

    printf("    Max \t Allocation\n");
    for(int j = 0; j < r; j++)
    {
        printf(" R%d", j+1);
    }
    printf("\t");
    for(int j = 0; j < r; j++)
    {
        printf(" R%d", j+1);
    }
    printf("\n");

    for(int i = 0; i < p; i++)
    {
        printf("P%d ", i+1);
        for(int j = 0; j < r; j++)
        {
            printf("%d ", max[i][j]);
        }
        printf("\t");
        for(int j = 0; j < r; j++)
        {
            printf("%d ", allocation[i][j]);
        }
        printf("\n");
    }
}
