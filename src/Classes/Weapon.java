package Classes;
public abstract class Weapon extends Item{
  private int attackValue;
  private int durability;

  public Weapon(String name, double weight, int goldValue, int attackValue, int durability) {
    super(name, weight, goldValue);
    this.attackValue = attackValue;
    this.durability = durability;
  }
  
  public int getAttackValue() {
    return attackValue;
  }

  public void setAttackValue(int attackValue) {
    this.attackValue = attackValue;
  }

  public int getDurability() {
    return durability;
  }

  public void setDurability(int durability) {
    this.durability = durability;
  }

  /* @Override
  public String toString() {
    return super.toString() + ", Attack Value: " + attackValue + ", Durability: " + durability;
  } */
}

