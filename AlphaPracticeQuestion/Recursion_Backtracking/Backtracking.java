public class Backtracking {

    public static boolean isSafeSuduko(int arr[][], int row, int col, int digits){
        //column
        for(int i=0;i<=8;i++){
            if(arr[i][col]==digits){
                return false;
            }
        }

        //Row
        for(int i=0;i<=8;i++){
            if(arr[row][i]==digits){
                return false;
            }
        }

        //3*3
        int sr=(row/3)*3;
        int sc=(row/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(arr[sr][sc]==digits){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokoSolver(int arr[][], int row, int col){
        //base case
        if(row==9){
            return true;
        }

        int nextRow=row, nextCol=col+1;
        if(col+1==9){
            nextRow = row+1;
            col=0;            
        }

        if(arr[row][col]!=0){
            return sudokoSolver(arr, nextRow, nextCol);
        }

        for(int digits=1;digits<=9;digits++){
            if(isSafeSuduko(arr, row, col, digits)){
                arr[row][col] = digits;
                if(sudokoSolver(arr, nextRow, nextCol)){
                    return true;
                }    
                arr[row][col] = 0;               
            }
        }
        return false;
    }

    public static int factorial(int n){
        int fact=1;
        for(int i=n;i>=1;i--){
            fact = fact*i;
        }
        return fact;
    }

    public static int GridWaysTrick(int i, int j, int n, int m){
        int numerator = factorial(n-1+m-1);
        int denominator = factorial(n-1)*factorial(m-1);
        return numerator/denominator;

    }

    public static int GridWays(int i,int j,int n, int m)
    {
        //base
        if(i==n-1 && j==m-1)
        {
            return 1; 
        }
        else if(i == n || j == m)
        {
            return 0;
        }

        //Kaam
       int w1 =  GridWays(i, j+1, n, m); //Right
       int w2 =  GridWays(i+1, j, n, m); //Down
        return w1 + w2;

    }

    public static boolean isSafe(char b[][],int row, int col)
    {
        //verticalUp
        for(int i=row-1;i>=0;i--)
        {
            if(b[i][col]=='Q')
            {
                return false;
            }
        }
        
        //DiagonalRight
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
        {
            if(b[i][j]=='Q')
            {
                return false;
            }
        }

        //DiagonalLeft
    for(int i=row-1,j=col+1;i>=0 && j<=b.length;i--,j++)
    {
    if(b[i][j]=='Q')
    {
        return false;
    }
    }
    
    return true;
    }

    public static void nQueens(char b[][],int row)
    {
       //base
       if(row==2)
       {
        printb(b);
        return;
       }

       for(int j=0;j<2;j++)
       {
        if(isSafe(b,row,j))
        {
        b[row][j]='Q';
        nQueens(b,row+1);  //function call
        b[row][j] = 'x';   //backtrack
        }

       }

    }

    public static void printb(char b[][])
    {
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
    }

    public static void Permutation(String str, String ans)
    {
        //base
        if(str.length()==0)
        {
            //System.out.println(ans);
            return;
        }

        //kaam
        System.out.println(str.length());
        for(int i=0;i<str.length();i++)
        {
           char curr = str.charAt(i);
           String newStr = str.substring(0, i) + str.substring(i+1);
           Permutation(newStr, ans+curr);
        }

    }
   
    public static void Subsets(String str,String ans ,int i)
    {
        //base
        if(i==str.length())
        {
            if(ans.length()==0)
            {
                System.out.println("NULL");
            }
            else
            {
                System.out.println(ans);
            }
            return;
        }

      //Yes
       Subsets(str, ans+str.charAt(i), i+1);
      //No
      Subsets(str, ans, i+1);

    }

    public static void changeArr(int a[],int i,int v)
    {
        //base
        if(i==a.length)
        {
            printarr(a);
            return ;
        }

        a[i]=v;//Kaam
        changeArr(a, i+1, v+1);//Recursion call
        a[i] = a[i]-2;

    }
    
    public static void printarr(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String[] args) {
       /* 
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        System.out.println();
       printarr(arr);
    */
   //String a = "abcd";
   //Subsets(a, "",0);

   //Permutation(a,"");

  int n=4;
  char b[][] = new char[n][n];
  for(int i=0;i<2;i++)
  {
    for(int j=0;j<2;j++)
    {
        b[i][j] = '.';
    }
  }

  //nQueens(b,0);

//   System.out.println(GridWays(0, 0, 3, 2));
//   System.out.println(GridWaysTrick(0, 0, 3, 2));
     



    }
}
