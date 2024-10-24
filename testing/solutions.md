## **Solutions**

Here are the solutions to the exercise questions:

**Exercise 1: Mock an Object and Stub a Method**

```java
// CalculatorService.java
import java.util.List;

public class CalculatorService {
    public int calculateTotal(List<Integer> numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
}
```

```java
// CalculatorServiceTest.java
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CalculatorServiceTest {
    @Test
    void testCalculateTotal() {
        // Create a mock object of the List interface
        List<Integer> mockList = mock(List.class);

        // Stub the get method to return specific values
        when(mockList.get(0)).thenReturn(5);
        when(mockList.get(1)).thenReturn(10);
        when(mockList.get(2)).thenReturn(15);

        // Create an instance of CalculatorService
        CalculatorService calculatorService = new CalculatorService();

        // Call the calculateTotal method with the mocked list
        int total = calculatorService.calculateTotal(mockList);

        // Assert the result
        assertEquals(30, total);
    }
}
```

**Exercise 2: Create a Spy Object and Stub a Method Based on Arguments**

```java
// EmailService.java
public class EmailService {
    public boolean sendEmail(String to, String subject, String body) {
        // Actual implementation omitted for brevity
        return true;
    }
}
```

```java
// EmailServiceTest.java
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class EmailServiceTest {
    @Test
    void testSendEmail() {
        // Create a spy object of the EmailService class
        EmailService spyEmailService = spy(EmailService.class);

        // Stub the sendEmail method to return false for an invalid email
        doReturn(false).when(spyEmailService).sendEmail("invalid@example.com", "Test", "Test body");

        // Call the sendEmail method with a valid email
        boolean validResult = spyEmailService.sendEmail("valid@example.com", "Test", "Test body");
        assertTrue(validResult);

        // Call the sendEmail method with an invalid email
        boolean invalidResult = spyEmailService.sendEmail("invalid@example.com", "Test", "Test body");
        assertFalse(invalidResult);
    }
}
```

**Exercise 3: Suppress the Behavior of a Void Method**

```java
// UserService.java
public class UserService {
    public void deleteUser(String userId) {
        // Actual implementation omitted for brevity
        sendDeletionNotification(userId);
    }

    private void sendDeletionNotification(String userId) {
        System.out.println("Deletion notification sent for user: " + userId);
    }
}
```

```java
// UserServiceTest.java
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class UserServiceTest {
    @Test
    void testDeleteUser() {
        // Create a mock object of the UserService class
        UserService mockUserService = mock(UserService.class);

        // Suppress the behavior of the sendDeletionNotification method
        doNothing().when(mockUserService).sendDeletionNotification(anyString());

        // Call the deleteUser method
        mockUserService.deleteUser("user123");

        // Verify that the sendDeletionNotification method was called
        verify(mockUserService).sendDeletionNotification("user123");
    }
}
```

**Exercise 4: Use a Dummy Object to Satisfy a Method Parameter Requirement**

```java
// Logger.java
public class Logger {
    public void info(String message) {
        System.out.println("INFO: " + message);
    }
}
```

```java
// PaymentService.java
public class PaymentService {
    public boolean processPayment(double amount, String cardNumber, Logger logger) {
        logger.info("Processing payment for amount: " + amount);
        // Actual implementation omitted for brevity
        return true;
    }
}
```

```java
// PaymentServiceTest.java
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class PaymentServiceTest {
    @Test
    void testProcessPayment() {
        // Create a dummy object of the Logger class
        Logger dummyLogger = mock(Logger.class);

        // Create an instance of the PaymentService class
        PaymentService paymentService = new PaymentService();

        // Call the processPayment method with the dummy logger
        boolean result = paymentService.processPayment(100.0, "1234567890", dummyLogger);

        // Assert the result
        assertTrue(result);
    }
}
```

These solutions provide the implementations for the exercise questions, demonstrating the usage of Mockito features such as `mock()`, `@Spy`, `when().thenReturn()`, `doReturn().when().method()`, and `doNothing().when().method()`.
