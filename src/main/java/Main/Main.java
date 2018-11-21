package Main;
import Classes.BFSVisitor;
import Classes.DFSVisitor;
import Classes.Visitor;
import Classes.mBinaryTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String... args){
        mBinaryTree<Integer>  tree = new mBinaryTree<Integer>();
        tree.add(4);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(2);
        tree.add(5);

        Visitor BFS = new BFSVisitor();
        Visitor DFS = new DFSVisitor();

        tree.accept(BFS);
        tree.accept(DFS);
    }

}



