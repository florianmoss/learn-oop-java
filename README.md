# Introduction

This is a small project I have thrown together to help students at LYIT with their exams in **Object Orientated Programming 3**. This tutorial deals with Java code, which is what is being used for the exam. If you are interested in Processing, check out my other projects [Asteroids Game](https://github.com/florianmoss/asteroidsGame-Java-Processing) and [Maze Solver](https://github.com/florianmoss/mazeSolver-Java-Processing). These will deal with an actual implementation whereas the goal for this project is to help you understand the underlying concepts. Feel free to share this resource with your friends and copy from it whenever you need it.

![https://github.com/florianmoss/learn-oop-java/blob/master/uml.PNG](https://github.com/florianmoss/learn-oop-java/blob/master/uml.PNG)

I will go through the following chapters in this tutorial:

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

- Retrieve an object at position i:

```java
list.get(i)  // Returns object
```

- Add an object, add an object at position:

```java
list.add(i)  // Adds object i
list.add(index, i)  // Adds object i at index
```

- Empty the ArrayList:

```java
list.clear()  // Clears the ArrayList
```

- Remove an object, remove an object at position:

```java
list.remove(i)  // remove object i
list.remove(index)  // remove object at index
```

- Index of Object:

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

Hint: You will need to look at the [Existence Class](https://github.com/florianmoss/learn-oop-java/blob/master/Existence.java), the [Human Class](https://github.com/florianmoss/learn-oop-java/blob/master/Human.java) and the [Genitals Class](https://github.com/florianmoss/learn-oop-java/blob/master/Genitals.java).

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

[Another explanation](https://www.journaldev.com/1325/composition-in-java-example)

Composition is a fancy word for Objects in Objects. Sounds a bit weird at first, but it's super simple, I promise!

Let's look at an example first:

```java
public class Human extends Existence{
   private Arm armLeft;
   private Arm armRight;
   private Leg legLeft;
   private Leg legRight;

   ....
```

As you can see, instead of having just primitive datatypes as fields, we now have objects as a field. This is composition.

Composition is also knows as a **has-a-Relationship**.
A human has an arm, or two at best.
A human has two legs.

A book has-a-Author
A computer has-a-motherboard

And so forth.

The same way you would write your **getter and setter - Methods** you can also write these for objects:

```java
// Gain access to composition objects
  public Arm getLeftArm(){
     return armLeft;
  }

  public Arm getRightArm(){
     return armRight;
  }

  public Leg getLeftLeg(){
     return legLeft;
  }

  public Leg getRightLeg(){
     return legRight;
  }
```

This way you can access all fields and methods from the Arm and Leg objects within your human.
Some examples you can find [here](https://github.com/florianmoss/learn-oop-java/blob/master/main_starter.java).

For the constructor we have a variety of options:

**Option 1 - call the constructor with primitive Datatypes - also my implementation**

```java
public Human(int fingersLeft, int fingersRight, int toesLeft, int toesRight, int age, String name) {
         super(age, name);
         this.armLeft = new Arm(fingersLeft); // initialise the object here
         this.armRight = new Arm(fingersRight);
         this.legLeft = new Leg(toesLeft);
         this.legRight = new Leg(toesRight);
         this.familyMembers = new ArrayList<String>();
   }
```

Creating a human will work this way:

```java
Human h1 = new Human(5, 5, 5, 5, 0, "Test");
Human h2 = new Human();
```

**Option 2 - call the constructor with Objects - more Elegant way**

```java
public Human(Arm armLeft, Arm armRight, Leg legLeft, Leg legRight, int age, String name) {
        super(age, name);
        this.armLeft = armLeft;
        this.armRight = armRight;
        this.legLeft = legLeft;
        this.legRight = legRight
        this.familyMembers = new ArrayList<String>();
  }
```

Creating a human will work this way:

```java
Human h1 = new Human(new Arm(5), new Arm(5), new Leg(5), new Leg(5), 0, "Test");
```

**Choose one of the two options and be consistent with it, it doesn't matter how you do choose to do it (Except when your boss tells you to do it one way).**

# Inheritance

Inheritance is important, make sure you really understand it. We just looked at [Composition](#composition), Inheritance is basically the same but different.

Composition means **has-a-Relationship**, a human has-a-Leg for example.
Inheritance means **is-a-Relationship**, a human is an Existence, or a Dog is an animal. A chair is furniture.

Remember the difference!!!

Inheritance means that you can reuse functionality very easily and you can extend it quite easy.

Let's again start with an example:

Inheritance means there is a **superclass** and a **subclass**. The superclass is as the name suggests a class that is above the subclass. Animal - Dog, Furniture - Chair, Existence - Human all have this relationship to each other.

### Syntax

```java
public class Human extends Existence{   // extends means that the Human upon creation is also an Existence
   public Human(...){
      super();    // super() needs to be called first in your constructor
      ...
   }
}
```

### this vs. super

When you want to make it obvious that you are accessing a field from **this** class you use the **this** Keyword, by now you should know that. The **super** Keyword means that you are calling a field or method not from **this** but from **superclass**.

### Example

I will use a very simple example here, Animal and Dog.

Animal Class

```java
public class Animal{
   private int age;      // Every animal has an age.
   private String name;  // Every animal has a name.


   public Animal(int age, String name){  // An animal we create has an age and a name
      this.age = age;
      this.name = name;
   }

   public void eat(){                    // Every animal can eat
      System.out.println("Animal eat() invoked");
   }

   public int getAge(){
      return age;
   }

   public void setAge(int age){
      this.age = age;
   }
}
```

Dog Class

```java
public class Dog extends Animal{    // A Dog is an animal but receives also all functionality from the Animal class
   private int legs;                // A Dog can have additional fields, but doesn't need to

   public Dog(int age, String name, int legs){ //A Dog needs to have an Age, a Name (because he is an animal) and Legs (because he is a                                          Dog)
      super(age, name);    // calls the Animal constructor with the paramters age and name
      this.legs = legs;    // initialises the legs
   }

   @Override
   public void eat(){
      System.out.println("Dog eat() invoked");
   }
}
```

Tester class

```java
public class tester{
   public static void main(String[] args){
      Dog dog = new Dog(1, "Sergej", 4);               // invokes constructor in Dog.java
      Animal animal = new Animal(1, "Theresa");        // invokes constructor in Animal.java

      dog.eat();                                       // Output: "Dog eat() invoked", calls eat() first from Dog class
      dog.super.eat();                                 // Output: "Animal eat() invoked",specifically invokes from animal superclass

      dog.age;                                         // Compiler Error, age is private to Animal
      dog.getAge();                                    // returns 1 because getAge() is a public method
      dog.setAge(3);                                   // works as well because setAge() is public

      animal.age;                                      // returns 1;
      animal.getAge();                                 // returns 1 because getAge() an animal specific method
      animal.setAge(3);                                // same as above
   }
}
```

I would advise to look at [Existence Class](https://github.com/florianmoss/learn-oop-java/blob/master/Existence.java)and [Human Class](https://github.com/florianmoss/learn-oop-java/blob/master/Human.java).

Then go and try to reproduce the Animal - Dog relation in 2 classes and come up with more methods. What could be Dog specific? Maybe a race, a bark method and a drink method. Write a tester to invoke these methods and make sure you really understand what is going on.

You will understand it by doing, I promise.

# Override

[Another Documentation](https://www.geeksforgeeks.org/overriding-in-java/)

Override means that you are overwriting a method. You have seen the [toString()](#tostring--enhanced-for-loop) Method for example or the **Dog.eat()** Method in the [Inheritance section](#inheritance).

Both methods are already existent but have a form of return that we do not want, therefore we can change it.
You don't need to show in your code that you overwrote something, but you certainly can and you should - so other people know what you have done when they read your code.

### Syntax

```java
@Override
public String toString(){
   return //whatever you need
}
```

# Polymorphism

Polymorphism is again, just a fancy word for saying:
**One line of code invokes different behaviour at runtime**

It often occurs when the sublclass overrides a method in the superclass. You can check out the [Inheritance section](#inheritance) and the the [Override section](#override) to find more about this.

In other words, Polymorphism is the result of Inheritance in combination with Override.

### Code Example

Open the [main_starter Class](https://github.com/florianmoss/learn-oop-java/blob/master/main_starter.java) at line 69.

```java
      ArrayList<Existence> existenceList = new ArrayList<Existence>();
      try{
         for(int i=0; i<20; i++){
            existenceList.add(new Human(5, 5, 5, 5, i, ("Name"+i)));
         }
         existenceList.add(new Cell());
         existenceList.add(new Cell());
      }catch(Exception e){
         System.out.println(e.getMessage());
      }


      // --> This is Polymorphism, 1 Line of code but at execution with
      //     different execution/meaning.
      for(Existence h : existenceList){
         System.out.println(h);
      }
```

What output do you expect for the second for-loop:

```java
for(Existence h : existenceList){
        System.out.println(h);
}
```

First of all you need to understand the section about [toString() and enhanced for-loops](#tostring--enhanced-for-loop). Then we know, what to do, right? We need to check if the is a different implementation for **toString()** for the **Cell** and the **Human**, first we should check **Existence**, since it is the superclass for both.

Did you find a toString() Method in [Existence.java](https://github.com/florianmoss/learn-oop-java/blob/master/Existence.java)?

No, good. Let's move on then.

A [**Cell**](https://github.com/florianmoss/learn-oop-java/blob/master/Cell.java) seems to have no additional fields, only the name and age inherited from [**Existence**](https://github.com/florianmoss/learn-oop-java/blob/master/Existence.java).

```java
   @Override
  public String toString(){
     return "Cell{age="+getAge()+", name="+getName()+"}";
  }
```

A [**Human**](https://github.com/florianmoss/learn-oop-java/blob/master/Human.java) contains also a toString() Method, as we have discussed in detail [here](#tostring--enhanced-for-loop).

```java
  public boolean equals(Human h){
     return (this.getAge()==h.getAge() && this.getName().equals(h.getName()) &&
                 this.getLeftArm().equals(h.getLeftArm()) && this.getRightArm().equals(h.getRightArm()) &&
                    this.getLeftLeg().equals(h.getLeftLeg()) && this.getRightLeg().equals(h.getRightLeg()));
  }
```

Back to our Loop, we are now able to say, that the Output is:

```java
Human{age=0, name=Name0, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
Human{age=1, name=Name1, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
Human{age=2, name=Name2, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
Human{age=3, name=Name3, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
Human{age=4, name=Name4, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
Human{age=5, name=Name5, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
Human{age=6, name=Name6, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
Human{age=7, name=Name7, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
Human{age=8, name=Name8, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
Human{age=9, name=Name9, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4, familyMembers=[]
Human{age=10, name=Name10, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4,familyMembers=[]
Human{age=11, name=Name11, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4,familyMembers=[]
Human{age=12, name=Name12, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4,familyMembers=[]
Human{age=13, name=Name13, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4,familyMembers=[]
Human{age=14, name=Name14, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4,familyMembers=[]
Human{age=15, name=Name15, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4,familyMembers=[]
Human{age=16, name=Name16, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4,familyMembers=[]
Human{age=17, name=Name17, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4,familyMembers=[]
Human{age=18, name=Name18, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4,familyMembers=[]
Human{age=19, name=Name19, armLeft=0 ,1 ,2 ,3 ,4, armRight=0 ,1 ,2 ,3 ,4, legLeft=0 ,1 ,2 ,3 ,4, legRight=0 ,1 ,2 ,3 ,4,familyMembers=[]
Cell{age=0, name=Cell}
Cell{age=0, name=Cell}
```

### Why is that so fascinating?

Well let's look again at the loop:

```java
for(Existence h : existenceList){
        System.out.println(h);
}
```

We have one line of code **System.out.println(h)** but at execution it invokes different toString() Methods. From a **Human** and from a **Cell**. That's pretty cool isn't it?

# Overloading

- MUST change the argument list
- CAN change the return type

That's all you need to remember basically. Overloading means that you can have multiple constructors and/or methods with the same name.

### Code Example

```java
    // Constructor Overloading
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

   // Method Overloading

   public void eat(){
      System.out.println("Human eats.");
   }

   // Invalid, because we MUST change the argument list !!!
//  public String eat(){
//     return "Human eats."
//  }

   // Valid
   public String eat(String food){
      return "Human eats " + food;
   }

   // Valid
   public void eat(String food, int amount){
       System.out.println("Human eats " + food + ", " + amount + " times.");
   }
```

# Wrapper Classes

| Primitive Type | Wrapper Class |
| -------------- | :-----------: |
| boolean        |    Boolean    |
| byte           |     Byte      |
| char           |   Character   |
| float          |     Float     |
| int            |    Integer    |
| long           |     Long      |
| short          |     Short     |
| double         |    Double     |

Primitive datatypes limit us in their functionality. As the name suggest they are primitive - therefore they are not good for much because they can't do much.

Why not create an object that is an int with more functionality? And call it [Integer](https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html).

Can you think of a simple usecase for this?

```java
 ArrayList<Integer> numbers = new ArrayList<Integer>();
```

...well we know that we can't use ArrayLists with primitive datatypes, hence we need to use an object, here: Integer.

Not needed for this class, but I think you should know of is [Autoboxing and Unboxing](https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html). Take 5 min to read the official documentation and it will all make a lot more sense.

# instanceOf Operator (not used in code)

Let's start this again with an example, since the name basically says what it does.

```java
      Existence e;

      e = new Human();

      if(e instanceof Human)
            System.out.println("I'm a human");
      else
            System.out.println("I'm not a human");
```

**instanceof** just checks if a variable that is declared as a superclass is an instance of a certain subclass.

# Casting

For casting, please remember the following: **You can go always from subclass to superclass, but not the other way around.**.

### Code Example

```java
      // All 4 are valid declarations and initialisations
      Existence c = new Cell();
      Existence h = new Human();

      Cell c2 = new Cell();
      Human h2 = new Human();

      // Now, where do we need casting and where not:

      Existence h3 = c2;  // works because we are going from subclass to superclass.
      // Cell c3 = c;     // Doesn't work, because we are going from superclass to subclass. "c" is an Existence.

      // Solution:
      Cell c3 = (Cell)c2; // We can cast, and then assign the value.
```

You can also use the **instanceof** Keyword in combination with casting to avoid any compiler errors, for example:

```java
      Existence c = new Cell();

      if(c instanceof Cell)
            Cell c2 = (Cell)c;
```

# Abstract Classes

Abstract classes are more or less an evolution of [Inheritance](#inheritance). Let's look at our example, we have an Existence class from where the Human class and the Cell class inherit from. But do we actually want to be able to create an Existence object? Not really, we just want the subclasses to have certain properties, but an Existence itself doesn't exist, so we wan't to prevent this, this is where we can use **Abstract Classes**.

### Syntax

```java
      public abstract class Existence{
            // code
      }
```

The **abstract** Keyword indicated that you can't create an object of the form Existence. But it can still work as a superclass.

### Abstract Methods

You can also provide abstract methods, these methods are meant to be implemanted by the subclass. They **HAVE** to be implemented by any subclass in fact. Abstract methods only have a method signature but no method body. Abstract methods also **HAVE** to be **public**, for obvious reasons. An Example will explain it best though:

Existence Class:

```java
   // Abstract Class Methods
   public abstract int calcApproxDeath();
   public abstract void deleteExistence();
```

Human Class:

```java
   @Override
   public int calcApproxDeath(){
      return 80 - getAge();
   }

   @Override
   public void deleteExistence(){
      setAge(999);
      setName("Human dead");
   }
```

Cell Class:

```java
   @Override
   public int calcApproxDeath(){
      return 5 - getAge();
   }

   @Override
   public void deleteExistence(){
      setAge(999);
      setName("Cell dead");
   }
```

# equals()

We have covered the equals() method in the first year already, that's why I will keep it short here and give you only an example.

### Syntax

```java
      public boolean equals(Object o){
            return //compare all fields
      }
```

### Example

Cell Class:

```java
  public boolean equals(Cell c){
      return (this.getAge()==c.getAge() && this.getName().equals(c.getName()));
   }
```

Human Class:

```java
   public boolean equals(Human h){
      return (this.getAge()==h.getAge() && this.getName().equals(h.getName()) &&
                  this.getLeftArm().equals(h.getLeftArm()) && this.getRightArm().equals(h.getRightArm()) &&
                     this.getLeftLeg().equals(h.getLeftLeg()) && this.getRightLeg().equals(h.getRightLeg()));
   }
```

# Interfaces

Interfaces are a natural evolution of inheritance. The problem with inheritance is, that a class can only inherit from one superclass. This is obviously quite limiting. Let's think about a **Human**, a human is an **Existence** but at the same time a human is also **learnable**, this applies to a lot of existences, but how can we share this functionality between a variety of subclasses, if we can only inherit from one superclass? We can't and that's why we use interfaces.

Remember the following: **All interfaces are a description of promised behaviour.**.

### Syntax

The interface:

```java
      public interface InterfaceName<T>{                // don't worry about the <T> here. It's a generic and is a placeholder for all possible types.
            public returnType methodName(T obj);

            // more methods possibly
      }
```

The implementation in our class:

```java
public class ClassName implements InterfaceName<T>{
      // code
}
```

We can implement more than one interface, just put a ',' between them.

# Comparable + compareTo()

### Comparable Interface

```java
     public interface Comparable<T>{
           public int compareTo(T obj);
     }
```

Implementation in our Existence Class:

```java
public abstract class Existence implements Comparable<Existence>{
      @Override
      public int compareTo(Existence obj){
            if(this.getAge() > obj.getAge()) return  1;
            if(this.getAge() < obj.getAge()) return -1;
            return 0;
      }
}
```

When we compare two Existence objects, we compare them based on their age to create a natural hierachy based on the age.

# sort()

# Comparator + compare()

# Bubble Sort

# Selection Sort

# Sequential Search

# Binary Search
