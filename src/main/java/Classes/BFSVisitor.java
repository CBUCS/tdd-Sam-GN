package Classes;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BFSVisitor implements Visitor {
    @Override
    public boolean visit(BinaryTreeNode pRoot) {
        //uses a queue to know which item to print
        System.out.print("BFS: ");
        Queue<BinaryTreeNode> queue= new ConcurrentLinkedQueue<BinaryTreeNode>();
        queue.add(pRoot);
        while (queue.size()>0)
        {

            BinaryTreeNode tempNode = queue.poll();
            System.out.print(tempNode.getItem() + " ");

            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }


        }

        return true;
    }
}
