public class LinkedQueue<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;
    private int numElements;
    private E element;

    public LinkedQueue() {
        first = null;
        last = null;
        numElements = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean isFull() throws OverflowException{ 
        try {
            Node<E> current = new Node<E>(element);
            current = current.getNext();
            return false;

        } catch(OverflowException E) {
            return true;
        }
    }

    public int numElements() {
        if(isEmpty()) return 0;

        return numElements;
    }

    public void enqueue(E element) throws OverflowException{
        if(isFull()){
            throw new OverflowException();
        } else {
            Node<E> newNode = new Node<E>(element);
            newNode.setNext(null); //o novo nó sempre apontará como null
            if(first == null) {
                first = newNode; //o novo nó passa a ser o primeiro elemento caso o primeiro seja null
            } else {
                last.setNext(newNode);//o ultimo nó passa a apontar para o novo nó adicionado
            }

            last = newNode; //todo nó adicionado automaticamente passa a ser o último
            numElements++;
        }
    }

    public E dequeue() throws UnderflowException {
        if(isEmpty()) {
            throw new UnderflowException();
        } else {
            E element = first.getElement(); //guarda o primeiro elemento que será removido
            first = first.getNext();//agora o primeiro elemento passa a ser o próximo
            numElements--;
            if(first == null) {
                last = null;
            }
            return element;
        }
    }

    public E front() throws UnderflowException{
        if(isEmpty()) throw new UnderflowException();

        E element = first.getElement();
        return element;
    }

    public E back() throws UnderflowException {
        if(isEmpty()) {
            throw new UnderflowException();
        }else {
            E element = last.getElement();
            return element;
        }

        
    }
}
