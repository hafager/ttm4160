package unit4.rpi.component;

public class BerryclipSingletonSM extends no.ntnu.item.arctis.runtime.IStateMachine {

    private br.lib.rpi.berryclip.berryclipsingleton.BerryclipSingleton b002;
    private br.lib.rpi.berryclip.berryclip.Berryclip b003;
    private enum Br_lib_rpi_berryclip_BerryclipSingleton {_IDLE, ACTIVE};
    private Br_lib_rpi_berryclip_BerryclipSingleton b002_state;
    private boolean b003_BUTTON_UP_r0;
    private boolean b003_BUTTON_DOWN_r1;
    private boolean b003_READY_r2;
    private static int sessionCount = 0;

    public BerryclipSingletonSM(no.ntnu.item.arctis.runtime.Scheduler scheduler, java.lang.String sessionID, java.lang.String parentSessionID, java.lang.String parentSessionPath) {
        super(scheduler, "b002", sessionID, parentSessionID, parentSessionPath);
        ++ sessionCount;
    }

    public int getSessionCount() {
        return sessionCount;
    }

    public int getMultiplicityPattern() {
        return MULTIPLICITY_SINGLETON;
    }

    public int fireInitial() {
        b002 = new br.lib.rpi.berryclip.berryclipsingleton.BerryclipSingleton();
        b002.setBlockID("b002", sessionID);
        b002.setRuntime(scheduler.getRuntime());
        b003 = new br.lib.rpi.berryclip.berryclip.Berryclip();
        b003.setBlockID("b003", sessionID);
        b003.setRuntime(scheduler.getRuntime());
        b002_state = Br_lib_rpi_berryclip_BerryclipSingleton._IDLE;
        return CONSUME_SIGNAL;
    }

    public int fireTimer(java.lang.String _timerID) {
                return DISCARD_SIGNAL;
    }

    public int fire(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.String _signalID, java.lang.Object _data) {
        if (_signalID.equals("singleton_buzzerOff")) {
            return handleEvent_singleton_buzzerOff(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("singleton_buzzerOn")) {
            return handleEvent_singleton_buzzerOn(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("singleton_ledOff")) {
            return handleEvent_singleton_ledOff(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("singleton_ledOn")) {
            return handleEvent_singleton_ledOn(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("singleton_leds")) {
            return handleEvent_singleton_leds(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("singleton_start")) {
            return handleEvent_singleton_start(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("singleton_stop")) {
            return handleEvent_singleton_stop(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("BUTTON_UP_b003")) {
            return handleEvent_BUTTON_UP_b003(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("BUTTON_DOWN_b003")) {
            return handleEvent_BUTTON_DOWN_b003(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("READY_b003")) {
            return handleEvent_READY_b003(_sender, receiverSessionID, _data);
        }
        return TRIGGER_UNKNOWN;
    }

    private int handleEvent_singleton_buzzerOff(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b002_state == Br_lib_rpi_berryclip_BerryclipSingleton._IDLE) {
            b003.buzzerOff();
            b003_BUTTON_UP_r0 = false;
            scheduler.flushEventQueue(sessionID, "BUTTON_UP_b003");
            b003_BUTTON_DOWN_r1 = false;
            scheduler.flushEventQueue(sessionID, "BUTTON_DOWN_b003");
            b003_READY_r2 = false;
            scheduler.flushEventQueue(sessionID, "READY_b003");
            // step a7540;
            return CONSUME_SIGNAL;
        } else if (b002_state == Br_lib_rpi_berryclip_BerryclipSingleton.ACTIVE) {
            b003.buzzerOff();
            // step 79ec7;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_singleton_buzzerOn(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b002_state == Br_lib_rpi_berryclip_BerryclipSingleton._IDLE) {
            b003.buzzerOn();
            b003_BUTTON_UP_r0 = false;
            scheduler.flushEventQueue(sessionID, "BUTTON_UP_b003");
            b003_BUTTON_DOWN_r1 = false;
            scheduler.flushEventQueue(sessionID, "BUTTON_DOWN_b003");
            b003_READY_r2 = false;
            scheduler.flushEventQueue(sessionID, "READY_b003");
            // step 4a849;
            return CONSUME_SIGNAL;
        } else if (b002_state == Br_lib_rpi_berryclip_BerryclipSingleton.ACTIVE) {
            b003.buzzerOn();
            // step 2f03b;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_singleton_ledOff(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        no.ntnu.item.arctis.runtime.SingletonData _b0_c0_Berryclip_Singleton_ledOff = ((no.ntnu.item.arctis.runtime.SingletonData) _data);
        if (b002_state == Br_lib_rpi_berryclip_BerryclipSingleton._IDLE) {
            int b002_o1 = b002.extractInt(_b0_c0_Berryclip_Singleton_ledOff);
            b003.ledOff(b002_o1);
            b003_BUTTON_UP_r0 = false;
            scheduler.flushEventQueue(sessionID, "BUTTON_UP_b003");
            b003_BUTTON_DOWN_r1 = false;
            scheduler.flushEventQueue(sessionID, "BUTTON_DOWN_b003");
            b003_READY_r2 = false;
            scheduler.flushEventQueue(sessionID, "READY_b003");
            // step 87e31;
            return CONSUME_SIGNAL;
        } else if (b002_state == Br_lib_rpi_berryclip_BerryclipSingleton.ACTIVE) {
            int b002_o1 = b002.extractInt(_b0_c0_Berryclip_Singleton_ledOff);
            b003.ledOff(b002_o1);
            // step f09d8;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_singleton_ledOn(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        no.ntnu.item.arctis.runtime.SingletonData _b0_c0_Berryclip_Singleton_ledOn = ((no.ntnu.item.arctis.runtime.SingletonData) _data);
        if (b002_state == Br_lib_rpi_berryclip_BerryclipSingleton._IDLE) {
            int b002_o0 = b002.extractInt(_b0_c0_Berryclip_Singleton_ledOn);
            b003.ledOn(b002_o0);
            b003_BUTTON_UP_r0 = false;
            scheduler.flushEventQueue(sessionID, "BUTTON_UP_b003");
            b003_BUTTON_DOWN_r1 = false;
            scheduler.flushEventQueue(sessionID, "BUTTON_DOWN_b003");
            b003_READY_r2 = false;
            scheduler.flushEventQueue(sessionID, "READY_b003");
            // step 699da;
            return CONSUME_SIGNAL;
        } else if (b002_state == Br_lib_rpi_berryclip_BerryclipSingleton.ACTIVE) {
            int b002_o0 = b002.extractInt(_b0_c0_Berryclip_Singleton_ledOn);
            b003.ledOn(b002_o0);
            // step b977d;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_singleton_leds(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        no.ntnu.item.arctis.runtime.SingletonData _b0_c0_Berryclip_Singleton_leds = ((no.ntnu.item.arctis.runtime.SingletonData) _data);
        if (b002_state == Br_lib_rpi_berryclip_BerryclipSingleton._IDLE) {
            boolean[] b002_o5 = b002.extractLEDs(_b0_c0_Berryclip_Singleton_leds);
            b003.setLEDs(b002_o5);
            b003_BUTTON_UP_r0 = false;
            scheduler.flushEventQueue(sessionID, "BUTTON_UP_b003");
            b003_BUTTON_DOWN_r1 = false;
            scheduler.flushEventQueue(sessionID, "BUTTON_DOWN_b003");
            b003_READY_r2 = false;
            scheduler.flushEventQueue(sessionID, "READY_b003");
            // step f9c59;
            return CONSUME_SIGNAL;
        } else if (b002_state == Br_lib_rpi_berryclip_BerryclipSingleton.ACTIVE) {
            boolean[] b002_o5 = b002.extractLEDs(_b0_c0_Berryclip_Singleton_leds);
            b003.setLEDs(b002_o5);
            // step f0e4b;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_singleton_start(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        no.ntnu.item.arctis.runtime.SingletonData _b0_c0_Berryclip_Singleton_start = ((no.ntnu.item.arctis.runtime.SingletonData) _data);
        if (b002_state == Br_lib_rpi_berryclip_BerryclipSingleton._IDLE) {
            b002.addToButtonResponses(_b0_c0_Berryclip_Singleton_start);
            b002.initializing();
            b003.init();
            b003_READY_r2 = true;
            b002_state = Br_lib_rpi_berryclip_BerryclipSingleton.ACTIVE;
            // step 19784;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_singleton_stop(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b002_state == Br_lib_rpi_berryclip_BerryclipSingleton.ACTIVE) {
            b003.shutdown();
            b003_BUTTON_UP_r0 = false;
            scheduler.flushEventQueue(sessionID, "BUTTON_UP_b003");
            b003_BUTTON_DOWN_r1 = false;
            scheduler.flushEventQueue(sessionID, "BUTTON_DOWN_b003");
            b003_READY_r2 = false;
            scheduler.flushEventQueue(sessionID, "READY_b003");
            b002_state = Br_lib_rpi_berryclip_BerryclipSingleton._IDLE;
            // step 5eb49;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_BUTTON_UP_b003(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b003_BUTTON_UP_r0) {
            java.util.Set<no.ntnu.item.arctis.runtime.SingletonData> b002_o3 = b002.getButtonResponse();
            for (no.ntnu.item.arctis.runtime.SingletonData _it : b002_o3) {
                scheduler.sendToSession(this, _it.getSessionID(), _it.getInstance() + "_" + "buttonUp", _it);
            }
            // step 69574;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_BUTTON_DOWN_b003(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b003_BUTTON_DOWN_r1) {
            java.util.Set<no.ntnu.item.arctis.runtime.SingletonData> b002_o4 = b002.getButtonResponse();
            for (no.ntnu.item.arctis.runtime.SingletonData _it : b002_o4) {
                scheduler.sendToSession(this, _it.getSessionID(), _it.getInstance() + "_" + "buttonDown", _it);
            }
            // step 344ab;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_READY_b003(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b003_READY_r2) {
            b003_READY_r2 = false;
            b003_BUTTON_UP_r0 = true;
            b003_BUTTON_DOWN_r1 = true;
            // step adf6f;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }
}
