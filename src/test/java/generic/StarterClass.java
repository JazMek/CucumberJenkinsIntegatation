package generic;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.support.PageFactory;
import utill.Common;
import webPages.AmazonHomePage;
import java.io.IOException;
import java.util.Properties;


public  class StarterClass extends Common {
    public static AmazonHomePage amazonHomePage;
    // get parameters from Jenkins
    String PropertiesFilePath = "config.properties";
    String testingEnvironmentJ= System.getProperty("TestingEnvironment");
    String useCloudEnvJ= System.getProperty("UseCloudEnv");
    String cloudEnvNameJ= System.getProperty("CloudEnvName");
    String osJ= System.getProperty("Os");
    String os_versionJ = System.getProperty("Os_version");
    String browserNameJ = System.getProperty("BrowserName");
    String browserVersionJ = System.getProperty("BrowserVersion");
    String urlJ = System.getProperty("Url");
    String implicitlyWaitTimeJ=System.getProperty("ImplicitlyWaitTime");
    public void readJenkinsParameters() throws IOException {
        // put the parameter in the prop file
        setAppProperties("TestingEnvironment",testingEnvironmentJ, PropertiesFilePath);
        setAppProperties("UseCloudEnv",useCloudEnvJ, PropertiesFilePath);
        setAppProperties("CloudEnvName",cloudEnvNameJ, PropertiesFilePath);
        setAppProperties("Os",osJ, PropertiesFilePath);
        setAppProperties("Os_version",os_versionJ, PropertiesFilePath);
        setAppProperties("BrowserName",browserNameJ, PropertiesFilePath);
        setAppProperties("BrowserVersion",browserVersionJ, PropertiesFilePath);
        setAppProperties("Url",urlJ, PropertiesFilePath);
        setAppProperties("ImplicitlyWaitTime",implicitlyWaitTimeJ, PropertiesFilePath);
    }
    // Read properties from propertie file
    public static Properties prop;
    {
        try {
            prop = loadProperties(PropertiesFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void Init() {
        amazonHomePage = PageFactory.initElements(driver,AmazonHomePage.class);
    }

    String testingEnvironment= prop.getProperty("TestingEnvironment");
    Boolean useCloudEnv= Boolean.parseBoolean(prop.getProperty("UseCloudEnv")) ;
    String cloudEnvName= prop.getProperty("CloudEnvName");
    String os= prop.getProperty("Os");
    String os_version = prop.getProperty("Os_version");
    String browserName = prop.getProperty("BrowserName");
    String browserVersion = prop.getProperty("BrowserVersion");
    String url = prop.getProperty("Url");
    Long implicitlywaitTime=Long.parseLong(prop.getProperty("ImplicitlyWaitTime").trim());
    long implicitlyWaitTime= implicitlywaitTime.longValue();
    @Before
    public void setUp_Init() throws IOException {
        //readJenkinsParameters();
        System.out.println("The Testing Environment is: "+testingEnvironment);
        System.out.println("Use Cloud Environment? "+useCloudEnv);
        System.out.println("The Cloud Environment Name is: "+cloudEnvName);
        setUp( useCloudEnv,  cloudEnvName,
                os,  os_version,  browserName,
                browserVersion, url,implicitlyWaitTime);
        Init();


    }
    //ScreenShot method
    @After
    public void tearDown(Scenario scenario) throws IOException {
        screenShot(scenario);
        driver.quit();

    }
}