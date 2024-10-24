# **Exercise Questions**

1. **Mock an Object and Stub a Method**
   - Create a class `CalculatorService` with a method `int calculateTotal(List<Integer> numbers)` that takes a list of integers and returns the sum of all the numbers in the list.
   - Write a test case to verify the behavior of the `calculateTotal` method using a mocked `List` object and stubbing the `get` method to return specific values.

2. **Create a Spy Object and Stub a Method Based on Arguments**
   - Create a class `EmailService` with a method `boolean sendEmail(String to, String subject, String body)` that sends an email with the given subject and body to the specified recipient email address.
   - Write a test case to verify the behavior of the `sendEmail` method using a spy object and stubbing the method to return different values based on the arguments (e.g., return `false` if the recipient email is invalid).

3. **Suppress the Behavior of a Void Method**
   - Create a class `UserService` with a method `void deleteUser(String userId)` that deletes a user with the given ID.
   - The `deleteUser` method internally calls another method `sendDeletionNotification(String userId)` which is a `void` method that sends a deletion notification email.
   - Write a test case to verify the behavior of the `deleteUser` method, suppressing the behavior of the `sendDeletionNotification` method using `doNothing().when().method()`.

4. **Use a Dummy Object to Satisfy a Method Parameter Requirement**
   - Create a class `PaymentService` with a method `boolean processPayment(double amount, String cardNumber, Logger logger)` that processes a payment with the given amount and card number. The method also logs a message using the provided `Logger` object.
   - Write a test case to verify the behavior of the `processPayment` method using a dummy `Logger` object to satisfy the `logger` parameter requirement.
