//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法

package leetcode.editor.cn;


import java.util.Comparator;
import java.util.PriorityQueue;

// 题目编号：23
// https://leetcode-cn.com/problems/merge-k-sorted-lists/
@SuppressWarnings("all")
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            ListNode solider = new ListNode(-1);
            ListNode p = solider;

            PriorityQueue<ListNode> queue = new PriorityQueue(lists.length, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                queue.add(lists[i]);
            }

            while (!queue.isEmpty()) {
                ListNode poll = queue.poll();
                p.next = poll;
                p = p.next;
                if (poll.next != null) {
                    queue.add(poll.next);
                }
            }
            return solider.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}