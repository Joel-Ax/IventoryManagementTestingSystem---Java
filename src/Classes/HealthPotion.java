package Classes;
public class HealthPotion extends Consumable {
  private int healthPoints;

  public HealthPotion() {
    super("Health Potion", 0.5, 2, "Restores 25 HP.", 0);
    this.healthPoints = 25;
  }

  @Override
  public void inspectItem() {
    System.out.println(getName() + " (Consumable) - Effect: " + getEffect() + ", Duration: " + getDuration() +
    ", Weight: " + getWeight() + "kg, Gold Value: " + getGoldValue() + " gold");
  }
  @Override
  public void use() {
    System.out.println("Using " + getName() + "restoring " + healthPoints + " health points...");
  }

}
