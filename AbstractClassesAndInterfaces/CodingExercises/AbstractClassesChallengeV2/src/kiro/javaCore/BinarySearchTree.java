package kiro.javaCore;

public class BinarySearchTree implements NodeList {

    private ListItem root;

    public BinarySearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (item == null)
            return false;

        if (root == null) {
            root = item;
            return true;
        }

        return addItem(item, root);
    }

    @Override
    public void traverse(ListItem root) {
//        if (root == null) {
//            System.out.println("Binary Search Tree is empty");
//            return;
//        }

        System.out.println("Binary Search Tree:");
        System.out.println("=================================");
        traverseRecursion(root);
        System.out.println("=================================\n");
    }

    @Override
    public boolean removeItem(ListItem item) {


        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.prev();
            } else {
                // equal: we've found the item so remove it;
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    // private functional methods

    private boolean addItem(ListItem item, ListItem root) {
        int comparison = root.compareTo(item);

        if (comparison > 0) {   // item < root, send item to the left
            if (root.prev() == null) {
                root.setPrev(item);
                return true;
            }
            addItem(item, root.prev());
        } else if (comparison < 0) {    // item > root, send item to the right
            if (root.next() == null) {
                root.setNext(item);
                return true;
            }
            addItem(item, root.next());
        }

        return false;       // item == root, no duplicates allowed
    }

    private void traverseRecursion(ListItem root) {
//        if (root.prev() != null) {
//            traverse(root.prev());
//        }
//        System.out.println(root.getValue());
//
//        if (root.next() == null) {
//            return;
//        } else {
//            traverse(root.next());
//        }

        // alternatively, you can simply:
        if (root != null) {
            traverseRecursion(root.prev());
            System.out.println(root.getValue());
            traverseRecursion(root.next());
        }
    }

    private void performRemoval(ListItem item, ListItem parent) {
        // remove item from the tree
        if (item.next() == null) {
            // no right tree, so make parent point to the left tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.prev());
            } else if (parent.prev() == item) {
                parent.setPrev(item.prev());
            } else {
                // parent must be item, which means we were looking at the root
                this.root = item.prev();
            }
        } else if (item.prev() == null) {
            // no left tree, so make parent point to the right tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.next());
            } else if (parent.prev() == item) {
                parent.setPrev(item.next());
            } else {
                // parent must be item, which means we were looking at the root
                this.root = item.next();
            }
        } else {
            // neither left nor right are null, deletion is now a lot trickier
            // From the right sub-tree, find the smallest value (i.e., leftmost)
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.prev() != null) {
                leftmostParent = current;
                current = current.prev();
            }
            // Now put the smallest value into our node to be deleted
            item.setValue(current.getValue());
            // and delete the smallest
            if (leftmostParent == item) {
                // there was no leftmost node, so current points to the smallest
                //  node (the one that must now be deleted)
                item.setNext(current.next());
            } else {
                // set the smallest node's parent to point to
                //  the smallest node's right child (which may be null)
                leftmostParent.setPrev(current.next());
            }
        }
    }
}
