package copy;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class KeyboardListener implements KeyListener {
    private Game game;
    private JLabel[][] squares;
    private JLabel coloredSquare;

    public KeyboardListener(Game game, JLabel[][] squares) {
        this.game = game;
        this.squares = squares;        
    }

    @Override
    public void keyTyped(KeyEvent e) {        
    }        

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (game.up()) {
                game.direction("w");
                update();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (game.down()) {
                game.direction("s");
                update();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (game.left()) {
                game.direction("a");
                update();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (game.right()) {
                game.direction("d");
                update();
            }
        }
    }
    
    public void update() {
        int[] luvut = game.getNumbers();
        game.setNumber(luvut[0], luvut[1], 2);

        setNumbers();
        if (coloredSquare != null) {
            coloredSquare.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        }

        squares[luvut[0]][luvut[1]].setBorder(BorderFactory.createLineBorder(Color.green, 5));
        coloredSquare = squares[luvut[0]][luvut[1]];
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

    @Override
    public void keyReleased(KeyEvent e) {        
    }
    
}
