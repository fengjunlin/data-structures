package com.muehda.stack;

/**
 * @Description 利用栈实现计算器功能
 * @Author fengjl
 * @Date 2019/8/18 22:39
 * @Version 1.0
 **/
public class JiSuanQi {
    public static void main(String[] args) {
        String expresion = "7*20-4";
        // 数栈，符号栈
        ArrayStack2 dataStack = new ArrayStack2(100);
        ArrayStack2 operStack = new ArrayStack2(100);
        int index = 0;
        int num = 0;
        int num1 = 0;
        int res = 0;
        String keepNum = "";
        // 核心算法逻辑
        while (true) {
            char ch = expresion.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    if (operStack.power(ch) <= operStack.power(operStack.peek())) {
                        num = dataStack.pop();
                        num1 = dataStack.pop();
                        int pop = operStack.pop();
                        res = dataStack.cel(num1, num, pop);
                        dataStack.add(res);
                        operStack.add(ch);
                    }
                } else {
                    operStack.add(ch);
                }
            }
            // 若果是数字
            else {
                // 注意区分char 和 string 区别
                keepNum += ch;
                if (index == expresion.length() - 1) {
                    dataStack.add(Integer.parseInt(keepNum));
                } else {
                    // 去看后面一位，判断是否为操作符，如果是操作符，直接将keepnum 加入到数栈中
                    if (operStack.isOper(expresion.substring(index + 1, index + 2).charAt(0))) {
                        dataStack.add(Integer.parseInt(keepNum));
                        // 这里一定要清空
                        keepNum = "";
                    }
                }

            }
            index++;
            if (index >= expresion.length()) {
                break;
            }
        }

        // 开始出栈计算
        while (true) {
            // 当符号栈中，为空的时候，这个时候计算可以结束，然后数据栈中还有一个最终的结果数据。
            if (operStack.isEmpty()) {
                break;
            }
            int pop = operStack.pop();
            int pop1 = dataStack.pop();
            int pop2 = dataStack.pop();
            int cel = dataStack.cel(pop2, pop1, pop);
            dataStack.add(cel);
        }
        System.out.println(dataStack.peek());


    }
}

class ArrayStack2 {
    private int maxSize;
    private int top = -1;
    private int[] arr;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void add(int num) {
        if (isFull()) {
            System.out.println("满了");
        } else {
            top++;
            arr[top] = num;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("空");
        } else {
            int value = arr[top];
            top--;
            return value;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            throw new RuntimeException("kong");
        }
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("kong");
            return;
        }

        for (int i = top; i >= 0; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 判断运算符的权限
     */

    public int power(int chars) {
        if (chars == '*' || chars == '/') {
            return 1;
        } else if (chars == '+' || chars == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否为运算符
     */

    public boolean isOper(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    /**
     * 进行计算 switch case
     */
    public int cel(int num, int num1, int oper) {
        int res = 0;
        switch (oper) {
            case '*':
                res = num * num1;
                break;
            case '-':
                res = num - num1;
                break;
            case '/':
                res = num / num1;
                break;
            case '+':
                res = num + num1;
                break;
            default:
                break;
        }
        return res;
    }
}



