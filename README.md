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

### Liskov Substitution Principle
* We should be able to substitute base class object with child class object and this should not alter behavior or characteristics of program
* Hands-on:
  * Since Square is a rectangle, so it extends from Rectangle.
  * To keep square a square, whenever the width is set, the height should also be set to the same number, vise versa.
  * https://github.com/GongVictorFeng/Design-Patterns/commit/5abe24f5179c9b75ddb4f6bf5940db469503250a
  * Square failed in the test case: https://github.com/GongVictorFeng/Design-Patterns/commit/d497a4a9157c08990cad606f7816aad6a6f4a2ef
    * Square modified the behavior of its base class - Rectangle, which violated the liskov principle
  * Created an interface - Shape, then both Rectangle and Square implement it and override the computeArea method
    * https://github.com/GongVictorFeng/Design-Patterns/commit/7d5185a2cacfd4eec7b85e4bda3050c608515e40
    * https://github.com/GongVictorFeng/Design-Patterns/commit/f4e6b0c3d9b2e1836e9cd3af6256df9931932af9
    * https://github.com/GongVictorFeng/Design-Patterns/commit/c956a7437933ea85a40bb19daa829cc4a883aaa8

### Interface Segregation Principle
* Clients should not be forced to depend upon interfaces that they do not use
* Clients should not have to depend on methods that are defined in interfaces that they don't use
* Interface Pollution - We should not cram methods that are unrelated in a big interface and make all other classes in our software system or in our module implement that interface
  * Signs of Interface Pollution 
    * Classes have empty method implementations
    * Method implementations throw UnsupportedOperationException (or similar)
    * Method implementations return null or default/dummy values
* Break bigger interfaces so that methods or behaviors or contracts are defined in a particular interface are cohesive
* Hands-on:
  * The Interface PersistenceService has a method called findByName: https://github.com/GongVictorFeng/Design-Patterns/commit/b33c59e7b9603dffbda50406184f2ccd74176692
  * The User has the name, but the order does not have the name
    * https://github.com/GongVictorFeng/Design-Patterns/commit/b1df341a28fd677eaeac4df2658627c429d91bb8
    * https://github.com/GongVictorFeng/Design-Patterns/commit/a88bbdcb3d47912c545c0116ac0f0623fbdee0b1
  * the method findByName in OrderPersistenceService does not make sense: https://github.com/GongVictorFeng/Design-Patterns/commit/3e5c26d959b477848508b1259fea6409396e5051
  * Removed the findByName method in PersistenceService, so that the OrderPersistenceService should not force to override this method: https://github.com/GongVictorFeng/Design-Patterns/commit/053de0d1664dd97286c3f22e5a7a00afd2861a76

### Dependency Inversion Principle
* High level Modules should not depend on low level modules. Both should depend on abstraction
* Abstraction should not depend on details, details should depend on abstraction
* High level Module means a module provides or implements some business rules
* Low level Module is a functionality that is so basic that it can be used anywhere
* Hands-on:
  * There are two dependencies in MessagePrinter, JSONFormatter and PrintWriter: https://github.com/GongVictorFeng/Design-Patterns/commit/4219edb308a83b7b284dabaa2d7b15356f455a51
  * If we want to print this message on console, then current method is not working, need to create another method to use `System.out` instead of `PrintWriter`
  * If we want to change the format other than JSON, we have to modify this method and change JSONFormatter to Other Formatter
  * It violates the Dependency inversion, High level depends on Low level
  * used dependency injects to make the method - writeMessage depends on abstract and only contains business rule
    * https://github.com/GongVictorFeng/Design-Patterns/commit/af8e0ae34261a5d22a0f6aa662140d6635061eca

## Design Patterns
* Creational - Creational Patterns deal with the process of creating objects of classes
* Structural - Structural patterns deal with how classes and objects are arranged or composed
* Behavioral - Behavioral patterns describe how classes and objects interact and communicate with each other

### Creational Patterns
* The need of creational patterns - why not use new operator
* new operator is needed + multiple additional requirements
  * The object needs multiple other objects before it can be created
  * There may be multiple steps before creating an object
  * There may be only one object in the entire application

#### Builder
* The object of the class must be immutable
  * Class constructor requires a lot of information
* Objects that need other objects or "parts" to construct them
* We have a complex process to construct an object involving multiple steps, then builder design pattern can help us
* In builder, we remove the logic related to object construction from "client" code and abstract it in separated classes
* UML: ![builder.png](assets%2Fbuilder.png)
  * Product - final complex object that we want to create
  * Builder - Provides interface for creating "parts" of the product
    * provides a method - build() to assemble the final object
    * provides a method - getProduct to query already built object
  * Concrete Builder - Constructs parts and assembles final product and keeps track of product it creates
  * Director - Uses builder to construct object and knows the steps and their sequence to build product
* Implement a Builder
  * Start by creating a builder
    * Identify the "parts" of the product and provide methods to create those parts
    * It should provide a method to "assemble" or build the product/object
    * It must provide a way/method to get fully built object out. Optionally builder can keep reference to a product it has built so the same can be returned again in future
  * A director can be a separate class or client can play the role of director
* Hands-on:
  * UML: ![builder-example.png](assets%2Fbuilder-example.png)
  * Create Builder and Base class of final product: https://github.com/GongVictorFeng/Design-Patterns/commit/ce6ca5f5c2a65d8ba09b1b8269f20789277e09b4
  * Create concrete Builder: https://github.com/GongVictorFeng/Design-Patterns/commit/fa0c75180431721f6efa61adfe1f065596a51939
  * Create Client and Director: https://github.com/GongVictorFeng/Design-Patterns/commit/c8cc511716ef24f9416a6c354a91c96ba1699159
* Implementation Considerations
  * You can easily create an immutable class by implementing builder as an inner static class. You'll find this type of implementation used quite frequently even if immutability is not a main concern
* Design Considerations
  * The director role is rarely implemented as separate class, typically the consumer of the object instance or the client handles that role
  * Abstract builder is also not required if "product" itself is not part of any inheritance hierarchy. You can directly create concrete builder
  * If you are running into a "too many constructor arguments" problem then it is a good indication that builder pattern may help
* Real world example - java.util.Calendar.Builder
* Pitfalls
  * A little bit complex for newcomers mainly because of "method chain" where builder methods return builder object itself
  * Possibility of partially initialized object; user code can set only a few or none of properties using `withXXX` methods and call build(). If required properties are missing, build method should provide suitable defaults or throw exception

#### Simple Factory
* Multiple types can be instantiated and the choice is based on some simple criteria
* We simply move the instantiation logic to a separate class and most commonly to a static method of this class
* Some do not consider simple factory to be a "design pattern", as it is a simple method that encapsulates object instantiation. Nothing complex goes on in that method
* Typically, we want to do this if we have more than one option when instantiating object and a simple logic is used to choose correct class 
* UML:![simple-factory.png](assets%2Fsimple-factory.png)
  * Product - Object of this class and its subclasses
  * Simple Factory - Provides a static method to get instance of product subclass
* Implementation
  * We start by creating a separate class for simple factory
    * Add a method which returns desired object instance
      * This method is typically static and will accept some argument to decide which class to instantiate
      * You can also provide additional arguments which will be used to instantiate objects
* Hands-on
  * Created abstract product: https://github.com/GongVictorFeng/Design-Patterns/commit/c4b090708fe4526af667ca0e49ba956ed1a361f4
  * Created the subclasses of the product: https://github.com/GongVictorFeng/Design-Patterns/commit/ba96be856884d5cff45cd5a77266fbba64efee1f
  * Created the class of simple factory and the method to get desired object instance: https://github.com/GongVictorFeng/Design-Patterns/commit/f600ea96f80e043e280c638b5db69f707f2b1838
* Simple factory can be just a method in existing class. Adding a separate class allows other parts of code to use simple factory more easily
* Simple factory itself does not need any state tracking, so it's best to keep this as static method
* Simple factory will in turn may use other design pattern like builder to construct objects
* In case you want to specialize simple factory in subclasses, you need factory design pattern instead
* Real-world example: java.text.NumberFormat class has getInstance method, which is an example of simple factory
* Pitfalls
  * The criteria used by simple factory to decide which object to instantiate can get more convoluted/complex over time. If you find yourself in such situation then use factory design pattern

#### Factory
* We want to move the object creation logic from our code to a separate class
* We use this pattern when we do not know in advance which class we may need to instantiate beforehand and also to allow new classes to be added to system and handle their creation without affecting client code
* We let subclasses decide which object to instantiate by overriding the factory method
* UML:![factory.png](assets%2Ffactory.png)
  * Product - base class or interface of products created by factory method
  * Concrete Product - implements the product interface or extend the product base class
  * Creator - Declares the abstract factory method  and uses the factory method to create product
  * Concrete creator - implement factory method and return one of concrete product instance
* Implement a Factory Method
  * We start by creating a class for our creator 
    * Creator itself can be concrete if it can provide a default object, or it can be abstract
    * Implementations will override the method and return an object
* Hands-on:
  * UML: ![factory-example.png](assets%2Ffactory-example.png)
  * Created the abstract Message Class: https://github.com/GongVictorFeng/Design-Patterns/commit/ef1787a5114196c4b826fd73c2a906832acd6b3b
  * Created the concrete classes of the message class: https://github.com/GongVictorFeng/Design-Patterns/commit/1c3c28f668eba8c63e0200aa6883d971e41470ff
  * Created the abstract creator: https://github.com/GongVictorFeng/Design-Patterns/commit/48c6d669a7c650dad9743eca294326bcc738c541
  * Created the concrete creators: https://github.com/GongVictorFeng/Design-Patterns/commit/5879ac729e7803cac24a8b010a6fdc5f82959635
  * Created the client and test case for factory method: https://github.com/GongVictorFeng/Design-Patterns/commit/cba827524028a22d197bc8981cf73f6b85de4308
* Implement Consideration
  * The creator can be a concrete class and provide a default implementation for the factory method. In such cases you will create some "default" object in base creator
  * You can also use the simple factory way of accepting additional arguments to choose between different object types. Subclasses can then override factory method to selectively create different objects for some criteria
* Design Considerations
  * Creator hierarchy in factory method pattern reflects the product hierarchy. We typically end up with a concrete creator per object type
  * Template method design pattern often makes use of factory method
  * Abstract factory makes use of factory method as well
* Real-world example - Java.util.Collection has an abstract method called iterator()
* Pitfalls
  * More complex to implement. More classes involved and need unit test
  * You have to start with Factory method design pattern from the beginning. It's not easy to refactor existing code into factory method pattern
  * Sometimes this pattern forces you to subclass just to create appropriate instance

#### Prototype
* We have a complex object that is costly to create. To create more instances of such class, we use an existing instance as our prototype
* Prototype will allow us to make copies of existing object and save us from having to recreate objects from scratch
* UML: ![prototype.png](assets%2Fprototype.png)
  * Prototype - declares a method for cloning itself
  * Concrete prototype - implements cloning method
  * Client - creates new instance using prototype's clone method
* Implement a Prototype
  * We start by creating a class which will be a prototype
    * The class must implement Cloneable interface
    * Class should override clone method and return copy of itself
    * The method should declare CloneNotSupportedException in throw clause to give subclass chance to decide on whether to support cloning
  * Clone method implementation should consider the deep and shallow copy and choose whichever is applicable
* Hands-on:
  * UML: ![prototype-example.png](assets%2Fprototype-example.png)
  * Created the abstract prototype class: https://github.com/GongVictorFeng/Design-Patterns/commit/6a3c1a52980ae34025fbcf5db6a01073fa81d2ee
  * Created two concrete subclasses extend the prototype, one supports clone, another one is not: https://github.com/GongVictorFeng/Design-Patterns/commit/b57dde19fadb8684f414c294459910ba47e09537
  * Created client and test case: https://github.com/GongVictorFeng/Design-Patterns/commit/7625c549ade8a943bef8e1147d11872632c86413
* Implementation Considerations
  * Pay attention to the deep copy and shallow copy of references. Immutable fields on clones save the trouble of deep copy
  * Make sure to reset the mutable state of object before returning the prototype. It's good idea to implement this in method to allow subclasses to initialize themselves
  * clone() method is protected in Object class and must be overridden to be public  to be callable from outside the class
  * Cloneable is a "marker" interface, an indication that the class supports cloning
* Design Considerations
  * Prototypes are useful when you have large objects where majority of state is unchanged between instances, and you can easily identify that state
  * A prototype registry is a class where you can register various prototypes which other code can access to clone out instances This solves the issue of getting access to initial instance
  * Prototypes are useful when working with Composite and Decorator Patterns
* Real-world Example - Object.clone() method
  * This method is provided by Java and can clone an existing object, thus allowing any object to act as a prototype
  * Classes still need to be Cloneable but the method does the job of cloning object
* Pitfalls
  * Usability depends upon the number of properties in state that are immutable or can be shallow copied. An object where state is composed of large number of mutable object is complicated to clone
  * In java, the default clone operation will only perform the shallow copy so if you need a deep copy you have to implement it
  * Subclasses may not be able to support clone and so the code becomes complicated as you have to code for situations where an implementation may not support clone

#### Abstract Factory
* Abstract factory is used when we have two or more objects which work together forming a kit or set and there can be multiple sets or kits that can be created by client code
* We separate client code from concrete objects forming such a set and also from the code which creates these sets
* UML: ![abstract-factory.png](assets%2Fabstract-factory.png)
  * Abstract Product - interface for a type of product
  * Concrete Product - implements the product interface or class
  * Abstract Factory - interface defining operations to create products
  * Concrete Factory - implement factory and creates products from a particular family
  * Client - uses abstract factory and abstract products
* Implement Abstract Factory
  * We start by studying the product "sets"
    * Create abstract factory as an abstract class or an interface
    * Abstract factory defines abstract methods for creating products
    * Provide concrete implementation of factory for each set of products
  * Abstract factory makes use of factory method pattern. You can think of abstract factory as an object with multiple factory methods
* Hands-on:
  * UML: ![abstract-factory-example.png](assets%2Fabstract-factory-example.png)
  * Created the abstract factory: https://github.com/GongVictorFeng/Design-Patterns/commit/92f4915eb8ad283d01377b905c5e67012559692a
  * Created the abstract instance and the abstract storage: https://github.com/GongVictorFeng/Design-Patterns/commit/4a396e96de0e47b01beb441e0703572e45b75d4e
  * Created the concrete EC2 instance and GoogleComputeEngineInstance: https://github.com/GongVictorFeng/Design-Patterns/commit/eaf1da0bb54a9f2d7b0c134646573541a8c657b4
  * Created the concrete S3 Storage and GoogleCloudStorage: https://github.com/GongVictorFeng/Design-Patterns/commit/313a870c7d6bdcd423138838fecf0d2dcfe5756c
  * Created the factory implementation for AWS and Google cloud platform: https://github.com/GongVictorFeng/Design-Patterns/commit/4a6dcdc104a8e27e2f89e53418e83b0970f3b897
  * Created the client and test cases: https://github.com/GongVictorFeng/Design-Patterns/commit/35d8592c355d89493fdf8379e85062962a7e7849
* Implementation Considerations
  * Factories can be implemented as singletons, we typically ever need only one instance of it anyway. But make sure to familiarize yourself with drawbacks of singletons
  * Adding a new product type requires changes to the base factory as well as all implementations of factory
  * We provide the client code with concrete factory so that it can create objects
* Design Considerations
  * When you want to constrain object creations so that they all work together then abstract factory is good design pattern
  * Abstract factory uses factory method pattern
  * If objects are expensive to create then you can transparently switch factory implementations to use prototype design pattern to create objects
* Real-word example - javax.xml.parsers.DocumentBuilderFactory
* Pitfalls
  * A lot more complex to implement than factory method
  * Adding a new product requires changes to base factory as well as all implementations of factory
  * Difficult to visualize the need at start of development and usually starts out as a factory method
  * Abstract factory design pattern is very specific to the problem of "product families"