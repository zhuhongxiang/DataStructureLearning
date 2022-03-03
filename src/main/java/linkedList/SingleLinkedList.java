package linkedList;

import java.beans.Customizer;
import java.util.Stack;

public class SingleLinkedList {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(3,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(5,"吴用","智多星");
        HeroNode hero4 = new HeroNode(7,"林冲","豹子头");

        SimpleLinkedListDemo simpleLinkedListDemo = new SimpleLinkedListDemo();
//        SimpleLinkedListDemo.add(hero1);
//        SimpleLinkedListDemo.add(hero2);
//        SimpleLinkedListDemo.add(hero3);
//        SimpleLinkedListDemo.add(hero4);

        simpleLinkedListDemo.addByNo(hero1);
        simpleLinkedListDemo.addByNo(hero4);
        simpleLinkedListDemo.addByNo(hero3);
        simpleLinkedListDemo.addByNo(hero2);

        HeroNode hero5 = new HeroNode(2,"宋江","及时雨");
        HeroNode hero6 = new HeroNode(4,"卢俊义","玉麒麟");
        HeroNode hero7 = new HeroNode(6,"吴用","智多星");
        HeroNode hero8 = new HeroNode(8,"林冲","豹子头");

        SimpleLinkedListDemo simpleLinkedListDemo2 = new SimpleLinkedListDemo();


        simpleLinkedListDemo2.addByNo(hero5);
        simpleLinkedListDemo2.addByNo(hero6);
        simpleLinkedListDemo2.addByNo(hero7);
        simpleLinkedListDemo2.addByNo(hero8);

        // 测试合并链表效果
        System.out.println("两个有序链表合并：");
        HeroNode combine = combine(simpleLinkedListDemo.getHead(),simpleLinkedListDemo2.getHead());
        SimpleLinkedListDemo combineList = new SimpleLinkedListDemo();
        combineList.add(combine.next);
        combineList.list();

//        // 测试链表反转的效果
//        System.out.println("原来链表的情况");
//        simpleLinkedListDemo.list();
//
//        // 测试逆序打印
//        System.out.println("逆序打印：");
//        reverseOutput(simpleLinkedListDemo.getHead());

//        System.out.println("反转单链表后：");
//        reverseHeroNode(simpleLinkedListDemo.getHead());
//        simpleLinkedListDemo.list();
//
//        System.out.println("修改后的链表情况：");
//        HeroNode newHeroNode = new HeroNode(2,"李逵","黑旋风");
//        simpleLinkedListDemo.update(newHeroNode);
//
//        simpleLinkedListDemo.list();
//
//        // delete
//        System.out.println("删除后的链表情况：");
//        simpleLinkedListDemo.delete(1);
//        simpleLinkedListDemo.delete(4);
//        simpleLinkedListDemo.list();
//
//        // 测试求单链表有效节点的个数
//        System.out.println("有效节点的个数="+getLength(simpleLinkedListDemo.getHead()));
//
//        //测试是否得到了倒数第K的个节点
//        HeroNode res = findLastIndexNode(simpleLinkedListDemo.getHead(), 3);
//        System.out.println("res="+res);
    }
    //需求：合并两个有序的单链表，合并之后的链表依然有序
    public static HeroNode combine(HeroNode node1,HeroNode node2){
        if (node1.next == null && node2.next == null){
            System.out.println("输入的两个链表均为空");
            return null;
        }
        if (node1.next == null){
            return node2;
        }
        if (node2.next == null){
            return node1;
        }
        HeroNode combineHead = new HeroNode(0,"","");
        HeroNode cur = combineHead;
        HeroNode cur1 = node1.next;
        HeroNode cur2 = node2.next;
        while (cur1 !=null && cur2 !=null){
            if (cur1.no <= cur2.no){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 ==null){
            while (cur2 !=null){
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }else {
            while (cur1 !=null){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }
        }

        return combineHead;
    }

    // 单链表逆序打印
    // 思路：
    // 方法1. 先将单链表反转，再逐个打印。但是会破坏单链表原有的结构，不建议！！！
    // 方法2. 可以利用栈数据结构，将各个节点压入栈中，然后利用栈的先入后出的特点实现逆序打印。
    public static void reverseOutput(HeroNode head){
        Stack<HeroNode> stack = new Stack<HeroNode>();
        if (head.next == null){
            return;
        }
        HeroNode cursor = head.next;
        while (cursor != null){
            stack.push(cursor);
            cursor = cursor.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    // 将链表反转
    // 思路：
    //1. 先创建一个新的结点reverseHead = new HeroHead()
    //2. 从头遍历原来的链表，每遍历一个节点，就将其取出放在新链表的最前面
    //3. 将原来链表的头节点指向新链表的头节点的下一个结点head.next = reverseHead.next
    public static void reverseHeroNode(HeroNode head){
        HeroNode reverseHead = new HeroNode(0,"","");
        if (head.next == null){
            return ;
        }
        HeroNode cursor = head.next;
        HeroNode next = null;//指向当前结点的下一个结点
        while (cursor != null){
            next = cursor.next;//先暂时保存当前结点的下一个结点，因为后面需要用
            cursor.next = reverseHead.next;
            reverseHead.next = cursor;
            cursor = next;
        }
        head.next = reverseHead.next;
    }

    // 查找单链表中的倒数第k个结点【新浪面试题】
    // 思路
    //1. 编写一个方法，接收head节点，同时接收一个index
    //2. index 表示的是倒数第index个结点
    //3. 先把链表从头到尾遍历，得到链表的总长度size
    //4. 得到size后，我们从链表的第一个开始遍历(size - index)个就可以得到
    //5. 如果找到则返回该结点，否则返回null
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.next == null){
            return null;//没有找到
        }
        // 第一次遍历得到链表的长度
//        int size = 0;
//        HeroNode cursor = head.next;
//        while (cursor!=null){
//            size++;
//            cursor = cursor.next;
//        }
        int size = getLength(head);
        if (index <=0 || index > size){
            return null;
        }
        HeroNode cursor = head.next;
        for (int i =0;i<(size-index);i++){
            cursor = cursor.next;
        }
        return cursor;
    }

    //方法：获取到单链表节点的个数（如果是带头结点的链表，需要不统计头结点)

    /**
     *
     * @param head 链表的头结点
     * @return 返回的是有效节点的个数
     */
    public static int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        // 定义辅助变量，没有统计头节点
        HeroNode cursor = head.next;
        while (cursor!=null){
            length++;
            cursor = cursor.next;
        }
        return length;
    }

    static class SimpleLinkedListDemo{
        private HeroNode head = new HeroNode(0,"","");

        public HeroNode getHead() {
            return head;
        }

        public void add(HeroNode heroNode){
            HeroNode cursor = head;

            while (true){
                if (cursor.next == null){
                    break;
                }
                cursor = cursor.next;
            }
            cursor.next = heroNode;
        }
        public void addByNo(HeroNode heroNode){
            HeroNode cursor = head;
            boolean flag = false;

            while (true){
                if (cursor.next == null){
                    break;
                }
                if (cursor.next.no>heroNode.no){
                    break;
                }else if (cursor.next.no == heroNode.no){
                    flag = true;
                    break;
                }
                cursor = cursor.next;
            }
            if (!flag){
                heroNode.next = cursor.next;
                cursor.next = heroNode;
            }else {
                System.out.printf("准备插入的英雄编号%d 已经存在了,不能添加\n",heroNode.no);
            }

        }
        // 修改节点的信息，根据no编号来修改
        public void update(HeroNode newHeroNode){
            if (head.next==null){
                System.out.println("链表为空");
                return;
            }
            // 找到需要修改的结点
            HeroNode cursor = head.next;
            // 是否找到该结点标识
            boolean flag = false;
            while (true){
                if (cursor == null){
                    break;
                }
                if (cursor.no == newHeroNode.no){
                    flag = true;
                    break;
                }
                cursor = cursor.next;
            }
            if (flag){
                cursor.name = newHeroNode.name;
                cursor.nickName = newHeroNode.nickName;
            }else {
                System.out.println("没有找到该结点");
            }
        }

        public void delete(int no){
            HeroNode cursor = head;
            boolean flag = false;

            while (true){
                if (cursor.next == null){
                    break;
                }
                if (cursor.next.no == no){
                    flag = true;
                    break;
                }
                cursor = cursor.next;
            }
            if (flag){
                cursor.next = cursor.next.next;
            }else {
                System.out.println("没有找到该结点");
            }
        }

        public void list(){
            if (head.next == null){
                System.out.println("链表为空");
            }
            HeroNode cursor = head.next;

            while (true){
                if (cursor == null){
                    break;
                }
                System.out.println(cursor);
                cursor = cursor.next;
            }
        }

    }

     static class HeroNode{
        private int no;
        private String name;
        private String nickName;
        private HeroNode next;

        public HeroNode(int no,String name,String nickName){
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
}
