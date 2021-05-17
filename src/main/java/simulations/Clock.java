package simulations;

/**
 * 实现类Clcok，以类似9:48 P.M.的形式存储时间
 * @author 术
 */
public class Clock {
    private int hour;
    private int minutes;
    private boolean isMorning;

    /**
     * 无参构造方法，将时间初始化为午夜
     */
    public Clock() {
        hour = 12;
        minutes = 0;
        isMorning = true;
    }

    /**
     * 赋予给定时间
     * @param setHour
     * @param setMinutes
     * @param timeZone
     * @throws IllegalArgumentException
     * 如果输入的小时不是0-12的整数或者输入的分钟不是0-59的整数，则抛出异常IllegalArgumentException
     * @postcondition
     * 设置实例变量为输入的小时，分钟和上下午标识
     */
    public void setTime(int setHour, int setMinutes, boolean timeZone){
        if (1 > setHour  || 12 < setHour){
            throw new IllegalArgumentException("The hour is wrong:"+setHour);
        }
        if (0 > setMinutes || 59 < setMinutes){
            throw new IllegalArgumentException("The minutes is wrong:"+setMinutes);
        }
        hour = setHour;
        minutes = setMinutes;
        isMorning = timeZone;
    }

    /**
     * 将时间提前指定分钟数
     * 如果指定值amount为正数，就将时间提前，如果为负数，就将时间退后。
     * @param amount
     */
    public void advance(int amount){
        final int MINUTES_PER_DAY = 24*60;
        final int MINUTES_PER_HOUR = 60;

        while (amount < 0){
            amount += MINUTES_PER_DAY;
        }
        while (amount > MINUTES_PER_DAY){
            amount -= MINUTES_PER_DAY;
        }

        while (minutes + amount >= 60){
            hour++;
            amount -= MINUTES_PER_HOUR;
            if (hour == 12){
                isMorning = !isMorning;
            }else if(hour == 13){
                hour = 1;
            }
        }

        minutes += amount;
    }

    /**
     * 返回当前的小时
     * @return
     */
    public int getHour(){
        return hour;
    }

    /**
     * 返回当前的分钟
     * @return
     */
    public int getMinutes(){
        return minutes;
    }

    /**
     * 返回是在上午还是下午
     * @return
     */
    public boolean isMorning(){
        return isMorning;
    }

}
