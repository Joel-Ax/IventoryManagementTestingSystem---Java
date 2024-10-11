package Classes;
import Interfaces.EquipInterface;
import Interfaces.UseInterface;

public class SwordOfAThousandTruths extends Weapon implements EquipInterface, UseInterface{
  private int mana;
  private String useEffect;
  private boolean isEquipped;

  /* public SwordOfAThousandTruths(String name, int attackValue, int durability, int goldValue, int weight, int mana, String useEffect) {
    super(name, attackValue, durability, goldValue, weight);
    this.mana = mana;
    this.useEffect = useEffect;
    this.isEquipped = false; 
  } */

  public SwordOfAThousandTruths() {
    super("Sword Of A Thousand Truths", 5, 123, 850, 323);
    this.mana = 200;
    this.useEffect = "Cast spell from random school of magic";
    this.isEquipped = false;
  }

  public String castSpellFromRandomSchool() {
    String[] schools = {"Fire", "Frost", "Arcane", "Nature", "Holy", "Shadow"};
    int randomIndex = (int)(Math.random() * schools.length);
    return "Casts a " + schools[randomIndex] + " spell! Deals " + getAttackValue() + " damage!";
  }

  @Override
  public void inspectItem() {
    System.out.println(getName() + " (Magic Sword) - Attack: " + getAttackValue() +
    ", Durability: " + getDurability() + ", Mana: " + mana + ", Use: " + useEffect + ", Weight: " + getWeight() +
    "kg, Gold Value: " + getGoldValue() + " gold");
  }
  
  @Override
  public void equip() {
    isEquipped = true;
    System.out.println("Equipping " + getName() + "...");
  }

  @Override
  public void unEquip() {
    isEquipped = false;
    System.out.println("Unequipping " + getName() + "...");
  }

  @Override
  public void use() {
    System.out.println("Using " + getName() + ". " + castSpellFromRandomSchool());
  }

  public boolean isEquipped() {
    return isEquipped;
  }
}
