package Steps;

import BaseUtil.Base;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class LoginSteps extends Base {
    private Base base;

    public LoginSteps(Base base) {
        this.base = base;
    }

    @Given("^We are at the Login Page of the demo site$")
    public void weAreAtTheLoginPageOfTheDemoSite() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("GIVEN: We are at login Page");
        base.driver.get("http://executeautomation.com/demosite/Login.html");
    }

    @And("^We enter username and password as admin$")
    public void weEnterUsernameAndPasswordAsAdmin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("AND: We are Entering Username and Password");
    }

    @And("^We click on login button$")
    public void weClickOnLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.print("AND: We are clicking Login Button");
        LoginPage page = new LoginPage(base.driver);
        page.submitDetails();
    }

    @Then("^We should reach userform page$")
    public void weShouldReachUserformPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Login is Incorrect", base.driver.findElement(By.name("User Details")).isDisplayed(), true);
        System.out.println("THEN: We are at userform Page");

    }

    @And("^We enter ([^\"]*) and ([^\"]*) as admin$")
    public void weEnterUsernameAndPasswordAsAdmin(String userName, String passWord) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Username is " + userName);
        System.out.println("Password is " + passWord);
    }

    @And("^We enter following as admin$")
    public void weEnterFollowingAsAdmin(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        //Create an ArrayList
        List<User> users = new ArrayList<User>();
        users = table.asList(User.class);
        LoginPage page = new LoginPage(base.driver);
        for (User user : users) {
            page.Login(user.username, user.password);
        }
    }

    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username = userName;
            password = passWord;
        }
    }
}
