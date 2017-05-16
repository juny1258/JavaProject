import javax.swing.*;
import java.awt.*;

public class MySwing extends JFrame {

    public MySwing()
    {
        setTitle("My Swing");
        // 종료버튼 옵션 설정
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 화면 크기 설정
        Dimension dimension = new Dimension(200, 80);
        setSize(dimension);
        Point point = new Point(10, 32);
        setLocation(point);

//        frame.setLocationRelativeTo(null);
        setUndecorated(true);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MySwing();
    }
}