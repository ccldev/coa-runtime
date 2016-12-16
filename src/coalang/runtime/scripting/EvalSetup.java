package coalang.runtime.scripting;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import ccl.rt.Value;

public class EvalSetup {
	
	public static Value reflectEvalSupport() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<?> sem = Class.forName("javax.script.ScriptEngineManager");
		Class<?> es = Class.forName("coalang.runtime.scripting.EvalSupport");
		Constructor<?> c = es.getConstructor(sem);
		return (Value) c.newInstance(sem.newInstance());
	}
	
}
