import java.util.ArrayList;

public class Leg extends Genitals{
   
   public Leg(int toeAmount){
      super();
      setGenitals(toeAmount);
   }
   
   public void setGenitals(int toeAmount){
      for(int i=0; i<toeAmount; i++){
         super.genitals.add(i, i);
      }
   }
   
   public boolean deleteGenital(int index){
      if(index < super.genitals.size()){
         super.genitals.remove((Integer)index-1);
         return true;
      }
      System.out.println("Toe "+ index + " was not found.");
      return false;
   }

}