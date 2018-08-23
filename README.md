
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

1. We invoked the toString() Method for the Object **florian**. The object **florian** is a **human**, therefore we have to check the [Human Class](https://github.com/florianmoss/learn-oop-java/blob/master/Human.java) and look for the toString()-Method.
Go open it, and look at it.

2. What now? Well there is a lot to take in, isn't it? So let's break it up:
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

3. Now we have to break up the Genitals armLeft, armRight, legLeft and LegRight
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

4. Putting it all together
When you put all the partial outputs together, you will get exactly this:
Output: 
```java
Human{age=0, name=none, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
```

Not too bad, wasn't it!

# try-catch-Exceptions

# throw + user-Defined Exceptions

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
