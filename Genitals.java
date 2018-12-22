import java.util.ArrayList;

public abstract class Genitals{
   
   public ArrayList<Integer> genitals;
 
   public Genitals(){
      this.genitals = new ArrayList<Integer>();
   } 
   
   
   public abstract void setGenitals(int amount);
   public abstract boolean deleteGenital(int index);
   
   @Override
   public String toString(){
      String s = "";
      for(Integer i : genitals){
         s += " ,"+i;
      }
      return s.substring(2);
   }
   

   public boolean equals(Genitals obj){
      if(this.genitals.size() == obj.genitals.size()){
         for(int i=0; i<genitals.size(); i++){
            if(this.genitals.get(i).equals(obj.genitals.get(i)));
            else return false; 
         }
         return true;
      }  
      return false;
   }   
}
