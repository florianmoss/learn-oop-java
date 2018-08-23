
# Introduction

This is a small project I have thrown together to help students at LYIT with their exams in **Object Orientated Programming 3**. This tutorial deals with Java code, which is what is being used for the exam. If you are interested in Processing, check out my other projects [Asteroids Game](https://github.com/florianmoss/asteroidsGame-Java-Processing) and [Maze Solver](https://github.com/florianmoss/mazeSolver-Java-Processing). These will deal with an actual implementation whereas the goal for this project is to help you understand the underlying concepts. Feel free to share this resource with your friends and copy from it whenever you need it. I will go through the following chapters in this tutorial:

1.  [ArrayLists and Methods](#arraylists-and-methods)
2.  [toString + enhanced for-Loop](#tostring--enhanced-for-loop)
3.  [try-catch-Exceptions](#try-catch-exceptions)
4.  [throw + user-Defined Exceptions](#throw--user-defined-exceptions)
5.  [Composition](#composition)
6.  [Inheritance](#inheritance)
7.  [Override](#override)
8.  [Polymorphism](#polymorphism)
9.  [Overloading](#overloading)
10. [Wrapper Classes](#wrapper-classes)
11. [instanceOf Operator (not used in code)](#instanceof-operator-not-used-in-code)
12. [Casting](#casting)
13. [Abstract Classes](#abstract-classes)
14. [equals()](#equals)
15. [Interfaces](#interfaces)
16. [Comparable + compareTo()](#comparable--compareto)
17. [sort()](#sort)
18. [Comparator + compare()](#comparator--compare)
19. [Bubble Sort](#bubble-sort)
20. [Selection Sort](#selection-sort)
21. [Sequential Search](#sequential-search)
22. [Binary Search](#binary-search)

# ArrayLists-and-Methods
[Official Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)

An ArrayList is a more complex Array. An array needs to be initialised with a fixed size, whereas an ArrayList has the capability to grow and shrink as needed. Unfortunately an ArrayList can't directly store primitive datatypes, but we can solve that with [Wrapper Classes](#wrapper-classes). Arrays are also embedded in the java.lang package and therefore doesn't neeed to be imported. To access functionality of ArrayLists we need to import it with:
```java
import java.util.ArrayList;
```

**Syntax: (declare and initialise)** 
```java
ArrayList<Object> identifier = new ArrayList<Object>(size);
```
The size doesn't need to be declared, you can leave this empty in most cases.

Or you can declare an ArrayList first and then initialise:
```java
ArrayList<Object> identifier;
identifier = new ArrayList<Object>(size);
```

**Commonly used methods**
* Retrieve an object at position i:
```java
list.get(i)  // Returns object
```
* Add an object, add an object at position:
```java
list.add(i)  // Adds object i
list.add(index, i)  // Adds object i at index
```
* Empty the ArrayList:
```java
list.clear()  // Clears the ArrayList
```
* Remove an object, remove an object at position:
```java
list.remove(i)  // remove object i
list.remove(index)  // remove object at index
```
* Index of Object:
```java
list.indexOf(i)  // Returns index of object i or -1 if not found
```
# toString + enhanced for-Loop

### toString()
What would happen if you would execute the following in Java?
```java
System.out.println(object);
```
You would get the hashCode that looks something like this:
```java
Console: @66fee51b
```
This is obviusly not very helpful for us, yet. What we want is to retrieve information from an object in a readable form, that's why we need to implement a method, the toString() method. As the name suggests, it formats an object to a string.

Let's look at a quick example from [Human.java](https://github.com/florianmoss/learn-oop-java/blob/master/Human.java):
```java
   public String toString(){
      return "Human{age="+getAge()+", name="+getName()+", armLeft="+armLeft+", armRight="+armRight+
            ", legLeft="+legLeft+", legRight="+legRight+", familyMembers="+familyMembers;
   }
```
What would be the output for the following object?
```java
florian = new Human();
System.out.println(florian.toString()); // long way
System.out.println(florian); // short way
```
Hint: You will need to look at the [Existence Class](https://github.com/florianmoss/learn-oop-java/blob/master/Existence.java), the [Human Class](https://github.com/florianmoss/learn-oop-java/blob/master/Human.java)  and the [Genitals Class](https://github.com/florianmoss/learn-oop-java/blob/master/Genitals.java).

Output: 
```java
Human{age=0, name=none, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
```

If you got it right, great you understood everything, move on! If not, here is the explanation..

1. **Start at the beginning**
We invoked the toString() Method for the Object **florian**. The object **florian** is a **human**, therefore we have to check the [Human Class](https://github.com/florianmoss/learn-oop-java/blob/master/Human.java) and look for the toString()-Method.
Go open it, and look at it.

2. **What now? Well there is a lot to take in, isn't it? So let's break it up**:
```java 
   "Human{age="+getAge()+",
```
The first part is easy enough, it returns a String, the second part invokes the **getAge()**-Method. Is there a **getAge()**-Method in Human?

No there isn't, so where can it be? In the [Existence Class](https://github.com/florianmoss/learn-oop-java/blob/master/Existence.java) of course! The human inheritated it from Existence. So the **getAge()**-Method returns an int value. What is the age? We have to check the constructor for that:  
```java
florian = new Human();
```
Is there an empty constructor in the [Human Class](https://github.com/florianmoss/learn-oop-java/blob/master/Human.java)? Yes, great. The empty constructor chains to the second constructor, which then invokes the super class constructor. Constructor-inception basically.

In the end **florian** gets initialised with the age == 0.

Therefore **getAge()** returns 0. Exactly the output: 
```java
Human{age=0, ...
```

3. **Now we have to break up the Genitals armLeft, armRight, legLeft and LegRight**
The first genital is armLeft, so we should check the [Arm Class](https://github.com/florianmoss/learn-oop-java/blob/master/Arm.java).
Go, have a look! Did you find a toString()-Method?
No, good. Where else can we check? Oh, yes sure the Arm inherits from the [Genitals Class](https://github.com/florianmoss/learn-oop-java/blob/master/Genitals.java).

Oh, there seems to be a toString()-Method!

```java
   @Override
   public String toString(){
      String s = "";
      for(Integer i : genitals){
         s += " ,"+i;
      }
      return s.substring(2);
   }
   
```
Looks complicated, but it is actually quite simple.
It loops through the amount of genitals of a genital and returns them without a leading **,** (This is what .substring() does).

Now it's quite easy, we have to check the constructor and see with how many genitals the leftArm has been initialised.

You have done that earlier with the age, it's the same principle.

And from here on the same concept applies to the other genitals.

4. **Putting it all together**
When you put all the partial outputs together, you will get exactly this:
Output: 
```java
Human{age=0, name=none, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
```

Not too bad, wasn't it!

### enhanced for-Loop
[Official Documentation](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
The enhanced for-Loop has the same functionality that your regular for-loop. With some small differences.

```java
for(int i=0; i<10; i++) 
   System.out.print(i+ " ");
   
Output: 0 1 2 3 4 5 6 7 8 9   
``` 
This is your regular for-Loop, nothing really special.
Let's look at the enhanced for-Loop:

```java
for(int i : new int[10])
   System.out.print(i+ " ");
   
Output: 0 0 0 0 0 0 0 0 0 0 
``` 
The syntax is slightly different as you can see:
```java
for(type o : IterableObject)
   System.out.print(o+ " ");
``` 
We can basically iterate through everything that allows us to iterate through, 2 concepts you definitely know of, right?
**Arrays and ArrayLists**. The enhanced for-loop allows us to iterate through all elements that are stored in an iterable object. Simple as that. The benefit is that you don't have to define the size or think about **OutOfBoundExceptions**, you can savely iterate through all elements. The drawback is that you can't return the position.

Maybe another example:
```java
ArrayList<Integer> oneToTen = new ArrayList<Integer>();  // ArrayList that stores Integer objects
for(int i=1; i<11; i++)  // Store the values 1-10 in oneToTen ArrayList
   oneToTen.add(i);       
   
for(Integer i : oneToTen)     // iterate through all objects in oneToTen of the type Integer
   System.out.print(i+ " ");
   
Output: 1 2 3 4 5 6 7 8 9 10
``` 

# try-catch-Exceptions
[Official Documentation](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)

### What is an exception?
 An exception is an event that occurs during the execution of a program that disrupts the normal flow of instructions.
 We have already seen a few of these, let's say you have the following:
 
 ```java
int[] numbers = {1, 2, 3}

System.out.println(numbers[3]); // Leads into OutOfBound error
   
``` 

To prevent this you can use someting called try-catch. The name basically says what it does:

### Implementation of try-catch
 ```java
int[] numbers = {1, 2, 3}

try{
   System.out.println(numbers[3]); // Leads into IndexOutOfBoundsException error
}catch(IndexOutOfBoundsException e){
   System.out.println(e.getMessage());
}
```
In english: Dear compiler, please **TRY** to compile the line:
   _ System.out.println(numbers[3]);_
If you find an error saying **IndexOutOfBoundsException**, go and execute what follows in the curly brackets.
Simple as that. You can also stack **catches**, for example:

 ```java
int[] numbers = {1, 2, 3}

try{
   System.out.println(numbers[3]); // Leads into IndexOutOfBoundsException error
}catch(IndexOutOfBoundsException e){
   System.out.println(e.getMessage());
}catch(IOException e){
   // do nothing
}
```

Just remember, the moment you hit an error in your try-block, you will immediately jump into the catch-block and nothing else will be executed from try.

Most exceptions will be caught this way.
 
# throw + user-Defined Exceptions

This part will go further than what is needed for your exam, but you will learn some important things.

### the _throws_ Keyword
Every Method or Constructor can **throw** an Exception. This means, when you execute the code and an event occurs that you don't want to occur, you can go and say "Hey Java, throw an exception here and stop this non-sense!". One simple example would be a human with a negative age, we surely don't want that to happen. Go ahead and open the [Human Class](https://github.com/florianmoss/learn-oop-java/blob/master/Human.java).

```java
   public Human() throws Exception{
      this(5, 5, 5, 5, 0, "none");
   }

   public Human(int fingersLeft, int fingersRight, int toesLeft, int toesRight, int age, String name) throws Exception{
         super(age, name);
         this.armLeft = new Arm(fingersLeft);
         this.armRight = new Arm(fingersRight);
         this.legLeft = new Leg(toesLeft);
         this.legRight = new Leg(toesRight);
         this.familyMembers = new ArrayList<String>();
   }
```
When you look closely at the Constructor signature you can spot the **throws Exception** part. We know now that our constructors can throw exceptions, but we don't know what exactly they are throwing, right? So we have to check our [Existence Class](https://github.com/florianmoss/learn-oop-java/blob/master/Existence.java). 

```java
public Existence(int age, String name) throws Exception{
      if(age>-1){
         this.age = age;
         this.name = name;
      } else throw new AgeException();
   }
```
What can we observe? We also have the **throws Exception** in the Constructor signature, that's obviuous. What else?
if the age is -1 or smaller the Constructor will throw a new AgeException()! So we have an event that we don't want to happen, and we go ahead and say: **"Hey Java, stop this non-sense and tell me what non-sense occured!"**.

At this point we don't really know what AgeException is, so let's check it out: [AgeException.java](https://github.com/florianmoss/learn-oop-java/blob/master/AgeException.java)

```java
public class AgeException extends java.lang.Exception{
   public AgeException(){
   
   }
   
   public String getMessage(){
      return "Age is not valid";
   }

}
```
Looks like not much is going on actually, that's a relief isn't it?! It's a class that inherits from the java.lang.Exception package with an empty constructor and only one method. And the method only returns a String saying "Age is not valid."

So our constructor from the Existence class creates a new AgeException object of the type Exception and throws it. Think about it in a literal sense, when something is thrown, it needs to be caught as well, doesn't it? So where do we catch it? 

Upon calling the constructor of course. 

So where do we evoke the constructor from the [Existence Class](https://github.com/florianmoss/learn-oop-java/blob/master/Existence.java)? Right, in the [Human Class](https://github.com/florianmoss/learn-oop-java/blob/master/Human.java).

Our first instinct would be to write this in the Human class:

```java
   public Human(){
      try{ 
         this(5, 5, 5, 5, 0, "none");
      } catch(Exception e){
         System.out.println(e.getMessage());
      }
   }

   public Human(int fingersLeft, int fingersRight, int toesLeft, int toesRight, int age, String name) {
         try{
            super(age, name);
         } catch(Exception e){
         System.out.println(e.getMessage());
         }
         this.armLeft = new Arm(fingersLeft);
         this.armRight = new Arm(fingersRight);
         this.legLeft = new Leg(toesLeft);
         this.legRight = new Leg(toesRight);
         this.familyMembers = new ArrayList<String>();
   }
```
Because we want to catch the thrown Exception immediately. I would encourage you to download the files and change the code in the human.java constructor to the above. Try it and see what happens!

**You had a compiler issue. But why is that?**

Whenever we invoke a super() constructor, more about that in the [Inheritance](#inheritance) section, we are forced to invoke the super() as the first line of code, so we can't use the **try{** -block. What a shame, the most intuitive solution doesn't work.

So what other option do we have? We can **throw** the exception even further down, so let's try that:

```java
   public Human() throws Exception{
      this(5, 5, 5, 5, 0, "none");
   }

   public Human(int fingersLeft, int fingersRight, int toesLeft, int toesRight, int age, String name) throws Exception{
         super(age, name);
         this.armLeft = new Arm(fingersLeft);
         this.armRight = new Arm(fingersRight);
         this.legLeft = new Leg(toesLeft);
         this.legRight = new Leg(toesRight);
         this.familyMembers = new ArrayList<String>();
   }
```

Now, everytime the human constructor is being called, we will have to catch the exception. And where do we create a human? In the [Main Class](https://github.com/florianmoss/learn-oop-java/blob/master/main_starter.java) of course.

This is how it's gonna look:
```java
      try{         
         max = new Human(5, 5, 5, 5, -2, "Max");
         System.out.println(max);
      }catch(Exception e){
         System.out.println(e.getMessage());
      }
```
 When we run it, we will see the expected output. 
 
 Make sure you really understand what is happening, this is a bit tricky to understand at first, especially with throwing exceptions through 2 constructors.

# Composition

# Inheritance

# Override 

# Polymorphism

# Overloading

# Wrapper Classes

# instanceOf Operator (not used in code)

# Casting

# Abstract Classes

# equals()

# Interfaces

# Comparable + compareTo()

# sort()

# Comparator + compare()

# Bubble Sort

# Selection Sort

# Sequential Search

# Binary Search
