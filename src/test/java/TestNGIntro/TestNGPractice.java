package TestNGIntro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
    @Test
    public void test1(){
        System.out.println("First Test");
        Assert.assertEquals("Mothers Day","Mothers Day");
        //Assert equals method take two parameters, if these two parameters are equalst to each other
        //your test will pass
        //if hard assertion is failing oncoming line of codes will not be executed and it will throw the exception
        System.out.println("After assertion");
    }
    @Test
    public void test2(){
        System.out.println("Second Test");
        //it will take boolean conditon if the boolean condition is true test will pass, otherwise test will fail
        Assert.assertTrue("Mothers Day".startsWith("Mothers"));
        System.out.println("After second assertion");
    }



}
