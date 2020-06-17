package Tests.com.Sentrifugo.TestData;

import org.testng.annotations.DataProvider;

public class MaritalStatusData {
    @DataProvider(name = "maritalInfo")
    public Object[][] maritalInfo(){
        return new Object[][]{
                {"SS","SSingle","Test test1"},
                {"SW","WWidowed","Test test2"},
                {"SD","DDivorsed","Test test3"},
                {"SM","MMarried","Test test4"},
                {"SC","Ccheated","Test test5"}
        };
    }
}
