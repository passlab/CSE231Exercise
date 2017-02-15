//---------------------------------------------------------------------------
// CircularLinkedUnbndQueue.java         by OU SECS                Chapter 5
//
// Implements UnboundedQueueInterface using a linked list
//---------------------------------------------------------------------------

package ch05.queues;

import support.LLNode;

public class CircularLinkedUnbndQueue<T> implements UnboundedQueueInterface<T>
{
  protected LLNode<T> rear;    // reference to the rear of this queue

  public CircularLinkedUnbndQueue()
  {
    rear = null;
  }

  public void enqueue(T element)
  // Adds element to the rear of this queue.
  { 
      
    if (rear == null) { /* empty queue */
        /* step 1 */
        LLNode<T> newNode = new LLNode<T>(element);
        newNode.setLink(newNode);
        
        /* ignore step 2 */
        
        /* step 3 */
        rear = newNode;
    } else { /* non-empty queue */
        /* step 1: create new object and let it link to the current front */  
        LLNode<T> newNode = new LLNode<T>(element);
        newNode.setLink(rear.getLink());
    
        /* step 2: let the current rear node point to the new node*/
        rear.setLink(newNode);
    
        /* step 3: update the rear reference of the queue */
        rear = newNode;
    }
  }     

  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {
    if (isEmpty())
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T element = null;
      return element;
    }
  }
  
  public T front() {
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, return front element from this queue.
      
      return null;
      
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    if (rear == null) 
      return true;
    else
      return false;
  }

  public boolean isFull() {
      return false;
  }

  public String toString() {
        return null;
    }

    /* test the toString method */
    public static void main(String[] args) {
        CircularLinkedUnbndQueue<String> stringQueue = new CircularLinkedUnbndQueue<String>();
        stringQueue.enqueue("A");
        stringQueue.enqueue("B");

        stringQueue.enqueue("C");

        System.out.println(stringQueue.toString());

    }
}

