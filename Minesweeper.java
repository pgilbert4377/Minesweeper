import java.util.*;
public class Minesweeper
{
    Scanner kb = new Scanner(System.in);
    int height = 0;
    int width = 0;
    String validation = "";
    boolean isValid = false;
    String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    int mines;
    

    public Minesweeper()
    {
        String[][] board;
        while(!isValid)
        {
            try
            {
                System.out.println("How deep is the minefield? (5-12)");
                validation = kb.nextLine();
                height = Integer.parseInt(validation);
                if(height < 5 || height > 12)
                {
                    throw new Exception();
                }
                System.out.println("How wide is the minefield? (6-18)");
                validation = kb.nextLine();
                width = Integer.parseInt(validation);
                if(width < 6 || width > 18)
                {
                    throw new Exception();
                }
                isValid = true;
            }
            catch (Exception e)
            {
                System.out.println("That is not a valid input, try again.");
            }
        }
        board = createBoard();
        playGame(board);
    }
    
    public String[][] createBoard()
    {
        String[][] b = new String[height][width];

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                b[i][j] = "";
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
        int x;
        int y;
        mines = (int)(Math.sqrt(height*width));

        while(mines != 0)
        {
            x = (int)(Math.random()*width);
            y = (int)(Math.random()*height);
            if(b[y][x].equals(""))
            {
                b[y][x] = "BOOM!";
                mines--;
            }
        }

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                int number = 0;
                if(!b[i][j].equals("BOOM!"))
                {
                    if(i == 0 && j == 0)
                    {
                        if(b[0][1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[1][0].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[1][1].equals("BOOM!"))
                        {
                            number++;
                        }
                    }
                    else if(i == 0 && j == width - 1)
                    {
                        if(b[0][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[1][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[1][j].equals("BOOM!"))
                        {
                            number++;
                        }
                    }
                    else if(i == height - 1 && j == 0)
                    {
                        if(b[i-1][j].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i-1][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                    }
                    else if(i == height - 1 && j == width - 1)
                    {
                        if(b[i-1][j].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i-1][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                    }
                    else if(i == 0)
                    {
                        if(b[i][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i+1][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i+1][j].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i+1][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                    }
                    else if(i == height - 1)
                    {
                        if(b[i-1][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i-1][j].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i-1][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                    }
                    else if(j == 0)
                    {
                        if(b[i-1][j].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i-1][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i+1][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i+1][j].equals("BOOM!"))
                        {
                            number++;
                        }
                    }
                    else if(j == width - 1)
                    {
                        if(b[i-1][j].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i-1][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i+1][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i+1][j].equals("BOOM!"))
                        {
                            number++;
                        }
                    }
                    else
                    {
                        if(b[i-1][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i-1][j].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i-1][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i+1][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i+1][j].equals("BOOM!"))
                        {
                            number++;
                        }
                        if(b[i+1][j-1].equals("BOOM!"))
                        {
                            number++;
                        }
                    }
                    b[i][j] = "" + number;
                }
            }
        }

        return b;
    }

    public void playGame(String[][] master)
    {
        boolean gameFinished = false;
        String[][] board = new String[height][width];
        int row;
        int col;

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                board[i][j] = " ";
            }
        }

        System.out.println("Welcome to my version of Minesweeper!\nTo play the game, you must enter the coordinates of the box you'd like to search, leave the flagged boxes alone.\nWhen the only boxes left are the mines, you have won the game!");
        printBoard(board);

        while(!gameFinished)
        {
            try
            {
                System.out.print("Enter the coordinates of where you'd like to dig (ex. A1): ");
                validation = kb.nextLine();
                col = (int)(validation.charAt(0) - 65);
                row = Integer.parseInt(validation.substring(1)) - 1;
                if(row > height || col > width)
                {
                    throw new Exception();
                }
                dig(board, master, row, col);
                if(board[row][col].equals("BOOM!"))
                {
                    gameFinished = true;
                    System.out.println("You hit a bomb, better luck next time!");
                }
                else if(checkBoard(board) == mines)
                {
                    gameFinished = true;
                    System.out.println("Congrats, you've completed the game successfully!");
                }
                else
                {
                    printBoard(board);
                }
            }
            catch(Exception e)
            {
                System.out.println("That is not a valid coordinate for this board, try again");
            }
        }
        printBoard(master);
    }
    
    public void printBoard(String[][] b)
    {
        String colhead = "";
        for(int i = 0; i < width; i++)
        {
            colhead = colhead + "\t|\t" + letters[i];
        }
        System.out.print(colhead + "\n--------");
        for(int j = 0; j < width; j++)
        {
            System.out.print("----------------");
        }
        System.out.println();

        for(int i = 0; i < height; i++)
        {
            System.out.print(i + 1);
            for(int j = 0; j < width; j++)
            {
                System.out.print("\t|\t" + b[i][j]);
            }
            System.out.println();
            System.out.print("--------");
            for(int j = 0; j < width; j++)
            {
                System.out.print("----------------");
            }
            System.out.println();
        }
    }

    public void dig(String[][] b, String[][] m, int r, int c)
    {
        if(b[r][c].equals(" "))
        {
            if(!m[r][c].equals("0"))
            {
                b[r][c] = m[r][c];
                return;
            }
            else if(m[r][c].equals("0") && r == 0 && c == 0)
            {
                b[r][c] = m[r][c];
                dig(b, m, r + 1, c);
                dig(b, m, r + 1, c + 1);
                dig(b, m, r, c + 1);
            }
            else if(m[r][c].equals("0") && r == 0 && c == width - 1)
            {
                b[r][c] = m[r][c];
                dig(b, m, r, c - 1);
                dig(b, m, r + 1, c - 1);
                dig(b, m, r + 1, c);
            }
            else if(m[r][c].equals("0") && r == height - 1 && c == 0)
            {
                b[r][c] = m[r][c];
                dig(b, m, r - 1, c);
                dig(b, m, r - 1, c + 1);
                dig(b, m, r, c + 1);
            }
            else if(m[r][c].equals("0") && r == height - 1 && c == width - 1)
            {
                b[r][c] = m[r][c];
                dig(b, m, r - 1, c);
                dig(b, m, r - 1, c - 1);
                dig(b, m, r, c - 1);
            }
            else if(m[r][c].equals("0") && r == 0)
            {
                b[r][c] = m[r][c];
                dig(b, m, r, c - 1);
                dig(b, m, r + 1, c - 1);
                dig(b, m, r + 1, c);
                dig(b, m, r + 1, c + 1);
                dig(b, m, r, c + 1);
            }
            else if(m[r][c].equals("0") && r == height - 1)
            {
                b[r][c] = m[r][c];
                dig(b, m, r, c - 1);
                dig(b, m, r - 1, c - 1);
                dig(b, m, r - 1, c);
                dig(b, m, r - 1, c + 1);
                dig(b, m, r, c + 1);
            }
            else if(m[r][c].equals("0") && c == 0)
            {
                b[r][c] = m[r][c];
                dig(b, m, r - 1, c);
                dig(b, m, r - 1, c + 1);
                dig(b, m, r, c + 1);
                dig(b, m, r + 1, c + 1);
                dig(b, m, r + 1, c);
            }
            else if(m[r][c].equals("0") && c == width - 1)
            {            
                b[r][c] = m[r][c];
                dig(b, m, r - 1, c);
                dig(b, m, r - 1, c - 1);
                dig(b, m, r, c - 1);
                dig(b, m, r + 1, c - 1);
                dig(b, m, r + 1, c);
            }
            else
            {
                b[r][c] = m[r][c];
                dig(b, m, r - 1, c - 1);
                dig(b, m, r - 1, c);
                dig(b, m, r - 1, c + 1);
                dig(b, m, r, c - 1);
                dig(b, m, r, c + 1);
                dig(b, m, r + 1, c - 1);
                dig(b, m, r + 1, c);
                dig(b, m, r + 1, c + 1);
            }
        }
        else
        {
            return;
        }
    }

    public int checkBoard(String[][] b)
    {
        int blanks = 0;
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                if(b[i][j].equals(" "))
                {
                    blanks++;
                }
            }
        }
        return blanks;
    }

}
