# Java Streams API Exercises

## Exercise 1: `map()`

1. Given a list of strings, use the `map()` operation to convert all strings to uppercase.

```java
List<String> strings = Arrays.asList("hello", "world", "java", "streams");
// Your code here
```

2. Given a list of integers, use the `map()` operation to square each number.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
// Your code here
```

3. Given a list of `Person` objects with `name` and `age` fields, use the `map()` operation to create a list of strings in the format `"Name: <name>, Age: <age>"`.

```java
class Person {
    String name;
    int age;
    // Constructor, getters, and setters
}

List<Person> people = Arrays.asList(
    new Person("Alice", 25),
    new Person("Bob", 30),
    new Person("Charlie", 35)
);
// Your code here
```

## Exercise 2: `flatMap()`

1. Given a list of strings, use the `flatMap()` operation to create a single stream containing all the characters of all the strings.

```java
List<String> strings = Arrays.asList("hello", "world", "java", "streams");
// Your code here
```

2. Given a list of lists of integers, use the `flatMap()` operation to create a single stream containing all the integers.

```java
List<List<Integer>> lists = Arrays.asList(
    Arrays.asList(1, 2, 3),
    Arrays.asList(4, 5),
    Arrays.asList(6, 7, 8, 9)
);
// Your code here
```

3. Given a list of `Book` objects with `title` and `authors` fields (where `authors` is a list of `Author` objects), use the `flatMap()` operation to create a stream of all author names.

```java
class Author {
    String name;
    // Constructor, getters, and setters
}

class Book {
    String title;
    List<Author> authors;
    // Constructor, getters, and setters
}

List<Book> books = Arrays.asList(
    new Book("Book 1", Arrays.asList(new Author("Author 1"), new Author("Author 2"))),
    new Book("Book 2", Arrays.asList(new Author("Author 3"))),
    new Book("Book 3", Arrays.asList(new Author("Author 2"), new Author("Author 4")))
);
// Your code here
```

## Exercise 3: `distinct()`

1. Given a list of integers, use the `distinct()` operation to remove duplicates.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 1, 5);
// Your code here
```

2. Given a list of strings, use the `distinct()` operation to remove duplicate strings (case-insensitive).

```java
List<String> strings = Arrays.asList("hello", "WORLD", "java", "HELLO", "streams");
// Your code here
```

3. Given a list of `Person` objects with `name` and `age` fields, use the `distinct()` operation to remove persons with the same name and age.

```java
class Person {
    String name;
    int age;
    // Constructor, getters, and setters
}

List<Person> people = Arrays.asList(
    new Person("Alice", 25),
    new Person("Bob", 30),
    new Person("Charlie", 35),
    new Person("Alice", 25)
);
// Your code here
```

## Exercise 4: `sorted()`

1. Given a list of integers, use the `sorted()` operation to sort the list in ascending order.

```java
List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7);
// Your code here
```

2. Given a list of strings, use the `sorted()` operation to sort the list in alphabetical order (case-insensitive).

```java
List<String> strings = Arrays.asList("hello", "World", "java", "Streams", "Apple");
// Your code here
```

3. Given a list of `Employee` objects with `name`, `age`, and `salary` fields, use the `sorted()` operation to sort the list by salary in descending order.

```java
class Employee {
    String name;
    int age;
    double salary;
    // Constructor, getters, and setters
}

List<Employee> employees = Arrays.asList(
    new Employee("Alice", 25, 50000),
    new Employee("Bob", 30, 60000),
    new Employee("Charlie", 35, 55000)
);
// Your code here
```

## Exercise 5: `count()`

1. Given a list of integers, use the `count()` operation to count the number of even numbers.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
// Your code here
```

2. Given a list of strings, use the `count()` operation to count the number of strings that start with a vowel.

```java
List<String> strings = Arrays.asList("hello", "world", "java", "apple", "streams", "ink");
// Your code here
```

3. Given a list of `Book` objects with `title`, `author`, and `pages` fields, use the `count()` operation to count the number of books with more than 500 pages.

```java
class Book {
    String title;
    String author;
    int pages;
    // Constructor, getters, and setters
}

List<Book> books = Arrays.asList(
    new Book("Book 1", "Author 1", 300),
    new Book("Book 2", "Author 2", 600),
    new Book("Book 3", "Author 3", 450),
    new Book("Book 4", "Author 4", 550)
);
// Your code here
```

## Exercise 6: `filter()`

1. Given a list of integers, use the `filter()` operation to create a new list containing only positive numbers.

```java
List<Integer> numbers = Arrays.asList(1, -2, 3, -4, 5, -6, 7, -8, 9, -10);
// Your code here
```

2. Given a list of strings, use the `filter()` operation to create a new list containing only strings with more than 5 characters.

```java
List<String> strings = Arrays.asList("hello", "world", "java", "streams", "lambda", "functional");
// Your code here
```

3. Given a list of `Person` objects with `name`, `age`, and `gender` fields, use the `filter()` operation to create a new list containing only adults (age >= 18) of a specific gender.

```java
class Person {
    String name;
    int age;
    String gender;
    // Constructor, getters, and setters
}

List<Person> people = Arrays.asList(
    new Person("Alice", 25, "Female"),
    new Person("Bob", 17, "Male"),
    new Person("Charlie", 35, "Male"),
    new Person("Eve", 20, "Female")
);
// Your code here
```

## Exercise 7: `reduce()`

1. Given a list of integers, use the `reduce()` operation to calculate the sum of all numbers.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
// Your code here
```

2. Given a list of strings, use the `reduce()` operation to concatenate all strings into a single string.

```java
List<String> strings = Arrays.asList("hello", "world", "java", "streams");
// Your code here
```

3. Given a list of `Product` objects with `name` and `price` fields, use the `reduce()` operation to calculate the total cost of all products.

```java
class Product {
    String name;
    double price;
    // Constructor, getters, and setters
}

List<Product> products = Arrays.asList(
    new Product("Product 1", 10.99),
    new Product("Product 2", 15.49),
    new Product("Product 3", 7.99)
);
// Your code here
```
