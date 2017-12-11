package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
/**
 * Created by smrabet on 08/12/2017.
 */
public class PageObject {


    public PageObject(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    //************************************** User Forum  ***********************************

    public static final String Forum = "registrationForm";
    @FindBy(how = How.ID, using = Forum)
    public WebElement registrationForm;
    //************************************** User Name  ***********************************

    public static final String name = "name";
    @FindBy(how = How.ID, using = name)
    public WebElement UserName;

    //************************************** User email ***********************************

    public static final String  email = "email";
    @FindBy(how = How.ID, using = email)
    public WebElement UserEmail;

    //************************************** User password *********************************

    public static final String  password = "password";
    @FindBy(how = How.ID, using = password )
    public WebElement UserPassword;

    //************************************** User confirmation Password ***********************************

    public static final String confirmationPassword = "confirmationPassword";
    @FindBy(how = How.ID, using = confirmationPassword)
    public WebElement UserconfirmationPassword;

    //************************************** Submit button  ***********************************

    public static final String SubmitButton = "//button[@type='submit' and text()='Submit']";
    @FindBy(how = How.XPATH, using = SubmitButton)
    public WebElement SubmitButtonForum;


    //************************************** List all users button  ***********************************

    public static final String AllUsersButton = "//a[@href='/users/all' and text()='All User']";
    @FindBy(how = How.XPATH, using = AllUsersButton )
    public WebElement AllUsers;

    //************************************** error text name ***********************************

    public static final String TexterrorName = "user.name.error";
    @FindBy(how = How.ID, using = TexterrorName )
    public WebElement TextErrorName;


   //************************************** error text email  ***********************************

    public static final String TexterrorEmail = "user.email.error";
    @FindBy(how = How.ID, using = TexterrorEmail )
    public WebElement TextErrorEmail;


    //************************************** error text password  ***********************************

    public static final String TexterrorPassword = "user.password.error";
    @FindBy(how = How.ID, using = TexterrorPassword )
    public WebElement TextErrorPassword;
    //************************************** error text confirmationPassword  ************************

    public static final String TexterrorconfirmationPassword = "user.confirmationPassword.error";
    @FindBy(how = How.ID, using = TexterrorconfirmationPassword)
    public WebElement TextErrorconfirmationPassword;

    //************************************** Success text msg creation *********************************

    public static final String TextsucessMsg = "TBD";
    @FindBy(how = How.ID, using = TextsucessMsg )
    public WebElement TextSucessMsg ;


}
