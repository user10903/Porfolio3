package AbominodoController;

import AbominodoView.View;
import java.io.IOException;
import AbominodoModel.Model;
import java.util.Scanner;


public class Controller {
    
    public void startApplication() {
        View view = new View();
        view.setVisible(true);
    }
    public String getMessage() {
        try {
            Model model = new Model();
            return model.getData();
        } catch (IOException er) {
            return "There was an error.";
        }
 }
 public void viewData() {
    Scanner in = new Scanner(System.in);
    System.out.println();
    String h1 = "Main menu";
    String u1 = h1.replaceAll(".", "=");
    System.out.println(u1);
    System.out.println(h1);
    System.out.println(u1);
    System.out.println("1) Play");
    System.out.println("2) View high scores");
    System.out.println("3) View rules");
    System.out.println("0) Quit");
    boolean quit = false;
    int menuItem; do {
    System.out.print("Select Number : ");
    menuItem = in.nextInt();
    
    switch (menuItem) {
        case 1:
        System.out.println("You've chosen Play");
        break;
        case 2:
        System.out.println("You've chosen View high scores");
        break;
        case 3:
        System.out.println("You've chosen View rules");
        break;
        case 0:
        quit = true;
        break;
        default:
        System.out.println("Invalid number.");
    }
    } while (!quit);
        System.out.println("It is a shame that you did not want to play");
        System.out.println("Thankyou for playing");
        System.exit(0);
 }
}