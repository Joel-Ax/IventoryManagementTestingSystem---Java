package Classes;
import Interfaces.EquipInterface;

public class MagicOgreArmor extends Armor implements EquipInterface {
  private int stamina;
  private int strength;
  private boolean isEquipped;

  public MagicOgreArmor() {
    super("Magic Ogre Armor", 10, 500, 1000, "Magic");
    this.stamina = 3500;
    this.strength = 5000;
    this.isEquipped = false;
  }

  @Override
  public void equip() {
    isEquipped = true;
    System.out.println("Equipping " + getName() + "...");
    System.out.println("+" + stamina + " Stamina +\n" + strength + " Strength");
  }
  @Override
  public void unEquip() {
    isEquipped = false;
    System.out.println("Unequipping " + getName() + "...");
  }
  @Override
  public void inspectItem(){
    System.out.println(getName() + " (Armor) - Defense: " + getDefenseValue() +
    ", Material: " + getMaterial() + ", Stamina: " + stamina + ", Strength" + strength + ", Weight: " + getWeight() +
    "kg, Gold Value: " + getGoldValue() + " gold");
  }
  
  public boolean isEquipped() {
    return isEquipped;
  }
}
