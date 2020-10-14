package tests;

import flows.FlowsInit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login implements FlowsInit {

    @Test
    public void loginIntoApp(){
        Assert.assertTrue(loginFlows.loginIntoPage(),"Login successfully");
    }
}
