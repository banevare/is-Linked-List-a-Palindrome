class IsPalindrome {
    public class ListNode {										// Definition of a singly-linked list.
		final int val;
		ListNode next = null;
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode prev) { this.val = val; prev.next = this; }
    }
    public boolean isPalindrome(ListNode head) {
		int length = 0;
		ListNode tail = null;
		for(ListNode q = head;q != null;q = q.next){						// Find the length and tail of a list of nodes
			length++;
			tail = q;
		}
		int count = 0;
		for(ListNode p = head; p != null;p = p.next,++count){		        		// Reverses the last half of the list
			if(count == (length/2)) reverseList(p);
		}
		return areListsEqual(head,tail);							// Check if first and last halves of the list are equal
	}
	public ListNode reverseList(ListNode head) {							// Reverse a singly-linked list
		if (head == null) return head;
		ListNode curr = head, after = null, before = null;
		while(curr != null){
			after     = curr.next;
			curr.next = before;
			before    = curr;
			curr      = after;
		}
		return before;
	}
	public boolean areListsEqual(ListNode head, ListNode tail){				        // Are two linked lists equal?
		for(ListNode p =  head, q = tail; p != null && q != null; p = p.next,q = q.next){
			if(p.val != q.val) return false;
		}
		return true;
	}
	
	public String print(final ListNode head){							// Print a singly linkedlist
		String s = null;
		ListNode p = head;
		while(p != null){
			if( s == null) s = "" + p.val; else s += " " + p.val;
			p = p.next;
		}
		return s == null ? "" : s;
	}

	// ----------- TESTING ------------
	public ListNode makeList(int vals[]){								// Six nodes
		ListNode head = null, tail = null;
		for(int i : vals) if(head == null) head = tail =  new ListNode(i);
			else tail = tail.next = new ListNode(i,head);
		return head;
	}
	public static void test0(){									// Empty list
		IsPalindrome s = new IsPalindrome();
		ListNode head = null;
		assert(s.isPalindrome(head));
	}
	public static void test1(){									// One node
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1});
		assert(s.isPalindrome(head));
	}
	public static void test2a(){									// Two nodes - good
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1,1});
		assert(s.isPalindrome(head));
	}
	public static void test2b(){									// Two nodes - bad
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1,2});
		assert(!s.isPalindrome(head));
	}
	public static void test3a(){									// Three nodes - good
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1,2,3});
		assert(!s.isPalindrome(head));
	}
	public static void test3b(){									// Three nodes - bad
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1,2,1});
		assert(s.isPalindrome(head));
	}
	public static void test4a(){									// Four nodes - good
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1,2,2,1});
		assert(s.isPalindrome(head));
	}
	public static void test4b(){									// Four nodes - bad
		IsPalindrome s = new IsPalindrome();
		ListNode head = s.makeList(new int[] {1,2,1,2});
		assert(!s.isPalindrome(head));
	}
	public static void main(String[] args){								// Run all the tests if we are called via main
		test0();
		test1();
		test2a();
		test2b();
		test3a();
		test3b();
		test4a();
		test4b();
	}
}
