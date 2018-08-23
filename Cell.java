public class Cell extends Existence{
   
   public Cell() throws Exception{
      super(0, "Cell");
   }
   
   @Override
   public int calcApproxDeath(){
      return 5 - getAge();
   }
   
   @Override
   public void deleteExistence(){
      setAge(999);
      setName("Cell dead");
   }
   
   @Override 
   public String toString(){
      return "Human{age="+getAge()+", name="+getName()+"}";
   }
   
   public boolean equals(Cell c){
      return (this.getAge()==c.getAge() && this.getName().equals(c.getName()));
   }
   
   
   
   
}