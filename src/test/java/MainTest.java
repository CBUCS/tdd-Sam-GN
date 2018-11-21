import Classes.mBinaryTree;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class MainTest {


    mBinaryTree tree;



    @Test
    public void treeNotNull(){
        tree = new mBinaryTree<Integer>();
        Assertions.assertNotNull(tree);
    }
}




























