/**
 * Created by juny on 2017. 5. 19..
 */
public class Gold extends Customer {
    private int coupons, cash;
    double cashRate;

    Gold(String n, String no, int p, int c, int ca, double cr) {
        super(n, no, p);
        coupons = c; cash = ca; cashRate = cr;
    }

    public int getCoupons() {
        return coupons;
    }

    public void setCoupons(int coupons) {
        this.coupons = coupons;
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
