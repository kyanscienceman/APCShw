public class myQueue<E>{
    private Node<E> first;
    private Node<E> last;

    /*-------------------- Constructors, Utilities ---------------------*/

    public myQueue(){
	first = new Node<E>();
        last = first;
	first.setNext(last);
    }

    public String toString(){
	Node<E> tmp = first.getNext();
	String s = "";
	s = s + "Last: " + last + "\n";
	for( ; tmp != last ; tmp = tmp.getNext() )
	    s = s + tmp.getData() + " <-- ";
	s = s + last.getData() + "\n";
	return s;
    }

    /*----------------------- Fundamental Methods -----------------------*/

    public void enqueue(E data){
	Node<E> tmp = new Node<E>(data);
	last.setNext(tmp);
	last = tmp;
    }

    public E dequeue(){
	if(!empty()){
	    Node<E> tmp = first.getNext();
	    first.setNext(tmp.getNext());
	    return tmp.getData();
	}
	else
	    return null;
    }

    /*----------------------- Helpful Methods --------------------------*/

    public boolean empty(){
	return last == null;
    }

    public E head(){
	return first.getNext().getData();
    }

    /*---------------------------- Main -------------------------------*/

    public static void main(String[] args){
	myQueue<Integer> q = new myQueue<Integer>();
	System.out.println(q);
	q.enqueue(1);
	System.out.println(q);
	System.out.println("Removing "+q.dequeue());
    }
   
}