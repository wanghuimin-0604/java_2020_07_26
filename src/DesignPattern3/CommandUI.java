package DesignPattern3;

import DesignPattern.Exercise;
import DesignPattern.Student;
import DesignPattern2.Parents;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-21
 * Time:13:24
 * 一万年太久，只争朝夕，加油
 */
public class CommandUI {
    static String ui1[] = {"退出", "在线练习", "批量习题", "批改习题", "", "", "", "", ""};
    static String ui2[][] = {{},
            {"返回上一级菜单", "加法", "减法", "混合"},
            {"返回上一级菜单", "加法", "减法", "混合"},
            {}, {}, {}, {}, {}, {}};
    static Scanner sc = new Scanner(System.in);


    public CommandUI() {
    }

    public static void main(String[] args) {
        int command1, command2;
        boolean exit = false;
        while (!exit) {
            print1();
            command1 = sc.nextInt();
            switch (command1) {
                case 1:
                    print2(command1);
                    command2 = sc.nextInt();
                    command1_1(command2);
                    break;
                case 2:
                    print2(command1);
                    command2 = sc.nextInt();
                    command1_2(command2);
                    break;
                case 3:
                    command1_3();
                    break;
                case 0:
                    exit = true;
                    System.out.println("感谢使用本软件，再见");
                default:
                    //


            }

        }
        sc.close();

    }

    //一级菜单
    public static void print1() {
        System.out.println("口算练习..........功能列表");
        for (int i = 1; i < ui1.length; i++) {
            if (ui1[i] != null && ui1[i].length() > 0) {
                System.out.println("" + i + ui1[i]);
            }
        }
        System.out.println("0" + ui1[0]);
        System.out.println("请选择功能序号");
    }

    //二级菜单
    public static void print2(int index) {
        System.out.println("您选择了功能：" + index + ui1[index]);
        if (ui2[index] != null && ui2[index].length > 0) {
            System.out.println("请选择习题类型");
            for (int i = 1; i < ui2[index].length; i++) {
                System.out.println("" + i + ui2[index][i]);
            }
            System.out.println("0" + ui2[index][0]);
        }

    }

    //响应用户命令
    public static void command1_1(int index) {
        int count;
        System.out.println("您选择了" + ui2[1][index]);
        if (index == 0)
            return;
        System.out.println("请输入算式数量");
        count = sc.nextInt();
        Exercise ex = new Exercise(count);
        if (index == 1) {
            ex.generateAddExercise();

        } else if (index == 2) {
            ex.generateSubExercise();
        } else {
            ex.generateExercise();
        }
        Student s = new Student();
        s.setSc(sc);
        s.setExercise(ex);
        s.praticeOneByOne();

    }

    //批量练习
    public static void command1_2(int index) {
            int count, exCount;
            //Scanner sc = new Scanner(System.in);
            System.out.println("您选择了" + index + ui2[2][index]);
            if(index == 0) return;
            System.out.println("请输入算式数量:");
            count = sc.nextInt();
            System.out.println("请输入习题套数:");
            exCount = sc.nextInt();
            Parents p = new Parents(count, exCount);
            if(index == 1){
                p.writeAddExercisesToFiles();
            }
            else if(index == 2){
                p.writeSubExercisesToFiles();
            }
            else{
                p.writeExercisesToFiles();
            }
            System.out.println("***成功批量生成 " + exCount + " 套，每套包含 " + count + " 道" + ui2[1][index] + "算式的习题。***");
            //sc.close();
        }
    //批改系统
    public static void command1_3() {
        Parents p = new Parents();
        p.setSc(sc);
        p.check();

    }

}
