package linkedList;

import javafx.scene.shape.HLineTo;

public class Josepfu {
    public static void main(String[] args) {
        // 测试环形链表创建和遍历是否正确
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoys();

        circleSingleLinkedList.countBoy(1,2,5);

    }
    static class CircleSingleLinkedList{
        // 创建一个first,当前没有编号
        private Boy first = new Boy(-1);
        // 添加小孩节点，构建成一个环形的链表
        public void addBoy(int nums){
            // nums做数值校验
            if (nums < 1){
                System.out.println("nums的值不正确");
                return;
            }
            // 辅助变量
            Boy curBoy = null;
            // 利用for来创建环形链表
            for (int i = 1;i <= nums;i++){
                // 根据编号创建小孩节点
                Boy boy = new Boy(i);
                // 如果是第一个小孩
                if (i == 1){
                    first = boy;
                    first.setNext(first);
                    // 让curBoy指向第一个小孩
                    curBoy = first;
                }
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }

        public void showBoys(){
            if (first == null){
                System.out.println("链表为空");
                return;
            }
            Boy curBoy = first;
            while (true){

                System.out.printf("小孩的编号：%d\n",curBoy.getNo());
                if (curBoy.getNext() == first){
                    break;
                }
                curBoy = curBoy.getNext();
            }
        }

        // 根据用户的输入，计算出小孩出圈的顺序
        /**
         *
         * @param startNo 表示第几个小孩开始数数
         * @param countNum 表示数几下
         * @param nums 表示最初有几个小孩在圈中
         */
        public void countBoy(int startNo,int countNum, int nums){
            // 先对数据进行校验
            if (first == null || startNo <1 || startNo > nums || countNum < 1){
                System.out.println("参数输入有误，请重新输入");
                return;
            }
            Boy helper = first;
            while (true){
                if (helper.getNext()==first){
                    break;
                }
                helper = helper.getNext();
            }
            // 小孩报数前，先让first和helper移动startNo-1次
            for (int i = 0;i < startNo-1;i++){
                first = first.getNext();
                helper = helper.getNext();
            }
            // 当小孩报数时，让first和helper同事移动countNum-1次
            // 这里是一个循环，直到圈中只有一个节点
            while (true){
                if (helper == first){
                    break;
                }
                for (int j = 0;j<countNum-1;j++){
                    first = first.getNext();
                    helper = helper.getNext();
                }
                System.out.printf("小孩%d出圈\n",first.getNo());
                // 小孩出圈
                first = first.getNext();
                helper.setNext(first);
            }
            System.out.printf("最后留在圈中的小孩编号%d \n",helper.getNo());
        }
    }
    // 创建一个Boy类，表示一个节点
    static class Boy {
        private int no;
        private Boy next;

        public Boy(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public Boy getNext() {
            return next;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public void setNext(Boy next) {
            this.next = next;
        }
    }
}
