package TestNGPractice;

import org.testng.annotations.*;

public class TestNGAnnotationsPractice {
    /*
    in Before Suite
    in Before Test
    in Before Class
    in Before Method
    in Test Case 1
    in After Method
    in Before Method
    in Test Case 2
    in After Method
    in After Class
    in After Test
    in After Suite

     */
    // Test Case 1
    @Test(priority = 2)
    public void testCase1() {
        System.out.println("in Test Case 1");
    }

    // Test Case 2(in case if test2 required to execute before test1. prioritize is used to
    //(prioritise=1)
    @Test(priority = 1,enabled = false)//starts with 1,not 0(using 0 will be redundant)
    public void testCase2() {
        System.out.println("in Test Case 2");
    }
    @Test//if annotations don't have prioritisation, then no priority will run before priority=1
    public void testCase3() {
        System.out.println("in Test Case 2");
    }

    @BeforeMethod//before every test annotation
    public void beforeMethod() {
        System.out.println("in Before Method");
    }

    @AfterMethod//after every test annotation
    public void afterMethod() {
        System.out.println("in After Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("in Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("in After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("in Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("in After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("in Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("in After Suite");
    }
}
