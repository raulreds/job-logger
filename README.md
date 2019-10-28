### Code Review / Refactoring exercise
________
If you were to review the following code 
[JobLoggerOld.java](/Users/raul.rojas/samples/job-logger/src/main/java/com/belatrix/logger/joblogger/JobLoggerOld.java) , 
what feedback would you give? Please be specific and indicate any errors that would occur as well as other best practices 
and code refactoring that should be done.

### **Answer**
* The code in the **JobLoggerOld.java** shows many design errors that can trigger uncontrolled exceptions. For example, 
if I create an instance of JobLoggerOld with logErrorParam = false and then invoke de LogMessage method with
error = true then the method not log the message.

* This class (JobLoggerOld) violate some principles of SOLID (https://en.wikipedia.org/wiki/SOLID) like SRP 
(https://en.wikipedia.org/wiki/Single_responsibility_principle), because a class should have one, and only one, reason 
to change, but this class have many reasons like change the database destination, file or any other. Also the 
open/closed principle (https://en.wikipedia.org/wiki/Open%E2%80%93closed_principle), because Software entities 
(classes, modules, functions, etc.) should be open for extension, but closed for modification, and we can see in this
class that we are forced to change always the same class for new functionalities of logging.

* The class does not meet the maintainability quality attribute. This problem can generate errors in functionalities 
different from those modified.

* Obviously good principles of object-oriented programming are not applied.


### **Changes to Apply**

* In general terms an analysis is made from the design of object-oriented programming, and the need for a design that 
groups concepts such as file, database and console into types of information destinations to be logged is evidenced.
We can make use of the GoF patterns (https://en.wikipedia.org/wiki/Design_Patterns) to improve the implementation of 
the solution. We can be as sophisticated as we want to implement the solution, for example make use of Abtract Factory
 to have a high level of decoupling, make use of Dependency Injection, AOP, and so on. But in this case it has been 
 decided to implement a very functional, decoupled, easy to implement and maintainable solution using the Factory Method 
 pattern, which facilitates us to easily expand the destinations to which we want to send the logs. As we know today we 
 have a wide variety of non-relational databases, streams, cloud storage such as AWS s3, etc.
