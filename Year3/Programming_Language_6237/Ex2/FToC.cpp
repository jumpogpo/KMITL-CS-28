#include <iostream>

using namespace std;

int main() {
      double fahrenheit,celsius;
      cout << "enter degree in fahrenheit: ";
      cin >> fahrenheit;
      celsius =  (5.0/9.0) * (fahrenheit - 32);
      cout << fahrenheit  << " fahrenheit =  " << celsius << " celsius" ;
}