package copy;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GraphicalUserinterface implements Runnable {
    private JFrame frame;
    private Game game;
    
    private JLabel[][] squares;
    private JLabel coloredSquare;

    public GraphicalUserinterface(Game game) {       
        this.game = game;
        
        this.squares = new JLabel[4][4];
    }

    @Override
    public void run() {
        this.frame = new JFrame("2048");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        KeyboardListener keys = new KeyboardListener(game, squares);
        frame.addKeyListener(keys);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(createBoard());

        container.add(mainPanel);
    }
    
    private JPanel createBoard() {
        JPanel board = new JPanel(new GridLayout(4, 4));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel label = new JLabel();
                squares[i][j] = label;
                label.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                if (game.getValue(i, j) != 0) {
                    label.setText(" " + game.getValue(i, j));
                    label.setFont(new Font("Serif", Font.BOLD, 40));
                }
                board.add(label);
            }
        }
        
        return board;
    }
    
    public void update() {
        int[] numbers = game.getNumbers();
        game.setNumber(numbers[0], numbers[1], 2);

        setNumbers();
        if (coloredSquare != null) {
            coloredSquare.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        }

        squares[numbers[0]][numbers[1]].setBorder(BorderFactory.createLineBorder(Color.green, 5));
        coloredSquare = squares[numbers[0]][numbers[1]];
    }
    
    public void setNumbers() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game.getValue(i, j) == 0) {
                    squares[i][j].setText("");
                } else {
                    squares[i][j].setText(" " + game.getValue(i, j));
                    squares[i][j].setFont(new Font("Serif", Font.BOLD, 40));
                }
            }
        }
    }
    
}
