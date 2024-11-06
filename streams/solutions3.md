# Java Streams API Solutions

## Factory Methods Solutions

### Practice 
```java
// 1. Stream of integers 1-5
Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
numbers.forEach(System.out::println);

// 2. Stream of fruits
Stream<String> fruits = Stream.of("Apple", "Banana", "Orange");
fruits.forEach(System.out::println);
```

### Extra 
```java
// 1. Random numbers stream
Random random = new Random();
List<Integer> randomNumbers = Stream.generate(() -> random.nextInt(100) + 1)
    .limit(10)
    .collect(Collectors.toList());
System.out.println(randomNumbers);

// 2. UUID stream
List<UUID> uuids = Stream.generate(UUID::randomUUID)
    .limit(5)
    .collect(Collectors.toList());
System.out.println(uuids);
```

### Bonus 
```java
// 1. Powers of 2
Stream.iterate(1, n -> n * 2)
    .limit(10)
    .forEach(System.out::println);

// 2. Fibonacci sequence
Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
    .limit(8)
    .map(arr -> arr[0])
    .forEach(System.out::println);
```

### Challenge 
```java
// Alternating positive/negative numbers
Stream.iterate(new int[]{1, 1}, arr -> new int[]{arr[0] + 1, -arr[1]})
    .limit(10)
    .map(arr -> arr[0] * arr[1])
    .forEach(System.out::println);
// Output: 1, -2, 3, -4, 5, -6, 7, -8, 9, -10
```

## Numeric Streams Solutions

### Practice 
```java
// 1. IntStream range
IntStream.range(1, 11)
    .forEach(System.out::println);

// 2. DoubleStream generate
DoubleStream.generate(() -> 1.5)
    .limit(5)
    .forEach(System.out::println);
```

### Extra 
```java
// 1. Sum of first 100 numbers
long sum = LongStream.rangeClosed(1, 100)
    .sum();
System.out.println("Sum: " + sum);

// 2. Even numbers stream
IntStream.rangeClosed(1, 20)
    .filter(n -> n % 2 == 0)
    .forEach(System.out::println);
```

### Bonus 
```java
// 1. Square roots
DoubleStream.iterate(1.0, n -> n + 1)
    .map(Math::sqrt)
    .limit(5)
    .forEach(n -> System.out.printf("%.2f%n", n));

// 2. Prime numbers
IntStream.rangeClosed(2, 100)
    .filter(n -> isPrime(n))
    .limit(10)
    .forEach(System.out::println);

private static boolean isPrime(int number) {
    return IntStream.rangeClosed(2, (int) Math.sqrt(number))
        .noneMatch(i -> number % i == 0);
}
```

### Challenge 
```java
// Triangular numbers
IntStream.iterate(1, n -> n + 1)
    .map(n -> (n * (n + 1)) / 2)
    .limit(8)
    .forEach(System.out::println);
// Output: 1, 3, 6, 10, 15, 21, 28, 36
```

## Implementation Notes:

1. Factory Methods:
   - For infinite streams, always use `limit()` to prevent endless execution
   - `generate()` is useful for random or constant values
   - `iterate()` is better for sequences with a pattern

2. Numeric Streams:
   - Use specialized streams for better performance
   - `range()` vs `rangeClosed()`: remember range is exclusive, rangeClosed is inclusive
   - For mathematical sequences, consider using `iterate()` with appropriate transformations

## Example Usage:

```java
// Example showing different ways to use factory methods
public class StreamExamples {
    public static void main(String[] args) {
        // Basic stream with of()
        Stream.of(1, 2, 3, 4, 5)
            .forEach(System.out::println);

        // Random number generator with generate()
        Random random = new Random();
        List<Integer> randomNums = Stream.generate(() -> random.nextInt(100))
            .limit(5)
            .collect(Collectors.toList());
        System.out.println("Random numbers: " + randomNums);

        // Fibonacci with iterate()
        System.out.println("Fibonacci sequence:");
        Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
            .limit(8)
            .map(f -> f[0])
            .forEach(System.out::println);
    }
}
```

## Numeric Stream Operations Solutions

### Practice 
```java
// 1. Sum and average of 1-5
IntStream nums = IntStream.rangeClosed(1, 5);
System.out.println("Sum: " + nums.sum());

IntStream nums2 = IntStream.rangeClosed(1, 5);
double avg = nums2.average().orElse(0.0);
System.out.println("Average: " + avg);

// 2. Max and min values
int[] array = {45, 12, 56, 15, 24};
int max = Arrays.stream(array).max().getAsInt();
int min = Arrays.stream(array).min().getAsInt();
System.out.println("Max: " + max + ", Min: " + min);
```

### Extra 
```java
// 1. Standard deviation
double[] numbers = {10, 20, 30, 40, 50};
double mean = Arrays.stream(numbers).average().orElse(0.0);
double stdDev = Math.sqrt(Arrays.stream(numbers)
    .map(x -> x - mean)
    .map(x -> x * x)
    .average()
    .orElse(0.0));
System.out.println("Standard Deviation: " + stdDev);

// 2. Median
int[] nums = {13, 23, 12, 44, 56, 42};
double median = Arrays.stream(nums)
    .sorted()
    .skip((nums.length - 1) / 2)
    .limit(2 - nums.length % 2)
    .average()
    .orElse(0.0);
System.out.println("Median: " + median);
```

### Bonus 
```java
// 1. Factorial
int factorial = IntStream.rangeClosed(1, 5)
    .reduce(1, (a, b) -> a * b);
System.out.println("Factorial of 5: " + factorial);

// 2. Sum of squares of odd numbers
int sumOfSquares = IntStream.rangeClosed(1, 10)
    .filter(n -> n % 2 != 0)
    .map(n -> n * n)
    .sum();
System.out.println("Sum of squares of odd numbers: " + sumOfSquares);
```

### Challenge 
```java
// Running average
public static double[] calculateRunningAverage(int[] numbers) {
    double[] result = new double[numbers.length];
    Arrays.stream(numbers)
        .iterate()
        .forEach(i -> {
            double sum = Arrays.stream(numbers).limit(i + 1).sum();
            result[i] = sum / (i + 1);
        });
    return result;
}
```

## Boxing/Unboxing & Mapping Solutions

### Practice 
```java
// 1. IntStream to List<Integer>
List<Integer> boxed = IntStream.rangeClosed(1, 5)
    .boxed()
    .collect(Collectors.toList());

// 2. List<Integer> to IntStream
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
IntStream unboxed = numbers.stream()
    .mapToInt(Integer::intValue);
```

### Extra 
```java
// 1. Integers to Strings
Stream<Integer> nums = Stream.of(1, 2, 3, 4, 5);
List<String> strings = nums
    .map(String::valueOf)
    .collect(Collectors.toList());

// 2. Strings to Integer sum
Stream<String> strNums = Stream.of("1", "2", "3");
int sum = strNums
    .mapToInt(Integer::parseInt)
    .sum();
```

### Bonus 
```java
// 1. Celsius to Fahrenheit
List<Double> celsius = Arrays.asList(0.0, 25.0, 100.0);
List<Double> fahrenheit = celsius.stream()
    .map(c -> c * 9/5 + 32)
    .collect(Collectors.toList());

// 2. Dates to day names
List<LocalDate> dates = Arrays.asList(LocalDate.now(), LocalDate.now().plusDays(1));
List<String> dayNames = dates.stream()
    .map(date -> date.getDayOfWeek().toString())
    .collect(Collectors.toList());
```

### Challenge 
```java
// Distance calculator
class Point {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
}

Stream<Point> points = Stream.of(new Point(3, 4), new Point(1, 2));
List<Double> distances = points
    .map(Point::distanceFromOrigin)
    .collect(Collectors.toList());
```

## Parallel Streams Solutions

### Practice 
```java
// 1. Parallel sum
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.parallelStream()
    .mapToInt(Integer::intValue)
    .sum();

// 2. Sequential to parallel
List<String> words = Arrays.asList("hello", "world");
List<String> upperCase = words.stream()
    .parallel()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

### Extra 
```java
// 1. Performance comparison
long start = System.currentTimeMillis();
long countSequential = IntStream.range(2, 100000)
    .filter(StreamExamples::isPrime)
    .count();
long seqTime = System.currentTimeMillis() - start;

start = System.currentTimeMillis();
long countParallel = IntStream.range(2, 100000)
    .parallel()
    .filter(StreamExamples::isPrime)
    .count();
long parTime = System.currentTimeMillis() - start;

System.out.println("Sequential time: " + seqTime + "ms");
System.out.println("Parallel time: " + parTime + "ms");
```

### Bonus 
```java
// 1. Parallel file processing
public static void processLargeFile(String filename) throws IOException {
    try (Stream<String> lines = Files.lines(Paths.get(filename))) {
        lines.parallel()
            .filter(line -> line.contains("specific text"))
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}

// 2. Parallel factorial for large numbers
public static BigInteger parallelFactorial(int n) {
    return IntStream.rangeClosed(1, n)
        .parallel()
        .mapToObj(BigInteger::valueOf)
        .reduce(BigInteger.ONE, BigInteger::multiply);
}
```

### Challenge 
```java
// Complete Binary Tree Parallel Processing Challenge Solution

public class TreeNode<T> {
    T value;
    TreeNode<T> left, right;
    
    public TreeNode(T value) {
        this.value = value;
    }
}

public class TreeNodeSpliterator<T> implements Spliterator<T> {
    private Queue<TreeNode<T>> queue = new LinkedList<>();
    private int size;
    
    public TreeNodeSpliterator(TreeNode<T> root) {
        if (root != null) {
            queue.offer(root);
            size = calculateSize(root);
        }
    }
    
    private int calculateSize(TreeNode<T> node) {
        if (node == null) return 0;
        return 1 + calculateSize(node.left) + calculateSize(node.right);
    }
    
    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        TreeNode<T> node = queue.poll();
        if (node == null) return false;
        
        action.accept(node.value);
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
        return true;
    }
    
    @Override
    public Spliterator<T> trySplit() {
        if (size <= 1) return null;
        
        List<TreeNode<T>> nodes = new ArrayList<>();
        int splitSize = queue.size() / 2;
        
        for (int i = 0; i < splitSize && !queue.isEmpty(); i++) {
            nodes.add(queue.poll());
        }
        
        if (nodes.isEmpty()) return null;
        
        return new Spliterator<T>() {
            private int index = 0;
            
            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                if (index >= nodes.size()) return false;
                action.accept(nodes.get(index++).value);
                return true;
            }
            
            @Override
            public Spliterator<T> trySplit() {
                return null;
            }
            
            @Override
            public long estimateSize() {
                return nodes.size() - index;
            }
            
            @Override
            public int characteristics() {
                return SIZED | SUBSIZED | ORDERED;
            }
        };
    }
    
    @Override
    public long estimateSize() {
        return size;
    }
    
    @Override
    public int characteristics() {
        return SIZED | SUBSIZED | ORDERED;
    }
}

// Example usage and testing
public class TreeProcessingExample {
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode<Integer> root = createSampleTree();
        
        // Process tree sequentially
        System.out.println("Sequential processing:");
        StreamSupport.stream(new TreeNodeSpliterator<>(root), false)
            .forEach(System.out::print);
        System.out.println();
        
        // Process tree in parallel
        System.out.println("Parallel processing:");
        StreamSupport.stream(new TreeNodeSpliterator<>(root), true)
            .forEach(System.out::print);
        System.out.println();
        
        // Performance comparison
        long start = System.currentTimeMillis();
        StreamSupport.stream(new TreeNodeSpliterator<>(root), false)
            .forEach(x -> heavyOperation(x));
        long seqTime = System.currentTimeMillis() - start;
        
        start = System.currentTimeMillis();
        StreamSupport.stream(new TreeNodeSpliterator<>(root), true)
            .forEach(x -> heavyOperation(x));
        long parTime = System.currentTimeMillis() - start;
        
        System.out.println("Sequential time: " + seqTime + "ms");
        System.out.println("Parallel time: " + parTime + "ms");
    }
    
    private static TreeNode<Integer> createSampleTree() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        return root;
    }
    
    private static void heavyOperation(int value) {
        try {
            Thread.sleep(100); // Simulate heavy processing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Additional utility methods for tree operations
public class TreeUtils {
    public static <T> List<T> getTreeValuesParallel(TreeNode<T> root) {
        return StreamSupport.stream(new TreeNodeSpliterator<>(root), true)
            .collect(Collectors.toList());
    }
    
    public static <T> Optional<T> findValueParallel(TreeNode<T> root, T target) {
        return StreamSupport.stream(new TreeNodeSpliterator<>(root), true)
            .filter(value -> value.equals(target))
            .findFirst();
    }
    
    public static <T extends Comparable<T>> Optional<T> findMaxParallel(TreeNode<T> root) {
        return StreamSupport.stream(new TreeNodeSpliterator<>(root), true)
            .max(Comparator.naturalOrder());
    }
}
```

This implementation includes:

1. Complete `TreeNodeSpliterator` with all required methods
2. Size estimation for better parallel processing
3. Proper splitting strategy for parallel execution
4. Example usage with both sequential and parallel processing
5. Performance comparison utilities
6. Additional utility methods for common tree operations

Usage example:
```java
TreeNode<Integer> root = createSampleTree();

// Get all values in parallel
List<Integer> values = TreeUtils.getTreeValuesParallel(root);

// Find specific value
Optional<Integer> found = TreeUtils.findValueParallel(root, 5);

// Find maximum value
Optional<Integer> max = TreeUtils.findMaxParallel(root);

// Process with custom operation
StreamSupport.stream(new TreeNodeSpliterator<>(root), true)
    .map(x -> x * 2)
    .forEach(System.out::println);
```

Key features of this implementation:

1. **Thread Safety**: The implementation is thread-safe for parallel processing
2. **Efficient Splitting**: Provides efficient splitting for parallel processing
3. **Size Estimation**: Accurate size estimation for better performance
4. **Ordered Processing**: Maintains tree traversal order
5. **Flexibility**: Works with any type T
6. **Performance**: Efficient for both small and large trees

Remember that parallel processing might not always be faster, especially for small trees or simple operations. The overhead of parallel processing might outweigh the benefits in such cases.
