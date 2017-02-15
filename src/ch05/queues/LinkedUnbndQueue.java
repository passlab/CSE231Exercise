//---------------------------------------------------------------------------
// LinkedUnbndQueue.java         by Dale/Joyce/Weems                Chapter 5
//
// Implements UnboundedQueueInterface using a linked list
//---------------------------------------------------------------------------

package ch05.queues;

import support.LLNode;

public class LinkedUnbndQueue<T> implements UnboundedQueueInterface<T>
{
  protected LLNode<T> front;   // reference to the front of this queue
  protected LLNode<T> rear;    // reference to the rear of this queue

  public LinkedUnbndQueue()
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
        LLNode<T> cursor = front;
        String outs = "";
        int numElements = 0;
        
        while (cursor != null) {
            numElements ++;
            outs += cursor.getInfo().toString() + "\n";
            cursor = cursor.getLink();
        }
        
        outs = numElements + ":\n" + outs;
        
        return outs;
    }

    /* use enque and dequeu opertion to do toString2 */
    public String toString2() {
        String outs = "";
        /* empty queue */
        if (front == null) return outs;

        LLNode<T> originalRear = rear;

        /* the while loop terminates at the node immediately before the original rear node */
        while (front != originalRear) {
            T ele = dequeue();
            outs += ele.toString() + "\n";
            //System.out.println(ele);
            enqueue(ele);
        }

        /* deqeue and enqueue the original rear node to restore the queue back to the original state */
        T ele = dequeue();
        //System.out.println(ele);
        outs += ele.toString() + "\n";
        enqueue(ele);
        return outs;

    }

    /* test the toString method */
    public static void main(String[] args) {
        LinkedUnbndQueue<String> stringQueue = new LinkedUnbndQueue<String>();
        //stringQueue.enqueue("A");
        //stringQueue.enqueue("B");
        //stringQueue.enqueue("C");

        System.out.println(stringQueue.toString2());

    }
}

