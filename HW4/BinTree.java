public class BinTree {
    Node root;

    public boolean add(int value) {
        if (root == null) {
            root = new Node();
            root.color = Color.black;
            root.value = value;
            return true;

        } else {
            boolean res = addNode(root, value);
            root = rebalnce(root);
            root.color = Color.black;
            return res;
        }

    }

    private boolean addNode(Node node, int value) {
        if (node.value == value)
            return false;

        if (node.value > value) {
            if (node.left == null) {
                node.left = new Node();
                node.left.color = Color.red;
                node.left.value = value;
                return true;

            } else {
                boolean res = addNode(node.left, value);
                node.left = rebalnce(node.left);
                return res;
            }

        } else {
            if (node.right == null) {
                node.right = new Node();
                node.right.value = value;
                node.right.color = Color.red;
                return true;

            } else {
                boolean res = addNode(node.right, value);
                node.right = rebalnce(node.right);
                return res;
            }
        }
    }

    private Node rebalnce(Node node) {
        Node res = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (res.right != null && res.right.color == Color.red &&
                    (res.left == null || res.left.color == Color.black)) {
                needRebalance = true;
                res = rightSwap(res);
            }

            if (res.left != null && res.left.color == Color.red &&
                    res.left.left != null && res.left.left.color == Color.red) {
                needRebalance = true;
                res = leftSwap(res);
            }

            if (res.left != null && res.left.color == Color.red &&
                    res.right != null && res.right.color == Color.red) {
                needRebalance = true;
                colorSwap(res);
            }
        } while (needRebalance);

        return res;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.right;
        Node betweenChild = rightChild.left;
        rightChild.left = node;
        node.right = betweenChild;
        rightChild.color = node.color;
        node.color = Color.red;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.left;
        Node betweenChild = leftChild.right;
        leftChild.right = node;
        node.left = betweenChild;
        leftChild.color = node.color;
        node.color = Color.red;
        return leftChild;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.black;
        node.left.color = Color.black;
        node.color = Color.red;
    }

    public boolean contain(int value) {
        Node currentNode = root;

        while (currentNode != null) {
            if (currentNode.value == value)
                return true;

            if (currentNode.value > value)
                currentNode = currentNode.left;

            else
                currentNode = currentNode.right;
        }
        return false;
    }

    private class Node {
        int value;
        Node left;
        Node right;
        Color color;

        Node() {
            this.color = Color.red;
        }

    }

    enum Color {
        red, black
    }
}
