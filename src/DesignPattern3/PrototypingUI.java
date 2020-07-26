package DesignPattern3;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-05-21
 * Time:17:28
 * 一万年太久，只争朝夕，加油
 */
import java.util.Scanner;

public class PrototypingUI {


    public PrototypingUI() {

    }
    public static void main(String[] args) {
        int command, command2;
        int count, exCount;
        boolean noExit = true;
        Scanner sc = new Scanner(System.in);
        while(noExit){
            //主菜单
            System.out.println("***口算练习***");
            System.out.println("***功能列表***");
            System.out.println("1 在线练习");
            System.out.println("2 批量习题");
            System.out.println("3 批改习题");
            System.out.println("4 退出");
            System.out.println("请输入功能序号:");

            command = sc.nextInt();
            //分支结构
            switch(command){
                case 1:
                    System.out.println("您选择了功能1:在线练习");
                    System.out.println("请选择习题类型:");
                    System.out.println("1 加法");
                    System.out.println("2 减法");
                    System.out.println("3 混合");
                    System.out.println("4 返回上一级菜单");
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
                    System.out.println("您选择了功能2:批量习题");
                    System.out.println("请选择习题类型:");
                    System.out.println("1 加法");
                    System.out.println("2 减法");
                    System.out.println("3 混合");
                    System.out.println("4 返回上一级菜单");
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
                    System.out.println("请选择要批改的习题文件:");
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

}
