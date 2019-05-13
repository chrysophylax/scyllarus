/**
 *
 */
package eu.brightraven.experimental.scyllarus.verification.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import eu.brightraven.experimental.scyllarus.verification.automation.functional.ExecuteClojureTestCases;
import eu.brightraven.experimental.scyllarus.scyllarus.ScyllarusConnector;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

@RunWith(Suite.class)
@SuiteClasses({ ExecuteClojureTestCases.class })

public class FunctionalTestSuite {

	@BeforeClass
	public static void initialiseSuite() {
		ConnectorTestContext.initialize(ScyllarusConnector.class);
	}

	@AfterClass
	public static void shutdownSuite() {
		ConnectorTestContext.shutDown();
	}

}