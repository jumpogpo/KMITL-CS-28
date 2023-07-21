#include <stdio.h>
int main() {
    int sum = 0, amount = 0;

    while(1) {
        int input;
        printf("Enter a number : ");
        scanf("%d", &input);
        if (input <= 0) break;
        sum += input;
        amount += 1;
    }

    printf("summation = %d avg = %d\n", sum, sum / amount);
    return 0;
}