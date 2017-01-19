package coalang.runtime.scripting.support.nashorn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import ccl.rt.Expression;
import ccl.rt.Value;
import ccl.rt.vm.IVM;

public class NashornMirrorValue extends Expression {

	private ScriptObjectMirror mirror;
	private IVM vm;

	public NashornMirrorValue(IVM vm, ScriptObjectMirror value) {
		super(vm, value);
		this.vm = vm;
		this.mirror = value;
	}
	
	public Value invoke(Value... args) throws Exception{
		if(mirror.isFunction()){
			Object[] params = new Object[args.length];
			for(int i = 0; i < args.length; i++){
				params[i] = args[i].getValue();
			}
			return new Expression(vm, mirror.call(null, params));
		}else{
			return super.invoke(args);
		}
	}
	
	public Value getProperty(String name){
		if(mirror.hasMember(name)){
			return wrap(mirror.getMember(name));
		}else{
			return super.getProperty(name);
		}
	}

	private Value wrap(Object slot) {
		return NashornValueWrapper.INSTANCE.call(slot);
	}

}
