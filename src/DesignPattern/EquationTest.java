package DesignPattern;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class EquationTest {
    AddEquation equation;

    @Before
    public void setUp() {
        equation=new AddEquation();
    }
    public void init(){
        equation.setLeft(44);
        equation.setRight(20);
    }

    @Test
    public void Testcalculate() {
        Assert.assertEquals(64,equation.calculate());
    }
}