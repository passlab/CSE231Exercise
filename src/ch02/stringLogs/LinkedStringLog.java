//----------------------------------------------------------------------
// LinkedStringLog.java       by Dale/Joyce/Weems              Chapter 2
//
// Implements StringLogInterface using a linked list 
// of LLStringNode to hold the log strings.
//----------------------------------------------------------------------

package ch02.stringLogs;

public class LinkedStringLog implements StringLogInterface 
{
  protected LLStringNode log; // reference to first node of linked 
                              // list that holds the StringLog strings
  protected String name;      // name of this StringLog
  
  public LinkedStringLog(String name)
  // Instantiates and returns a reference to an empty StringLog object 
  // with name "name".
  {
    log = null;
    this.name = name;
  }

  public void insert(String element)
  // Precondition:   This StringLog is not full.
  //
  // Places element into this StringLog.
  {      
    LLStringNode newNode = new LLStringNode(element);
    newNode.setLink(log);
    log = newNode;
  }

  public boolean isFull()
  // Returns true if this StringLog is full, false otherwise.
  {              
    return false;
  }

  public boolean isEmpty() {
    if (log == null) return true;
    else return false;
  }

  // precondition: noempty
  public String smallest() {
    LLStringNode currNode = log;
    String smallestSring = log.getInfo();

    while(currNode != null) {

      /* do something for finding the smallest */
      if (currNode.getInfo().compareTo(smallestSring) < 0)
        smallestSring = currNode.getInfo();

      currNode = currNode.getLink();
    }

    return null;
  }
  
  public int size()
  // Returns the number of Strings in this StringLog.
  {
    int count = 0;
    LLStringNode node;
    node = log;
    while (node != null)
    {
      count++;
      node = node.getLink();
    }
    return count;
  }
  
  public boolean contains(String element)
  // Returns true if element is in this StringLog,
  // otherwise returns false.
  // Ignores case difference when doing string comparison.
  {                 
    LLStringNode node;
    node = log;

    while (node != null) 
    {
      if (element.equalsIgnoreCase(node.getInfo()))  // if they match
        return true;
      else
        node = node.getLink();
    }

   return false;
  }
  
  public int howMany(String element)
  // Returns true if element is in this StringLog,
  // otherwise returns false.
  // Ignores case difference when doing string comparison.
  {                 
    LLStringNode node;
    node = log;
    int count = 0;

    while (node != null) 
    {
      if (element.equalsIgnoreCase(node.getInfo()))  count ++;
        node = node.getLink();
    }
   return count;
  }

  /* insert only if it does not exist in the log
  * return false if it is already in the list
  * true if it is inserted
  * */
  @Override
  public boolean uniqueInsert(String element){
    //if (contains(element)) return false;
    //insert(element); return true;

    /* do it using while loop */
    LLStringNode currNode;
    currNode = log;

    while (currNode != null)
    {
      if (element.equalsIgnoreCase(currNode.getInfo()))  // if they match
        return false;
      else
        currNode = currNode.getLink();
    }

    /* insert at the beginning */
    LLStringNode newNode = new LLStringNode(element);
    newNode.setLink(log);
    log = newNode;

    return true;

  }

  public void clear()
  // Makes this StringLog empty.
  { 
    log = null;
  }

  public String getName()
  // Returns the name of this StringLog.
  {
    return name;
  }

  public String toString()
  // Returns a nicely formatted string representing this StringLog.
  {
    String logString = "Log: " + name + "\n\n";
    LLStringNode node;
    node = log;
    int count = 0;
    
    while (node != null)
    {
      count++;
      logString = logString + count + ". " + node.getInfo() + "\n";
      node = node.getLink();
    }
      
    return logString;
  }
}