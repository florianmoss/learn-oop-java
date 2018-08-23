public abstract class Existence implements Comparable<Existence>{
   private int age;
   private String name;

   // Constructor that throws an Exception, also needs to be thrown in subclass,
   // check out Human.java line 11 and line 15 for example. And try-catch 
   // in main_starter
   public Existence(int age, String name) throws Exception{
      if(age>-1){
         this.age = age;
         this.name = name;
      } else throw new AgeException();
   }
   
   // Regular Class Methods
    public int getAge(){
      return age;
   }
   
   public void setAge(int age){
      this.age = age;
   }
   
   public String getName(){
      return name;
   }
   
   public void setName(String name){
      this.name = name;
   }
   
   // Abstract Class Methods
   public abstract int calcApproxDeath();
   public abstract void deleteExistence();
   
   //Comparable Interface
   @Override
   public int compareTo(Existence obj){
      if(this.getAge() > obj.getAge()) return  1;
      if(this.getAge() < obj.getAge()) return -1;
      return 0;
   }
}  