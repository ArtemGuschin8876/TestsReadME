package testgooglesearch;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://www.google.com/";
    }
}

