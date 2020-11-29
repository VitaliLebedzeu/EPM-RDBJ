Description
NOTE: All tasks should be implemented in Plain Java based on the standard library, without using any external libraries like Lombok, Apache Commons ...

Task 1 (v.1.0) - branch: task-1
Design an object model for a given domain and then design a hierarchy of exceptions for the engineered object model.
Airline: Define a hierarchy of aircraft, helicopters, quadcopters, etc. Create an airline. Calculate the total capacity and lifting capacity.
Sort the company's flight vehicles by range. Find an aircraft in the company that matches the specified range of parameters.

Task 2 Dynamic Array (v.1.0) - branch: task-2
Create your own DynamicDoubleArray class containing a double [] array inside that supports adding an element to the end of the array (add), 
getting an element by index (get), printing the internal state (toString), removing an arbitrary element by index (remove), as well as 
the ability set the initial size when calling the constructor. When the number of elements changes, the internal array must be recreated. 
Parameterize the class by letting it store an array of elements of any type.

Task 3. Classic Annotations (v.1.0) - branch: task-3
Use the project from the previous module [Java Core I] with class hierarchy or another pet project with class hierarchy.
Use next annotations correctly with explanation in comments
@Deprecated
@Override
@SuppressWarnings
@FunctionalInterface
Refactor code if it is required

Task 4. Reflection API usage (v.1.0) - branch: task-4
Use the project from the previous module [Java Core I] with class hierarchy or another pet project with class hierarchy.
Rewrite your app with Reflection API:
Use reflection to instantiate all objects in client code via constructors (with or without arguments)
Use reflection API to fill private fields without setters
Use reflection API to change method calls from direct call on reflection call in client code
Print out the metadata for all classes in application in human-readable format format (about all fields, methods, modifiers and etc.)

Task 5. Custom annotations (v.1.0) - branch: task-5
Use the project from the previous module [Java Core I] with class hierarchy or another pet project with class hierarchy.
Create custom annotations and use them in code
@UseStackOnly which could be attached to fields and couldn’t be accessed in Runtime
@UseArrayList which could be attached to methods and couldn’t be found in the bytecode
@ThisCodeSmells(reviewer=”Petya”) which could be attached everywhere and could be repeatable
@ProdCode which could be attached to methods only and should be accessed in Runtime

Task 6. How to handle annotations? (v.1.0) - branch: task-6
Write annotation handler for the @ThisCodeSmells annotation from the previous task source code.
It should print out
All smelt code names (classes, method, fields)
Authority of persons who count this code smelt and vote for it
Range all smelt code areas by votes (amount of annotations)

Task 7. Very helpful annotation and its handler (v.1.0) branch: task-7
Write annotation handler for the previous task and @ProdCode annotation
Add class ProdRunner and run all methods annotated with @ProdCode
