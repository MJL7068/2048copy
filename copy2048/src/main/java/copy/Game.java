package copy;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private int[][] table;
    private int[] usedNumber;
    private ArrayList<String> usedSquares;

    public Game() {
        int[][] taulukko = new int[4][4];
        this.table = taulukko;

        this.usedSquares = new ArrayList<String>();

        this.usedNumber = new int[2];
        usedNumber[0] = -1;
        usedNumber[1] = -1;
        
        newNumber();
        newNumber();
    }
    
    public int[] getNumbers() {
        int[] numbers = new int[2];
        ArrayList<String> spaces = getFreeSpaces();
        
        Random rnd = new Random();
        int apu = rnd.nextInt(spaces.size());
        
        String luku = spaces.get(apu);
        numbers[0] = Integer.parseInt(luku.charAt(0) + "");
        numbers[1] = Integer.parseInt(luku.charAt(1) + "");
        
        return numbers;
    }
    
    public ArrayList<String> getFreeSpaces() {
        ArrayList<String> spaces = new ArrayList<String>();
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (table[i][j] == 0) {
                    spaces.add(i + "" + j);
                }
            }
        }
        
        return spaces;
    }
    
    public void setNumber(int i, int j, int number) {
        usedNumber[0] = -1;
        usedNumber[1] = -1;

        table[i][j] = number;

        usedNumber[0] = i;
        usedNumber[1] = j;
    }
    
    public void newNumber() {
        int[] numbers = getNumbers();
        setNumber(numbers[0], numbers[1], 2);
    }
    
    public void reset() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                table[i][j] = 0;
            }
        }
        
        int[] numbers = getNumbers();
        setNumber(numbers[0], numbers[1], 2);

    }
    
    public void direction(String direction) {
        switch (direction) {
            case "a":
                while (left());
                usedSquares.clear();
                break;
            case "w":
                while (up());
                usedSquares.clear();
                break;
            case "s":
                while (down());
                usedSquares.clear();
                break;
            case "d":
                while (right());
                usedSquares.clear();
                break;
        }
    }
    
    public int getValue(int i, int j) {
        return table[i][j];
    }
    
    public boolean up() {
        boolean moves = false;

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                int temp = table[i][j];
                if (table[i][j] != 0) {
                    if (i - 1 >= 0) {
                        if (table[i - 1][j] == temp && !usedSquares.contains((i - 1) + "" + j)) {
                            moves = true;
                            table[i - 1][j] = temp * 2;
                            String used = (i - 2) + "" + j;
                            usedSquares.add(used);
                            
                            String used2 = (i - 1) + "" + j;
                            usedSquares.add(used2);
                            
                            table[i][j] = 0;
                        } else if (table[i - 1][j] == 0) {
                            moves = true;
                            table[i - 1][j] = temp;
                            table[i][j] = 0;
                        }
                    }
                }
            }
        }          
        return moves;
    }
    
    public boolean down() {
        boolean moves = false;

        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j <= 3; j++) {
                if (table[i][j] != 0) {
                    int temp = table[i][j];
                    if (i + 1 <= 3) {
                        if (table[i + 1][j] == temp && !usedSquares.contains((i + 1) + "" + j)) {
                            moves = true;
                            table[i + 1][j] = temp * 2;
                            String used = (1 + 2) + "" + j;

                            String used2 = (1 + 1) + "" + j;
                            usedSquares.add(used2);
                            usedSquares.add(used);
                            table[i][j] = 0;
                        } else if (table[i + 1][j] == 0) {
                            moves = true;
                            table[i + 1][j] = temp;
                            table[i][j] = 0;
                        }
                    }
                }
            }
        }

        return moves;
    }
    
    public boolean right() {
        boolean moves = false;

        for (int i = 0; i <= 3; i++) {
            for (int j = 3; j >= 0; j--) {
                if (table[i][j] != 0) {
                    int temp = table[i][j];
                    if (j + 1 <= 3) {
                        if (table[i][j + 1] == temp && !usedSquares.contains(i + "" + (j + 1))) {
                            moves = true;
                            table[i][j + 1] = temp * 2;
                            String used = i + "" + (j + 2);

                            String used2 = 1 + "" + (j + 1);
                            usedSquares.add(used2);
                            usedSquares.add(used);
                            table[i][j] = 0;

                        } else if (table[i][j + 1] == 0) {
                            moves = true;
                            table[i][j + 1] = temp;
                            table[i][j] = 0;
                        }
                    }
                }
            }
        }

        return moves;
    }
    
    public boolean left() {
        boolean moves = false;

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (table[i][j] != 0) {
                    int temp = table[i][j];
                    if (j - 1 >= 0) {
                        if (table[i][j - 1] == temp && !usedSquares.contains(i + "" + (j - 1))) {
                            moves = true;
                            table[i][j - 1] = temp * 2;
                            String used = i + "" + (j - 2);

                            String used2 = 1 + "" + (j - 1);
                            usedSquares.add(used2);
                            usedSquares.add(used);
                            table[i][j] = 0;
                        } else if (table[i][j - 1] == 0) {
                            moves = true;
                            table[i][j - 1] = temp;
                            table[i][j] = 0;
                        }
                    }
                }
            }
        }

        return moves;
    }
    
}
