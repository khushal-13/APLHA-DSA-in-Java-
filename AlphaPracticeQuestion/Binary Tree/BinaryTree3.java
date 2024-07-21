import java.util.*;

public class BinaryTree3 {
    static class Node{

        int data;
        Node left,right;

        public Node(int data)
        {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    public static void klevel(Node root, int level, int k)
    {
        if(root == null)
        {
            return;
        }

        if(level==k){
            System.out.print(root.data +" ");
            return;
        }
        klevel(root.left, level+1, k);
        klevel(root.right, level+1, k);

    }
    
    public static boolean getpath(Node root, int n,ArrayList<Node> path)
    {
        if(root==null)
        {
            return false;
        }

        path.add(root);

        if(root.data == n)
        {
            return true;
        }

        boolean foundLeft = getpath(root.left, n, path);
        boolean foundRight = getpath(root.right, n, path);

        if(foundLeft || foundRight)
        {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static Node lowestCommonAncestor(Node root,int n1 , int n2)
    {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getpath(root,n1,path1);
        getpath(root,n2,path2);

        //last common ancestor
        int i=0;
        for(;i<path1.size() && i<path2.size();i++)
        {    if(path1.get(i) != path2.get(i))
            {
                break;
            }
        }

        //last equal node is i-1
        Node lca = path1.get(i-1);
        return lca;
    }

    public static Node lowestCommonAncestor2(Node root ,int n1,int n2)
    {
        if(root == null)
        {
            return null;
        }

        if(root.data == n1 || root.data == n2)
        {
            return root;
        }

        Node leftLca = lowestCommonAncestor2(root.left, n1, n2);
        Node rightLca = lowestCommonAncestor2(root.right, n1, n2);

        if(leftLca == null)
        {
            return rightLca;
        }
        if(rightLca == null)
        {
            return leftLca;
        }
            return root;
        }

        public  static int lcaDist(Node root, int n)
        {
          if(root==null)
          {
            return -1;
          }

          if(root.data==n)
          {
            return 0;
          }

          int leftDist = lcaDist(root.left, n);
          int rightDist = lcaDist(root.right, n);

          if(leftDist == -1 && rightDist == -1)
          {
            return -1;
          }
          else if(leftDist == -1)
          {
             return rightDist+1;     
          }
          else
          {
            return leftDist+1;
          }

        }
        

    
        public static int minDistance(Node root,int n1, int n2)
        {
            Node lca = lowestCommonAncestor2(root, n1, n2);
            int dis1 = lcaDist(lca,n1);
            int dis2 = lcaDist(lca,n2);

            return dis1+dis2;
        }

        public static int Kancestor(Node root, int n,int k)
        {
            if(root==null)
            {
                return -1;
            }

            if(root.data == n){
              return 0;
            }

            int leftDist = Kancestor(root.left, n,k);
            int rightDist = Kancestor(root.right, n,k);

            if(leftDist== -1 && rightDist== -1)
            {
                return -1;
            }
            int max = Math.max(leftDist, rightDist);
            if(max+1==k){
                System.out.println(root.data);
            }
            return max+1;
        }

        public static int transform(Node root)
        {
            if(root==null)
            {
                return 0;
            }

            int leftChild = transform(root.left);
            int rightChild = transform(root.right);

            int data = root.data;

            int newLeft = root.left==null? 0 : root.left.data;
            int newRight = root.right==null? 0 : root.right.data;
            root.data = leftChild + newLeft + rightChild + newRight;

            return data;
        }

        public static void preorder(Node root)
        {
            if(root==null)
            {
                return;
            }

            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);

        }

        public static void levelOrder(Node root)
        {
            if(root==null)
            {
                return;
            }

            java.util.Queue<Node> q = new java.util.LinkedList<>();

            q.add(root);
            q.add(null);

            while(!q.isEmpty())
            {
                Node curr=q.remove();

                if(curr==null)
                {
                    System.out.println();
                    if(q.isEmpty())
                    {
                        break;
                    }
                    else
                    {
                        q.add(null);
                    }
                }
                else
                {
                    System.out.print(curr.data+" ");
                    if(curr.left!=null)
                    {
                        q.add(curr.left);
                    }
                    if(curr.right!=null)
                    {
                        q.add(curr.right);
                    }
                }
            }


        }
         

    public static void main(String[] args) {
        
        Node c = new Node(1);
        c.left = new Node(2);
        c.right = new Node(3);
        c.left.left = new Node(4);
        c.left.right = new Node(5);
        c.right.left = new Node(6);
        c.right.right = new Node(7);
 
       // klevel(c,1,3);

      // System.out.println(lowestCommonAncestor(c, 4, 2).data);

      //System.out.println(lowestCommonAncestor2(c, 4, 5).data);
       
      //System.out.println(minDistance(c, 4, 1));
      

     //Kancestor(c, 5, 1);

     //levelOrder(c);
    // preorder(c);
    // System.out.println();
    // transform(c);
    // System.out.println();
    // preorder(c);
   // levelOrder(c);

    }
}
