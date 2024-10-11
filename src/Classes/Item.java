package Classes;
public abstract class Item {
  private String name;
  private double weight;
  private int goldValue;

  public Item(String name, double weight, int goldValue) {
    this.name = name;
    this.weight = weight;
    this.goldValue = goldValue;
  }

  public String getName(){
    return name;
  }
  public double getWeight(){
    return weight;
  }
  public int getGoldValue(){
    return goldValue;
  }
  public void setName(String name){
    this.name = name;
  }
  public void setWeight(double weight){
    this.weight = weight;
  }
  public void setGoldValue(int goldValue){
    this.goldValue = goldValue;
  }
  
  public abstract void inspectItem();
}
