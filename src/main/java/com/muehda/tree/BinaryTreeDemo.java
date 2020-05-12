package com.muehda.tree;

/**
 * @Description 二叉树相关操作
 * @Author fengjl
 * @Date 2019/9/23 10:44
 * @Version 1.0
 **/
public class BinaryTreeDemo {
}

class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (null == root) {
            System.out.println("二叉树为空，不能遍历");
        } else {
            root.preOrder();
        }
    }

    public void midOrder() {
        if (null == root) {
            System.out.println("kong");
        } else {
            root.midOrder();
        }
    }

    public void lastOrder() {
        if (null == root) {
            System.out.println("kong");
        } else {
            root.lastOrder();
        }
    }

    public TreeNode findNumber(int no) {
        if (null != root) {
            return this.root.findNumber(no);
        } else {
            return null;
        }
    }
    public void del(int no) {
      if (root != null) {
          if (root.getNumber() == no) {
              root = null;
          } else {
              this.root.del(no);
          }
        } else {
          System.out.println( "kong"
          );
        }
    }
}

class TreeNode {
    private Integer number;
    private String name;
    /**
     * 左节点
     */
    private TreeNode left;
    /**
     * 右节点
     */
    private TreeNode right;

    public TreeNode(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (null != this.left) {
            this.left.preOrder();
        }
        if (null != this.right) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (null != left) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (null != right) {
            this.right.midOrder();
        }
    }

    /**
     * 后续遍历
     */
    public void lastOrder() {
        if (null != left) {
            this.left.lastOrder();
        }
        if (null != right) {
            this.right.lastOrder();
        }
        System.out.println(this);
    }

    /**
     * 查找
     *
     * @param no
     * @return
     */
    public TreeNode findNumber(int no) {
        if (no == this.number) {
            return this;
        }
        TreeNode temp = null;
        if (null != left) {
            temp = this.left.findNumber(no);
        }
        if (temp != null) {
            return temp;
        }
        if (null != right) {
            temp = this.right.findNumber(no);
        }
        return temp;
    }

    /**
     * 删除
     *
     * @param no
     */
    public void del(int no) {
        if (this.left != null && this.left.number == no) {

            if (this.left.left != null && this.left.right == null) {
                this.left =this.left.left ;
            }
            if (this.left.right != null && this.left.left == null) {
                this.left =this.left.right ;
            }
            if (this.left.right != null && this.left.right != null) {
                this.left =this.left.left ;
            }
            return;
        }
        if (this.right != null && this.right.number == no) {
            if (this.left.left != null && this.left.right == null) {
                this.left =this.left.left ;
            }
            if (this.left.right != null && this.left.left == null) {
                this.left =this.left.right ;
            }
            if (this.left.right != null && this.left.right != null) {
                this.left =this.left.left ;
            }
            return;
        }

        if (null != this.left) {
            this.left.del(no);
        }
        if (null != this.right) {
            this.right.del(no);
        }
    }
}
