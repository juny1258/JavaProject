import java.util.ArrayList;
import java.util.Scanner;

public class CustManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();

        char menu;
        double silver_CB = 0.05, gold_CB = 0.1;

        System.out.println("---------------------------");
        System.out.println("      [고객 관리 프로그램]");
        System.out.println("---------------------------");
        System.out.println("1. 회원등록");
        System.out.println("2. 회원검색");
        System.out.println("3. 회원삭제");
        System.out.println("4. 회원목록");
        System.out.println("5. 포인트 추가");
        System.out.println("6. 캐쉬백 비율조정");
        System.out.println("7. 종료");
        System.out.println("-----------------------------");


        while(true) {
            boolean foundNo = false;
            System.out.printf("메뉴선택 : ");
            menu = scanner.next().charAt(0);
            if(menu == '1') {
                String name, telno;
                int point;
                System.out.printf("이름 : ");
                name = scanner.next();
                System.out.printf("전화번호 : ");
                telno = scanner.next();
                System.out.printf("포인트 : ");
                point = scanner.nextInt();
                if (point < 20000) {
                    customers.add(new Bronze(name, telno, point, 1));
                } else if (20000 <= point && point < 100000) {
                    customers.add(new Silver(name, telno, point, 5000, silver_CB));
                } else if (point >= 100000) {
                    customers.add(new Gold(name, telno, point, 1, 10000, gold_CB));
                } else System.out.println("잘못된 입력값입니다.");
            } else if(menu == '2') {
                String n;
                System.out.printf("전화번호 : ");
                n = scanner.next();
                for (Customer customer : customers) {
                    if (customer.getTelno().equals(n)) {
                        customer.printCustomer(); System.out.println();
                        foundNo = true;
                        break;
                    }
                }
                if(!foundNo)
                    System.out.println("일치하는 고객이 없습니다.");
            } else if(menu == '3') {
                String no;
                System.out.printf("전화번호 : ");
                no = scanner.next();
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).getTelno().equals(no)) {
                        customers.remove(i);
                        System.out.println("삭제되었습니다");
                        foundNo = true;
                    }
                }
                if(!foundNo) System.out.println("일치하는 고객이 없습니다.");
            } else if(menu == '4') {
                for (Customer customer : customers) {
                    customer.printCustomer();
                    if(customer instanceof Bronze)
                        System.out.println(" / 보유쿠폰 : " + ((Bronze) customer).getCoupons() + " / 등급 : 브론즈");
                    else if(customer instanceof Silver)
                        System.out.println(" / 보유캐시 : " + ((Silver) customer).getCash()
                                + "원 / 캐시백 : " + (int)(((Silver) customer).getCashRate()*100) +  "% / 등급 : 실버");
                    else if(customer instanceof Gold)
                        System.out.println(" / 보유쿠폰 : " + ((Gold) customer).getCoupons() + "개 / 보유캐시 : "
                                + ((Gold) customer).getCash() + "원 / 캐시백 : " + (int)(((Gold) customer).getCashRate()*100)
                                +  "% / 등급 : 골드");
                }
            } else if(menu == '5') {
                int buy;
                String no;
                System.out.printf("구매금액 : ");
                buy = scanner.nextInt();
                System.out.printf("전화번호 : ");
                no = scanner.next();
                for (int i=0; i<customers.size(); i++) {
                    if(customers.get(i).getTelno().equals(no)) {

                        customers.get(i).setPoint(customers.get(i).getPoint() + (int)(buy * 0.02));
                        if (customers.get(i) instanceof Bronze) {
                            if(customers.get(i).getPoint() >= 20000) {
                                customers.add(i, new Silver(customers.get(i).getName(), customers.get(i).getTelno(),
                                        customers.get(i).getPoint(), 5000, silver_CB));
                                customers.remove(i+1);
                            }
                        } else if (customers.get(i) instanceof Silver) {
                            ((Silver) customers.get(i)).cashBack(buy);
                            if(customers.get(i).getPoint() >= 100000) {
                                customers.add(i, new Gold(customers.get(i).getName(), customers.get(i).getTelno(),
                                        customers.get(i).getPoint(), 1, 10000, gold_CB));
                                customers.remove(i+1);
                            }
                        } else if(customers.get(i) instanceof Gold) {
                            ((Gold) customers.get(i)).cashBack(buy);
                        }
                        System.out.println("적립되었습니다.");
                        foundNo = true;
                    } else if(customers.size()-1 == i && !foundNo)
                        System.out.println("일치하는 전화번호가 없습니다");
                }
            } else if(menu == '6') {
                int m;
                double r;
                System.out.println("--------캐시백 비율 조정--------");
                System.out.printf("1.실버비율 , 2.골드비율 : ");
                m = scanner.nextInt();
                if(m == 1) {
                    System.out.printf("비율 : ");
                    r = scanner.nextDouble();
                    for (Customer customer : customers) {
                        if(customer instanceof Silver) {
                            silver_CB = r;
                            ((Silver) customer).setCashRate(r);
                        }
                    }
                } else if(m == 2) {
                    System.out.printf("비율 : ");
                    r = scanner.nextDouble();
                    for (Customer customer : customers) {
                        if(customer instanceof Gold) {
                            gold_CB = r;
                            ((Gold) customer).setCashRate(r);
                        }
                    }
                } else System.out.println("잘못된 입력값입니다.");
            } else if(menu == '7') {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else System.out.println("잘못된 입력값입니다.");
        }
    }

}
