package DesignPattern2;

import DesignPattern.AddEquation;
import DesignPattern.Equation;
import DesignPattern.Exercise;
import DesignPattern.SubEquation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-21
 * Time:11:03
 * 一万年太久，只争朝夕，加油
 */
public class ExerciseFileDAO {


    public ExerciseFileDAO() {
    }
    //写文件
    public void writeExerciseToFile(Exercise e, String fileName){
        File exFile=new File(fileName);
        Writer out;
        Equation equation;
        try{
            out = new FileWriter(exFile,true);
            /*for(int i=0;i<e.getCount();i++){
                equation = e.getExercise().get(i);
                out.write(equation.toString()+".");

            }*/
            while(e.hasNext()){
                out.write(e.next().toString()+"= ");
            }
            out.close();

        }catch(IOException ex){
            System.out.println("ERROR"+ex);
        }

    }
    //读文件
    public Exercise readExerciseFromFile(String fileName){
        File exFile=new File(fileName);
        Exercise exercise=new Exercise();
        String  equation;
        Scanner in=null;
        try{
            in = new Scanner(exFile);
            in.useDelimiter(",");
            while(in.hasNext()){
                equation=in.next().replaceAll("\\s","");
                if(equation.contains("+")){
                    exercise.add(new AddEquation(equation));
                }else{
                    exercise.add(new SubEquation(equation));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            in.close();
        }
    return exercise;
    }
}
