
public class LinkedStack<E> implements Stack<E> {
    
    private Node<E> top;
    private int numElements;

    public LinkedStack() {
        top = null;
        numElements = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() throws OverflowException { 
        Node<E> current = top; 
        try {
            Node<E> newNode = new Node<E>(current.getElement()); //cria um novo nó na memória para verificar se ainda há espaço
            newNode = newNode.getNext(); //desaloca o novo nó da memória para liberar o espaço
            return false;

        } catch (OverflowException E ) { //caso não haja espaço na memória o programa lança uma excessão
            return true;
        }
    }

    public int numElements() {
        if(isEmpty()) return 0;
        return numElements;
    }

    public void push(E element) throws OverflowException {
        if(isFull()) throw new OverflowException();
        
        Node<E> current = top;
        Node<E> newNode = new Node<E>(element);
        newNode.setNext(current);
        top = newNode;
        numElements++;
    }

    public E pop() throws UnderflowException {
        if(isEmpty()) throw new UnderflowException();
        
        Node<E> current = top;
        E element = current.getElement();
        current = current.getNext();
        top = current;
        numElements--;

        return element;
    }

    public E top() throws UnderflowException {
        if(isEmpty()) throw new UnderflowException();
        E element = top.getElement(); //pega o elemento que está no topo da pilha

        return element;
    }

}
