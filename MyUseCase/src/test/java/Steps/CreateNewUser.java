package Steps;


import Base.BaseUtile;

import Pages.PageObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Created by smrabet on 08/12/2017.
 */
public class CreateNewUser  extends BaseUtile {

    private BaseUtile base;



    public CreateNewUser(BaseUtile base) {
        this.base = base;
        this.driver = base.driver;

    }



    @Given("^There is a user created with the name ([^\\\"]*)$")
    public void thereIsAUserCreatedWithTheNameName(String Name) throws Throwable {
        PageObject PO = new PageObject(driver);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PageObject.AllUsersButton)));
        PO.AllUsers.click();
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + Name + "')]"));
        Assert.assertTrue(list.size() == 1);

    }

    @When("^I create a user with the existing ([^\\\"]*)$")
    public void iCreateAUserWithTheExistingName(String Name) throws Throwable {

        //************* Navigate to Adding New User Form *********************************************
        base.driver.navigate().to("http://85.93.17.135:9000");

        PageObject PO = new PageObject(driver);
        //************** I'm in the registrationForm page ********************************************
        Assert.assertTrue(driver.getTitle().equals("New User"));
        //*************  Input alla fields ************************************************************
        PO.UserName.sendKeys(Name);
        PO.UserEmail.sendKeys(Name+"@test.com");
        PO.UserPassword.sendKeys("password");
        PO.UserconfirmationPassword.sendKeys("password");
        //************** Submit ************************************************************************
        PO.SubmitButtonForum.click();
    }



    @Then("^the system displays an error msg indicating that this user exists$")
    public void theSystemDisplaysAnErrorMsgIndicatingThatThisUserExists() throws Throwable {
        PageObject PO = new PageObject(driver);
        //  ******************* Verify that the error message displays ************************
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""+PO.TextErrorName)));
        Assert.assertTrue(PO.TextErrorName.getText().contains("Must be unique"));
        System.out.println("Error message appears");

    }

    @And("^the user ([^\\\"]*) is not created$")
    public void theUserNameIsNotCreated(String Name) throws Throwable {
        PageObject PO = new PageObject(driver);
        // ******************* Listing all users **************************************
        PO.AllUsers.click();
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + Name + "')]"));
        Assert.assertTrue(list.size() == 1);
    }

    @When("^I create a user without a name$")
    public void iCreateAUserWithoutAName() throws Throwable {
        PageObject PO = new PageObject(driver);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PageObject.SubmitButton)));
        Assert.assertTrue(driver.getTitle().equals("New User"));
        PO.UserName.sendKeys("");
        PO.UserEmail.sendKeys("Name@test.com");
        PO.UserPassword.sendKeys("password");
        PO.UserconfirmationPassword.sendKeys("password");
        PO.SubmitButtonForum.click();
      }




    @Given("^There is a no user created with the name ([^\\\"]*) or ([^\\\"]*)$")
    public void thereIsANoUserCreatedWithTheNameNameOrEmail(String Name, String Email) throws Throwable {
        PageObject PO = new PageObject(driver);
        // ******************* Listing all users **************************************
        PO.AllUsers.click();
        List<WebElement> listName = driver.findElements(By.xpath("//*[contains(text(),'" + Name + "')]"));
        Assert.assertTrue(listName.size() == 0);
        List<WebElement> listEmail = driver.findElements(By.xpath("//*[contains(text(),'" + Email + "')]"));
        Assert.assertTrue(listEmail.size() == 0);

    }

    @When("^I create a user with valid ([^\\\"]*) ([^\\\"]*) and ([^\\\"]*)$")
    public void iCreateAUserWithValidNameEmailAndPassword(String Name,String Email, String Password) throws Throwable {

        PageObject PO = new PageObject(driver);
        //************** I'm in the registrationForm page ********************************************
        Assert.assertTrue(driver.getTitle().equals("New User"));
        //*************  Input all fields ************************************************************
        PO.UserName.sendKeys(Name);
        PO.UserEmail.sendKeys(Email);
        PO.UserPassword.sendKeys(Password);
        PO.UserconfirmationPassword.sendKeys(Password);
        //************** Submit ************************************************************************
        PO.SubmitButtonForum.click();
    }

    @Then("^the system displays Success message of creating new user$")
    public void theSystemDisplaysSuccessMessageOfCreatingNewUser() throws Throwable {
        PageObject PO = new PageObject(driver);
        //  ******************* Verify that the error message displays ************************
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""+PO.TextSucessMsg)));
        Assert.assertTrue(PO.TextErrorName.getText().contains("New User is created"));
        System.out.println("Success message appears");
    }

    @And("^the user ([^\\\"]*) is created$")
    public void theUserNameIsCreated(String Name) throws Throwable {
        //************* Navigate to All users *********************************************
        base.driver.navigate().to("http://85.93.17.135:9000/user/all");

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + Name + "')]"));
        Assert.assertTrue(list.size() > 1);

    }

    @Given("^There is a user created with the email ([^\\\"]*)$")
    public void thereIsAUserCreatedWithTheEmailEmail(String Email) throws Throwable {
        base.driver.navigate().to("http://85.93.17.135:9000/user/all");

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + Email + "')]"));
        Assert.assertTrue(list.size() > 1);


    }

    @When("^I create a user ([^\\\"]*) with the existing ([^\\\"]*)$")
    public void iCreateAUserNameWithTheExistingEmail(String Name, String Email) throws Throwable {

        //************* Navigate to Adding New User Form *********************************************
        base.driver.navigate().to("http://85.93.17.135:9000");

        PageObject PO = new PageObject(driver);
        //************** I'm in the registrationForm page ********************************************
        Assert.assertTrue(driver.getTitle().equals("New User"));
        //*************  Input all fields ************************************************************
        PO.UserName.sendKeys(Name);
        PO.UserEmail.sendKeys(Email);
        PO.UserPassword.sendKeys("password");
        PO.UserconfirmationPassword.sendKeys("password");
        //************** Submit ************************************************************************
        PO.SubmitButtonForum.click();

    }

    @Then("^the system displays an error msg indicating that this email exists$")
    public void theSystemDisplaysAnErrorMsgIndicatingThatThisEmailExists() throws Throwable {

        PageObject PO = new PageObject(driver);
        //  ******************* Verify that the error message displays ************************
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""+PO.TextErrorEmail)));
        Assert.assertTrue(PO.TextErrorEmail.getText().contains("Must be unique"));
        System.out.println("Error message appears");

    }

    @Given("^I'm in the registration Forum$")
    public void iMInTheRegistrationForum() throws Throwable {
        //************** I'm in the registrationForm page ********************************************
        Assert.assertTrue(driver.getTitle().equals("New User"));

    }

    @Then("^the system displays an error msg indicating that the name is Required$")
    public void theSystemDisplaysAnErrorMsgIndicatingThatTheNameIsRequired() throws Throwable {

        PageObject PO = new PageObject(driver);
        //  ******************* Verify that the error message displays ************************
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""+PO.TextErrorName)));
        Assert.assertTrue(PO.TextErrorName.getText().contains("Required"));
        System.out.println("Error message appears");


    }

    @When("^I create a user with a blank in the name$")
    public void iCreateAUserWithABlankInTheName() throws Throwable {
        PageObject PO = new PageObject(driver);

        //*************  Create user with a blank space in the name **********************************
        PO.UserName.sendKeys(" ");
        PO.UserEmail.sendKeys("Email@test.de");
        PO.UserPassword.sendKeys("Password");
        PO.UserconfirmationPassword.sendKeys("Password");
        //************** Submit ************************************************************************
        PO.SubmitButtonForum.click();
    }

    @When("^I create a user ([^\\\"]*) without an email$")
    public void iCreateAUserNameWithoutAnEmail(String Name) throws Throwable {
        PageObject PO = new PageObject(driver);
        //*************  Create user with a blank space in the name **********************************
        PO.UserName.sendKeys(Name);
       //*************** No input in the email field
        PO.UserPassword.sendKeys("Password");
        PO.UserconfirmationPassword.sendKeys("Password");
        //************** Submit ************************************************************************
        PO.SubmitButtonForum.click();

    }

    @Then("^the system displays an error msg indicating that the email is Required$")
    public void theSystemDisplaysAnErrorMsgIndicatingThatTheEmailIsRequired() throws Throwable {
        PageObject PO = new PageObject(driver);
        //  ******************* Verify that the error message displays ************************
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""+PO.TextErrorEmail)));
        Assert.assertTrue(PO.TextErrorEmail.getText().contains("Required"));
        System.out.println("Error message appears");
    }

    @When("^I create a user with correct ([^\\\"]*) and wrong ([^\\\"]*)$")
    public void iCreateAUserWithCorrectNameAndWrongEmail(String Name, String Email) throws Throwable {

        PageObject PO = new PageObject(driver);

        //*************  Input all fields ************************************************************
        PO.UserName.sendKeys(Name);
        PO.UserEmail.sendKeys(Email);
        PO.UserPassword.sendKeys("password");
        PO.UserconfirmationPassword.sendKeys("password");
        //************** Submit ************************************************************************
        PO.SubmitButtonForum.click();
    }

    @Then("^the system displays an error msg indicating that the email  is wrong$")
    public void theSystemDisplaysAnErrorMsgIndicatingThatTheEmailIsWrong() throws Throwable {
        PageObject PO = new PageObject(driver);
        //  ******************* Verify that the error message displays ************************
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""+PO.TextErrorEmail)));
        Assert.assertTrue(PO.TextErrorEmail.getText().contains("Invalid email address"));
        System.out.println("Error message appears");
    }

    @When("^I create a user ([^\\\"]*) without password$")
    public void iCreateAUserNameWithoutPassword(String Name) throws Throwable {
        PageObject PO = new PageObject(driver);

        //*************  Input all fields ************************************************************
        PO.UserName.sendKeys(Name);
        PO.UserEmail.sendKeys(Name+"@test.com");
        //************ No Input for the field password
        //************** Submit ************************************************************************
        PO.SubmitButtonForum.click();
    }

    @Then("^the system displays an error msg indicating that the password is missing$")
    public void theSystemDisplaysAnErrorMsgIndicatingThatThePasswordIsMissing() throws Throwable {
        PageObject PO = new PageObject(driver);
        //  ******************* Verify that the error message displays ************************
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""+PO.TextErrorPassword)));
        Assert.assertTrue(PO.TextErrorPassword.getText().contains("Required"));
        System.out.println("Error message appears");
    }

    @When("^I create a user ([^\\\"]*) with ([^\\\"]*) and ([^\\\"]*) different$")
    public void iCreateAUserNameWithPasswordAndRepeatPassDifferent(String Name,String Password, String RepeatPass) throws Throwable {
        PageObject PO = new PageObject(driver);

        //*************  Input all fields ************************************************************
        PO.UserName.sendKeys(Name);
        PO.UserEmail.sendKeys(Name+"@test.com");
        PO.UserPassword.sendKeys(Password);
        PO.UserconfirmationPassword.sendKeys(RepeatPass);
        //************** Submit ************************************************************************
        PO.SubmitButtonForum.click();
    }

    @Then("^the system displays an error msg indicating that the password and  repeat password are different$")
    public void theSystemDisplaysAnErrorMsgIndicatingThatThePasswordAndRepeatPasswordAreDifferent() throws Throwable {
        PageObject PO = new PageObject(driver);
        //  ******************* Verify that the error message displays ************************
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""+PO.TextErrorconfirmationPassword)));
        Assert.assertTrue(PO.TextErrorconfirmationPassword.getText().contains("passwords are not the same"));
        System.out.println("Error message appears");
    }

    @When("^I create a user ([^\\\"]*) with ([^\\\"]*) length inferior to six$")
    public void iCreateAUserNameWithPasswordLengthInferiorToSix(String Name, String Password) throws Throwable {
        PageObject PO = new PageObject(driver);

        //*************  Input all fields ************************************************************
        PO.UserName.sendKeys(Name);
        PO.UserEmail.sendKeys(Name+"@test.com");
        PO.UserPassword.sendKeys(Password);
        PO.UserconfirmationPassword.sendKeys(Password);
        //************** Submit ************************************************************************
        PO.SubmitButtonForum.click();
    }

    @Then("^the system displays an error msg indicating that the password length is inferior to six$")
    public void theSystemDisplaysAnErrorMsgIndicatingThatThePasswordLengthIsInferiorToSix() throws Throwable {
        PageObject PO = new PageObject(driver);
        //  ******************* Verify that the error message displays ************************
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""+PO.TextErrorPassword)));
        Assert.assertTrue(PO.TextErrorPassword.getText().contains("min 6 characters"));
        System.out.println("Error message appears");

    }


}
