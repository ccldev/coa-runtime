package coalang.runtime.scripting.support.nashorn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import ccl.rt.ArrayValue;

public class NashornArrayValue extends ArrayValue {

	public NashornArrayValue(ScriptObjectMirror value) {
		super(new NashornArray(value));
	}

}
