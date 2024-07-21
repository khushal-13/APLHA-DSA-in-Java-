public class nQueens
{
    static int count = 0;

    public static boolean isSafe(char board[][],  int row, int col)
    {
        //Vertical
        for(int i=row-1;i>=0;i--)
        {
            if(board[i][col]=='Q')
            {
                return false;
            }
        }

        //DiagonalRight
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }

        //DiagonalLeft
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }

        return true;
    }

    public static void nQueen(char board[][],int row)
    {
       
  
        //base
        if(row==board.length)
        {
           printBoard(board);
           //count++;
           System.out.println();
            return;
        }


        //kaam  Column 
        for(int j=0;j<board.length;j++)
        {
           if(isSafe(board,row,j))
           {
            board[row][j]='Q';
            nQueen(board, row+1);
            board[row][j]='x';
        }
    }
      
    }



    public static void printBoard(char board[][])
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n=4;
        char board[][] = new char[n][n];
       
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                board[i][j]='x';
            }
        }

        nQueen(board,0);
        //System.out.println(count);

    }

}