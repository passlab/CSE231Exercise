//---------------------------------------------------------------------------
// CircularLinkedUnbndQueue.java         by OU SECS                Chapter 5
//
// Implements UnboundedQueueInterface using a linked list
//---------------------------------------------------------------------------

package ch05.queues;

import support.LLNode;

public class CircularLinkedUnbndQueue<T> implements UnboundedQueueInterface<T>
{
  protected LLNode<T> front;   // reference to the front of this queue
  protected LLNode<T> rear;    // reference to the rear of this queue

  public CircularLinkedUnbndQueue()
  {
    front = null;
    rear = null;
  }

  public void enqueue(T element)
  // Adds element to the rear of this queue.
  { 
    LLNode<T> newNode = new LLNode<T>(element);
    if (rear == null)
      front = newNode;
    else
      rear.setLink(newNode);
    rear = newNode;
  }     

  public T dequeue()
  // Throws QueueUnderflowException if this queue is empty;
  // otherwise, removes front element from this queue and returns it.
  {
    if (isEmpty())
      throw new QueueUnderflowException("Dequeue attempted on empty queue.");
    else
    {
      T element;
      element = front.getInfo();
      front = front.getLink();
      if (front == null)
        rear = null;

      return element;
    }
  }

  public boolean isEmpty()
  // Returns true if this queue is empty; otherwise, returns false.
  {              
    if (front == null) 
      return true;
    else
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

