package DesignPattern2;

import DesignPattern.AddEquation;
import DesignPattern.SubEquation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-21
 * Time:11:30
 * 一万年太久，只争朝夕，加油
 */
public class Answer {
    private ArrayList<Integer> answer;
    private int index;

    public Answer() {
        //初始化
        answer=new ArrayList<Integer>();
        index=0;
    }

    public ArrayList<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<Integer> answer) {
        this.answer = answer;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public void writeAnswerToFile(String fileName){
    File exFile=new File(fileName);
    Writer out=null;
    try{
        out=new FileWriter(exFile,true);
        for(Integer i:answer){
            out.write(i+",");
        }
        out.flush();
        out.close();
    }catch(IOException e){
        e.printStackTrace();
    }finally {
        //out.close();
    }
}
//从文件中读取答案
    public void readAnswerFromFile(String fileName){
        File exFile=new File(fileName);
        String a;
        Scanner in;
        answer.clear();
        try{
            in = new Scanner(exFile);
            in.useDelimiter(",");
            while(in.hasNext()){
                a=in.next().replaceAll("\\s","");
                answer.add(Integer.parseInt(a));
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{

        }
    }
    //从键盘接受用户练习的答案
    public void ScanAnswerFromeKeyboard(int count){
        Scanner sc=new Scanner(System.in);
        answer.clear();
        System.out.println("请按照序号输入答案后回车");
        for(int i=1;i<=count;i++){
            System.out.println("("+i+")");
            answer.add(sc.nextInt());

        }
        sc.close();

    }
    //重置答案
    public void reset(){
        index=0;
    }
    public boolean add(int a){
        return answer.add(a);
    }
    //
    public boolean hasNext(){
        return index<answer.size();
    }
    public int next(){
        if(index<answer.size()){
            return answer.get(index++);
        }else{
            return -1;
        }
    }
    //按照题目序号获取答案
    public int get(int index){
        return answer.get(index);
    }
    //设置答案
    public void set(int inex,int x){
        answer.set(index,x);
    }

}
