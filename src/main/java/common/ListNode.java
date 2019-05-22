package common;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode arrayToListNode(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int[] temp = new int[nums.length - 1];
        for (int i = 1; i < nums.length && temp.length > 0; i++) {
            temp[i - 1] = nums[i];
        }
        ListNode listNode = new ListNode(nums[0]);
        listNode.next = arrayToListNode(temp);
        return listNode;
    }

    @Override
    public String toString() {
        if (next != null) {
            return val + next.toString();
        }
        return String.valueOf(val);
    }

    public String toReverseString() {
        if (next != null) {
            return next.toString() + val;
        }
        return String.valueOf(val);
    }

}
