package com.muehda.singlelinkedlist;

import java.util.Stack;

/**
 * @Description 带头节点的单链表
 * @Author fengjl
 * @Date 2019/8/15 22:56
 * @Version 1.0
 **/
public class SingleLinkedListDemo {
    public static void main(String[] args) {

    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    // 从最后面加入
    // 思考：1、需要遍历 2、头节点不能动 3、遍历的时候用中间变量去遍历
    public void add(HeroNode data) {
        HeroNode temp = head;

        // 遍历
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = data;
    }

    // 从中间有顺序的加入，同时如果存在相同的排名的就不加入，打印排名信息，找到添加节点的前一个节点，考虑到相等的情况
    public void addByOrder(HeroNode data) {
        HeroNode temp = head;
        // 判断是否有相同的
        boolean flag = false;
        while (true) {
            // 遍历结束的标志
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > data.no) {
                break;
            } else if (temp.next.no == data.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("已经存在不能加入");
        } else {
            // 适用于加入末尾和从中间加入这两种情况
            data.next = temp.next;
            temp.next = data;
        }

    }

    /**
     * 显示链表中的所有数据
     */
    public void list() {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        // 循环,头结点不能动，所有要一个辅助变量
        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    public void list1() {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            // 退出循环
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    /**
     * 根据排名去更新
     * 1、中间变量
     * 2、循环
     * 3、循环出口
     * 4、头结点不能动
     */
    public void update(HeroNode data) {
        if (head.next == null) {
            System.out.println("链表为空。。。。");
            return;
        }
        boolean flag = false;
        HeroNode temp = head.next;
        while (true) {
            // 循环结束
            if (temp == null) {
                break;
            }

            if (temp.no == data.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.nickName = data.nickName;
            temp.name = data.name;
        } else {
            System.out.println("没有这个排位。。。。。");
        }

    }

    /**
     * 删除元素
     *
     * @param no
     */
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空。。。。。。。。。。。。。。。");
        }
        boolean flag = false;
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有要删除的");
        }
    }

    /**
     * 求出单链表有效节点的个数
     * 1、不包括头结点
     * 2、循环
     * 4、
     *
     * @return
     */
    public int size() {
        HeroNode temp = head.next;
        int size = 0;
        while (true) {
            if (temp == null) {
                break;
            }
            size++;
            temp = temp.next;
        }
        return size;
    }

    /**
     * 获取到单链表倒数第k个指针
     *
     * @return
     */
    public HeroNode getLastHearNode(int index) {
        if (head.next == null) {
            return null;
        }
        int size = size();
        HeroNode temp = head.next;

        // 对参数进行校验
        if (index > size || index <= 0) {
            return null;
        }
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 链表反转(腾讯面试题)
     * 稍微有点难度
     * 1、改变原来的链表的结构
     */
    public void reverseLinkedList() {
        //  若链表为空或者长度为1则直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        // 开始反转操作
        /**
         * 1、定义一个新的头节点
         * 2、临时变量指针
         * 3、指向下一个变量的指针
         */
        HeroNode newHeadNode = new HeroNode(0, "", "");
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = newHeadNode.next;
            newHeadNode.next = cur;
            cur = next;
        }
        // 将现在的头节点指向反转之后的节点
        head.next = newHeadNode.next;
    }


    /**
     * 逆序打印单链表
     * 1、链表反转 （会改变原来的链表的结构）
     * 2、利用栈的特点 （不改变原来链表的结构）
     * 3、
     */
    public void reversePrintLinkedList() {
        if (head.next == null) {
            return;
        }
        HeroNode tmep = head.next;
        Stack<HeroNode> stack = new Stack<>();
        while (tmep != null) {
            stack.push(tmep);
            tmep = tmep.next;
        }
        // 打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }


}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
