package binarytree;

import java.util.Objects;

public class BinaryIntTree extends ABinaryIntTree {

    private BinaryIntTreeNode rootNode;
    private int size;

    public BinaryIntTree() {
        this.rootNode = null;
        this.size = 0;
    }

    @Override
    public ABinaryIntTreeNode root() {
        return this.rootNode;
    }

    @Override
    public void add(int value) {
        if (isEmpty()) {
            rootNode = new BinaryIntTreeNode(value);
            size++;
        } else {
            if (rootNode.add(value)) {
                size++;
            }
        }
    }

    @Override
    public void remove(int value) {
        if (isEmpty()) return;

        final BinaryIntTreeNode removedNode = this.rootNode.remove(null, value);
        if (removedNode != null) {
            size--;
        }
    }

    @Override
    public boolean contains(int value) {
        return this.rootNode != null && this.rootNode.contains(value);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class BinaryIntTreeNode extends ABinaryIntTreeNode {

        private final int value;
        private ABinaryIntTreeNode left;
        private ABinaryIntTreeNode right;

        BinaryIntTreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public int value() {
            return this.value;
        }

        @Override
        public ABinaryIntTreeNode left() {
            return this.left;
        }

        @Override
        public ABinaryIntTreeNode right() {
            return this.right;
        }

        private boolean add(int value) {
            if (value < value()) {
                final BinaryIntTreeNode left = (BinaryIntTreeNode) left();
                if (left == null) {
                    this.left = new BinaryIntTreeNode(value);
                    return true;
                } else {
                    return left.add(value);
                }
            } else if (value > value()) {
                final BinaryIntTreeNode right = (BinaryIntTreeNode) right();
                if (right == null) {
                    this.right = new BinaryIntTreeNode(value);
                    return true;
                } else {
                    return right.add(value);
                }
            } else {
                // value already exists in this tree
                return false;
            }
        }

        private boolean contains(int value) {
            if (value < value()) {
                final BinaryIntTreeNode left = (BinaryIntTreeNode) left();
                return left != null && left.contains(value);
            } else if (value > value()) {
                final BinaryIntTreeNode right = (BinaryIntTreeNode) right();
                return right != null && right.contains(value);
            } else {
                return true;
            }
        }

        private BinaryIntTreeNode remove(BinaryIntTreeNode parent, int value) {
            if (value < value()) {
                final BinaryIntTreeNode left = (BinaryIntTreeNode) left();
                if (left == null) {
                    return null;
                } else {
                    return left.remove(this, value);
                }
            }

            if (value > value()) {
                final BinaryIntTreeNode right = (BinaryIntTreeNode) right();
                if (right == null) {
                    return null;
                } else {
                    return right.remove(this, value);
                }
            }

            final boolean hasLeft = left() != null;
            final boolean hasRight = right() != null;

            BinaryIntTreeNode result = null;

            if (hasLeft && hasRight) {
                final BinaryIntTreeNode right = (BinaryIntTreeNode) right();
                result = right.remove(this, findMinimumValue(right));
                Objects.requireNonNull(result);
                result.left = left();
                result.right = right();
            } else if (hasLeft) {
                result = (BinaryIntTreeNode) left();
            } else if (hasRight) {
                result = (BinaryIntTreeNode) right();
            }

            if (parent != null) {
                if (parent.left == this) {
                    parent.left = result;
                } else if (parent.right == this) {
                    parent.right = result;
                }
            } else {
                rootNode = result;
            }

            return this;
        }

        private int findMinimumValue(BinaryIntTreeNode node) {
            Objects.requireNonNull(node);

            BinaryIntTreeNode left = (BinaryIntTreeNode) node.left();
            if (left != null) {
                return findMinimumValue(left);
            } else {
                return node.value();
            }
        }

    }

}
