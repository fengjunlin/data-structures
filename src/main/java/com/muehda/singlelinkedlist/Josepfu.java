package com.muehda.singlelinkedlist;

/**
 * @Description 经典算法题，约瑟夫环形队列问题，用单项环形链表去解决
 * @Author fengjl
 * @Date 2019/8/18 16:57
 * @Version 1.0
 **/
public class Josepfu {
    public static void main(String[] args) {
        CirCleSingleLinked cirCleSingleLinked = new CirCleSingleLinked();
        cirCleSingleLinked.add(5);
        cirCleSingleLinked.showCircleLinked();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        cirCleSingleLinked.countByBoy(1, 2, 5);
    }
}

class CirCleSingleLinked {
    private Boy first;

    /**
     * 构建环形链表
     * 1、构建传入no个数据的环形的链表
     * 2、第一个节点单独考虑
     * 3、一个current 指针，指向对后面
     * 4、每次加入的时候 current.next = boy; boy.next = first current = boy
     */
    public void add(int no) {
        // 这种情况下的，环链表是没有意义的。
        if (no <= 1) {
            return;
        }
        Boy current = null;
        for (int i = 1; i <= no; i++) {
            // 第一个节点单独考虑
            if (i == 1) {
                first = new Boy(1);
                first.setNext(first);
                current = first;
            } else {
                Boy boy = new Boy(i);
                current.setNext(boy);
                boy.setNext(first);
                current = boy;
            }
        }
    }

    /**
     * 显示环形链表中的数据
     */
    public void showCircleLinked() {
        if (first == null) {
            System.out.println("没有数据");
        }
        Boy temp = first;
        while (true) {
            System.out.println(temp.getNo());
            if (temp.getNext() == first) {
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 解决约瑟夫问题
     */
    /**
     * @param startNo  从几号开始数
     * @param countNum 中间数几下
     * @param nums     总共有多少数
     */
    public void countByBoy(int startNo, int countNum, int nums) {
        // 首先校验
        if (startNo <= 0 || countNum > nums) {
            System.out.println("参数不合法");
            return;
        }

        // 把current一道first节点后面
        Boy helper = first;
        while (true) {
            helper = helper.getNext();
            if (helper.getNext() == first) {
                break;
            }
        }
        // 把fist节点和current移到startNo num开始数据的地方
        for (int i = 0; i < startNo - 1; i++) {
            helper = helper.getNext();
            first = first.getNext();
        }

        while (true) {
            if (first.getNo() == helper.getNo()) {
                break;
            }
            // 然后开始数据 countNum -1 下
            for (int i = 0; i < countNum - 1; i++) {
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.println(first.getNo());
            // fist指向要出圈的位置
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后的出圈位置：" + first.getNo());
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}