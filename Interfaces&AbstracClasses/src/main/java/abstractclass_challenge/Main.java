package abstractclass_challenge;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.transver(list.getRoot());

        String strinData = "9 2 5 6 8 9 5 4 2 3 5 6";
        String[] data = strinData.split(" ");

        for(String s : data) {
            list.addItem(new Node(s));
        }

        list.transver(list.getRoot());

        list.removeItem(new Node("5"));
        list.transver(list.getRoot());
    }
}
