package LinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkListTest {

	@Test
	public void testIsEmpty() {
		LinkList theLinkedList = new LinkList();
		boolean retVal = theLinkedList.isEmpty();
		assertEquals(true,retVal);
	}

	@Test
	public void testInsertFirstLink() {
		LinkList theLinkedList = new LinkList();
		boolean result = theLinkedList.insertFirstLink("The Day The Earth Stood Still", 50);
		assertEquals(true,result);
	}

	

}
