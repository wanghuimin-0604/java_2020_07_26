package DesignPattern;

import DesignPattern2.Answer;
import DesignPattern2.Check;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:用户类
 * User:wanghuimin
 * Date:2020-05-06
 * Time:23:30
 * 一万年太久，只争朝夕，加油
 */
public class Student {
    private static Exercise exercise;
    private Answer answer;
    private Check check;
    private int columms=5;
    private Scanner sc;

    public static Exercise getExercise() {
        return exercise;
    }

    public static void setExercise(Exercise exercise) {
        Student.exercise = exercise;
    }

    public Student() {
        check=new Check();
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public static void main(String[] args) {

        exercise=new Exercise();
        exercise.generateExercise();
        exercise.printExercise();
    }
    private static void printExercise(){
        int i=0;
        while(exercise.hasNext()){
            i++;
            System.out.print("("+i+")"+exercise.next().toString());
            if(i%5==0){
                System.out.println();
            }else{
                System.out.print("\t");
            }
        }
    }
    public void praticeOneByOne(){
        answer=new Answer();
        exercise.setIndex(0);
        int i=1;
        System.out.println("请开始练习");
        while(exercise.hasNext()){
            System.out.println("("+(i++)+")"+exercise.next().toString2());
            answer.add(sc.nextInt()) ;

        }
        check.check(exercise,answer);
        check.printCheck();
    }
}
