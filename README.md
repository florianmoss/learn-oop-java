
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
````java
   public String toString(){
      return "Human{age="+getAge()+", name="+getName()+", armLeft="+armLeft+", armRight="+armRight+
            ", legLeft="+legLeft+", legRight="+legRight+", familyMembers="+familyMembers;
   }
````

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
