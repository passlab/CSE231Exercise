//----------------------------------------------------------------------
// StringLogInterface.java     by Dale/Joyce/Weems             Chapter 2
//
// Interface for a class that implements a log of Strings.
// A log "remembers" the elements placed into it.
//
// A log must have a "name".
//----------------------------------------------------------------------

package ch02.stringLogs;

public interface StringLogInterface
{
  void insert(String element);
  // Precondition:   This StringLog is not full.
  // 
  // Places element into this StringLog.

  boolean isFull();
  // Returns true if this StringLog is full, otherwise returns false.

  int size();
  // Returns the number of Strings in this StringLog.

  boolean contains(String element);
  // Returns true if element is in this StringLog,
  // otherwise returns false.
  // Ignores case differences when doing string comparison.

  /* insert only if it does not exist in the log
  * return false if it is already in the list
  * true if it is inserted
  * */
  boolean uniqueInsert(String element);

  void clear();
  // Makes this StringLog empty.

  String getName();
  // Returns the name of this StringLog.

  String toString();
  // Returns a nicely formatted string representing this StringLog.
  
  int howMany(String element);
}
