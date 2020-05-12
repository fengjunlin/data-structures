package com.muehda.hashtable;

/**
 * @Description hash 表实现
 * @Author fengjl
 * @Date 2019/9/20 10:18
 * @Version 1.0
 **/
public class HashTableDemo {
    public static void main(String[] args) {

    }
}

class HashTabel {
    private LinkedList[] arr;
    private int size;

    public HashTabel(int size) {
        this.arr = new LinkedList[size];
        this.size = size;
    }

    public void add(Empy data) {
        int hash = hash(data.getId());
        if (null == arr[hash]) {
            arr[hash] = new LinkedList();
        }
        arr[hash].add(data);
    }

    public Empy findEmpById(int id) {
        int hash = hash(id);
        if (null == arr[hash]) {
            return null;
        }
        return arr[hash].findEmpById(id);
    }

    public void list(int no) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].list(i);
        }
    }


    public int hash(int no) {
        return no % size;
    }
}

class LinkedList {
    private Empy head = null;
    private Empy next;

    public LinkedList() {
    }

    /**
     * 增加
     *
     * @param data
     */
    public void add(Empy data) {
        if (null == data) {
            System.out.println("添加的数据为空");
            return;
        }
        if (head == null) {
            head = data;
        }
        Empy temp = head;
        while (true) {
            if (head.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(data);
    }

    public void list(int no) {
        if (null == head) {
            System.out.println("第几" + no + "个位置的数据为空");
            return;
        }

        Empy temp = head;
        while (true) {
            System.out.println(temp);
            if (null == temp.getNext()) {
                break;
            }
            temp = temp.getNext();
        }
    }

    public Empy findEmpById(int id) {
        if (null == head) {
            System.out.println("kong");
            return null;
        }
        Empy temp = head;
        while (true) {
            if (temp.getId() == id) {
                return temp;
            }
            if (null == temp.getNext()) {
                break;
            }
            temp = temp.getNext();

        }
        return null;
    }


}

class Empy {
    private Integer id;
    private String name;
    private Empy next;

    public Empy() {
    }

    public Empy(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Empy getNext() {
        return next;
    }

    public void setNext(Empy next) {
        this.next = next;
    }
}
