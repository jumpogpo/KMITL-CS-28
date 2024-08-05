//65050368
#include <stdio.h>

#define PI 3.14
#define CIRCLE_AREA(r) (PI * (r) * (r))

int main() {
    printf("area = %f\n", CIRCLE_AREA(3 + 2));
    printf("area = %f\n", CIRCLE_AREA(3.5 + 2));
}
