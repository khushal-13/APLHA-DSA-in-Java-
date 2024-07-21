import java.util.*;

public class BinarySearchTree2 {
    static class Node{
        int data;
        Node left,right;
        public Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public Node SorrtedArrayToBalanced(int arr[],int start, int end)
    {
       if(start>end)
       {
        return null;
       }

       int mid=(start+end)/2;
       Node root = new Node(arr[mid]);
       root.left = SorrtedArrayToBalanced(arr, start, mid-1);
       root.right = SorrtedArrayToBalanced(arr, mid+1, end);

       return root;      
    }

    public void preorder(Node root)
    {
        if(root==null)
        {
            return;
        }  
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void getinorder(Node root,ArrayList<Integer> inorder)
    {  
        if(root==null)
        {
            return;
        }

        getinorder(root.left,inorder);
        inorder.add(root.data);
        getinorder(root.right, inorder);

    }

    public static Node createBST(ArrayList<Integer> inorder, int start, int end)
    {
        if(start>end)
        {
            return null;
        }

        int mid=(start+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, start, mid-1);
        root.right = createBST(inorder, mid+1, end);

        return root;
    }

    public static Node balanceTree(Node root)
    {
         ArrayList<Integer> inorder = new ArrayList<>();
         getinorder(root,inorder);

        
       root = createBST(inorder,0,inorder.size()-1);
       return root;
    }

     static class Info
    {
        int max;
        int min;
        int size;
        boolean isBST ;

            public Info(boolean isBST,int size,int min,int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;
    public Info largestBST(Node root)
    {
        if(root== null)
        {
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size +1;
        int min = Math.min(root.data,Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data,Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min)
        {
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST)
        {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
         return new Info(false, size, min, max);
    }

    public void levelOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
       java.util.Queue<Node> q = new  java.util.LinkedList<>();

       q.add(root);
       q.add(null);

       while(!q.isEmpty())
       {
        Node curr = q.remove();
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

    public static void inorder(Node root,ArrayList<Integer> arr)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }

    public static Node BalancedBST(ArrayList<Integer> a,int st, int end)
    {
        if(st>end)
        {
           return null;
        }
       int mid = (st+end)/2;
       Node root = new Node(a.get(mid));
       root.left= BalancedBST(a, st, mid-1);
       root.right= BalancedBST(a, mid+1, end);
        
        return root;
    }

    public static Node Merge2BST(Node root1, Node root2)
    {
        //1 Inorder of BST1
        ArrayList<Integer> arr1 = new ArrayList<>();
        inorder(root1,arr1);

        //2 Inorder of BST2
        ArrayList<Integer> arr2 = new ArrayList<>();
        inorder(root2,arr2);

        //3 Merge BST1 and BST2
        int i=0,j=0;
        ArrayList<Integer> finalarr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size())
        {
            if(arr1.get(i)<=arr2.get(j))
            {
               finalarr.add(arr1.get(i));
               i++;
            }
            else
            {
                finalarr.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size())
        {
            finalarr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size())
        {
            finalarr.add(arr2.get(j));
                j++;
        }

        //Create BST
       return BalancedBST(finalarr,0,finalarr.size()-1);
     }
    

    public static void main(String[] args) {

        BinarySearchTree2 b = new BinarySearchTree2();
      //  int arr[]={3,5,6,8,10,11,12};
       // Node root = b.SorrtedArrayToBalanced(arr, 0, arr.length-1);


       /* 
       Node c = new Node(8);
       c.left = new Node(6);
       c.right = new Node(10);
       c.left.left = new Node(5);
       c.left.left.left = new Node(3);
       c.right.right = new Node(11);
       c.right.right.right = new Node(12);
       b.preorder(c);
       System.out.println();
       Node root = balanceTree(c);
       b.preorder(root);
       */

       /* 
       Node l = new Node(50);
       l.left = new Node(30);
       l.right = new Node(60);
       l.left.left = new Node(5);
       l.left.right = new Node(20); 
       l.right.left = new Node(45);
       l.right.right = new Node(70);
       l.right.right.left = new Node(65);
       l.right.right.right = new Node(80);
       b.preorder(l);
       System.out.println();

       b.largestBST(l);
       System.out.println("Largest BST size is : "+maxBST);

       */

       Node r1 = new Node(2);
       r1.left = new Node(1);
       r1.right = new Node(4);
       b.preorder(r1);
       System.out.println();

       Node r2 = new Node(9);
       r2.left = new Node(3);
       r2.right = new Node(12); 
       b.preorder(r2);
       System.out.println();


        Node root = Merge2BST(r1, r2);
        b.preorder(root);
        
    }
}
