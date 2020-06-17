package TestNGPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterPractice {
    //we need to give the value from xml runner class
    // if you use parameter annotation you could provide the value inside your runner class
    //@Parameter("name") --->name is the key
    @Parameters("name")
    @Test
    public void test1(String name){
        System.out.println("Name is "+name);
    }


}
