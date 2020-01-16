import java.util.Scanner;
public class Shopping {
  public static void main (String [] args) {
    Scanner scan = new Scanner(System.in);
    String shop = "";
    Cart cart = new Cart();
    System.out.println("Welcome to the grocery store!");
    while(!shop.equals("done")) {
      System.out.print("\nName the item you want to add to cart: ");
      String itemname = scan.nextLine();
      System.out.print("\nHow much does it cost? ");
      double price = scan.nextDouble();
      System.out.print("\nHow many do you want?");
      int quant = scan.nextInt();
      scan.nextLine();
      Item item = new Item(itemname, price, quant);
      cart.addToCart(itemname, price, quant);
      System.out.print("\n"+item);
      System.out.print("\nWould you like to keep shopping? (Type \"done\" to finish shopping): ");
      shop = scan.nextLine();
    }
      System.out.println(cart);
      System.out.println("\nThank you for shopping with us!");
  }
}
