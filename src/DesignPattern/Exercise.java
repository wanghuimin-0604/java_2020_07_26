package DesignPattern;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:构造习题
 * User:wanghuimin
 * Date:2020-05-06
 * Time:23:02
 * 一万年太久，只争朝夕，加油
 */
public class Exercise {
    private int count=50;
    private int index=0;
    private ArrayList<Equation> exercise=null;

    public Exercise() {
        index=0;
        exercise=new ArrayList<Equation>();
    }
    public Exercise(int count){
        this.setCount(count);
        index=0;
        exercise=new ArrayList<Equation>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<Equation> getExercise() {
        return exercise;
    }

    public void setExercise(ArrayList<Equation> exercise) {
        this.exercise = exercise;
    }
    //定义一个方法判断算式是否已经存在
    public boolean occur(Equation e) {
        boolean b = false;
        for (Equation equation:exercise) {
            //如果这个算式出现过
            if (equation.isEquals(e)) {
                b = true;
                break;
            }
        }
        return b;
    }
    //构造习题的方法
    public void generateExercise() {
        int i = 0;
        Random r = new Random();
        while (i < count) {
            Equation e;
            if (r.nextInt(2) == 1) {
                e = new AddEquation();
            } else {
                e = new SubEquation();
            }
            if (!occur(e)) {
                exercise.add(e);
                i++;
            }
        }
    }
     //构造加法习题
     public void generateAddExercise() {
         int i = 0;
         while (i < count) {
             Equation e=new AddEquation();
             if (!occur(e)) {
                 exercise.add(e);
                 i++;
             }
         }
     }
     //减法
     public void generateSubExercise() {
         int i = 0;
         while (i < count) {
             Equation e=new SubEquation();
             if (!occur(e)) {
                 exercise.add(e);
                 i++;
             }
         }
     }
     public void printExercise(){
        int i=0;
        for(Equation e:exercise){
            i++;
            System.out.print("(" + i + ")"+" " + e.toString3());
            if (i % 5 == 0) {
                System.out.println();
            }else{
                System.out.print("\t");
            }
        }
     }
     public boolean hasNext(){
        return index<exercise.size();
     }
     public Equation next(){
        if(index<exercise.size()){
            return exercise.get(index++);
        }else{
            return null;
        }
     }
     public boolean add(Equation e){
        if(index<count){
            exercise.add(e);
            index++;
            return true;
        }else{
            return false;
        }
     }
     public int size(){
        return exercise.size();
     }
}
