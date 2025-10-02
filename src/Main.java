import Graphics.Pages.Page;
import Graphics.Pages.StartMenu;

public class Main {
    public static void main(String[] args) {
        Page startMenu = new StartMenu();
        startMenu.addComponents();
        startMenu.renderPage();
        startMenu.addListeners();
        startMenu.show();
    }
}