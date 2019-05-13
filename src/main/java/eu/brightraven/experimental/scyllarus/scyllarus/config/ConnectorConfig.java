/**
 *
 */
package eu.brightraven.experimental.scyllarus.scyllarus.config;

import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.param.Default;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {

	/**
	 * Clojure eval code
	 */
	@Configurable
	private String clojureCode;
	
	public void setClojureCode(String code) {
		this.clojureCode = code;
	}
	
	public String getClojureCode() {
		return this.clojureCode;
	}

}