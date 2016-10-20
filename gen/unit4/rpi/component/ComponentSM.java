package unit4.rpi.component;

public class ComponentSM extends no.ntnu.item.arctis.runtime.IStateMachine {

    private br.lib.rpi.berryclip.button.Button b001;
    private br.lib.rpi.berryclip.buzzer.Buzzer b005;
    private br.lib.rpi.berryclip.led.LED b010;
    private br.lib.rpi.berryclip.led.LED b014;
    private br.lib.rpi.berryclip.led.LED b019;
    private br.lib.rpi.berryclip.led.LED b023;
    private enum Br_lib_rpi_berryclip_Button {_IDLE, ACTIVE, DOWN};
    private Br_lib_rpi_berryclip_Button b001_state;

    public ComponentSM(no.ntnu.item.arctis.runtime.Scheduler scheduler) {
        super(scheduler);
    }

    public int fireInitial() {
        b001 = new br.lib.rpi.berryclip.button.Button();
        b001.setBlockID("b001", sessionID);
        b001.setRuntime(scheduler.getRuntime());
        b005 = new br.lib.rpi.berryclip.buzzer.Buzzer();
        b005.setBlockID("b005", sessionID);
        b005.setRuntime(scheduler.getRuntime());
        b010 = new br.lib.rpi.berryclip.led.LED(4);
        b010.setBlockID("b010", sessionID);
        b010.setRuntime(scheduler.getRuntime());
        b014 = new br.lib.rpi.berryclip.led.LED(5);
        b014.setBlockID("b014", sessionID);
        b014.setRuntime(scheduler.getRuntime());
        b019 = new br.lib.rpi.berryclip.led.LED(0);
        b019.setBlockID("b019", sessionID);
        b019.setRuntime(scheduler.getRuntime());
        b023 = new br.lib.rpi.berryclip.led.LED(1);
        b023.setBlockID("b023", sessionID);
        b023.setRuntime(scheduler.getRuntime());
        b001_state = Br_lib_rpi_berryclip_Button._IDLE;
        no.ntnu.item.arctis.runtime.SingletonData b001_o0 = b001.makeData();
        b001_state = Br_lib_rpi_berryclip_Button.ACTIVE;
        ((no.ntnu.item.arctis.runtime.SingletonData) b001_o0).setSessionID(this.sessionID);
        ((no.ntnu.item.arctis.runtime.SingletonData) b001_o0).setInstance("_b0_c0_Berryclip_Singleton");
        scheduler.sendToSession(this, "singleton_227460273", "singleton_start", b001_o0);
        // step a7bc9;
        return CONSUME_SIGNAL;
    }

    public int fireTimer(java.lang.String _timerID) {
                return DISCARD_SIGNAL;
    }

    public int fire(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.String _signalID, java.lang.Object _data) {
        if (_signalID.equals("_b0_c0_Berryclip_Singleton_buttonDown")) {
            return handleEvent__b0_c0_Berryclip_Singleton_buttonDown(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("_b0_c0_Berryclip_Singleton_buttonUp")) {
            return handleEvent__b0_c0_Berryclip_Singleton_buttonUp(_sender, receiverSessionID, _data);
        }
        return TRIGGER_UNKNOWN;
    }

    private int handleEvent__b0_c0_Berryclip_Singleton_buttonDown(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b001_state == Br_lib_rpi_berryclip_Button._IDLE) {
            // step 32cc5;
            return CONSUME_SIGNAL;
        } else if (b001_state == Br_lib_rpi_berryclip_Button.DOWN) {
            // step a68b3;
            return CONSUME_SIGNAL;
        } else if (b001_state == Br_lib_rpi_berryclip_Button.ACTIVE) {
            no.ntnu.item.arctis.runtime.SingletonData b005_o0 = b005.makeData();
            no.ntnu.item.arctis.runtime.SingletonData b010_o0 = b010.makeData();
            no.ntnu.item.arctis.runtime.SingletonData b014_o0 = b014.makeData();
            no.ntnu.item.arctis.runtime.SingletonData b019_o1 = b019.makeData();
            no.ntnu.item.arctis.runtime.SingletonData b023_o1 = b023.makeData();
            b001_state = Br_lib_rpi_berryclip_Button.DOWN;
            ((no.ntnu.item.arctis.runtime.SingletonData) b005_o0).setSessionID(this.sessionID);
            ((no.ntnu.item.arctis.runtime.SingletonData) b005_o0).setInstance("_b1_c0_Berryclip_Singleton");
            scheduler.sendToSession(this, "singleton_227460273", "singleton_buzzerOn", b005_o0);
            ((no.ntnu.item.arctis.runtime.SingletonData) b010_o0).setSessionID(this.sessionID);
            ((no.ntnu.item.arctis.runtime.SingletonData) b010_o0).setInstance("_b2_c0_c0_Berryclip_Singleton");
            scheduler.sendToSession(this, "singleton_227460273", "singleton_ledOn", b010_o0);
            ((no.ntnu.item.arctis.runtime.SingletonData) b014_o0).setSessionID(this.sessionID);
            ((no.ntnu.item.arctis.runtime.SingletonData) b014_o0).setInstance("_b2_c1_c0_Berryclip_Singleton");
            scheduler.sendToSession(this, "singleton_227460273", "singleton_ledOn", b014_o0);
            ((no.ntnu.item.arctis.runtime.SingletonData) b019_o1).setSessionID(this.sessionID);
            ((no.ntnu.item.arctis.runtime.SingletonData) b019_o1).setInstance("_b3_c0_c0_Berryclip_Singleton");
            scheduler.sendToSession(this, "singleton_227460273", "singleton_ledOff", b019_o1);
            ((no.ntnu.item.arctis.runtime.SingletonData) b023_o1).setSessionID(this.sessionID);
            ((no.ntnu.item.arctis.runtime.SingletonData) b023_o1).setInstance("_b3_c1_c0_Berryclip_Singleton");
            scheduler.sendToSession(this, "singleton_227460273", "singleton_ledOff", b023_o1);
            // step 6f20a;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent__b0_c0_Berryclip_Singleton_buttonUp(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b001_state == Br_lib_rpi_berryclip_Button._IDLE) {
            // step a2d6d;
            return CONSUME_SIGNAL;
        } else if (b001_state == Br_lib_rpi_berryclip_Button.ACTIVE) {
            // step 581d0;
            return CONSUME_SIGNAL;
        } else if (b001_state == Br_lib_rpi_berryclip_Button.DOWN) {
            no.ntnu.item.arctis.runtime.SingletonData b005_o1 = b005.makeData();
            no.ntnu.item.arctis.runtime.SingletonData b010_o1 = b010.makeData();
            no.ntnu.item.arctis.runtime.SingletonData b014_o1 = b014.makeData();
            no.ntnu.item.arctis.runtime.SingletonData b019_o0 = b019.makeData();
            no.ntnu.item.arctis.runtime.SingletonData b023_o0 = b023.makeData();
            b001_state = Br_lib_rpi_berryclip_Button.ACTIVE;
            ((no.ntnu.item.arctis.runtime.SingletonData) b005_o1).setSessionID(this.sessionID);
            ((no.ntnu.item.arctis.runtime.SingletonData) b005_o1).setInstance("_b1_c0_Berryclip_Singleton");
            scheduler.sendToSession(this, "singleton_227460273", "singleton_buzzerOff", b005_o1);
            ((no.ntnu.item.arctis.runtime.SingletonData) b010_o1).setSessionID(this.sessionID);
            ((no.ntnu.item.arctis.runtime.SingletonData) b010_o1).setInstance("_b2_c0_c0_Berryclip_Singleton");
            scheduler.sendToSession(this, "singleton_227460273", "singleton_ledOff", b010_o1);
            ((no.ntnu.item.arctis.runtime.SingletonData) b014_o1).setSessionID(this.sessionID);
            ((no.ntnu.item.arctis.runtime.SingletonData) b014_o1).setInstance("_b2_c1_c0_Berryclip_Singleton");
            scheduler.sendToSession(this, "singleton_227460273", "singleton_ledOff", b014_o1);
            ((no.ntnu.item.arctis.runtime.SingletonData) b019_o0).setSessionID(this.sessionID);
            ((no.ntnu.item.arctis.runtime.SingletonData) b019_o0).setInstance("_b3_c0_c0_Berryclip_Singleton");
            scheduler.sendToSession(this, "singleton_227460273", "singleton_ledOn", b019_o0);
            ((no.ntnu.item.arctis.runtime.SingletonData) b023_o0).setSessionID(this.sessionID);
            ((no.ntnu.item.arctis.runtime.SingletonData) b023_o0).setInstance("_b3_c1_c0_Berryclip_Singleton");
            scheduler.sendToSession(this, "singleton_227460273", "singleton_ledOn", b023_o0);
            // step 40e6c;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }
}
