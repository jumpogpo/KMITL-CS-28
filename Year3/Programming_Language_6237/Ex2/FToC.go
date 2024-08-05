package main

import "fmt"

func main() {
	var fahrenheit float64
	fmt.Print("Enter degree in Fahrenheit: ")
	fmt.Scan(&fahrenheit)
	fmt.Printf("%.1f Fahrenheit = %.1f Celsius\n", fahrenheit, (5.0/9.0)*(fahrenheit-32))
}
