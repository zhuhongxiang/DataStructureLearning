package BasicLearning;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeExample extends JApplet {
    private JTree sample;

    @Override
    public void init(){
        DefaultMutableTreeNode root;
        DefaultMutableTreeNode child;

        final String ROOT_QUESTION = "你是一只哺乳动物吗？";
        final String LEFT_QUESTION = "你比一只猫大吗？";
        final String RIGHT_QUESTION = "你生活在水下吗？";
        final String ANIMAL1 = "袋鼠";
        final String ANIMAL2 = "老鼠";
        final String ANIMAL3 = "鲤鱼";
        final String ANIMAL4 = "黄鹂";

        root = new DefaultMutableTreeNode(ROOT_QUESTION);

        child = new DefaultMutableTreeNode(LEFT_QUESTION);
        child.insert(new DefaultMutableTreeNode(ANIMAL1),0);
        child.insert(new DefaultMutableTreeNode(ANIMAL2),1);
        root.insert(child,0);

        child = new DefaultMutableTreeNode(RIGHT_QUESTION);
        child.insert(new DefaultMutableTreeNode(ANIMAL3),0);
        child.insert(new DefaultMutableTreeNode(ANIMAL4),1);
        root.insert(child,1);

        sample = new JTree(root);
        sample.setShowsRootHandles(true);
        getContentPane().add(sample);
    }
}
