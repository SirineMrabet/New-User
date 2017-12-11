package Steps;

import Base.BaseUtile;
import Pages.PageObject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


/**
 * Created by smrabet on 08/12/2017.
 */

public class Hook extends BaseUtile {

    private BaseUtile base;

    public Hook(BaseUtile base) {
        this.base = base;
        this.driver = base.driver;
    }


    @Before
    public void InitializeTest(Scenario scenario) {
        System.out.println("Opening the browser Firefox");
        System.out.println("Scenario Name: "+scenario.getName());
        System.setProperty("webdriver.firefox.marionette", "D:\\libs\\geckodriver.exe");
        //base.driver = new HtmlUnitDriver(true);
        base.driver = new FirefoxDriver();
        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Navigate to Adding New User Form
        base.driver.navigate().to("http://85.93.17.135:9000");

        //************* Clear all fields ************************************************************
        PageObject PO = new PageObject(driver);

        PO.UserName.clear();
        PO.UserEmail.clear();
        PO.UserPassword.clear();
        PO.UserconfirmationPassword.clear();


    }


    @After
    public void TearDownTest(Scenario scenario) {

         if (scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
        System.out.println("Ending test");
        base.driver.quit();

    }

    public BaseUtile getBase() {
        return base;
    }




}

