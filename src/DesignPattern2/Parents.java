package DesignPattern2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-21
 * Time:17:24
 * 一万年太久，只争朝夕，加油
 */

import DesignPattern.Exercise;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;
public class Parents {
    private String path;
    private String[] fileName;
    private int count;
    private int n;
    private Scanner sc;
    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    private ExerciseFileDAO eDAO;

    /**
     *
     */
    public Parents() {
        path = "D:\\csv";
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        eDAO = new ExerciseFileDAO();
    }

    public Parents(int count, int n){
        this();
        this.count = count;
        this.n = n;
    }

    public void writeExercisesToFiles(){
        Exercise ex = new Exercise(count);

        for(int i = 0; i < n; i++){
            String fileName = "D:\\csv/exercise_mix_" + count + "_" + i + ".txt";
            ex.generateExercise();
            eDAO.writeExerciseToFile(ex, fileName);
        }
    }

    public void writeAddExercisesToFiles(){
        Exercise ex = new Exercise(count);

        for(int i = 0; i < n; i++){
            String fileName = "D:\\csv/exercise_add_" + count + "_" + i + ".txt";
            ex.generateAddExercise();
            eDAO.writeExerciseToFile(ex, fileName);
        }
    }

    public void writeSubExercisesToFiles(){
        Exercise ex = new Exercise(count);

        for(int i = 0; i < n; i++){
            String fileName = "D:\\csv/exercise_sub_" + count + "_" + i + ".txt";
            ex.generateSubExercise();
            eDAO.writeExerciseToFile(ex, fileName);
        }
    }
    //设置文件名称
    public void setFileName(){
        File file = new File(path);
        FileFilter filter = new FileFilter();
        fileName = file.list(filter);
    }

    public void check(){
        setFileName();
        int i = 1;
        if(fileName.length <= 0){
            System.out.println("******没有需要批改的习题！******");
            return;
        }
        for(String s: fileName){
            System.out.println(i++ + ": " + s);
        }
        System.out.println("******请选择需要批改的习题序号，回车继续******");
        //Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        //sc.close();
        Exercise exercise = new Exercise(0);
        exercise = eDAO.readExerciseFromFile(path + fileName[index - 1]);
        Answer answer = new Answer();

        //answer.scanAnswerFromKeyboard(exercise.size());
        int n = exercise.size();
        System.out.println("******请根据序号提示依次输入答案后回车******");
        for(i = 0; i < n; i++){
            System.out.print("(" + (i + 1) + ")");
            answer.add(sc.nextInt());
        }

        //sc.close();

        answer.writeAnswerToFile(path + fileName[index - 1].replaceAll("exercise", "answer"));
        Check check = new Check();
        check.check(exercise, answer);
        check.writeCheckToFile(path + fileName[index - 1].replaceAll("exercise", "check"));
        check.printCheck();
    }

    class FileFilter implements FilenameFilter{
        //private String type;
        public FileFilter(){
            //this.type = type;
        }

        public boolean accept(File dir, String name){
            return name.matches("[e][x][e][r][c][i][s][e]\\w*[.][c][s][v]");
        }
    }

}
