import java.text.NumberFormat;

public class Cart {
  private int itemCount;
  private double totalPrice;
  private int capacity;
  private Item[] cart;
  public Cart() {
    capacity = 5;
    itemCount = 0;
    totalPrice = 0.0;
    cart = new Item[capacity];
  }
  
  public void addToCart(String itemName, double price, int quantity) {
    Item temp = new Item(itemName, price, quantity);
    boolean placed = false;
      for(int i=0; i<cart.length; i++) {
        if(cart[i]==null) {
          cart[i] = temp;
          itemCount += 1;
          placed = true;
          totalPrice += price*quantity;
          break;
        }
      }
      if(!placed) {
      increaseSize();
      cart[cart.length-3] = temp;
      totalPrice += price;
      }
  }
  private void increaseSize() {
    Item[] temp = new Item[capacity+3];
    for(int i = 0; i < capacity; i++) {
      temp[i] = cart[i];
    }
    cart = temp;
    capacity += 3;
  }
  
  public String toString()
  {
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    String contents = "\nCart\n";
    contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";
    for (int i = 0; i < itemCount; i++)
      contents += cart[i].toString() + "\n";
    contents += "\nTotal Price: " + fmt.format(totalPrice);
    contents += "\n";
    return contents;
  }
}
