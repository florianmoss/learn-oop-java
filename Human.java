import java.util.ArrayList;

public class Human extends Existence{
   private Arm armLeft;
   private Arm armRight;
   private Leg legLeft;
   private Leg legRight;
   
   private ArrayList<String> familyMembers;
   // Constructor throws exception because superclass requires it
   public Human() throws Exception{
      this(5, 5, 5, 5, 0, "none");
   }
   // same as line 10.
   public Human(int fingersLeft, int fingersRight, int toesLeft, int toesRight, int age, String name) throws Exception{
         super(age, name);
         this.armLeft = new Arm(fingersLeft);
         this.armRight = new Arm(fingersRight);
         this.legLeft = new Leg(toesLeft);
         this.legRight = new Leg(toesRight);
         this.familyMembers = new ArrayList<String>();
   }
   

   public void addFamilyMember(String firstName){
      familyMembers.add(firstName);
   }
   
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
   
   // Implemented methods from abstract class Existence
   @Override
   public int calcApproxDeath(){
      return 80 - getAge();
   }
   
   @Override 
   public void deleteExistence(){
      setAge(999);
      setName("Human dead");
   }
   
   // Implementation of toString()
   @Override 
   public String toString(){
      return "Human{age="+getAge()+", name="+getName()+", armLeft="+armLeft+", armRight="+armRight+
            ", legLeft="+legLeft+", legRight="+legRight+", familyMembers="+familyMembers;
   }
   
   // Implementation of equals()
   public boolean equals(Human h){
      return (this.getAge()==h.getAge() && this.getName().equals(h.getName()) && 
                  this.getLeftArm().equals(h.getLeftArm()) && this.getRightArm().equals(h.getRightArm()) &&
                     this.getLeftLeg().equals(h.getLeftLeg()) && this.getRightLeg().equals(h.getRightLeg()));
   }  
}
