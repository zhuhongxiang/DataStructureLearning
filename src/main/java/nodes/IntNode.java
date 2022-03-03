package nodes;

import java.sql.Statement;

/**
 * 一个IntNode类的对象可用作链表中的一个结点，每个结点都包含整型的数据，链表可以达到任意长度，
 * 仅受堆中空闲内存空间的限制。但是，当链表长度超过Integer.MAX_VALUE时，方法listLength就会因为
 * 算法溢出而不正确
 * @author 术
 */
public class IntNode {
    //结点数据
    private int data;
    //引用结点
    private IntNode link;

    /**
     * 用给定的初始数据和引向下一节点的引用初始化生成结点。
     * 注意：initialLink可以是空引用，表示新结点后没有其他结点
     * @param initialData
     * @param initialLink
     * @postcondition 根据指定的数据和引向下一结点的引用创建生成一个结点
     */
    public IntNode(int initialData, IntNode initialLink){
        data = initialData;
        link = initialLink;
    }

    /**
     * 用于在该结点后增加一个新的结点
     * @param element
     * @postcondition 新节点数据域的值为element,并被放置在当前结点之后，
     * 先前位于当前结点后的所有结点现在都位于新结点之后
     * @throws OutOfMemoryError
     * 表明没有足够的内存来生成一个新的IntNode实例
     */
    public void addNodeAfter(int element){
        link = new IntNode(element,link);
    }

    /**
     *
     * @return 该结点data的值
     */
    public int getData(){
        return data;
    }

    /**
     *
     * @return 引向当前结点后下一结点的引用（如果当前结点后没有结点存在，则返回空引用）
     */
    public IntNode getLink(){
        return link;
    }

    /**
     * 复制链表
     * @param source
     * 引向要复制的链表的头结点的引用
     * @return
     * 创建了从source开始的某个链表的副本。返回值为该副本的头结点的引用。
     * @throws OutOfMemoryError
     */
    public static IntNode listCopy(IntNode source){
        IntNode copyHead;
        IntNode copyTail;

        if (source == null){
            return null;
        }
        copyHead = new IntNode(source.data,null);
        copyTail = copyHead;

        while (source.link != null){
            source = source.link;
            copyTail.addNodeAfter(source.data);
            copyTail = copyTail.link;
        }
        return copyHead;
    }

    /**
     * 复制链表，同时返回引向副本链表头结点和尾结点的引用数组
     * @param source
     * 引向要复制的链表的头结点的引用
     * @return
     * 返回值是一个数组，[0]号元素是引向副本链表头结点的引用，[1]号元素是引向副本链表尾结点的引用
     * @throws OutOfMemoryError
     */
    public static IntNode[] listCopyWithTail(IntNode source){
        IntNode copyHead;
        IntNode copyTail;
        IntNode[] answer = new IntNode[2];

        if (source == null){
            return null;
        }
        copyHead = new IntNode(source.data, null);
        copyTail = copyHead;

        while (source.link != null){
            source = source.link;
            copyTail.addNodeAfter(source.data);
            copyTail = copyTail.link;
        }
        answer[0] = copyHead;
        answer[1] = copyTail;
        return answer;
    }

    /**
     * 计算链表中结点的个数
     * @param head
     * @return 给定链表中结点的个数
     */
    public static int listLength(IntNode head){
        IntNode cursor;
        int count;
        count = 0;
        for (cursor = head;cursor != null;cursor = cursor.link){
            count++;
        }
        return count;
    }

    /**
     * 复制链表的一部分，同时返回引向副本链表头结点和尾结点的引用数组
     * @precondition
     * start和end是非空引用，它们引向同一个链表中的结点，而且start引向的结点在end引向的结点处或之前
     * @param start
     * @param end
     * @return
     * @throws OutOfMemoryError
     * @exception IllegalArgumentException
     */
    public static IntNode[] listPart(IntNode start, IntNode end){
        IntNode copyHead;
        IntNode copyTail;
        IntNode[] answer = new IntNode[2];

        if (start == null){
            throw new IllegalArgumentException("start node is null!");
        }
        if (end == null){
            throw new IllegalArgumentException("end node is null!");
        }
        copyHead = new IntNode(start.data,null);
        copyTail = copyHead;

        while (start != end){
            start = start.link;
            if (start == null){
                throw new IllegalArgumentException("end node is not found");
            }
            copyTail.addNodeAfter(start.data);
            copyTail = copyTail.link;
        }
        answer[0] = copyHead;
        answer[1] = copyTail;
        return answer;
    }

    /**
     * 查找链表中位于指定位置的结点
     * @param head
     * @param position
     * @return
     * 返回引向链表中指定位置的结点的引用。（头结点的位置为1，下一结点的位置为2，以此类推）
     * @throws IllegalArgumentException
     */
    public static IntNode listPosition(IntNode head, int position){
        IntNode cursor;
        int i;
        if (position < 0 ){
            throw new IllegalArgumentException("posiytion is not positive");
        }
        cursor = head;
        for (i = 1; (i < position)&&(cursor!=null);i++){
            cursor = cursor.link;
        }
        return cursor;
    }

    /**
     * 在链表中查找具有某个特定值的结点。
     * @param head
     * @param target
     * @return
     * 返回一个引用，引向包含指定元素的第一个结点。如果不存在，则返回null
     */
    public static IntNode listSearch(IntNode head, int target){
        IntNode cursor;
        for (cursor = head; cursor != null; cursor = cursor.link){
            if (target == cursor.data){
                return cursor;
            }
        }
        return null;
    }

    /**
     * 用于删除当前结点的后一个结点
     * @precondition 该节点不能是链表的尾结点。
     * @postcondition 当前结点后的结点已经从链表中删除
     * @throws NullPointerException
     */
    public void removeNodeAfter(){
        link = link.link;
    }

    /**
     * 用于设置当前结点的data域
     * @param newData
     */
    public void setData(int newData){
        data = newData;
    }

    /**
     * 用于设置当前结点的link域
     * @param newLink
     */
    public void setLink(IntNode newLink){
        link = newLink;
    }

    /**
     * 返回num在链表中出现的次数
     * @param num
     * @param head
     * @return
     */
    public static int countInt(int num,IntNode head){
        int count = 0;
        IntNode cursor;
        for (cursor = head;cursor != null;cursor = cursor.link){
            if (cursor.data == num){
                count ++;
            }
        }
        return count;
    }

    /**
     * 检测是否包含某个整数，包含返回true，不包含返回false
     * @param num
     * @param head
     * @return
     */
    public static boolean hasInt(int num,IntNode head){
        if (countInt(num,head)>0){
            return true;
        }
        return false;
    }

    /**
     * 在链表的尾部添加元素
     * @param num
     * @param head
     */
    public static void tailAddInt(int num,IntNode head){
        IntNode cursor;
        if (head == null){
            head = new IntNode(num,null);
        }else {
            cursor = head;
            while (cursor != null){
                cursor = cursor.link;
            }
            cursor.addNodeAfter(num);
        }
    }
}
