package binarytree;

import java.util.*;

public class BinaryTree<T> extends ABinaryTree<T> {

    private BinaryTreeNode rootNode;
    private int size;

    public BinaryTree(final Comparator<T> comparator) {
        super(comparator);
        this.rootNode = null;
        this.size = 0;
    }

    @Override
    public ABinaryTreeNode<T> root() {
        return this.rootNode;
    }

    @Override
    public void add(T value) {
        if (isEmpty()) {
            rootNode = new BinaryTreeNode(value);
            size++;
        } else {
            if (rootNode.add(value)) {
                size++;
            }
        }
    }

    @Override
    public void remove(T value) {
        if (isEmpty()) return;

        final BinaryTreeNode removedNode = this.rootNode.remove(null, value);
        if (removedNode != null) {
            size--;
        }
    }

    @Override
    public boolean contains(T value) {
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
/*
    @Override
    public Iterator<T> breadthFirstIterator() {
        return new BinaryTreeBreadthFirstIterator(rootNode);
    }

    @Override
    public Iterator<T> depthFirstIterator() {
        return new BinaryTreeDepthFirstInOrderIterator(rootNode);
    }
*/
    private class BinaryTreeNode extends ABinaryTreeNode<T> {

        private final T value;
        private ABinaryTreeNode<T> left;
        private ABinaryTreeNode<T> right;

        BinaryTreeNode(final T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public T value() {
            return this.value;
        }

        @Override
        public ABinaryTreeNode<T> left() {
            return this.left;
        }

        @Override
        public ABinaryTreeNode<T> right() {
            return this.right;
        }

        private boolean add(T value) {
            if (comparator.compare(value, value()) < 0) {
                final BinaryTreeNode left = (BinaryTreeNode) left();
                if (left == null) {
                    this.left = new BinaryTreeNode(value);
                    return true;
                } else {
                    return left.add(value);
                }
            } else if (comparator.compare(value, value()) > 0) {
                final BinaryTreeNode right = (BinaryTreeNode) right();
                if (right == null) {
                    this.right = new BinaryTreeNode(value);
                    return true;
                } else {
                    return right.add(value);
                }
            } else {
                // value already exists in this tree
                return false;
            }
        }

        private boolean contains(T value) {
            if (comparator.compare(value, value()) < 0) {
                final BinaryTreeNode left = (BinaryTreeNode) left();
                return left != null && left.contains(value);
            } else if (comparator.compare(value, value()) > 0) {
                final BinaryTreeNode right = (BinaryTreeNode) right();
                return right != null && right.contains(value);
            } else {
                return true;
            }
        }

        private BinaryTreeNode remove(BinaryTreeNode parent, T value) {
            if (comparator.compare(value, value()) < 0) {
                final BinaryTreeNode left = (BinaryTreeNode) left();
                if (left == null) {
                    return null;
                } else {
                    return left.remove(this, value);
                }
            }

            if (comparator.compare(value, value()) > 0) {
                final BinaryTreeNode right = (BinaryTreeNode) right();
                if (right == null) {
                    return null;
                } else {
                    return right.remove(this, value);
                }
            }

            final boolean hasLeft = left() != null;
            final boolean hasRight = right() != null;

            BinaryTreeNode result = null;

            if (hasLeft && hasRight) {
                final BinaryTreeNode right = (BinaryTreeNode) right();
                result = right.remove(this, findMinimumValue(right));
                Objects.requireNonNull(result);
                result.left = left();
                result.right = right();
            } else if (hasLeft) {
                result = (BinaryTreeNode) left();
            } else if (hasRight) {
                result = (BinaryTreeNode) right();
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

        private T findMinimumValue(BinaryTreeNode node) {
            Objects.requireNonNull(node);

            BinaryTreeNode left = (BinaryTreeNode) node.left();
            if (left != null) {
                return findMinimumValue(left);
            } else {
                return node.value();
            }
        }

    }
/*
    private class BinaryTreeBreadthFirstIterator implements Iterator<T> {

        private final Queue<BinaryTreeNode> queue = new ArrayDeque<>();

        BinaryTreeBreadthFirstIterator(BinaryTreeNode node) {
            pushIfNonEmpty(node);
        }

        private void pushIfNonEmpty(BinaryTreeNode node) {
            if (node != null) {
                queue.add(node);
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            final BinaryTreeNode inner = queue.poll();
            pushIfNonEmpty((BinaryTreeNode) inner.left());
            pushIfNonEmpty((BinaryTreeNode) inner.right());
            return inner.value;
        }

    }

    private class BinaryTreeDepthFirstInOrderIterator implements Iterator<T> {

        private final Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeDepthFirstInOrderIterator(BinaryTreeNode node) {
            pushIfNonEmpty(node);
        }

        private void pushIfNonEmpty(final BinaryTreeNode theNode) {
            BinaryTreeNode node = theNode;

            while (node != null) {
                stack.push(node);
                node = (BinaryTreeNode) node.left();
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            final BinaryTreeNode node = stack.pop();
            pushIfNonEmpty((BinaryTreeNode) node.right());
            return node.value;
        }

    }
*/
}
