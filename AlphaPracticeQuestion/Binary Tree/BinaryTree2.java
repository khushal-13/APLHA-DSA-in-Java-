import java.util.*;

public class BinaryTree2 {

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

    static class Info2{
        int hd ;
        Node node;

        public Info2(Node node, int hd)
        {
            this.node=node;
            this.hd=hd;
        }
    }

    static class Info{
        int dia;
        int ht ;

        Info(int diam, int hiet)
        {
            this.dia = diam;
            this.ht = hiet;
        }
    }

    public Info diameter(Node root)
    {
       if(root==null)
       {
        return new Info(0,0);
       }

      Info  leftInfo = diameter(root.left);
      Info  rightInfo = diameter(root.right);

      int selfDiameter = Math.max(Math.max(leftInfo.dia, rightInfo.dia), (leftInfo.ht+rightInfo.ht+1));
      int height = Math.max(leftInfo.ht,rightInfo.ht) +1;

      return new Info(selfDiameter, height);
    }

    public boolean isIdentical(Node node, Node subRoot)
    {
        if(node == null && subRoot == null)
        {
            return true;
        }
        else if( node==null || subRoot==null || node.data!=subRoot.data)
        {
            return false;
        }

        if(!isIdentical(node.left, subRoot.left))
        {
            return false;
        }
        if(!isIdentical(node.right, subRoot.right))
        {
            return false;
        }
         
        return true;
    }

    public boolean isSubtree(Node root,Node subRoot)
    {
        //Base
        if(root==null)
        {
            return false;
        }

        if(root.data == subRoot.data)
        {
       if(isIdentical(root,subRoot)) {
            return true;
        }
        }

        //Kaam
        return   isSubtree(root.left, subRoot) ||  isSubtree(root.right, subRoot);
    }

    public void TopView(Node root)
    {
        //LevelOrder
        Queue<Info2> q = new java.util.LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        int min=0,max=0;
        q.add(new Info2(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info2 curr = q.remove();
            if(curr == null){
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
                if(!map.containsKey(curr.hd)) // first time occurring
                {
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left!=null)
                {
                    q.add(new Info2(curr.node.left, curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null)
                {
                    q.add(new Info2(curr.node.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }
        }

        for(int i=min;i<=max;i++)
        {
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();


        
    }

    public static void main(String[] args) {
        
        BinaryTree2 b = new BinaryTree2();
        
        Node c = new Node(1);
        c.left = new Node(2);
        c.right = new Node(3);
        c.left.left = new Node(4);
       c.left.right = new Node(5);
      c.right.left = new Node(6);
       c.right.right = new Node(7);

     //  Node subRoot = new Node(2);
       //subRoot.left = new Node(4);
       //subRoot.right = new Node(5);

        //System.out.println(b.diameter(c).dia);

        //System.out.println(b.isSubtree(c, subRoot));

        b.TopView(c);
    }
}
