package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;
    int heightOfTree;
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.root = binarySearchTree.addNode(binarySearchTree.root,new Node(17));
        binarySearchTree.addNode(binarySearchTree.root,new Node(20));
        binarySearchTree.addNode(binarySearchTree.root,new Node(23));
        binarySearchTree.addNode(binarySearchTree.root,new Node(21));
        binarySearchTree.addNode(binarySearchTree.root,new Node(25));
        binarySearchTree.addNode(binarySearchTree.root,new Node(10));
        binarySearchTree.addNode(binarySearchTree.root,new Node(5));
        binarySearchTree.addNode(binarySearchTree.root,new Node(15));
        binarySearchTree.addNode(binarySearchTree.root,new Node(3));
        binarySearchTree.addNode(binarySearchTree.root,new Node(2));
        binarySearchTree.addNode(binarySearchTree.root,new Node(1));
        binarySearchTree.inOrderTraverse(binarySearchTree.root);
        //binarySearchTree.deleteNode(binarySearchTree.root, new Node(20));
        binarySearchTree.inOrderTraverse(binarySearchTree.root);
        System.out.println(binarySearchTree.heightOfTree(binarySearchTree.root));
        System.out.println(binarySearchTree.checkIFBST(binarySearchTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        binarySearchTree.bfs(binarySearchTree.root);
        binarySearchTree.printLeafNodes(binarySearchTree.root);
    }

    public Node addNode(Node root,Node n){
        if(root == null){
            root = n;
        }
        else{
            if(n.data<=root.data){
                root.left = addNode(root.left,n);
            }else{
                root.right = addNode(root.right,n);
            }
        }
        return root;
    }

    public void inOrderTraverse(Node root){
        if(root==null){
            return;
        }else{
            inOrderTraverse(root.left);
            System.out.println(root.data);
            inOrderTraverse(root.right);
        }
    }

    public Node deleteNode(Node root, Node n){
        if(root!=null){
            if(root.data>n.data){
                root.left = deleteNode(root.left,n);
            }
            else if(root.data<n.data){
                root.right = deleteNode(root.right,n);
            }else{
                if(root.left==null){
                    return root.right;
                }else if(root.right == null){
                    return root.left;
                }else{
                    Node minNode = minNode(root.right);
                    root.data = minNode.data;
                    root.right = deleteNode(root.right,minNode);
                }
            }
        }
        return root;
    }

    public Node minNode(Node root){
        Node minNode = new Node(root.data);
        while(root.left!=null){
            minNode.data = root.data;
            root = root.left;
        }
        return minNode;
    }

    public int heightOfTree(Node root){
        int l =0;
        int r= 0;
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right==null){
            return 0;
        }
        else{
           l = 1+heightOfTree(root.left);
           r= 1+heightOfTree(root.right);
           if(l<=r){
               return r;
           }else{
               return l;
           }
        }
    }

    public boolean checkIFBST(Node root, int min, int max){
        if(root == null){
            return true;
        }
        else{
            if(root.data<min || root.data>max){
                return false;
            }
            boolean l = checkIFBST(root.left, min, root.data);
            boolean r = checkIFBST(root.right, root.data, max);
            return l && r;
        }
    }

    public void bfs(Node root){
        if(root == null){
            return;
        }else{
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node n = q.remove();
                System.out.println(n.data);
                if(n.left!=null){
                    q.add(n.left);
                }
                if(n.right!=null){
                    q.add(n.right);
                }
            }
        }
    }

    public void printLeafNodes(Node root){
        if(root==null){
            return;
        }
        else{
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node n = q.remove();
                if(n.left==null && n.right == null){
                    System.out.println(n.data);
                }
                if(n.left!=null){
                    q.add(n.left);
                }
                if(n.right!= null){
                    q.add(n.right);
                }
            }
        }
    }
}
