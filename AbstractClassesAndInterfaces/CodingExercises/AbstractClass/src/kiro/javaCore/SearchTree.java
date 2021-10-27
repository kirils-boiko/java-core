package kiro.javaCore;

public class SearchTree implements NodeList {

    private ListItem root;

    public SearchTree(ListItem root) {
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

        ListItem currentItem = this.root;
        while (true) {
            int comparison = currentItem.compareTo(item);
            if (comparison > 0) {   // item < root, send item to the left
                if (currentItem.previous() == null) {
                    currentItem.setPrevious(item);
                    return true;
                }
                currentItem = currentItem.previous();
            } else if (comparison < 0) {    // item > root, send item to the right
                if (currentItem.next() == null) {
                    currentItem.setNext(item);
                    return true;
                }
                currentItem = currentItem.next();
            } else {
                return false;
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
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
                currentItem = currentItem.previous();
            } else {
                // equal: we've found the item so remove it;
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    // private functional methods


    private void performRemoval(ListItem item, ListItem parent) {
        // remove item from the tree
        if (item.next() == null) {
            // no right tree, so make parent point to the left tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.previous());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.previous());
            } else {
                // parent must be item, which means we were looking at the root
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            // no left tree, so make parent point to the right tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext(item.next());
            } else if (parent.previous() == item) {
                parent.setPrevious(item.next());
            } else {
                // parent must be item, which means we were looking at the root
                this.root = item.next();
            }
        } else {
            // neither left nor right are null, deletion is now a lot trickier
            // From the right sub-tree, find the smallest value (i.e., leftmost)
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
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
                leftmostParent.setPrevious(current.next());
            }
        }
    }
}
