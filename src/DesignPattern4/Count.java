package DesignPattern4;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-06-03
 * Time:12:10
 * 一万年太久，只争朝夕，加油
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//继承JFrame类来创建窗体
public class Count extends JFrame {
    public static int a,b,cint;//创建题目的两个随机整数a和b以及用0~1随机数来表示的算术运算符c
    public static String c = null;//以及算术运算符c(以字符串形式表示)
   //JPanel是java图形用户界面工具包Swing中的面板控制容器，可以加入到JFrame窗体中
    //把组件添加到Jpanel之类的中间容器中，用setContentPane()方法把该容器置为JFrame的内容面板：
    public static  JPanel Countpanel;//创建计算面板
    public JPanel Buttonpanel;//创建按钮及结果面板
    public static JButton Clearbutton;//创建清空按钮
    public static JButton Resetbutton;//创建重置按钮
    public static JButton Printfbutton;//创建提交按钮
     //创建标签
     public static JTextField CountLable;//创建正确率(标签),正确率在标签中呈现
    public static JTextField CountRight;
    public static JTextField CountWrong;
    //定义三个标签组件，用来标记正确数、错误数、正确率
    public static JLabel RightNum;
    public static JLabel WrongNum;
    public static JLabel Accuracy;




    //数据结构
    public static List<Integer> userlist = new ArrayList<>();//创建存储用户计算结果的集合
    public static List<JLabel> list = new ArrayList<>();//创建题目(标签)集合,题目在标签中呈现
    public static List<JTextField> list1 = new ArrayList<>();//创建用户输入计算结果的文本框集合
    public static List<Integer> list2 = new ArrayList<>();//创建所有题目正确答案集合

    public static int num ;//设置用户答对的题数
    public static int num2;//设置用户答错的题数

    public static int j=0;
    public static int k=0;
    public static int i=0;



    public Count() {

        //初始化按钮
        Clearbutton = new JButton("清空");
        Resetbutton = new JButton("重置");
        Printfbutton = new JButton("提交");


        //设置按钮大小
        Clearbutton.setSize(200, 300);
        Resetbutton.setSize(200, 300);
        Printfbutton.setSize(200, 300);

        //初始化计数面板
        //setLayout设置用户界面上的屏幕组件的格式布局，是java图形界面编程的常用方法。默认为流式布局
        Countpanel = new JPanel();
        Countpanel.setLayout(new GridLayout(10, 10));


        //初始化按钮面板（清空按钮）
        Buttonpanel = new JPanel();
        Buttonpanel.setLayout(new FlowLayout());
        Buttonpanel.setSize(500, 400);
        Buttonpanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        JTextArea jTextArea = new JTextArea("小学生100以内加减法混合运算在线练习");
        Buttonpanel.add(Clearbutton);

        //JLable(标签组件）
        //显示正确率
        Accuracy = new JLabel("正确率");
        int width=20,height=20;
        ImageIcon image=new ImageIcon("D:\\c8209c6678894297b30c8af298054196.jpeg");
        Image img=image.getImage();
        img=img.getScaledInstance(width,height,Image.SCALE_AREA_AVERAGING);
        image.setImage(img);
        Accuracy.setIcon(image);
        Accuracy.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        //显示正确的题目数量
        RightNum = new JLabel("正确题数");
        ImageIcon image1=new ImageIcon("D:\\28799234_185836035500_2.jpg");
        Image img1=image1.getImage();
        img1=img1.getScaledInstance(width,height,Image.SCALE_AREA_AVERAGING);
        image1.setImage(img1);
        RightNum.setIcon(image1);
        RightNum.setBorder(BorderFactory.createLineBorder(Color.RED));
        //显示错误的题目数量
        WrongNum = new JLabel("错误题数");
        ImageIcon image2=new ImageIcon("D:\\5d259497c55f24abba7890ceb91c350baebd.png");
        Image img2=image2.getImage();
        img2=img2.getScaledInstance(width,height,Image.SCALE_AREA_AVERAGING);
        image2.setImage(img2);
        WrongNum.setIcon(image2);
        WrongNum.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        //将按钮添加至结果面板中
        Buttonpanel.add(Resetbutton);
        Buttonpanel.add(Printfbutton);

        //将标签组件添加到结果面板中

        Buttonpanel.add(RightNum);
        Buttonpanel.add(WrongNum);
        Buttonpanel.add(Accuracy);



        //设置窗体属性
        setLayout(new BorderLayout());
        setBounds(100, 100, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        //将计数面板,按钮面板放置在容器中指定位置
        jTextArea.setFont(new Font("宋体", Font.BOLD, 40));
        container.add(jTextArea, BorderLayout.NORTH);
        container.add(Countpanel, BorderLayout.CENTER);
        container.add(Buttonpanel, BorderLayout.SOUTH);
    }


    public static void main(String[] args) {
        //setVisible()方法是设置窗体可见
        new Count().setVisible(true);
        CountLable();
    }

    //设置CountPanel面板中的组件
    public static void CountLable(){
        for(i=0;i<50;i++){
            JLabel label = new JLabel();
            //重点:在设置布局的条件下,调用setPreferredSize(new Dimension(80, 20))可以设置标签的大小
            //重点:而不能调用setsize()方法
            label.setPreferredSize(new Dimension(70, 25));
            label.setFont(new Font("宋体",Font.BOLD, 25));
            label.setBorder(BorderFactory.createLineBorder(Color.ORANGE));//设置标签的边界
            list.add(label);//list为题目(标签)集合,题目在标签中呈现
            JTextField textField = new JTextField(5);
            textField.setFont(new Font("",Font.PLAIN,25));
            list1.add(textField);//list1为用户输入计算结果的文本框集合
        }
        for(i = 0;i<100;i++){//利用if-else语句来间隔输出标签和文本框
            if(i%2 == 0){//如果余数为0,则添加标签
                Countpanel.add(list.get(j));
                j++;
            }else{//如果余数为1,则添加文本框
                Countpanel.add(list1.get(k));
                k++;
            }

        }
        CreateRandom();//调用创建随机题目的方法CreateRandom();
        myAddActionLIstener();//调用按钮的动作监听方法myAddActionLIstener()
    }
    //随机创建算术题
    public static void CreateRandom(){
        //int a,b,cint;
        //String c = null;
        Random random = new Random();
        for(JLabel lable:list){//list为题目(标签)集合,题目在标签中呈现
            a = random.nextInt(101);
            b = random.nextInt(101);
            cint = random.nextInt(2);
            switch (cint) {
                case 0:
                    c = "+";
                    RandomRange();//创建规定算数题范围函数,即和不大于100,差不小于0
                    lable.setText(a+c+b);
                    list2.add(a+b);//list2为所有题目正确答案的集合
                    break;
                default:
                    c = "-";
                    RandomRange();//创建规定算数题范围函数,即和不大于100,差不小于0
                    lable.setText(a+c+b);
                    list2.add(a-b);//list2为所有题目正确答案的集合
                    break;
            }
        }
    }
    //判断：如果得数正确，那么设置文本框颜色为红色
    //如果不正确，那么设置文本框颜色为蓝色
    public static void RandomRange(){//创建规定算数题范围函数,即和不大于100,差不小于0
        Random r = new Random();
        switch (c) {
            case "+":
                while(a+b>100){
                    a = r.nextInt(101);
                    b = r.nextInt(101);
                    if(a + b <= 100){

                    }
                }
                break;
            default:
                while(a-b<0){
                    a = r.nextInt(101);
                    b = r.nextInt(101);
                    if(a - b >= 0){
                        break;
                    }
                }
                break;
        }
    }
    //为按钮添加动作监听方法
    public static void myAddActionLIstener() {
        //为清空按钮添加动作监听
        Clearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                for(JLabel clearlable:list){
                    clearlable.setText("");
                }
                for(JTextField cleartextField : list1){
                    cleartextField.setText("");
                    cleartextField.setBackground(Color.WHITE);
                }
            }
        });
        //为重置按钮添加动作监听
        Resetbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                CreateRandom();
                for(JTextField cleartextField : list1){
                    cleartextField.setText(" ");
                    cleartextField.setBackground(Color.WHITE);
                }
            }
        });
        //为打印按钮添加监听
        Printfbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Integer i;
                Double result;
                num = 0;
                //获取用户在文本框中输入的计算结果
                for(i = 0;i<list1.size();i++){//list为用户输入计算结果的文本框集合
                    //Integer.parseInt()方法用于将字符串转换成数字
                    userlist.add(Integer.parseInt(list1.get(i).getText()));
                }
                //计算用户做对的题
                // 目个数
                for(i = 0;i<userlist.size();i++){
                    if(userlist.get(i) == list2.get(i)){//list2为所有题目正确答案的集合
                        num++;                    //num为用户计算正确的个数
                        //并且设置文本框颜色
                        list1.get(i).setBackground(Color.GREEN);
                    }
                }

               //计算用户做错的题目个数
                for(i = 0;i<userlist.size();i++){
                    if(userlist.get(i) != list2.get(i)){//list2为所有题目正确答案的集合
                        num2++;//num2为用户计算错误的个数
                        //并设置文本框颜色
                        list1.get(i).setBackground(Color.RED);

                    }
                }

                //计算正确的数目
                RightNum.setText(num+"");
                //计算用户错误的题目数量
                WrongNum.setText(num2+"");
                /*//计算用户没有做的题目数量
                CountNo.setText(num3+" ");*/
                //计算用户做题的正确率
                result = ((num*1.0)/(list.size())*100);
                Accuracy.setText(result + "%");
            }
        });
    }
}

