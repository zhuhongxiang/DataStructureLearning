package simulations;

/**
 * Throttle对象用于模拟控制燃料流量的油门
 * @author 术
 */
public class Throttle {
    //油门的最大刻度
    private int top;
    //油门的当前刻度
    private int position;

    /**
     * 构造一个油门，其刻度数量由参数指定
     * @param size
     * @precondition
     *  size > 0
     * @postcondition
     *  生成的油门被初始化，其关闭点上面的刻度数就是参数指定的值。油门当前处于关闭状态
     * @throws IllegalArgumentException
     *  表明size不是正数
     */
    public Throttle(int size){
        if (size <= 0){
            throw new IllegalArgumentException("size <= 0" + size);
        }
        top = size;
    }

    public Throttle(){
        top = 1;
        position = 0;
    }

    public Throttle(int initTop, int initPosition){
        if (initTop <=0){
            throw new IllegalArgumentException("initTop <= 0:"+initTop);
        }
        if (initPosition < 0){
            throw new IllegalArgumentException("initPosition < 0:"+initPosition);
        }
        if (initPosition > initTop){
            throw new IllegalArgumentException("initPosition is too big:"+initPosition);
        }
        top = initTop;
        position = initPosition;
    }

    /**
     * 获得该油门的当前流量
     * @return 当前流量和最大流量的比例[0,1]
     */
    public double getFlow(){
        return (double) position / (double) top;
    }

    /**
     * 判断油门是否处于打开状态
     * @return
     * 如果油门流量大于0，则返回true，否则返回false
     */
    public boolean isOn(){
        return (getFlow() > 0);
    }

    /**
     * 将油门的位置上移或下移
     * @param amount
     *  上移或下移的幅度（正数表示上移，负数表示下移）
     * @postcondition
     *  油门的位置按照指定幅度进行了调整。如果结果高于最高位置，则停留在最高位置；如果结果小于位置，则停在0位置。
     */
    public void shift(int amount){
        if (amount > top - position){
            position = top;
        }else if(position + amount < 0){
            position = 0;
        }else {
            position += amount;
        }
    }

    /**
     * 关闭该油门
     * @postcondition 该油门已关闭
     */
    public void shutOff(){
        position = 0;
    }
}
