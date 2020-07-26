package DesignPattern5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static DesignPattern5.Define.*;
import static DesignPattern5.Exercise.CreateRandom;
public class Action {
    public static void myAddActionLIstener() {
        //为清空按钮添加动作监听
        Clearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                for (JLabel clearlable : list) {
                    clearlable.setText("");
                }
                for (JTextField cleartextField : list1) {
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
                for (JTextField cleartextField : list1) {
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
                for (i = 0; i < list1.size(); i++) {//list为用户输入计算结果的文本框集合
                    //Integer.parseInt()方法用于将字符串转换成数字
                    userlist.add(Integer.parseInt(list1.get(i).getText()));
                }
                //计算用户做对的题
                // 目个数
                for (i = 0; i < userlist.size(); i++) {
                    if (userlist.get(i) == list2.get(i)) {//list2为所有题目正确答案的集合
                        num++;                    //num为用户计算正确的个数
                        //并且设置文本框颜色
                        list1.get(i).setBackground(Color.GREEN);
                    }
                }

                //计算用户做错的题目个数
                for (i = 0; i < userlist.size(); i++) {
                    if (userlist.get(i) != list2.get(i)) {//list2为所有题目正确答案的集合
                        num2++;//num2为用户计算错误的个数
                        //并设置文本框颜色
                        list1.get(i).setBackground(Color.RED);
                    }
                }

                //计算正确的数目
                RightNum.setText(num + "");
                //计算用户错误的题目数量
                WrongNum.setText(num2 + "");
                /*//计算用户没有做的题目数量
                CountNo.setText(num3+" ");*/
                //计算用户做题的正确率
                result = ((num * 1.0) / (list.size()) * 100);
                Accuracy.setText(result + "%");
            }
        });
    }
}
