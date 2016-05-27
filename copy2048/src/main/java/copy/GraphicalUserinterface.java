package copy;
import javax.swing.JFrame;

public class GraphicalUserinterface implements Runnable {
    private JFrame frame;
    private Game game;

    public GraphicalUserinterface(Game game) {
        this.frame = new JFrame("2048");
        this.game = game;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
