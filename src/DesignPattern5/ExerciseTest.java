package DesignPattern5;
import javafx.scene.control.Labeled;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static DesignPattern4.Count.cint;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:wanghuimin
 * Date:2020-06-18
 * Time:16:01
 * 一万年太久，只争朝夕，加油
 */
public class ExerciseTest {
    Exercise exercise;

    @Before
    public void setUp() {
        exercise=new Exercise();
    }

    @Test
    public void createRandom() {
        Integer left=5;
        Integer right=9;
        char s='+';
        List<String> list = new ArrayList<>();
        list.add((left+s+right)+"");
        Assert.assertEquals("5+9",list.get(0));

    }
}