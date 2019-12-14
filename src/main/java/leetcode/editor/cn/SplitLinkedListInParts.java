//给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。 
//
// 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。 
//
// 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。 
//
// 返回一个符合上述规则的链表的列表。 
//
// 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ] 
//
// 示例 1： 
//
// 
//输入: 
//root = [1, 2, 3], k = 5
//输出: [[1],[2],[3],[],[]]
//解释:
//输入输出各部分都应该是链表，而不是数组。
//例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
//第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
//最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
// 
//
// 示例 2： 
//
// 
//输入: 
//root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
//输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
//解释:
//输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
// 
//
// 
//
// 提示: 
//
// 
// root 的长度范围： [0, 1000]. 
// 输入的每个节点的大小范围：[0, 999]. 
// k 的取值范围： [1, 50]. 
// 
//
// 
// Related Topics 链表

package leetcode.editor.cn;

import java.util.Arrays;

// 题目编号：725
// https://leetcode-cn.com/problems/split-linked-list-in-parts/
@SuppressWarnings("all")
public class SplitLinkedListInParts {
    public static void main(String[] args) {
        Solution solution = new SplitLinkedListInParts().new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        //ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(1);
//        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        //node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

        ListNode[] listNodes = solution.splitListToParts(node1, 2);
        System.out.println(Arrays.toString(listNodes));
    }


//leetcode submit region begin(Prohibit modification and deletion)

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {

            ListNode current = root;
            // 链表中节点总个数
            int count = 0;
            while (current != null) {
                count++;
                current = current.next;
            }
            // 每个子链表的平均长度size
            int size = count / k;
            // 前面的 mod 个子链表的长度是 (size + 1)
            int mod = count % k;

            ListNode[] array = new ListNode[k];
            current = root;
            for (int i = 0; i < k && current != null; i++) {
                array[i] = current;
                // 每个子链表的长度
                int l = (mod--) > 0 ? size + 1 : size;

                // 找到子链表截断处
                while (current != null && --l > 0) {
                    current = current.next;
                }
                if (current == null) {
                    break;
                }
                // 截断子链表
                ListNode next = current.next;
                current.next = null;
                // 让 current 指向下一个子链表的头节点
                current = next;

            }
            return array;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}