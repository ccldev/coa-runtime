package coalang.runtime.scripting;

import java.util.HashMap;

import javax.script.ScriptEngine;

import ccl.rt.Value;
import ccl.rt.use.Func;

public class ScriptValueWrappers {

	static{
		map = new HashMap<Class<? extends ScriptEngine>, Func<Object, Value>>();
	}
	
	private static HashMap<Class<? extends ScriptEngine>, Func<Object,Value>> map;
	
	public static Func<Object,Value> find(ScriptEngine engine) {
		return map.get(engine.getClass());
	}
	
	@SuppressWarnings("unchecked")
	public static void init(){
		try {
			map.put((Class<? extends ScriptEngine>) Class.forName("jdk.nashorn.api.scripting.NashornScriptEngine"), (Func<Object, Value>) Class.forName("coalang.runtime.scripting.support.nashorn.NashornValueWrapper").newInstance());
		} catch (Exception e) {}
	}

}
