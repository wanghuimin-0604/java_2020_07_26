package DesignPattern5;

import javax.swing.*;
import java.util.Random;
import static DesignPattern5.Define.*;


public class Exercise {
    //随机创建算术题
    public static void CreateRandom(){

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
}
