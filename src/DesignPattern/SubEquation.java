package DesignPattern;

/**
 * Created with IntelliJ IDEA.
 * Description:减法算式
 * User:wanghuimin
 * Date:2020-05-06
 * Time:22:54
 * 一万年太久，只争朝夕，加油
 */
public class SubEquation extends Equation {
    public SubEquation() {
        generateEquation('-');
    }

    public SubEquation(String s) {
        int index = s.indexOf("-");
        int length = s.length();
        this.setLeft(Integer.parseInt(s.substring(0, index)));
        this.setRight(Integer.parseInt(s.substring(index + 1, length)));
        this.setOp(s.charAt(index));
        this.setRight(calculate());
    }

    @Override
    public int calculate() {

        return this.getLeft() - this.getRight();
    }
}
