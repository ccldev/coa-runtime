package coalang.runtime.scripting.support.nashorn;

import io.github.coalangsoft.lib.data.Func;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import ccl.rt.Expression;
import ccl.rt.Special;
import ccl.rt.Value;

public class NashornValueWrapper implements Func<Object, Value> {

	public static final NashornValueWrapper INSTANCE = new NashornValueWrapper();
	
	@Override
	public Value call(Object p) {
		if(p instanceof ScriptObjectMirror){
			ScriptObjectMirror m = (ScriptObjectMirror) p;
			if(m.isArray()){
				return new NashornArrayValue(m);
			}
			if(ScriptObjectMirror.isUndefined(m)){
				return new Expression(Special.UNDEFINED);
			}
			return new NashornMirrorValue(m);
		}
		return new Expression(p);
	}

}
