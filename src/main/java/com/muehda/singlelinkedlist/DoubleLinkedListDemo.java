package com.muehda.singlelinkedlist;

/**
 * @Description 双链表
 * @Author fengjl
 * @Date 2019/8/17 22:17
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }

}

@SuppressWarnings("all")
class DoubleLinkedList {
    public HeroNode2 head = new HeroNode2(0, "", "");

    public void add(HeroNode2 node) {
        HeroNode2 temp = head;
        // 遍历找到最后一个节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }
    // list

    /**
     * 展示所有的元素
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空。。。。。");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            // 遍历结束
            if (temp == null) {
                break;
            }

            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void update(HeroNode2 heroNode2) {
        if (head.next == null) {
            System.out.println("链表为空，不能更新");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            // 遍历到最后面就结束
            if (temp == null) {
                break;
            }

            // 找到了
            if (temp.no == heroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.nickName = heroNode2.nickName;
            temp.name = heroNode2.name;
        } else {
            System.out.println("没有找到要更新的");
        }
    }

    // 删除
    public void del(HeroNode2 node) {
        if (head.next == null) {
            System.out.println("链表为空。。。。");
            return;
        }
        boolean flag = false;
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }

            if (temp.no == node.no) {
                flag = false;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            if (temp != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("没有找到要删除的。。。");
        }
    }

    /**
     * 双向链表顺序添加
     *
     * @param hero
     */
    public void addByOrder(HeroNode2 hero) {
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            // 遍历到链表末尾结束
            if (temp.next == null) {
                break;
            }
            if (hero.no > temp.no) {
                break;
            } else if (hero.no == temp.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("已经加入了");
        } else {
            temp.next.pre = hero;
            hero.next = temp.next;
            temp.next = hero;
            hero.pre = temp;
        }


    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}