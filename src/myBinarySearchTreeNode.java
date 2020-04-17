class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;
    
  myBinarySearchTreeNode(int inValue){
    myValue = inValue;
    left = null;
    right = null;
  }
  
  myBinarySearchTreeNode(int[] A){
    myValue = A[0]; //first value of the array is the root
    if(A.length > 1) {//if there are more values then insert them
      for(int i = 1; i < A.length; i++) {
        insert(A[i]);
      }
    }
  }
  
  public void insert(int inValue){
    if(inValue < myValue) {//this checks if the next value should go on the left
      if(left == null) {//if there are no values on the left insert it
        left = new myBinarySearchTreeNode(inValue);
      } else {//if there is a value on the left you have to compare the inValue with that value
        left.insert(inValue);
      }
    } else if(inValue > myValue) {//same as above but now on the right side
      if(right == null) {
        right = new myBinarySearchTreeNode(inValue);
      } else {
        right.insert(inValue);
      }
    }
  }
  
  public int height(){
     int LS = 0;
     int RS = 0;
     if(left != null) {//if you are not at the edge continue to go left and increment because you went a level
       LS = left.height() + 1;
     }
     if(right != null) {//same as above but to the right
       RS = right.height() + 1;
     }
     return Math.max(LS, RS);//which ever has the highest height is the one that should be returned
  }
  
  public int depth(int search){
    int depth;
    if(search > myValue) {//checks to see if the value is on the right side
      if(right != null) {//if you are not at the edge keep searching
        depth = right.depth(search);
        if(depth == -1) {//the value was not found so keep returning -1
          return -1;
        } else {//the value was found so increment the depth
          return depth + 1;
        }
      } else {//you have reach the edge and the value is not there
        return -1;
      }
    } else if(search < myValue) {//same as above but searching through the left
      if(left != null) {
        depth = left.depth(search);
        if(depth == -1) {
          return -1;
        } else {
          return depth + 1;
        }
      } else {
        return -1;
      }
    } else {//you have found the value so this is your base case
      return 0;
    }
  }

  public int size() {
    int s = 1;//you know you have a root otherwise you wouldn't have been able to call this method
    if(left != null) {//if you can still go to the left add one and keep searching
      s += left.size();
    }
    if(right != null) {//same as above but going right
      s += right.size();
    }
    return s;
  }
  
  // Utility function included so you can debug your solution. 
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
  
} 
