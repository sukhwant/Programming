package datastructure;

public class List {

    private ListNode head;

    public List() {
        this.head = null;
    }

    public void add(int data) {
        ListNode temp = head;

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        ListNode newNode = new ListNode();
        newNode.setData(data);
        newNode.setNext(null);

        temp.setNext(newNode);
    }

    public int remove() {
        // TODO:-
        return 0;
    }
}
