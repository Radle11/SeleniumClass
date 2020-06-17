package TestNGPractice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
    @DataProvider(name="fullname")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { "Techtorial"," Academy" ,"Techtorial Academy"},
                { "Shawm"," Achor","Shawm Achor"},
                {"Grand"," Cardone","Grand Cardone"},
                {"Priyanka"," Chopra","Priyanka Chopra"}
        };
    }
    @Test
    public void test1(){
        int a=5;
        int b=6;
        System.out.println(a+b);
        Assert.assertEquals(a+b,11);
    }
    @Test(dataProvider = "fullname")
    public void test2(String firstName, String lastName, String fullName){
        String fname=firstName;
        String lname=lastName;
        String result=firstName+lastName;
        Assert.assertTrue(result.equals(fullName));
    }




}
