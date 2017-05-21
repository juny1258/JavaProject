/**
 * Created by juny on 2017. 5. 19..
 */
public class Bronze extends Customer {
    private int coupons;

    Bronze(String n, String no, int p, int c) {
        super(n, no, p); coupons = c;
    }

    public int getCoupons() {
        return coupons;
    }

    public void setCoupons(int coupons) {
        this.coupons = coupons;
    }
}
