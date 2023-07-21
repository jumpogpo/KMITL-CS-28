#include <stdio.h>
int main() {
    int a,b,c;
    printf("Enter a number : ");
    scanf("%d", &a);
    printf("Enter two number : ");
    scanf("%d %d", &b, &c);
    printf("Summation = %d\n", a+b+c);
    return 0;
}