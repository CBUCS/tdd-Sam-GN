import Classes.BFSVisitor;
import Classes.DFSVisitor;
import Classes.Visitor;
import Classes.mBinaryTree;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MainTest {


    mBinaryTree tree;
    Visitor v;



    @Test
    public void accept(){
        tree = new mBinaryTree<Integer>();
        v = new DFSVisitor();
        Assertions.assertTrue(tree.accept(v));
    }

    @Test
    public void BFS(){
        tree = new mBinaryTree<Integer>();
        tree.add(1);
        v = new BFSVisitor();
        Assertions.assertTrue(v.visit(tree.getRoot()));
    }
    @Test
    public void DFS(){
        tree = new mBinaryTree<Integer>();
        tree.add(1);
        v = new DFSVisitor();
        Assertions.assertTrue(v.visit(tree.getRoot()));
    }
}




























