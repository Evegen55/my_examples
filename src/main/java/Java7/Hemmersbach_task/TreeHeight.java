package Java7.Hemmersbach_task;

class TreeNode {
    private TreeNode leftChild, rightChild;

    public TreeNode(TreeNode leftChild, TreeNode rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public TreeNode getLeftChild() {
        return this.leftChild;
    }

    public TreeNode getRightChild() {
        return this.rightChild;
    }
}

public class TreeHeight {
    public static int height=0;
    public static int calculateHeight(TreeNode root) {

        if (root == null) {
            return 0;
        } else {
            if(root.getLeftChild()!=null||root.getRightChild()!=null){
                height++;
                calculateHeight(root.getLeftChild());
                calculateHeight(root.getRightChild());
            }
            return height;
        }
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        TreeNode leaf1 = new TreeNode(null, null);
        TreeNode leaf2 = new TreeNode(null, null);
        TreeNode node = new TreeNode(leaf1, null);
        TreeNode root = new TreeNode(node, leaf2);

        System.out.println(TreeHeight.calculateHeight(root));
    }
}
