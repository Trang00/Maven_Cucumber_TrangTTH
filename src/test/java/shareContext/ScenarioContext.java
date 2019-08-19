package shareContext;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
	private Map<String, Object> scenarioContext;
	
	public ScenarioContext() {
		scenarioContext=new HashMap <> ();
	}
	public void setContext(ContextVariable key, Object value) {
		scenarioContext.put(key.toString(), value);
	}
	public Object getContext(ContextVariable key) {
		return scenarioContext.get(key.toString());
	}
}
