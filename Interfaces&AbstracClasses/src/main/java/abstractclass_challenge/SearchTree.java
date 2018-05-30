package abstractclass_challenge;

public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    public ListItem getRoot() {
        return this.root;
    }

    public boolean addItem(ListItem item) {
        return false;
    }

    public boolean removeItem(ListItem item) {
        return false;
    }

    public void transver(ListItem root) {

    }
}
