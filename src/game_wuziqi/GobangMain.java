package game_wuziqi;

import java.awt.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GobangMain extends JPanel implements Gobang {

    public static void main(String[] args) {

System.out.println();

        GobangMain gm = new GobangMain();
        gm.initUI();
    }

    public void initUI() {
        JFrame frame = new JFrame("wudage");
        frame.setSize(780, 635);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        //更换logo
        Image icon= Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir").replace("/","//")+"\\src\\wu.png");
        frame.setIconImage(icon);
        // 设置棋盘面板的背景颜色
        this.setBackground(Color.LIGHT_GRAY);
        // 将棋盘面板添加到窗体的中间部分
        frame.add(this, BorderLayout.CENTER);

        // 实例化JPanel面板对象，作为东边放置按钮的面板
        JPanel eastPanel = new JPanel();
        // 设置东边面板的布局方式为流式布局居中对齐
        eastPanel.setLayout(new FlowLayout());
        // 设置面板容器组件的宽度和高度
        eastPanel.setPreferredSize(new Dimension(150, 0));

        // 实例化单选按钮分组对象
        ButtonGroup bg = new ButtonGroup();

        // 实例化事件处理类的对象，然后将棋盘面板作为参数传递到GobangListener类的对象中
        GobangListener gl = new GobangListener(this, array);

        // 定义数组，存储组件上要显示的文字信息
        String[] array = {"开始新游戏", "悔棋", "认输", "对战模式：", "人人对战", "人机对战"};
        for (int i = 0; i < array.length; i++) {
            if (i < 3) {
                JButton button = new JButton(array[i]);
                button.setPreferredSize(new Dimension(140, 80));
                eastPanel.add(button);
                button.addActionListener(gl);
            } else if (i == 3) {
                JLabel label = new JLabel(array[i]);
                eastPanel.add(label);
            } else {
                JRadioButton button = new JRadioButton(array[i]);
                button.setSelected(false);
                bg.add(button);
                eastPanel.add(button);
                button.addActionListener(gl);
            }
        }

        // 将eastPanel添加到窗体上的东边
        frame.add(eastPanel, BorderLayout.EAST);
        frame.setVisible(true);
    }


    private MyArrayList<Chess> array = new MyArrayList<Chess>();

    public void paint(Graphics g) {
        super.paint(g);
        // System.out.println(">>>");
        for (int i = 0; i < COLOUM; i++) {
            g.drawLine(X, Y + SIZE * i, X + SIZE * (COLOUM - 1), Y + SIZE * i);// 横线 //格子40
            g.drawLine(X + SIZE * i, Y, X + SIZE * i, Y + SIZE * (COLOUM - 1));// 竖线 //格子40
        }

        for (int i = 0; i < array.getSize(); i++) {
            Chess e = array.get(i);
            g.setColor(e.color);
            g.fillOval(X + e.coloum * SIZE - SIZE / 2, Y + e.row * SIZE - SIZE / 2, SIZE, SIZE);
        }
    }
}