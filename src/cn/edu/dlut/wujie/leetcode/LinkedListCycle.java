package cn.edu.dlut.wujie.leetcode;
//判断一个链表中是否存在循环
public class LinkedListCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10 <--9 <-- 8 <-- 5 <--9
		ListNode head = new ListNode(10);
		ListNode node2 = new ListNode(9);
		head.next = node2;
		node2.next = new ListNode(8);
		node2.next.next = new ListNode(5);
		node2.next.next.next = null;
		//node2.next.next.next = node2;
		System.out.println("has cycle ? " + hasCycle(head));
	}
	
	public static boolean hasCycle(ListNode head) {
		//快慢指针
		if(head == null || head.next == null)
			return false;
		ListNode walk = head, run = head.next;
		while(run != null && run.next != null) {
			walk = walk.next;
			run = run.next.next;
			if(walk == run)
				return true;
		}
		return false;		
	}
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode() {
		
	}
	ListNode(int val) {
		this.val = val;
	}
}