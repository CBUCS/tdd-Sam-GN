package Classes;

public class BinaryTreeNode<T> {
    //node class for binary tree. it stores an item and has the attribute to point to the next two nodes
    private T item;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T pItem){
        this.item = pItem;
        this.left = null;
        this.right = null;
    }

    public void setItem(T item) {
        this.item = item;
    }
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getItem() {
        return this.item;
    }

    public BinaryTreeNode<T> getLeft() {
        return this.left;
    }

    public BinaryTreeNode<T> getRight() {
        return this.right;
    }
}

