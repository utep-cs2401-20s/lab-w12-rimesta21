import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class myBinarySearchTreeTester {

    /*This test is testing whether myBinarySearchTreeNode can take an array and correctly create a binary search tree.
       Because this method uses the default constructor and the insert method, this test is testing all three methods.Note
       that the array has duplicates to whether the method disregards the duplicate.
       The test passed.
     */
    @Test
    public void myBinarySearchTreeTest1() {
        int[] A = {5,2,7,3,3};
        myBinarySearchTreeNode BT = new myBinarySearchTreeNode(A);
        /*I realize that this looks really bad being hard coded but I didn't want to create another tree with the
        myBinarySearchTreeNode constructor because if the method didn't work then the test would pass and I would not be
        able to tell if it works. Instead I created a small tree with left and right children with the left child having
        a right child.
         */
        assertEquals(5, BT.myValue);
        assertEquals(2,BT.left.myValue);
        assertEquals(3, BT.left.right.myValue);
        assertEquals(7,BT.right.myValue);
        assertNull(BT.left.left);
        assertNull(BT.left.right.left);
        assertNull(BT.left.right.right);
        assertNull(BT.right.left);
        assertNull(BT.right.right);
    }

    /*This test is testing the basic functionality of the size method(). Noting that the myBinarySearchTreeNode
    constructor works well, I decided to create a bigger tree with an ordinary set of numbers. The test passed.
     */
    @Test
    public void myBinarySearchTreeTest2() {
        int[] A = {5,2,4,3,1,3,7,8,9};
        myBinarySearchTreeNode BT = new myBinarySearchTreeNode(A);
        assertEquals(8,BT.size());
    }

    /*This test is testing the basic functionality of the height method. Again, with an ordinary set of numbers can the
    method traverse through the tree and evaluate the height correctly. The test passed.
     */
    @Test
    public void myBinarySearchTreeTest3() {
        int[] A = {5,2,4,3,1,3,7,8,9};
        myBinarySearchTreeNode BT = new myBinarySearchTreeNode(A);
        assertEquals(3,BT.height());
    }

    /*This test is testing the basic functionality of the depth method. I chose to search for 4 because searching for 4
    requires the method to go left at the root and the right at 2. Using 4 allows me to test the left and right branches
    of the method. The test passed.
     */
    @Test
    public void myBinarySearchTreeTest4() {
        int[] A = {5,2,4,3,1,3,7,8,9};
        myBinarySearchTreeNode BT = new myBinarySearchTreeNode(A);
        assertEquals(2,BT.depth(4));
    }

    /*This test is also testing the basic functionality of the depth method. The difference between this test and the one
    above is that this test is testing whether the method returns a -1 when the number is not found. The test passed.
     */
    @Test
    public void myBinarySearchTreeTest5() {
        int[] A = {5,2,4,3,1,3,7,8,9};
        myBinarySearchTreeNode BT = new myBinarySearchTreeNode(A);
        assertEquals(-1,BT.depth(10));
    }
}
