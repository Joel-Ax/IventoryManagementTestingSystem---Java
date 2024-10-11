package Classes;
import java.util.ArrayList;

import Interfaces.EquipInterface;

public class Inventory {
  private ArrayList<Item> items;
  private ArrayList<EquipInterface> equippedItems;
  private int gold;

  public Inventory() {
    items = new ArrayList<Item>();
    equippedItems = new ArrayList<EquipInterface>();
  }

  public ArrayList<Item> getItems() {
    return items;
  }

  public ArrayList<EquipInterface> getEquippedItems() {
    return equippedItems;
  }

  public int getGold() {
    return gold;
  }

  public void setGold(int gold) {
    this.gold = gold;
  }

  public void addItem(Item item) {
    items.add(item);
  } 

  public void removeItem(Item item) {
    if (items.contains(item)) {
      items.remove(item);
      System.out.println("Item removed from inventory.");
    } else {
      System.out.println("Item not found in inventory.");
    }
  }

      public void equipItem(Item item) {
        if (item instanceof EquipInterface) {
            EquipInterface equippable = (EquipInterface) item;
            if (!equippable.isEquipped()) {
                equippable.equip(); // Mark item as equipped
                equippedItems.add(equippable); // Add to equipped items list
                System.out.println(item.getName() + " is now equipped.");
            } else {
                System.out.println(item.getName() + " is already equipped.");
            }
        }
    }

    // Unequip item and remove it from the equippedItems list
    public void unequipItem(Item item) {
        if (item instanceof EquipInterface) {
            EquipInterface equippable = (EquipInterface) item;
            if (equippable.isEquipped()) {
                equippable.unEquip(); // Mark item as unequipped
                equippedItems.remove(equippable); // Remove from equipped items list
                System.out.println(item.getName() + " is now unequipped.");
            } else {
                System.out.println(item.getName() + " is not equipped.");
            }
        }
    }

  public void displayInventory() {
    if (items.isEmpty()) {
      System.out.println("Inventory is empty.");
    } else {
      System.out.println("Inventory:");
      for (int i = 1; i < items.size(); i++) {
        System.out.println(i + ". " + items.get(i).getName());
      }
    }
  }
}
