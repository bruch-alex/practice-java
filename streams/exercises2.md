# Java Streams API Exercises

## Section 1: Max/Min using `reduce()`

### Practice Tasks
1. Write a stream operation to find the maximum number from a list of integers using `reduce()` without using an identity value.
2. Find the minimum number from a list of integers using `reduce()` without using an identity value.

### Additional Exercises
1. Explain why using an identity value (like 0) for finding max/min with `reduce()` can be problematic.
2. Find the longest string from a list of strings using `reduce()`.
3. Find the person with the highest salary from a list of employees using `reduce()`.

## Section 2: `limit()` and `skip()`

### Practice Tasks
1. From a list of numbers 1-100, get the first 5 even numbers using streams.
2. From a list of numbers 1-100, skip the first 50 numbers and get the next 10 numbers.

### Additional Exercises
1. Implement a pagination function that takes a list, page number, and page size.
2. Get the third to seventh elements from a list using streams.
3. Create a function that returns the last 5 elements of a list using streams.

## Section 3: Match Operations

### Practice Tasks
1. Write a stream operation to check if all numbers in a list are even.
2. Check if any word in a list of strings has length greater than 5.

### Additional Exercises
1. Verify that no numbers in a list are negative.
2. Write a stream operation to check if all persons in a list are adults (`age >= 18`).
3. Check if any employee in a list has a salary greater than 100,000.

## Section 4: `findAny()` and `findFirst()`

### Practice Tasks
1. Find the first even number in a list using streams.
2. Find any number greater than 3 in a list using streams.

### Additional Exercises
1. Demonstrate the difference between `findAny()` and `findFirst()` using a parallel stream.
2. Find the first person in a list who is an adult.
3. Find any employee with a specific job title.

## Section 5: Short-Circuiting Combined Operations

### Practice Tasks
1. Find the first 5 numbers that are divisible by 7 from a list of 1 to 1,000,000. Add logging to demonstrate short-circuiting.
2. Write an efficient stream operation to check if any number greater than 100,000 exists in a large list.

### Additional Exercises
1. Combine `skip()`, filter(), `limit()`, and `findFirst()` to find the first even number from the second page of a list.
2. Find the first three strings that start with 'A' and have length greater than 5.
3. Create a function that returns the first positive number that is both even and divisible by 3.

## Bonus Challenges

### Practice Challenge
Write a stream operation that finds the first person who:
- Is an adult (`age >= 18`)
- Has a name starting with `'J'`
- Is from the second page (`page size = 10`)
- Returns a default person if no match is found

### Additional Challenges
1. Find the average salary of the top 5 earning employees who are under 30 years old.
2. Create a function that returns the first three departments that have all employees with salaries above 50,000.
3. Implement a search function that finds the first product that:
   - Has stock available
   - Is priced under $100
   - Has a rating above 4.5
   - Has been reviewed by at least 10 customers
