/**
 *
 */
package eu.brightraven.experimental.scyllarus.scyllarus;

import org.slf4j.Logger;
import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Payload;
import org.slf4j.LoggerFactory;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

import eu.brightraven.experimental.scyllarus.scyllarus.config.ConnectorConfig;

@Connector(name="scyllarus", friendlyName="Scyllarus")
public class ScyllarusConnector {
    @Config
    ConnectorConfig config;
    
    private static Logger logger = LoggerFactory.getLogger(ScyllarusConnector.class);
    /**
     * Custom processor
     *
     * @param friend Name to be used to generate a greeting message.
     * @return A greeting message
     */
    @Processor
    public Object executeClojure(@Payload Object payload) {
    	
    	/* init clojure runtime */
    	try {
	    
			Class.forName("clojure.java.api.Clojure");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	IFn evalFunc = Clojure.var("clojure.core/eval");
    	IFn readStringFunc = Clojure.var("clojure.core/read-string");

    	IFn vectorFunc = Clojure.var("clojure.core/vector");
    	IFn mapFunc = Clojure.var("clojure.core/map");
    	
    	String setUpFunctions = "(defn execute-script [pl script] (do "
    			+ "(def ^:dynamic mule-payload nil)(binding [mule-payload pl] (load-string script)))))";
    	IFn execFunc = (IFn) evalFunc.invoke(readStringFunc.invoke(setUpFunctions));    	
    	

    	/* invoke user script */
    	String code = config.getClojureCode();
    	Object result = execFunc.invoke(payload, code);
		return result;
    }

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}
