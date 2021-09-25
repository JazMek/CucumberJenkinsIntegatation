package utill.reporting;



import java.io.File;

public class ExtentManager {
//    private static ExtentReports extent;
//    private static ITestContext context;
//    ExtentTest logger;
//
//
//    @BeforeTest
//    public synchronized static ExtentReports getInstance() {
//        if (extent == null) {
//            File outputDirectory = new File(context.getOutputDirectory());
//            File resultDirectory = new File(outputDirectory.getParentFile(), "html");
//
//            extent = new ExtentReports(System.getProperty("user.dir") + "/Extent-Report/ExtentReport.html", true);
//
//            Reporter.log("Extent Report Directory" + resultDirectory, true);
//            extent.addSystemInfo("Host Name", "PNT").addSystemInfo("Environment", "QA").addSystemInfo("User Name", "AutomationFramework_Team4");
//            extent.loadConfig(new File(System.getProperty("user.dir") + "/report-config.xml"));
//        }
//        return extent;
//    }
//
//    public static void setOutputDirectory(ITestContext context) {
//        ExtentManager.context = context;
//
//    }
}