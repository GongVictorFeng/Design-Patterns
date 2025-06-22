# DESIGN-PATTERNS

## Solid Design Principles
* Single Responsibility Principle
* Open Closed Principle
* Liskov Substitution Principle
* Interface Segregation Principle
* Dependency Inversion Principle

### Single Responsibility Principle
* There should never be more than one reason for a class to change 
* A class focused single functionality, it addresses a specific concern of the desired functionality
* Example:
  * A class is creating and sending a message to a remote server
  * reasons for this class to change:
    * Communication protocol changes - HTTP to HTTPS
    * Message format changes - JSON to XML
    * Parameters of communication - authentication is added
  * three separate responsibilities, we should have three separate class for each of them
* Hands-on
  * The UserController is supposed to receive the user requests and pass them to the rest of the application; then it gets the result of the processing and send the response back
  * Our UserController violates single responsibility principle
    * creating User object from the request
    * Validating User object
    * storing the User object
    * implementation: https://github.com/GongVictorFeng/Design-Patterns/commit/6085e65411b28e83478b65c9b12ecdad2cb26890
  * Refactoring:
    * creating a UserValidator to validate user: https://github.com/GongVictorFeng/Design-Patterns/commit/c1ed54106d983a7b9120a5585cd51d176a63e440
    * creating a UserPersistenceService to talk to the user data store: https://github.com/GongVictorFeng/Design-Patterns/commit/0ffd2b51dde3ae78dd00c0a192a791eef2eecb50
    * creating a UserMapper to convert userJson to User object: https://github.com/GongVictorFeng/Design-Patterns/commit/ebefa1d069f535532466917fcc3b327679c290ad

### Open-Closed Principle
* Software entities (Classes, Modules, Methods,...) should be open for extension, but closed for modification
* Open for extension - extend existing behaviour
* Closed for modification - existing code remains unchanged
* Example:
  * A base class which is already written and tested, we can use inheritance to extend or modify behaviour of methods in base class
  * We should not modify the code which is written in the base class
* Hands-on
  * There are many duplicated attributes between PhoneSubscriber and ISPSubscriber: 
    * https://github.com/GongVictorFeng/Design-Patterns/commit/b4d840f9ae8c349b7c7b0b09f1812d56625e4bd2
    * https://github.com/GongVictorFeng/Design-Patterns/commit/b4d840f9ae8c349b7c7b0b09f1812d56625e4bd2
  * Created a base class - Subscriber which is closed to modification, and method calculateBill is open for extension
    * https://github.com/GongVictorFeng/Design-Patterns/commit/0bb60b2b0a2b57d092a97a45754469518173e3ee
  * Both PhoneSubscriber and ISPSubscriber extends from base class to reuse the code and override the method calculateBill
    * https://github.com/GongVictorFeng/Design-Patterns/commit/e33c44fc2145a1f044c764de331668f91ee01c72