/**
 * Created by juny on 2017. 5. 16..
 */
public class Customer {
    private String name, telno;
    private int point;

    Customer() {}
    Customer(String n, String no, int p) {
        name = n; telno = no; point = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void printCustomer() {
        System.out.printf("이름 : " + name + " / 전화번호 : " + telno + " / 보유 포인트 : " + point);
    }

}
