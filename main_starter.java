import java.util.ArrayList;

public class main_starter{

   public static void main(String[] args){
      Human florian;
      Human max;
      //Try-Catch-Exceptions
      try{       
         florian = new Human();
         florian.addFamilyMember("Max");
         florian.addFamilyMember("Fiona");
         florian.addFamilyMember("Gregor");
         System.out.println(florian);
         florian.getLeftArm().deleteGenital(1);
         System.out.println(florian);      
      }catch(Exception e){
         System.out.println(e.getMessage());
      }
            
      try{         
         max = new Human(5, 5, 5, 5, -2, "Max");
         System.out.println(max);
      }catch(Exception e){
         System.out.println(e.getMessage());
      }
      
      // Equals()
      try{
         Human h1 = new Human(5, 5, 5, 5, 0, "Test");
         Human h2 = new Human(5, 5, 5, 5, 0, "Test");
         Human h3 = new Human(5, 5, 3, 5, 0, "Test");
      
         if(h1.equals(h2)) System.out.println("H1 equals H2.");
         else System.out.println("H1 not equals H2.");
      
         if(h1.equals(h3)) System.out.println("H1 equals H3.");
         else System.out.println("H1 not equals H3.");
      }catch(Exception e){
         System.out.println(e.getMessage());
      }
      
      // Casting
      try{
         // Returns false, why?
         Existence h4 =  new Human(5, 5, 5, 5, 0, "Test");
         Existence c1 = new Cell();
         System.out.println(h4);
         System.out.println(c1);
         System.out.println(h4.equals(c1));
         
         // Will return false, why?
         Existence c2 = new Cell();
         Cell c3 = new Cell();
         System.out.println(c2.equals(c3));
        
         // Will return true, why?
         Cell c4 = (Cell)c2;
         System.out.println(c2.equals(c4));
         
         // Will return true, why?
         Existence c5 = c4;
         System.out.println(c5.equals(c4));
         
      }catch(Exception e){
         System.out.println(e.getMessage());
      }
      
      // Polymorphism
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
      
      // Use of comparable interface in combination with polymorphism
      // We can sort Cells and Humans because of the implementation
      // of compareTo() in Existence.
      java.util.Collections.sort(existenceList);
      
      for(Existence h : existenceList){
         System.out.println(h);
      }
    
   }
   
}