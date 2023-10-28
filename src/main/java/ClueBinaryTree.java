//class Node {
//    int data; // 节点数据
//    Node left, right; // 左右子节点
//    int leftType, rightType; // 左右指针类型：0表示指向子节点，1表示前驱或后继线索
//
//    public Node(int data) {
//        this.data = data;
//        this.leftType = 0;
//        this.rightType = 0;
//    }
//}
//
//class ThreadedBinaryTree {
//    private Node pre = null; // 前驱节点
//
//    // 中序线索化
//    public void inOrderThreadNodes(Node node) {
//        if (node == null) {
//            return;
//        }
//
//        // 线索化左子树
//        inOrderThreadNodes(node.left);
//
//        // 线索化当前节点：如果当前节点的左子节点为空，则将左指针指向前驱节点
//        if (node.left == null) {
//            node.left = pre;
//            node.leftType = 1;
//        }
//
//        // 线索化当前节点：如果前驱节点的右子节点为空，则将右指针指向当前节点
//        if (pre != null && pre.right == null) {
//            pre.right = node;
//            pre.rightType = 1;
//        }
//
//        // 每处理一个节点后，让当前节点是下一个节点的前驱
//        pre = node;
//
//        // 线索化右子树
//        inOrderThreadNodes(node.right);
//    }
//}
