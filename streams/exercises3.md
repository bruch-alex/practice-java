# Java Streams API Exercises

## Factory Methods

### Practice 
1. Create a stream of integers using `Stream.of()` with numbers 1 to 5.
2. Create a stream of your three favorite fruits using `Stream.of()`.

### Extra 
1. Use `Stream.generate()` to create a stream of 10 random numbers between 1-100.
2. Create an infinite stream of UUIDs using `Stream.generate()` and limit to 5.

### Bonus 
1. Use `Stream.iterate()` to generate the first 10 powers of 2.
2. Generate Fibonacci sequence up to first 8 numbers using `Stream.iterate()`.

### Challenge 
1. Create a custom sequence using `Stream.iterate()` that generates alternating positive and negative numbers, limit to first 10.

## Numeric Streams

### Practice 
1. Create an `IntStream` from 1 to 10 using `range()`.
2. Generate a `DoubleStream` of 5 elements containing the value 1.5.

### Extra 
1. Use `LongStream.rangeClosed()` to calculate sum of first 100 natural numbers.
2. Create an `IntStream` of even numbers from 1 to 20.

### Bonus 
1. Generate a `DoubleStream` of the first 5 square roots starting from 1.
2. Create an `IntStream` of the first 10 prime numbers.

### Challenge 
1. Create a custom number sequence using appropriate numeric stream that represents triangular numbers (1, 3, 6, 10, 15, ...) up to the 8th number.

## Numeric Stream Operations

### Practice 
1. Find sum and average of numbers 1 to 5 using `IntStream`.
2. Find max and min values in array: `{45, 12, 56, 15, 24}`.

### Extra 
1. Calculate standard deviation of numbers: `{10, 20, 30, 40, 50}`.
2. Find median of numbers: `{13, 23, 12, 44, 56, 42}`.

### Bonus 
1. Calculate factorial of 5 using `IntStream`.
2. Find sum of squares of odd numbers from 1 to 10.

### Challenge 
1. Calculate running average of a stream of numbers (each element represents average up to that point).

## Boxing/Unboxing & Mapping

### Practice 
1. Convert `IntStream` of 1-5 to `List<Integer>` using boxing.
2. Convert `List<Integer>` to `IntStream` using unboxing.

### Extra 
1. Map stream of integers to their string representations.
2. Convert stream of strings ("1", "2", "3") to sum of integers.

### Bonus 
1. Convert stream of temperatures in Celsius to Fahrenheit using appropriate mapping.
2. Transform stream of dates to stream of day names.

### Challenge 
1. Create a complex mapping that converts stream of coordinates (x,y) to distances from origin (0,0).

## Parallel Streams

### Practice 
1. Create a parallel stream from list of integers and find their sum.
2. Convert a sequential stream operation to parallel stream.

### Extra 
1. Compare execution time of sequential vs parallel stream for counting prime numbers up to 100000.
2. Use parallel stream to convert list of strings to uppercase.

### Bonus 
1. Implement parallel processing of large file content using streams.
2. Calculate factorial of large numbers using parallel streams.

### Challenge 
1. Create a custom spliterator for parallel processing of a binary tree structure.

```java
// Starter code for Challenge exercises

// Custom sequence challenge
public static Stream<Integer> generateAlternatingSequence() {
    // Your code here
}

// Triangular numbers challenge
public static IntStream generateTriangularNumbers() {
    // Your code here
}

// Running average challenge
public static Stream<Double> calculateRunningAverage(int[] numbers) {
    // Your code here
}

// Distance calculator challenge
class Point {
    double x, y;
    // Add constructor and methods
}
public static Stream<Double> calculateDistances(Stream<Point> points) {
    // Your code here
}

// Binary tree parallel processing challenge
class TreeNode<T> {
    T value;
    TreeNode<T> left, right;
    // Add constructor and methods
}
public static <T> Spliterator<T> treeNodeSpliterator(TreeNode<T> root) {
    // Your code here
}
```
