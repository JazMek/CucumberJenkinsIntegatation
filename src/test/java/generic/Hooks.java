package generic;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.support.PageFactory;
import webPages.AmazonHomePage;

import java.io.IOException;
import java.util.Properties;

public abstract class Hooks extends Common {
    public static AmazonHomePage amazonHomePage;
    // get parameters from Jenkins
    String PropertiesFilePath = "src/test/resources/config.properties";
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
    Properties prop = loadProperties(PropertiesFilePath);
    String testingEnvironment= prop.getProperty("TestingEnvironment");
    Boolean useCloudEnv= Boolean.parseBoolean(prop.getProperty("UseCloudEnv")) ;
    String cloudEnvName= prop.getProperty("CloudEnvName");
    String os= prop.getProperty("Os");
    String os_version = prop.getProperty("Os_version");
    String browserName = prop.getProperty("BrowserName");
    String browserVersion = prop.getProperty("BrowserVersion");
    String url = prop.getProperty("Url");
    int implicitlyWaitTime=Integer.parseInt(prop.getProperty("ImplicitlyWaitTime"));
    public Hooks() throws IOException {
    }

    // jenkins
//    Boolean useCloudEnv= Boolean.parseBoolean(System.getProperty("UseCloudEnv"));
//    String cloudEnvName= System.getProperty("CloudEnvName");
//    String os= System.getProperty("Os");
//    String os_version = System.getProperty("Os_version");
//    String browserName = System.getProperty("BrowserName");
//    String browserVersion = System.getProperty("BrowserVersion");
//    String url = System.getProperty("Url");
//    int implicitlyWaitTime=Integer.parseInt(System.getProperty("ImplicitlyWaitTime"));

    public static void Init() {

        amazonHomePage = PageFactory.initElements(driver,AmazonHomePage.class);

    }
    @Before
    public void setUp_Init() throws IOException {
       // readJenkinsParameters();
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