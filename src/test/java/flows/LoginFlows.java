package flows;

import config.TestConfig;
import pages.LoginPage;

public class LoginFlows extends TestConfig{

    private LoginPage loginPage = initPageWebElement(LoginPage.class);

    public boolean loginIntoPage(){
        return loginPage.Login();
    }

}
