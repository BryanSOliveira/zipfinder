import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ZipCodeLookup zipCodeLookup = new ZipCodeLookup();

    System.out.println("Enter a ZIP Code for inquiry:");
    String zip = scanner.nextLine();

    try {
      Address newAddress = zipCodeLookup.findAddress(zip);
      System.out.println(newAddress);
      FileGenerator fileGenerator = new FileGenerator();
      fileGenerator.saveJson(newAddress);
    } catch (RuntimeException | IOException e) {
      System.out.println(e.getMessage());
      System.out.println("Closing application");
    }

  }
}
