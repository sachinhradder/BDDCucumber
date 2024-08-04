package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features"}, // it defines where the feature files are kept.
		glue = {"steps"}, // it defines where the steps definition files are kept.
		plugin = {"pretty", "json:target/json-report/cucumber.json"},  // to get reports to get reports in json format use "json:report2" "junit:report3" to get junit report.
		dryRun =false,  // it is going to run the feature files in dry run mode, in this it just finds out wether is there a features files which doesn't have step definition file attached to it.
		 //dryRun = true   // it will run the feature files which have step definition files.
		// strict = true  // when strict = true then it becomes mandatory to add the step definition files for all the feature files. it is deprecated please don't use this option.
		//monochrome = false  // it deals with how the output format is displayed after running the scenarios, when it is true the output will be dispalyed in the better format.
		tags =  "@P300"  // here you associate scenarios of one type to a specific tag and when you run the tag all scenarios associated to that tag will get executed.
		//name = {"Logo"}  // in this we can specify any keyword from the scenario name and it will execute that matching scenario name.
		)
public class TestRunner {

}

