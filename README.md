# Java_Lab
Lab 1 Program 1 :

  This Java program validates an 8 or 9-digit credit card number using a series of digit checks and transformations. It first confirms that the card number has the correct length, then removes and stores the last digit separately. Next, it reverses the remaining digits, doubles each digit in odd positions, and adjusts any doubled values over 9 by summing their individual digits. The program then sums all the digits and subtracts the last digit of this modified number from 10, comparing the result to the initially removed last digit to determine validity. If the result matches, the card is declared valid; otherwise, it is invalid. This tool demonstrates basic principles of credit card validation and is suitable for educational purposes.

Lab 1 Program 2 :

  The AlphabetWarGame program in Java simulates a word-based game where certain letters on the "left" and "right" sides of the alphabet are assigned different strengths. The program calculates and compares the total strengths of these sides based on letters in a word (or two separate words) entered by the user, and it determines the winning side or if there’s a tie. The game offers a default mode with preset strengths and a customizable mode for user-defined strengths. With intuitive methods for calculation and a simple console-based interface, this program demonstrates basic Java concepts, such as object-oriented programming, user input, loops, and conditional logic, making it beginner-friendly and ideal for learning purposes.

Lab 2 Program 1 :

  This Java program performs frequency analysis on an integer array by identifying the top K elements based on their occurrence frequency. Users input the array size, elements, and the value of K. The program then counts each element's frequency using a HashMap, sorts them in descending order by frequency (and by value if frequencies are equal), and outputs the K most frequent numbers. With built-in error handling, the program ensures that K is within valid range limits. This utility is useful for analyzing data patterns, finding common items, and implementing frequency-based filtering in various applications.

Lab 2 Program 2 :

  This Java program, ShareTrader, calculates the maximum profit achievable from an array of stock prices using at most two transactions (buy and sell). The program takes daily stock prices as input from the user and uses dynamic programming to compute the best possible profit through two key steps: calculating the maximum profit possible up to each day with the first transaction and then determining the maximum profit achievable from each day onward for a second transaction. Finally, it combines these results to output the maximum profit possible across both transactions. This program is particularly useful for understanding and testing basic stock trading strategies in Java.

Lab 3 Program :

  This Java program implements an employee payroll system that calculates weekly salary, annual earnings, and bonuses for different types of employees: HourlyEmployee, SalariedEmployee, and ExecutiveEmployee. Using inheritance and polymorphism, each employee type has unique calculations—hourly employees' weekly salary is based on hours worked, salaried employees receive a fixed monthly salary, and executive employees earn additional bonuses based on a percentage of their annual salary. The program prompts users for employee details, displays each employee's information, and computes the total payroll. This example highlights object-oriented principles in Java, such as method overriding and class hierarchy.

Lab 4 Program :

  This program simulates maximizing money robbed from different house arrangements while avoiding triggering security alarms. It features Row Houses (linear arrangement), Round Houses (circular arrangement), Square Houses, and a Multi-House Building with a repeating pattern of house types. It calculates the maximum money that can be robbed from each type using dynamic programming based on user input for the number of houses and the money in each. The program is implemented through an abstract class, Robber, and its subclass, JAVAProfessionalRobber, with methods tailored for each house type. To run, compile the program, input the house details when prompted, and get the maximum robbable amounts for each scenario.
