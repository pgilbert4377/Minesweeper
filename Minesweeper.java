import java.util.*;
public class Minesweeper
{
    Scanner kb = new Scanner(System.in);
    int height = 0;
    int width = 0;
    String validation = "";
    boolean isValid = false;
    

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
        int mines = (int)(Math.sqrt(height*width));

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
                        if(b[0][j-1].equals("(BOOM!"))
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
                        if(b[i+1][j+1].equals("BOOM!"))
                        {
                            number++;
                        }
                    }
                    b[i][j] = "" + number;
                }
            }
        }

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }

        return b;
    }

    public void playGame(String[][] master)
    {
        boolean gameFinished = false;
        String[][] board = new String[height][width];
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                board[i][j] = "\t";
            }
        }

        System.out.println("Welcome");

        while(!gameFinished)
        {
            
        }
    }

}
