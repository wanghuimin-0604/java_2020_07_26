package DesignPattern;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:算式
 * User:wanghuimin
 * Date:2020-05-06
 * Time:22:26
 * 一万年太久，只争朝夕，加油
 */
public abstract class Equation {
    private final int MAX=100;
    private final int MIN=0;
    private final int COUNT=50;
    private int left;
    private int right;
    private int result;
    private char op;

    public int getLeft() {
        return left;
    }

    public  void setLeft(int left) {
        this.left = left;

    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public Equation() {
    }
    //生成随机数
    private int generateRandom(int min,int max){
        Random r=new Random();
        return r.nextInt(max-min+1)-min;
    }
    //判断运算结果是否合法
    private boolean isBetween(int value, int min, int max) {
        return value >= min && value <= max;
    }
    //定义运算的方法(抽象方法）
    protected abstract  int calculate();
    //判断两个算式是否相等
    public boolean isEquals(Equation e) {
        boolean b = false;
        //如果两个算式的操作符都不一样，那么这两个算是肯定是不一样的
        if (e.getOp() != this.getOp()) {
            b = false;
        } else {
            b = e.getLeft() == this.getLeft() && e.getRight() == this.getRight();
        }
        return b;
    }
    //将算式转换成字符串
    public String toString() {
        return ""+this.getLeft() + (this.getOp()) + this.getRight();
    }
    public String toString2() {
        return toString()+"=";
    }
    public String toString3() {
        return toString2()+ this.getResult();
    }
    //构造算式
    public void generateEquation(char op){
        do{
            left=generateRandom(MIN,MAX);
            right=generateRandom(MIN,MAX);
            result=calculate();
        }while(!isBetween(result,MIN,MAX));
        this.setOp(op);

    }
}
