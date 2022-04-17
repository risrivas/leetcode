package linkedlist;

import java.util.Stack;

public class ConvertBinaryNumber {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        System.out.println(getDecimalValue(head));
    }

    private static int getDecimalValue(ListNode head) {
        int result = 0;
        Stack<Integer> cache = new Stack<>();
        while (head != null) {
            cache.push(head.val);
            head = head.next;
        }

        int i = 0;
        while (!cache.isEmpty()) {
            int num = cache.pop();
            if (num == 1) {
                result += Math.pow(2, i);
            }
            i++;
        }

        return result;
    }

}
