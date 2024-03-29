package com.finn.start;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static void main(String[] args) {
        new Solution().addTwoNumbers(new ListNode(2), new ListNode(1));
        String s = "{\"EDATA\":[{\"ZYL02\":\"Z\",\"SPE_MDNUM_EWM\":\"M230224150042978\",\"BUDAT\":20230224,\"WERKS\":1502,\"AUFNR\":\"001000001189\",\"MATNR\":\"1ACLC0210001\",\"CHARG\":\"C2H1ACK22400014\",\"MENGE\":\"1.000 \",\"BWART\":101,\"LGORT\":1524},{\"ZYL02\":\"Z\",\"SPE_MDNUM_EWM\":\"M230224150042978\",\"BUDAT\":20230224,\"WERKS\":1502,\"AUFNR\":\"001000001219\",\"MATNR\":\"1ACLC0210001\",\"CHARG\":\"C2H1ACK22400014\",\"MENGE\":\"1.000 \",\"BWART\":101,\"LGORT\":1524},{\"ZYL02\":\"Z\",\"SPE_MDNUM_EWM\":\"M230224150042978\",\"BUDAT\":20230224,\"WERKS\":1502,\"AUFNR\":\"000030000182\",\"MATNR\":\"1ACLC0210001\",\"CHARG\":\"C2H1ACK22400014\",\"MENGE\":\"1.000 \",\"BWART\":531,\"LGORT\":1524,\"TYPE\":\"E\",\"MESSAGE\":\"物料不在工单上，请检查!!\"}]}";
    }


}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode xList = new ListNode(0);  //创建首节点
        ListNode newList = xList;  //声名一个变量用来在移动过程中指向当前节点
        int curr = 0;
        while (l1 != null || l2 != null) {
            //获取链表的值
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            //计算和
            int sum = x + y + curr;
            curr = sum / 10;
            ListNode sumNode = new ListNode(sum % 10); //生成新的节点
            //移动指针指向下一个值
            newList.next = sumNode; //把新节点连起来
            newList = newList.next; //当前节点往后移动
            if (l1 != null) l1 = l1.next; //将节点向后移动，对l1的下一个节点进行处理
            if (l2 != null) l2 = l2.next; //将节点向后移动，对l2的下一个节点进行处理
        }
        if (curr > 0) {
            newList.next = new ListNode(curr);
        }
        return xList.next;
    }
}


