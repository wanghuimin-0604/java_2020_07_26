package DesignPattern2;

import DesignPattern.Exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-21
 * Time:11:51
 * 一万年太久，只争朝夕，加油
 */
public class Check {
    //习题数量
    private int count;
    private int right;
    private int wrong;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    //初始化
    public Check() {
        right = 0;
        wrong = 0;
    }

    public void check(Exercise ex, Answer an) {
        count = ex.size();
        int wrong = 0;
        int right = 0;
        ex.setIndex(0);
        an.reset();
        while (ex.hasNext()) {
            if (ex.next().getResult() == an.next()) {
                right++;

            } else {
                wrong++;
            }
        }
        setRight(right);
        setWrong(wrong);
    }

    //批改结果写入到文件中
    public void writeCheckToFile(String fileName) {
        File exFile = new File(fileName);
        Writer out;
        try {
            out = new FileWriter(exFile, true);
            out.write("算式总数:" + count + ";\r\n");
            out.write("正确:" + right + ";\r\n");
            out.write("错误:" + wrong + ";\r\n");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //输出到屏幕上
    public void printCheck() {
        System.out.println("本次练习批改结果：");
        System.out.println("算式总数:" + count);
        System.out.println("正确:" + right);
        System.out.println("错误:" + wrong);
    }
}
