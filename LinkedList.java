public class LinkedList {
	
	static class E {
	    E next = null;
	    int data;

	    public E(int d){
	    	data = d;
	    }
	}
	
	public static E head;
	public int size;

	public LinkedList(){
		head = null;
		size = 0;
	}
	
	public void add(E item) {
		if(head == null){
			head = new E(item.data);
			++size;
		}
		else {
			E prev = head;
			while(prev.next != null)
				prev = prev.next;
			prev.next = item;
			++size;
		}
	}
	
	public void add(E item, int position) {
		if(head == null){
			head = new E(item.data);
			++size;
		}
		else if(position==0){
			item.next = head;
			remove(1);
		}
		
		else{
			E prev = head;
			for(int i=0; i < position-1; i++)
				prev = prev.next;
			item.next = prev.next;
			prev.next = item;
			++size;
		}
	}

	public E get(int position) {
		E curr = head;
		for(int i=0; i < position; i++)
			curr = curr.next;
		return curr;
	}
	
	public E remove(int position) {
		if (position==0){
			E node = head;
			head = head.next;
			--size;
			return node;
		}
		else{
			E prev = head;
			for (int i=0; i < position-1; i++)
				prev = prev.next;
			E node = prev.next;
			prev.next = node.next;
			--size;
			return node;
		}
	}
	
	public E reverse(E head) {
		E previous = null;
		E current = head; 
		E following = head;

		while (current != null) { 
			following = following.next;
			current.next = previous;
			previous = current;
			current = following;
		}
		return previous;
	}
	
	public static void show(LinkedList llist) {
    	for(int i = 0; i < llist.size; i++)
    		System.out.print(llist.get(i).data + "->");
    	System.out.print("NULL\n\n");
	}


    public static void main(String[] args) {

    	LinkedList llist = new LinkedList();
    	
    	System.out.println("Ex 1. add() Node containing '12' to list:");
    	E node = new E(12);
    	llist.add(node);
    	show(llist);
    	
    	System.out.println("Ex 2. add() Node containing '13' to list:");
    	E node1 = new E(13);
    	llist.add(node1);
    	show(llist);
    	
    	System.out.println("Ex 3. add() Node containing '14' to list at index 1:");
    	E node2 = new E(14);
    	llist.add(node2, 1);
    	show(llist);
    	
    	System.out.println("Ex 4. get() index 1:");
    	System.out.println(llist.get(1).data + "\n");
   
    	System.out.println("Ex 5. remove() index 2:");
    	llist.remove(2);
    	show(llist);
    	
    	System.out.println("Ex 6. reverse() LinkedList:");
    	System.out.println("Reversed list head located at "+ llist.reverse(head));
    }
}