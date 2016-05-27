package copy;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        
        GraphicalUserinterface gui = new GraphicalUserinterface(game);
        SwingUtilities.invokeLater(gui);
    }
    
}
