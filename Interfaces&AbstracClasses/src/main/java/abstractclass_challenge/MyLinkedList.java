package abstractclass_challenge;

public class MyLinkedList implements NodeList{

    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    public ListItem getRoot() {
        return this.root;
    }

    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // the list is empty, so this item become the head
            this.root = newItem;
            return true;
        } else {
            ListItem currenItem = this.root;
            while (currenItem != null ) {
                int compartor = currenItem.compareTo(newItem);
                if (compartor < 0) {
                    // newItem is greater, move to the right
                    if (currenItem.next() != null ) {
                        currenItem = currenItem.next();
                    } else {
                        currenItem.setNext(newItem).setPrevious(currenItem);
                        return true;
                    }
                } else if (compartor > 0) {
                    // new item is before
                    if (currenItem.previous() != null ){
                        currenItem.previous().setNext(newItem).setPrevious(currenItem.previous());
                        currenItem.setPrevious(newItem).setNext(currenItem);
                    } else {
                        // the node with a previous is the root
                        newItem.setNext(this.root).setPrevious(newItem);
                        this.root = newItem;

                    }
                    return true;
                } else {
                    // the value is present
                    System.out.println("This item " + newItem.getValue() + " is already present");
                    return false;
                }
            }
            return false;
        }

    }

    public boolean removeItem(ListItem item) {
        if (item != null ) {
            System.out.println("Deleting Item " + item.getValue());
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                // found the item
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0 ) {
                currentItem = currentItem.next();
            } else {
                return false;
            }
        }
        return false;
    }

    public void transver(ListItem root) {

        if (root == null) {
            System.out.println("The List is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
