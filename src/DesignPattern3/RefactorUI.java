package DesignPattern3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-21
 * Time:17:29
 * 一万年太久，只争朝夕，加油
 */
import java.util.Scanner;

public class RefactorUI {
    static String ui1[] = {"1 在线练习","2 批量习题","3 批改习题","4 退出","","","","",""};
    static String ui2[][] = {
            {"1 加法","2 减法","3 混合","4 返回上一级菜单"},
            {"1 加法","2 减法","3 混合","4 返回上一级菜单"},
            {},{},{},{},{},{},{}
    };
    public RefactorUI() {
    }
    public static void main(String[] args) {
        int command, command2;
        int count, exCount;
        boolean noExit = true;
        Scanner sc = new Scanner(System.in);
        while(noExit){
            //主菜单

            print1();


            command = sc.nextInt();
            //分支结构
            switch(command){
                case 1:
                    print2(command-1);
                    command2 = sc.nextInt();
                    switch(command2){
                        case 1:
                            System.out.println("您选择了1:加法习题");
                            System.out.println("请输入算式数量:");
                            count = sc.nextInt();
                            System.out.println("实现"+count+"道算式在线练习");
                            //continue;
                            break;
                        case 2:
                            System.out.println("您选择了2:减法习题");
                            System.out.println("请输入算式数量:");
                            count = sc.nextInt();
                            System.out.println("实现"+count+"道算式在线练习");
                            //continue;
                            break;
                        case 3:
                            System.out.println("您选择了3:混合习题");
                            System.out.println("请输入算式数量:");
                            count = sc.nextInt();
                            System.out.println("实现"+count+"道算式在线练习");
                            //continue;
                            break;
                        case 4:
                            //continue;
                            break;
                        default:
                    }
                    break;
                case 2:
                    print2(command-1);
                    command2 = sc.nextInt();
                    switch(command2){
                        case 1:
                            System.out.println("您选择了1:加法习题");
                            System.out.println("请输入算式数量:");
                            count = sc.nextInt();
                            System.out.println("请输入习题套数:");
                            exCount = sc.nextInt();
                            System.out.println("实现"+exCount+"套包含"+count+"道算式批量练习");
                            //continue;
                            break;
                        case 2:
                            System.out.println("您选择了2:减法习题");
                            System.out.println("请输入算式数量:");
                            count = sc.nextInt();
                            System.out.println("请输入习题套数:");
                            exCount = sc.nextInt();
                            System.out.println("实现"+exCount+"套包含"+count+"道算式批量练习");
                            //continue;
                            break;
                        case 3:
                            System.out.println("您选择了3:混合习题");
                            System.out.println("请输入算式数量:");
                            count = sc.nextInt();
                            System.out.println("请输入习题套数:");
                            exCount = sc.nextInt();
                            System.out.println("实现"+exCount+"套包含"+count+"道算式批量练习");
                            //continue;
                            break;
                        case 4:
                            //continue;
                            break;
                        default:
                    }
                    break;
                case 3:
                    print2(command-1);
                    //continue;
                    break;
                case 4:
                    noExit = false;
                    break;
                default:
            }
        }
        sc.close();
    }

    public static void print1(){
        System.out.println("***口算练习***");
        System.out.println("***功能列表***");
        for(int i = 0; i < ui1.length; i++){
            if(ui1[i] != null && ui1[i].length() > 0){
                System.out.println(ui1[i]);
            }
        }
        System.out.println("请输入功能序号:");
    }

    public static void print2(int index){
        System.out.println("您选择了功能"+ui1[index]);
        if(ui2[index] != null && ui2[index].length > 0){

            System.out.println("请选择习题类型:");

            for(int i = 0; i < ui2[index].length; i++){
                //
                System.out.println(ui2[index][i]);
            }
        }
    }

}

