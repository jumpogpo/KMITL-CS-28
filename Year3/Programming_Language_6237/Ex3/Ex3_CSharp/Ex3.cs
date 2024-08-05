using System;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("การประกาศตัวแปรแบบ Static Typing");
        string name = "Thanapat";
        int age = 20;
        double weight = 56;
        bool isCompleted = true;

        Console.WriteLine("Name: " + name);
        Console.WriteLine("Age: " + age);
        Console.WriteLine("weight: " + weight);
        Console.WriteLine("isCompleted: " + isCompleted);

        Console.WriteLine("------------------------------------");

        Console.WriteLine("การประกาศตัวแปรแบบ Implicit Typing");
        var number = 60;
        var city = "Bangkok";
        var temperature = 36.5;
        var isCompleted2 = true;

        Console.WriteLine("number: " + number + " Type: " + number.GetType());
        Console.WriteLine("City: " + city + " Type: " + city.GetType());
        Console.WriteLine("Temperature: " + temperature + " Type: " + temperature.GetType());
        Console.WriteLine("isCompleted2: " + isCompleted2 + " Type: " + isCompleted2.GetType());

        Console.WriteLine("------------------------------------");

        Console.WriteLine("การประกาศตัวแปรแบบ Dynamic Typing");
        dynamic anything = 11.1;
        Console.WriteLine("Dynamic value: " + anything);

        anything = "Now I'm a double!";
        Console.WriteLine("Dynamic value: " + anything);

        anything = new { Message = "Hello Dynamic!" };
        Console.WriteLine("Dynamic value: " + anything.Message);
    }
}
