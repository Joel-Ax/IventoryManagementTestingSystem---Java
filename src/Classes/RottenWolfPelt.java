package Classes;
public class RottenWolfPelt extends Item {
  private String description;

  public RottenWolfPelt() {
    super("Rotten Wolf Pelt", 2.0, 15);
    description = "It's a rotten wolf pelt, who would ever buy this?.";
  }
  @Override
  public void inspectItem() {
    System.out.println(description + " Weight: " + getWeight() + " gold value: " + getGoldValue());
  }
}