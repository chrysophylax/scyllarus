/**
 *
 */
package eu.brightraven.experimental.scyllarus.verification.automation.functional;

import static org.junit.Assert.*;
import eu.brightraven.experimental.scyllarus.scyllarus.ScyllarusConnector;
import eu.brightraven.experimental.scyllarus.scyllarus.config.ConnectorConfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class ExecuteClojureTestCases extends AbstractTestCase<ScyllarusConnector> {

	public ExecuteClojureTestCases() {
		super(ScyllarusConnector.class);
	}

	@Before
	public void setup() {
		// TODO
	}

	@After
	public void tearDown() {
		// TODO
	}

@Test
public void verify(){
	java.lang.String expected="8";
	ConnectorConfig conn = new ConnectorConfig();
	conn.setClojureCode("(+ 5 3)");
	assertEquals(getConnector().executeClojure(""),expected);
}

}