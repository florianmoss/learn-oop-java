import java.util.ArrayList;

public class Arm extends Genitals{
  
   public Arm(int fingerAmount){
      super();
      setGenitals(fingerAmount);
   }
   
   public void setGenitals(int fingerAmount){
      for(int i=0; i<fingerAmount; i++){
         super.genitals.add(i, i);
      }
   }
   
   public boolean deleteGenital(int index){
      if(index < super.genitals.size()){
         super.genitals.remove((Integer)index-1);
         return true;
      }
      System.out.println("Finger "+ index + " was not found.");
      return false;
   } 
}
