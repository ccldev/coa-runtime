package coalang.runtime.scripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import ccl.rt.Expression;
import ccl.rt.Value;

public class EvalSupport extends Expression{

	static{
		ScriptValueWrappers.init();
	}
	
	private ScriptEngineManager mgr;

	public EvalSupport(ScriptEngineManager mgr){
		super(mgr);
		this.mgr = mgr;
	}
	
	@Override
	public Value getProperty(String name) {
		ScriptEngine e = mgr.getEngineByExtension(name);
		if(e != null){
			return new ScriptEngineValue(
				e,
				ScriptValueWrappers.find(e)
			);
		}
		return super.getProperty(name);
	}

}
