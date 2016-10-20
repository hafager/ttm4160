package unit4.rpi;

import no.ntnu.item.arctis.runtime.IStateMachine;
import no.ntnu.item.arctis.runtime.Runtime;
import no.ntnu.item.arctis.runtime.Register;
import no.ntnu.item.arctis.runtime.IRegister;
import no.ntnu.item.arctis.runtime.Scheduler;

public class MyRuntime extends Runtime {

	private MyRuntime(IRegister register) {
		super(register);
	}

    public static Runtime create() {
        MyRuntime runtime = new MyRuntime(new Register());
        return runtime;
    }

	protected IStateMachine createDefaultStateMachine(Scheduler scheduler) {
		return new unit4.rpi.component.ComponentSM(scheduler);
	}

	protected IStateMachine createSession(String signalID, Scheduler scheduler, String sessionID, String parentSessionID, String parentSessionPath) {
        if("singleton_227460273".equals(sessionID)) return new unit4.rpi.component.BerryclipSingletonSM(scheduler, sessionID, parentSessionID, parentSessionPath);

        return null;
    }

	protected boolean createsSession(String signalID) {

        return false;
    }


	public void applicationErrorDetected() {
		System.exit(1);
	}
}
