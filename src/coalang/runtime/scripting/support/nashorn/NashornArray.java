package coalang.runtime.scripting.support.nashorn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import ccl.rt.Array;

public class NashornArray extends Array {

	public NashornArray(ScriptObjectMirror m) {
		super((int) m.getMember("length"));
		for(int i = 0; i < length(); i++){
			setValue(i, NashornValueWrapper.INSTANCE.call(m.getSlot(i)));
		}
	}

}
