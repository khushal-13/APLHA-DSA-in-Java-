
public class BinaryTree {
    
    static class Node{
        int data;
        Node left;
        Node right;

       public  Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }



      static class BinaryT {
      static int idx=-1;
    public Node Preorder(int nodes[])
    {
        idx++;
       if(nodes[idx]==-1)
       {
        return null;
       }

       Node newNode = new Node(nodes[idx]);
       newNode.left = Preorder(nodes);
       newNode.right = Preorder(nodes); 
       
       return newNode;
    }

    public  void PreorderTraversal(Node root)
    {
        if(root==null)
        {
           return ;  
        }
     System.out.print(root.data+" ");
     PreorderTraversal(root.left);
     PreorderTraversal(root.right);
    }


    public void Inorder(Node root)
    {
        if(root==null)
        {
            return;
        }

        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }

    public void postorder(Node root)
    {
        if(root==null)
        {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    //LevelOrder
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

    public  int height (Node root) {
        //Base
        if(root==null)
        {
            return 0;
        }
        //Kaam

        int lh = height(root.left);
        int rh = height(root.right);

        int ht = Math.max(lh, rh)+1;
        
        return ht;
    }

    public int sum(Node root)
    {
        //Base
        if(root==null)
        {
            return 0;
        }

        //Kaam
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return leftSum+rightSum+root.data;

    }

    public int diameter(Node root)
    {
        if(root==null)
        {
            return 0;
        }

        int leftDiameter = diameter(root.left);
        int leftHeight = height(root.left);
        
        int rightDiameter = diameter(root.right);
        int rightHeight = height(root.right);

        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(Math.max(leftDiameter, rightDiameter), selfDiameter);

    }


    }

        public static void main(String[] args) {

        //int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryT b = new BinaryT();
        //Node root = b.Preorder(nodes);
       // System.out.println(root.data);
       //b.PreorderTraversal(root);
       // b.Inorder(root);
       //b.postorder(root);
        // b.levelOrder(root);

         
        Node c = new Node(1);
        c.left = new Node(2);
        c.right = new Node(3);
        c.left.left = new Node(4);
       c.left.right = new Node(5);
      c.right.left = new Node(6);
       c.right.right = new Node(7);
       c.left.left.left = new Node(8);
       c.left.left.right = new Node(9);

        //System.out.println(b.height(c));

        
       
       // System.out.println(b.sum(c));
      
       System.out.println(b.diameter(c));

         

        
    }
}
