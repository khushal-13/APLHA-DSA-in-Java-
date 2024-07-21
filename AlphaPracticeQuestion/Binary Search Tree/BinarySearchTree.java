import java.util.ArrayList;

public class BinarySearchTree {
    
    static class Node{
        int data;
        Node left,right;

        public Node(int data)
        {
            this.data=data;
        }
    }

    public Node Insert(Node root,int val)
    {
        if(root==null)
        {
           root = new Node(val);
           return root;
        }

        //left subtree
        if(root.data > val)
        {
            root.left = Insert(root.left, val);
        }
        else //right subtree
        {
            root.right = Insert(root.right, val);
        }

        return root; 
    }

    public static void Inorder(Node root)
    {
        if(root == null)
        {
            return ;
        }

        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);

    }

    public static boolean search(Node root, int key)
    {
        if(root == null)
        {
            return false;

        }

        if(root.data == key)
        {
            return true;
        }

        if(root.data > key)
        {
            return  search(root.left, key);
        }
        else
        {
            return search(root.right, key);
        }

    }

    public static Node delete(Node root,int val)
    {
        if(root == null)
        {
            System.out.println("Element not found");
            return null;
        }

        if(root.data < val)
        {
           root.right = delete(root.right, val);
        }
        else if(root.data > val)
        {
           root.left =  delete(root.left, val);
        }
        else // found the element
        {
            //case 1 : leaf node
            if(root.left==null && root.right==null)
            {
                return null;
            } 
            
            //case 2 : 1 child
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }

            //case 3 : 2 child
            else
            {
                Node IS = findinorder(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data); 

            }
        }
              return root;
    }

    public static Node findinorder(Node root)
    {
       while(root.left!=null)
       {
        root = root.left;
       }

       return root;
    }

    public  void printInRange(Node root, int k1, int k2) {
        //base
        if(root==null)
        {
            return;
        }

        if(k1 <= root.data && root.data <= k2)
        {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
           // print(root.left, k1, k2);
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1)
        {
            System.out.println(root.data);
            printInRange(root.left, k1, k2);
        }
        else
        {
            System.out.println(root.data);
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path)
    {
        for(int i=0;i<path.size();i++)
        {
            System.out.print(path.get(i)+" ");
        }
        System.out.println("null");
    }

    public void printRoot2Leaf(Node root,ArrayList<Integer> path)
    {
        if(root==null)
        {
            return;
        }

        
        path.add(root.data);

        if(root.left==null && root.right==null)
        {
            printPath(path);
        } 

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
        
    }

    public static boolean IsValid(Node root, Node min, Node max)
    {
        if(root==null)
        {
            return true;
        }

        if(min!=null && root.data <= min.data)
        {
            return false;
        }
        else if(max!=null && root.data >= max.data)
        {
            return false;
        }

        return IsValid(root.left, min, root) && IsValid(root.right, root, max);
          
    }

    public Node mirror(Node root)
    {
        if(root==null)
        {
            return null;
        }

        Node leftMirror = mirror(root.left);
        Node rightMirror = mirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;

    }

    public void Preorder(Node root)
    {
        if(root == null)
        {
            return ;
        }

        System.out.print(root.data +" ");
        Preorder(root.left);
        Preorder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        int values[]={8,5,3,1,4,6,10,11,14,9,13,15};
        Node root = null;

        for(int i=0;i<values.length;i++)
        {
            root = b.Insert(root,values[i]);            
        }

        /*
        Inorder(root);
        System.out.println();

        if(search(root,6))
        {
            System.out.println("Found");
        }
        else{
            System.out.println("Not Found");
        }

         */

         //Inorder(root);
         //System.out.println();
         //delete(root, 99);
        // Inorder(root);
         

         //b.printInRange(root, 5, 12);


       // ArrayList<Integer> path = new ArrayList<>();
        //b.printRoot2Leaf(root, path);


        /* 
        if(IsValid(root, null, null))
        {
            System.out.println("Valid");
        }
        else
        {
            System.out.println("Not Valid");
        }
        */

        //Node rootM = b.mirror(root);
        //b.Preorder(rootM);

    }
}
