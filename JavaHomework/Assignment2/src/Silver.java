/**
 * Created by juny on 2017. 5. 19..
 */
public class Silver extends Customer {
    private int cash;
    private double cashRate;

    Silver(String n, String no, int p, int c, double cr) {
        super(n, no, p);
        cash = c; cashRate = cr;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public double getCashRate() {
        return cashRate;
    }

    public void setCashRate(double cashRate) {
        this.cashRate = cashRate;
    }

    public void cashBack(int b) {
        cash += (int)(b * cashRate);
    }
}
