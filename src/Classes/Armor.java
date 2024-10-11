package Classes;
public abstract class Armor extends Item {
  private int defenseValue;
  private String material;

  public Armor(String name, double weight, int goldValue, int defenseValue, String material) {
    super(name, weight, goldValue);
    this.defenseValue = defenseValue;
    this.material = material;
  }
  public int getDefenseValue() {
    return defenseValue;
  }
  public void setDefenseValue(int defenseValue) {
    this.defenseValue = defenseValue;
  }
  public String getMaterial() {
    return material;
  }
  public void setMaterial(String material) {
    this.material = material;
  }

/*   @Override
  public String toString() {
    return super.toString() + ", Defense Value: " + defenseValue + ", Material: " + material;
  } */
}