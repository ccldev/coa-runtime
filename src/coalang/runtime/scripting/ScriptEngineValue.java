package coalang.runtime.scripting;

import io.github.coalangsoft.lib.data.Func;

import javax.script.ScriptEngine;

import ccl.rt.Expression;
import ccl.rt.Value;

public class ScriptEngineValue extends Expression {
	
	private ScriptEngine engine;
	private Func<Object,Value> wrapper;
	
	public ScriptEngineValue(ScriptEngine e, Func<Object,Value> w) {
		super(e);
		this.engine = e;
		this.wrapper = w;
	}

	@Override
	public Value invoke(Value... args) throws Exception {
		Object o = engine.eval(args[0].getValue() + "");
		if(wrapper != null){
			return wrapper.call(o);
		}
		return new Expression(o);
	}

}
