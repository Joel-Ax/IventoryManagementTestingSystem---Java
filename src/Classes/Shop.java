package Classes;

public class Shop {
  private Inventory shopInventory;

  public Shop() {
    shopInventory = new Inventory();

    shopInventory.addItem(new SwordOfAThousandTruths());
    shopInventory.addItem(new HealthPotion());
    shopInventory.addItem(new MagicOgreArmor());
    shopInventory.addItem(new RottenWolfPelt());
    shopInventory.addItem(new RottenWolfPelt());
    shopInventory.addItem(new RottenWolfPelt());
    shopInventory.addItem(new RottenWolfPelt());
  }

  public Inventory getShopInventory() {
    return shopInventory;
  }

  public void displayShopInventory() {
    System.out.println("\n=== Shop Inventory ===");
    for (Item item : shopInventory.getItems()) {
      System.out.println(item.getName() + " - " + item.getGoldValue() + " gold");
    }
  }

  public void buyItem(Item item, Inventory Inventory) {
    if (Inventory.getGold() >= item.getGoldValue()) {
      Inventory.addItem(item);
      Inventory.setGold(Inventory.getGold() - item.getGoldValue());
      System.out.println("You bought " + item.getName() + " for " + item.getGoldValue() + " gold.");
    } else {
      System.out.println("You don't have enough gold to buy " + item.getName() + ".");
    }
  }

  public void sellItem(Item item, Inventory inventory) {
    if (inventory.getItems().contains(item)) {
      inventory.removeItem(item);
      inventory.setGold(inventory.getGold() + item.getGoldValue());
      shopInventory.addItem(item);
      System.out.println("You sold " + item.getName() + " for " + item.getGoldValue() + " gold.");
    } else {
      System.out.println("You don't have " + item.getName() + " in your inventory.");
    }
  }
}