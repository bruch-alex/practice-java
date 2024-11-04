## Exercise 1: `map()`

1. Given a list of strings, use the `map()` operation to convert all strings to uppercase.

```java
List<String> strings = Arrays.asList("hello", "world", "java", "streams");
List<String> uppercaseStrings = strings.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());
System.out.println(uppercaseStrings); // Output: [HELLO, WORLD, JAVA, STREAMS]
```

2. Given a list of integers, use the `map()` operation to square each number.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> squaredNumbers = numbers.stream()
                                      .map(n -> n * n)
                                      .collect(Collectors.toList());
System.out.println(squaredNumbers); // Output: [1, 4, 9, 16, 25]
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

List<String> personStrings = people.stream()
                                    .map(p -> "Name: " + p.getName() + ", Age: " + p.getAge())
                                    .collect(Collectors.toList());
System.out.println(personStrings); // Output: [Name: Alice, Age: 25, Name: Bob, Age: 30, Name: Charlie, Age: 35]
```

## Exercise 2: `flatMap()`

1. Given a list of strings, use the `flatMap()` operation to create a single stream containing all the characters of all the strings.

```java
List<String> strings = Arrays.asList("hello", "world", "java", "streams");
List<Character> characters = strings.stream()
                                    .flatMap(str -> str.chars().mapToObj(c -> (char) c))
                                    .collect(Collectors.toList());
System.out.println(characters); // Output: [h, e, l, l, o, w, o, r, l, d, j, a, v, a, s, t, r, e, a, m, s]
```

2. Given a list of lists of integers, use the `flatMap()` operation to create a single stream containing all the integers.

```java
List<List<Integer>> lists = Arrays.asList(
    Arrays.asList(1, 2, 3),
    Arrays.asList(4, 5),
    Arrays.asList(6, 7, 8, 9)
);
List<Integer> allIntegers = lists.stream()
                                 .flatMap(list -> list.stream())
                                 .collect(Collectors.toList());
System.out.println(allIntegers); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
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

List<String> authorNames = books.stream()
                                .flatMap(book -> book.getAuthors().stream())
                                .map(Author::getName)
                                .collect(Collectors.toList());
System.out.println(authorNames); // Output: [Author 1, Author 2, Author 3, Author 2, Author 4]
```

## Exercise 3: `distinct()`

1. Given a list of integers, use the `distinct()` operation to remove duplicates.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 1, 5);
List<Integer> distinctNumbers = numbers.stream()
                                       .distinct()
                                       .collect(Collectors.toList());
System.out.println(distinctNumbers); // Output: [1, 2, 3, 4, 5]
```

2. Given a list of strings, use the `distinct()` operation to remove duplicate strings (case-insensitive).

```java
List<String> strings = Arrays.asList("hello", "WORLD", "java", "HELLO", "streams");
List<String> distinctStrings = strings.stream()
                                      .map(String::toLowerCase)
                                      .distinct()
                                      .collect(Collectors.toList());
System.out.println(distinctStrings); // Output: [hello, world, java, streams]
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

List<Person> distinctPeople = people.stream()
                                    .distinct()
                                    .collect(Collectors.toList());
System.out.println(distinctPeople); // Output: [Alice@1c28e079, Bob@7e32176f, Charlie@77bbc7c7]
```

Note: In the last example, the `distinct()` operation uses the `equals()` method of the `Person` class to determine equality. If you want to distinguish objects based on the `name` and `age` fields, you'll need to override the `equals()` and `hashCode()` methods in the `Person` class.

## Exercise 4: `sorted()`

1. Given a list of integers, use the `sorted()` operation to sort the list in ascending order.

```java
List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7);
List<Integer> sortedNumbers = numbers.stream()
                                     .sorted()
                                     .collect(Collectors.toList());
System.out.println(sortedNumbers); // Output: [1, 2, 5, 7, 9]
```

2. Given a list of strings, use the `sorted()` operation to sort the list in alphabetical order (case-insensitive).

```java
List<String> strings = Arrays.asList("hello", "World", "java", "Streams", "Apple");
List<String> sortedStrings = strings.stream()
                                    .sorted(String.CASE_INSENSITIVE_ORDER)
                                    .collect(Collectors.toList());
System.out.println(sortedStrings); // Output: [Apple, Streams, World, hello, java]
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

List<Employee> sortedEmployees = employees.stream()
                                          .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                                          .collect(Collectors.toList());

for (Employee employee : sortedEmployees) {
    System.out.println(employee.getName() + ": " + employee.getSalary());
}
// Output:
// Bob: 60000.0
// Charlie: 55000.0
// Alice: 50000.0
```

## Exercise 5: `count()`

1. Given a list of integers, use the `count()` operation to count the number of even numbers.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
long evenCount = numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .count();
System.out.println("Number of even numbers: " + evenCount); // Output: Number of even numbers: 5
```

2. Given a list of strings, use the `count()` operation to count the number of strings that start with a vowel.

```java
List<String> strings = Arrays.asList("hello", "world", "java", "apple", "streams", "ink");
long vowelStartCount = strings.stream()
                              .filter(str -> str.matches("^[aeiou].*"))
                              .count();
System.out.println("Number of strings starting with a vowel: " + vowelStartCount); // Output: Number of strings starting with a vowel: 2
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

long booksOver500Pages = books.stream()
                              .filter(book -> book.getPages() > 500)
                              .count();
System.out.println("Number of books with more than 500 pages: " + booksOver500Pages); // Output: Number of books with more than 500 pages: 1
```

## Exercise 6: `filter()`

1. Given a list of integers, use the `filter()` operation to create a new list containing only positive numbers.

```java
List<Integer> numbers = Arrays.asList(1, -2, 3, -4, 5, -6, 7, -8, 9, -10);
List<Integer> positiveNumbers = numbers.stream()
                                       .filter(n -> n > 0)
                                       .collect(Collectors.toList());
System.out.println(positiveNumbers); // Output: [1, 3, 5, 7, 9]
```

2. Given a list of strings, use the `filter()` operation to create a new list containing only strings with more than 5 characters.

```java
List<String> strings = Arrays.asList("hello", "world", "java", "streams", "lambda", "functional");
List<String> longerStrings = strings.stream()
                                    .filter(str -> str.length() > 5)
                                    .collect(Collectors.toList());
System.out.println(longerStrings); // Output: [world, streams, lambda, functional]
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

List<Person> adultFemales = people.stream()
                                  .filter(p -> p.getAge() >= 18 && p.getGender().equals("Female"))
                                  .collect(Collectors.toList());

for (Person person : adultFemales) {
    System.out.println(person.getName() + ": " + person.getAge() + ", " + person.getGender());
}
// Output:
// Alice: 25, Female
// Eve: 20, Female
```

## Exercise 7: `reduce()`

1. Given a list of integers, use the `reduce()` operation to calculate the sum of all numbers.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream()
                  .reduce(0, (a, b) -> a + b);
System.out.println("Sum: " + sum); // Output: Sum: 15
```


2. Given a list of strings, use the `reduce()` operation to concatenate all strings into a single string.

```java
List<String> strings = Arrays.asList("hello", "world", "java", "streams");
String concatenated = strings.stream()
                             .reduce("", (a, b) -> a + b);
System.out.println("Concatenated: " + concatenated); // Output: Concatenated: helloworldjavastreams
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

double totalCost = products.stream()
                           .map(Product::getPrice)
                           .reduce(0.0, Double::sum);
System.out.println("Total cost: " + totalCost); // Output: Total cost: 34.47
```


Note that we could also use the `mapToDouble()` operation instead of `map()` and `reduce()` with `Double::sum` for a more concise solution:

```java
double totalCost = products.stream()
                           .mapToDouble(Product::getPrice)
                           .sum();
```

