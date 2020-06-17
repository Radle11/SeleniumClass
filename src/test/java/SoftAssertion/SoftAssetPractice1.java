package SoftAssertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssetPractice1 {
    @Test
    public void test2(){
        Assert.assertEquals(3,4,"test2 The integer number verification");
        Assert.assertTrue("Techtorial".startsWith("Tech"), "test2 Boolean condition verification");
    }
    @Test
    public void test1(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(3,4,"test1 Soft Assert integer");
        softAssert.assertTrue("Techtorial".startsWith("Tech"), "test1 Soft assert string contains");
        softAssert.assertEquals("Tech","Tec","test1 Soft Assert string starts with");
        softAssert.assertAll("test1 Soft Asset Total");
    }
    @Test
    public void test3(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(3,4,"test3 Soft Assert integer");
        softAssert.assertTrue("Techtorial".startsWith("Tech"), "test3 Soft assert string contains");
        softAssert.assertEquals("Tech","Tec","test3 Soft Assert string starts with");
        softAssert.assertAll("Soft Asset Besics");
        //asssertAll() must be at the end of the test annotation
    }
}