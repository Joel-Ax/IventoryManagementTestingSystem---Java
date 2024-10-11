import java.util.Scanner;

import Classes.HealthPotion;
import Classes.Inventory;
import Classes.Item;
import Classes.MagicOgreArmor;
import Classes.Shop;
import Classes.SwordOfAThousandTruths;
import Interfaces.EquipInterface;
import Interfaces.UseInterface;

public class InventoryManagement {
  public static void main(String[] args) {
    Inventory inventory = new Inventory();

    Shop shop = new Shop();
    Scanner scanner = new Scanner(System.in);

    boolean systemRunning = true;

    while (systemRunning) {
      inventory.setGold(1000);
      System.out.println("\n=== Inventory Management System ===");
      System.out.println("Current gold: " + inventory.getGold());
      System.out.println("1. Add item to inventory");
      System.out.println("2. Remove item from inventroy");
      System.out.println("3. Equip item");
      System.out.println("4. Unequip item");
      System.out.println("5. Use item");
      System.out.println("6. Display iventory");
      System.out.println("7. Inspect item");
      System.out.println("8. Visit shop");
      System.out.println("9. Exit");
      System.out.println("=== Please select an option. ===");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Which item would you like to add:");
          System.out.println("1. Sword of a Thousand Truths\n2. Health Potion\n3. Magic Ogre Armor");
          System.out.println("Select an item to add:");
          int addChoice = scanner.nextInt();
          Item newItem = null;
                  
          switch (addChoice) {
            case 1:
              newItem = new SwordOfAThousandTruths();
              break;
            case 2:
              newItem = new HealthPotion();
              break;
            case 3:
              newItem = new MagicOgreArmor();
              break;
            default:
              System.out.println("Invalid item name.");
              break;
          } 
          if (newItem != null) {
            inventory.addItem(newItem);
            System.out.println(newItem.getName() +" added to inventory.");
          }
          break;

        case 2: // Remove item from inventory
          System.out.println("Enter the name of the item you would like to remove:");
          scanner.nextLine();
          String removeItemName = scanner.nextLine();

          Item foundItem = findItemByName(inventory, removeItemName);
          if (foundItem != null) {
            inventory.removeItem(foundItem);
            System.out.println(foundItem + " removed from inventory.");
          } else {
            System.out.println("Item not found in inventory.");
          }
          break;

        case 3: // Equip item
          System.out.println("Enter the name of the item you would like to equip:");
          scanner.nextLine();
          String itemToEquip = scanner.nextLine();
          Item item = findItemByName(inventory, itemToEquip);

          if (item != null && item instanceof EquipInterface) {
            inventory.equipItem(item);
          } else {
            System.out.println("Item not found in inventory or is not equippable.");
          }

          break;
        
        case 4: // Unequip item
          System.out.println("Enter the name of the item you would like to unquip");
          scanner.nextLine();
          String itemToUnequip = scanner.nextLine();

          Item unequipItem = findItemByName(inventory, itemToUnequip);
          
          if (unequipItem != null && unequipItem instanceof EquipInterface) {
            inventory.unequipItem(unequipItem);
          } else {
              System.out.println("Item not found.");
          }
          break;

        case 5: // Use item
          System.out.println("Enter the name of the item you would like to use:");
          scanner.nextLine();
          String itemToUse = scanner.nextLine();
          Item useItem = findItemByName(inventory, itemToUse);
          
          if (useItem != null && useItem instanceof UseInterface){
            //Check if the item is equipped
            if (useItem instanceof EquipInterface){
              EquipInterface equippableItem = (EquipInterface) useItem;
              if (equippableItem.isEquipped()) {
                ((UseInterface) useItem).use();
            } else {
              System.out.println(useItem.getName() + " needs to be equipped before you can use it.");
            }
          } else {
            ((UseInterface) useItem).use();
            System.out.println(useItem.getName() + " has been used.");
            inventory.removeItem(useItem);
          }
            
          } else {
            System.out.println("Item not found.");
          }
          break;

        case 6: // Display inventory
          inventory.displayInventory();
          break;
        
        case 7: // Inspect item
          System.out.println("Enter the name of the item you would like to inspect:");
          scanner.nextLine();
          String itemToInspect = scanner.nextLine();

          Item inspectItem = findItemByName(inventory, itemToInspect);
          if (inspectItem != null) {
            inspectItem.inspectItem();
          } else {
            System.out.println("Item not found.");
          }
          break;
          
        case 8: // Visit Shop
          boolean inShop = true;
          while (inShop) {
            System.out.println("Welcome to the shop!");
            System.out.println("You have " + inventory.getGold() + " gold.");
            System.out.println("1. Buy item");
            System.out.println("2. Sell item");
            System.out.println("3. View inventory");
            System.out.println("4. Exit shop");
            System.out.println("Enter your choice:");
            int shopChoice = scanner.nextInt();

            switch (shopChoice) {
              case 1: // Buy item
                shop.displayShopInventory();
                System.out.println("Enter the name of the item you would like to buy:");
                scanner.nextLine();
                String buyItemName = scanner.nextLine();

                Item foundShopItem = findItemByName(shop.getShopInventory(), buyItemName);

                if (foundShopItem != null) {
                  shop.buyItem(foundShopItem, inventory);
                } else {
                  System.out.println("Item not found in shop.");
                }
                break;
            
              case 2: // Sell item
                System.out.println("Enter the name of the item you would like to sell:");
                scanner.nextLine();
                String sellItemName = scanner.nextLine();
                Item foundSellItem = findItemByName(inventory, sellItemName);

                if (foundSellItem != null) {
                  System.out.println("Item sold." + foundSellItem.getName());
                  shop.sellItem(foundSellItem, inventory);
                } else {
                  System.out.println("Item not found.");
                }
                break;

              case 3: // View inventory
                inventory.displayInventory();
                break;
              
              case 4: // Exit shop
                System.out.println("Exiting shop.");
                inShop = false;
                break;
                
              default:
                System.out.println("Invalid choice.");
                break;
            }
          }
          break;
          case 9: // Exit inventory management
          systemRunning = false;
          System.out.println("Exiting inventory management.");
          break;

        default: 
        System.out.println("Invalid choice. Please select a vlid option.");
        
        }
      }
      scanner.close();   
    }

    private static Item findItemByName(Inventory inventory, String itemName) {
      for (Item item : inventory.getItems()) {
        if (item.getName().equalsIgnoreCase(itemName.trim())) {
          return item;
        }
      }
      return null;
    }
  }




/* 
if (unequipItem != null && unequipItem instanceof EquipInterface) {
            EquipInterface unequippableItem = (EquipInterface) unequipItem;

            if (unequippableItem.isEquipped()) {
              unequippableItem.unEquip();
              System.out.println(unequipItem.getName() + " is now unequipped.");
              inventory.unequipItem(unequipItem);
            } else {
              System.out.println(unequipItem.getName() + " is not equipped.");
            }
          } else {
            System.out.println("Item not found.");
          } */


 /* inventory.addItem(new SwordOfAThousandTruths());
    inventory.addItem(new HealthPotion());
    inventory.addItem(new MagicOgreArmor());
    inventory.displayInventory(); */

        /*       System.out.println("Enter the name of the item you would like to equip:");
          scanner.nextLine();
          String itemToEquip = scanner.nextLine();
          Item equipItem = findItemByName(inventory, itemToEquip);
          if (equipItem != null && equipItem instanceof EquipInterface) {
            ((EquipInterface) equipItem).equip();
          } else {
            System.out.println("Item not found in inventory or is not equippable.");
          }
          break;

        case 4: // Unequip item
          System.out.println("Enter the name of the item you would like to unequip:");
          scanner.nextLine();
          String itemToUnequip = scanner.nextLine();
          Item unequipItem = findItemByName(inventory, itemToUnequip);
          if (unequipItem != null && equipItem instanceof EquipInterface) {
            ((EquipInterface) unequipItem).unEquip();
          } else {
            System.out.println("Item is not equipped.");
          }
          break;

        case 5: // Use item
          System.out.println("Enter the name of the item you would like to use:");
          default: 
          System.out.println("Invalid choice."); */


           /*  
            EquipInterface equippableItem = (EquipInterface) item;
           if (!equippableItem.isEquipped()) {
              equippableItem.equip();
              System.out.println(item.getName() + " is now equipped.");
              inventory.equipItem(item);
            } else {
              System.out.println(item.getName() + " is already equipped."); // check if you want to unequip or not
            }
          } else {
            System.out.println("Item not found in inventory or is not equippable.");
          } */