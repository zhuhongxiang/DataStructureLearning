package linkedList;

public class DoubleLinkedList {

    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试~~");

        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");
        // 创建一个双线链表
        DoubleLinkedListDemo doubleLinkedListDemo = new DoubleLinkedListDemo();
        doubleLinkedListDemo.add(hero1);
        doubleLinkedListDemo.add(hero2);
        doubleLinkedListDemo.add(hero3);
        doubleLinkedListDemo.add(hero4);

        doubleLinkedListDemo.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedListDemo.update(newHeroNode);
        System.out.println("修改后的链表情况~~");
        doubleLinkedListDemo.list();

        // 删除
        doubleLinkedListDemo.delete(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedListDemo.list();
    }

    static class DoubleLinkedListDemo{
        private HeroNode2 head = new HeroNode2(0,"","");

        public HeroNode2 getHead() {
            return head;
        }
        public void add(HeroNode2 heroNode){
            HeroNode2 cursor = head;

            while (true){
                if (cursor.next == null){
                    break;
                }
                cursor = cursor.next;
            }
            cursor.next = heroNode;
            heroNode.pre = cursor;
        }
        public void addByNo(HeroNode2 heroNode){
            HeroNode2 cursor = head;
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
                heroNode.pre = cursor;
                // 注意如果是最后一个节点的情况
                if (cursor.next != null){
                    cursor.next.pre = heroNode;
                }
                cursor.next = heroNode;
            }else {
                System.out.printf("准备插入的英雄编号%d 已经存在了,不能添加\n",heroNode.no);
            }

        }
        // 修改节点的信息，根据no编号来修改
        public void update(HeroNode2 newHeroNode){
            if (head.next==null){
                System.out.println("链表为空");
                return;
            }
            // 找到需要修改的结点
            HeroNode2 cursor = head.next;
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
            // 判断当前链表是否为空
            if (head.next == null){
                System.out.println("当前链表为空");
                return;
            }
            HeroNode2 cursor = head.next;
            boolean flag = false;

            while (true){
                if (cursor == null){
                    break;
                }
                if (cursor.no == no){
                    flag = true;
                    break;
                }
                cursor = cursor.next;
            }
            if (flag){
                cursor.pre.next = cursor.next;
                // 如果是最后一个节点，就不需要执行下面这句话，否则会出现空指针异常
                if (cursor.next != null){
                    cursor.next.pre = cursor.pre;
                }

            }else {
                System.out.println("没有找到该结点");
            }
        }

        public void list(){
            if (head.next == null){
                System.out.println("链表为空");
            }
            HeroNode2 cursor = head.next;

            while (true){
                if (cursor == null){
                    break;
                }
                System.out.println(cursor);
                cursor = cursor.next;
            }
        }
    }

    static class HeroNode2{
        private int no;
        private String name;
        private String nickName;
        private HeroNode2 next;
        private HeroNode2 pre;

        public HeroNode2(int no,String name,String nickName){
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
}
