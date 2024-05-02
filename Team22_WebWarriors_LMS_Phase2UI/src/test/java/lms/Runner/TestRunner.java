package lms.Runner;
	
	import org.junit.runner.RunWith;
	import org.testng.annotations.DataProvider;
	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;
	import io.cucumber.junit.Cucumber;
		
	//@RunWith(Cucumber.class) //Junit execution

		@CucumberOptions(
				monochrome = false,  //console output formatting

				tags = "@Login", //tags from feature file
				tags = "@LMS1 or @LMS2", //tags from feature file
 master
				features = {"src/test/resources/features"}, //location of feature files
				glue= {"lms.StepDefinitions","lms.Hooks"}, //location of step definition files
				plugin = {"pretty", //For the Detailed output and generating reports.
							"html:target/Cucumber-Reports/Team22_WebWarriors.html" ,
							"json:target/Cucumber-Reports/Team22_WebWarriors.json" , 
							"junit:target/Cucumber-Reports/Team22_WebWarriors.xml",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
						}
				) 

		public class TestRunner extends AbstractTestNGCucumberTests{
			
			@Override
		    @DataProvider(parallel = false)
		    public Object[][] scenarios() {
				
				return super.scenarios();
	 }
}
	
