#include <stdio.h>

int main(){
    double fahrenheit,celsius;    
    printf("enter degree in fahrenheit: ");
    scanf("%lf", &fahrenheit);
    celsius =  (5.0/9.0) * (fahrenheit - 32);
    printf("%lf fahrenheit = %lf celsius", fahrenheit,celsius );
}