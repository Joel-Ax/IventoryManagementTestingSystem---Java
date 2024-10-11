package Classes;
import Interfaces.UseInterface;

public abstract class Consumable extends Item implements UseInterface{
  private String effect;
  private int duration;
  
  public Consumable(String name, double weight, int goldValue, String effect, int duration) {
    super(name, weight, goldValue);
    this.effect = effect;
    this.duration = duration;
  }

  public String getEffect() {
    return effect;
  }
  public void setEffect(String effect) {
    this.effect = effect;
  }
  public int getDuration() {
    return duration;
  }
  public void setDuration(int duration) {
    this.duration = duration;
  }
  
  @Override
  public void use() {
    System.out.println("Using " + getName() + "...");
  }
}