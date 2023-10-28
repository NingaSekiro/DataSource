// 定义线索二叉树节点
class ThreadedNode {
    int data;
    ThreadedNode left, right;
    boolean isThreaded;

    public ThreadedNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.isThreaded = false;
    }
}

// 线索二叉树类
class ThreadedBinaryTree {
    public ThreadedNode root;

    public ThreadedBinaryTree() {
        this.root = null;
    }

    // 构建线索二叉树
    public void buildThreadedBinaryTree(ThreadedNode node) {
        if (node == null) {
            return;
        }

        // 递归构建左子树
        buildThreadedBinaryTree(node.left);

        // 处理当前节点
        if (node.left == null) {
            node.left = getPredecessor(node);
            node.isThreaded = true;
        }

        if (node.right == null && node.right != root) {
            node.right = getSuccessor(node);
        }

        // 递归构建右子树
        buildThreadedBinaryTree(node.right);
    }

    // 获取当前节点的前驱节点
    public ThreadedNode getPredecessor(ThreadedNode node) {
        if (node == null) {
            return null;
        }

        ThreadedNode predecessor = node.left;
        if (predecessor != null) {
            while (predecessor.right != null && !predecessor.isThreaded) {
                predecessor = predecessor.right;
            }
        }
        return predecessor;
    }

    // 获取当前节点的后继节点
    public ThreadedNode getSuccessor(ThreadedNode node) {
        if (node == null) {
            return null;
        }

        ThreadedNode successor = node.right;
        if (successor != null && !successor.isThreaded) {
            while (successor.left != null) {
                successor = successor.left;
            }
        }
        return successor;
    }

    // 中序遍历线索二叉树
    public void inorderTraversal() {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }

        ThreadedNode current = root;
        while (current.left != null) {
            current = current.left;
        }

        while (current != null) {
            System.out.print(current.data + " ");

            if (current.isThreaded) {
                current = current.right;
            } else {
                current = current.right;
                while (current != null && !current.isThreaded) {
                    current = current.left;
                }
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        ThreadedBinaryTree tree = new ThreadedBinaryTree();

        // 构建二叉树
        tree.root = new ThreadedNode(1);
        tree.root.left = new ThreadedNode(2);
        tree.root.right = new ThreadedNode(3);
        tree.root.left.left = new ThreadedNode(4);
        tree.root.left.right = new ThreadedNode(5);
        tree.root.right.left = new ThreadedNode(6);
        tree.root.right.right = new ThreadedNode(7);

        // 构建线索二叉树
        tree.buildThreadedBinaryTree(tree.root);

        // 中序遍历线索二叉树
        System.out.print("Inorder Traversal: ");
        tree.inorderTraversal();
        System.out.println(tree.getPredecessor(tree.root));
    }
}