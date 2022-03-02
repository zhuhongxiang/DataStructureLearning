package simulations;

public class Averager {
    private int count;
    private double sum;

    public Averager() {
        count = 0;
        sum = 0;
    }

    public void addNumber(double value){
        if (count == Integer.MAX_VALUE){
            throw new IllegalStateException("too many numbers");
        }
        count++;
        sum += value;
    }

    public double average(){
        if (count == 0){
            return Double.NaN;
        }
        return sum / count;
    }

    public int howManyNumbers(){
        return count;
    }

}
