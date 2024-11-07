# Java Streams API Exercise Solutions

## Section 1: Max/Min using `reduce()`

### Practice Task Solutions

1. Finding Maximum:
```java
List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);
Optional<Integer> max = numbers.stream()
    .reduce((a, b) -> a > b ? a : b);
System.out.println("Max: " + max.orElse(0));
```

2. Finding Minimum:
```java
List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);
Optional<Integer> min = numbers.stream()
    .reduce((a, b) -> a < b ? a : b);
System.out.println("Min: " + min.orElse(0));
```

### Additional Exercise Solutions

1. Identity Problem Explanation:
```java
// Problematic approach
Integer maxWithIdentity = numbers.stream()
    .reduce(0, (a, b) -> a > b ? a : b);
// This fails when all numbers are negative because 0 becomes the maximum
```

2. Longest String:
```java
List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
Optional<String> longestWord = words.stream()
    .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
```

3. Highest Salary:
```java
Optional<Employee> highestPaid = employees.stream()
    .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
```

## Section 2: `limit()` and `skip()`

### Practice Task Solutions

1. First 5 Even Numbers:
```java
List<Integer> firstFiveEven = IntStream.rangeClosed(1, 100)
    .boxed()
    .filter(n -> n % 2 == 0)
    .limit(5)
    .collect(Collectors.toList());
```

2. Skip and Limit:
```java
List<Integer> skipAndLimit = IntStream.rangeClosed(1, 100)
    .boxed()
    .skip(50)
    .limit(10)
    .collect(Collectors.toList());
```

### Additional Exercise Solutions

1. Pagination Function:
```java
public List<T> getPage(List<T> items, int pageNumber, int pageSize) {
    return items.stream()
        .skip((pageNumber - 1) * pageSize)
        .limit(pageSize)
        .collect(Collectors.toList());
}
```

2. Third to Seventh Elements:
```java
List<T> elements = list.stream()
    .skip(2)
    .limit(5)
    .collect(Collectors.toList());
```

3. Last 5 Elements:
```java
public <T> List<T> getLastFive(List<T> list) {
    return list.stream()
        .skip(Math.max(0, list.size() - 5))
        .collect(Collectors.toList());
}
```

## Section 3: Match Operations

### Practice Task Solutions

1. All Even Check:
```java
List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
boolean allEven = numbers.stream()
    .allMatch(n -> n % 2 == 0);
```

2. Long Word Check:
```java
List<String> words = Arrays.asList("hello", "world", "java", "stream");
boolean hasLongWord = words.stream()
    .anyMatch(w -> w.length() > 5);
```

### Additional Exercise Solutions

1. No Negatives Check:
```java
boolean noNegatives = numbers.stream()
    .noneMatch(n -> n < 0);
```

2. All Adults Check:
```java
boolean allAdults = people.stream()
    .allMatch(p -> p.getAge() >= 18);
```

3. High Salary Check:
```java
boolean hasHighEarner = employees.stream()
    .anyMatch(e -> e.getSalary() > 100000);
```

## Section 4: `findAny()` and `findFirst()`

### Practice Task Solutions

1. First Even Number:
```java
Optional<Integer> firstEven = numbers.stream()
    .filter(n -> n % 2 == 0)
    .findFirst();
```

2. Any Number Greater Than 3:
```java
Optional<Integer> anyGreaterThan3 = numbers.stream()
    .filter(n -> n > 3)
    .findAny();
```

### Additional Exercise Solutions

1. Parallel Stream Demonstration:
```java
// findFirst() - Always returns same result
Optional<Integer> first = numbers.parallelStream()
    .filter(n -> n % 2 == 0)
    .findFirst();

// findAny() - May return different results
Optional<Integer> any = numbers.parallelStream()
    .filter(n -> n % 2 == 0)
    .findAny();
```

2. First Adult:
```java
Optional<Person> firstAdult = people.stream()
    .filter(p -> p.getAge() >= 18)
    .findFirst();
```

3. Find Employee by Job Title:
```java
Optional<Employee> developer = employees.stream()
    .filter(e -> "Developer".equals(e.getJobTitle()))
    .findAny();
```

## Section 5: Short-Circuiting Combined Operations

### Practice Task Solutions

1. First 5 Divisible by 7:
```java
List<Integer> firstFiveDivisibleBy7 = IntStream.rangeClosed(1, 1000000)
    .boxed()
    .filter(n -> {
        System.out.println("Checking " + n);
        return n % 7 == 0;
    })
    .limit(5)
    .collect(Collectors.toList());
```

2. Efficient Existence Check:
```java
boolean hasMatch = numbers.stream()
    .anyMatch(n -> {
        System.out.println("Checking " + n);
        return n > 100000;
    });
```

### Additional Exercise Solutions

1. Combined Operations:
```java
Optional<Integer> result = numbers.stream()
    .skip(10)
    .filter(n -> n % 2 == 0)
    .limit(5)
    .findFirst();
```

2. Strings Starting with `'A'`:
```java
List<String> result = strings.stream()
    .filter(s -> s.startsWith("A"))
    .filter(s -> s.length() > 5)
    .limit(3)
    .collect(Collectors.toList());
```

3. Even and Divisible by 3:
```java
Optional<Integer> result = numbers.stream()
    .filter(n -> n > 0)
    .filter(n -> n % 2 == 0)
    .filter(n -> n % 3 == 0)
    .findFirst();
```

## Bonus Challenge Solutions

### Practice Challenge Solution:
```java
Person result = people.stream()
    .skip(10)
    .limit(10)
    .filter(p -> p.getAge() >= 18)
    .filter(p -> p.getName().startsWith("J"))
    .findFirst()
    .orElse(new Person("Default", 0));
```

### Additional Challenge Solutions

1. Top 5 Young Earners Average:
```java
double avgSalary = employees.stream()
    .filter(e -> e.getAge() < 30)
    .sorted(Comparator.comparing(Employee::getSalary).reversed())
    .limit(5)
    .mapToDouble(Employee::getSalary)
    .average()
    .orElse(0.0);
```

2. High-Salary Departments:
```java
List<Department> result = departments.stream()
    .filter(dept -> dept.getEmployees().stream()
        .allMatch(e -> e.getSalary() > 50000))
    .limit(3)
    .collect(Collectors.toList());
```

3. Product Search:
```java
Optional<Product> product = products.stream()
    .filter(p -> p.getStock() > 0)
    .filter(p -> p.getPrice() < 100)
    .filter(p -> p.getRating() > 4.5)
    .filter(p -> p.getReviewCount() >= 10)
    .findFirst();
```
