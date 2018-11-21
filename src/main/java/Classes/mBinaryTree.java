package Classes;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class mBinaryTree<T> implements TreeInterface<T> {
    //Technically this is a binary search tree. But still a binary search tree is kind of a binary tree.
    private BinaryTreeNode<T> root;



    //to add new items to the tree
    @Override
    public boolean add(T pItem) {
        this.root = insertion(this.root,pItem);
        return true;
    }
    //removes item from the tree if available
    @Override
    public boolean remove(T pItem) {
        if(contains(pItem)) {
            deleteNode(this.root, pItem);
            return true;
        }
        else
            return false;
    }

    //searches the tree for specific item
    @Override
    public boolean contains(T pItem) {
        return searchTree(this.root,pItem);
    }

    //returns the number of items in the tree
    @Override
    public int numItems() {
        return count(this.root);
    }
    //returns the height of the tree
    @Override
    public int height() {
        return calculateHeight(this.root);
    }
    //prints all the items in the tree
    @Override
    public void print() {
        System.out.print("Model : Root(Left Leaf,Right Leaf)"+"\n");
        System.out.println(whatToPrint(this.root));
    }

    //when adding new items this method is called to decide where to add the new item
    private BinaryTreeNode<T> insertion (BinaryTreeNode<T> pCurrent, T pItem){
        //when node is empty
        if(pCurrent==null)
            return new BinaryTreeNode<T>(pItem);
            //decides where to put the value based on node's current value
        else if((Integer)pCurrent.getItem()>(Integer) pItem)
            pCurrent.setLeft(insertion(pCurrent.getLeft(),pItem));
        else if ((Integer)pCurrent.getItem()<(Integer) pItem)
            pCurrent.setRight(insertion(pCurrent.getRight(),pItem));
        return pCurrent;
    }

    //when removing item from tree, this method is called to decide if tree needs to be rearranged
    private BinaryTreeNode<T> deleteNode (BinaryTreeNode<T> pCurrent, T pItem){
        //when node is empty
        if(pCurrent==null)
            return null;
        //item to be deleted is found
        if(pCurrent.getItem()==pItem){
            //if there are no children for this node
            if(pCurrent.getLeft()==null&&pCurrent.getRight()==null)
                return null;
            //if only left has a child
            if(pCurrent.getRight()==null)
                return pCurrent.getLeft();
            //if only right has a child
            if(pCurrent.getLeft()==null)
                return pCurrent.getRight();
            //when both sides has a child, finds the smallest item from its right side to replace it with
            T smallestItem = findSmallestItem(pCurrent.getRight());
            pCurrent.setItem(smallestItem);
            pCurrent.setRight(deleteNode(pCurrent.getRight(),smallestItem));
            return pCurrent;
            //continue looking for the item based on current node's value
        } else if((Integer)pCurrent.getItem()>(Integer)pItem)
            pCurrent.setLeft(deleteNode(pCurrent.getLeft(),pItem));
        else if ((Integer)pCurrent.getItem() < (Integer)pItem)
            pCurrent.setRight(deleteNode(pCurrent.getRight(),pItem));
        return pCurrent;
    }

    //finds smallest value from any given node
    private T findSmallestItem (BinaryTreeNode<T> pNode){
        if(pNode.getLeft()==null)
            return pNode.getItem();
        else
            return findSmallestItem(pNode.getLeft());
    }

    //searches the tree for item
    private boolean searchTree (BinaryTreeNode<T> pCurrent, T pItem){
        if(pCurrent==null)
            return false;
        else if(pCurrent.getItem()==pItem)
            return true;
        else{
            if((Integer)pCurrent.getItem()>(Integer) pItem)
                return searchTree(pCurrent.getLeft(),pItem);
            else
                return searchTree(pCurrent.getRight(),pItem);
        }
    }
    //counts the number of nodes
    private int count (BinaryTreeNode<T> pCurrent) {
        if(pCurrent==null)
            return 0;
        else{
            int count = 1;
            count += count(pCurrent.getLeft());
            count += count(pCurrent.getRight());
            return count;
        }
    }
    //calculates the height of the tree
    private int calculateHeight(BinaryTreeNode<T> pCurrent){
        if(pCurrent==null)
            return 0;
        else{
            int left = calculateHeight(pCurrent.getLeft());
            int right = calculateHeight(pCurrent.getRight());
            return Math.max(left, right) + 1;

        }
    }
    //algorithm to print tree in meaningful order
    private String whatToPrint(BinaryTreeNode<T> pCurrent){
        if(pCurrent==null)
            return "Null";
        else{
            return String.valueOf(pCurrent.getItem())+"("+whatToPrint(pCurrent.getLeft())+","+whatToPrint(pCurrent.getRight())+")";
        }
    }

    //implementing BFS
    public void BFS() {
        //uses a queue to know which item to print
        System.out.print("BFS: ");
        Queue<BinaryTreeNode<T>> queue= new ConcurrentLinkedQueue<BinaryTreeNode<T>>();
        queue.add(root);
        while (queue.size()>0)
        {

            BinaryTreeNode<T> tempNode = queue.poll();
            System.out.print(tempNode.getItem() + " ");

            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }


        }
        System.out.println("");

    }

    // implementing a DFS
    public  void DFS(){
        //uses a stack to know which item to print.
        if(root == null)
            return;
        System.out.print("DFS: ");
        Stack<BinaryTreeNode<T>> res = new Stack<BinaryTreeNode<T>>();
        res.add(root);
        while(res.size()>0){
            BinaryTreeNode<T> top = res.pop();
            System.out.print(top.getItem() + " ");
            if(top.getLeft()!=null)
                res.add(top.getLeft());
            if(top.getRight()!=null)
                res.add(top.getRight());

        }
        System.out.println("");

    }

    public boolean accept(Visitor v){
        v.visit(this.root);
        return true;
    }

    public BinaryTreeNode<T> getRoot(){
        return this.root;
    }
}