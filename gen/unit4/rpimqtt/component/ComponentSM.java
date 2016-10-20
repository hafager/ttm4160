package unit4.rpimqtt.component;

public class ComponentSM extends no.ntnu.item.arctis.runtime.IStateMachine {

    private unit4.rpimqtt.component.Component b000;
    private com.bitreactive.library.mqtt.robustmqtt.RobustMQTT b001;
    private com.bitreactive.library.mqtt.createcallback.CreateCallback b002;
    private com.bitreactive.library.mqtt.connhandler.ConnHandler b003;
    private com.bitreactive.library.mqtt.publishmanager.PublishManager b004;
    private com.bitreactive.library.mqtt.publishhandler.PublishHandler b005;
    private com.bitreactive.library.mqtt.publishpolicy.PublishPolicy b006;
    private com.bitreactive.library.buffering.buffereager.BufferEager<com.bitreactive.library.mqtt.MQTTMessage> b007;
    private com.bitreactive.library.mqtt.publisher.Publisher b008;
    private com.bitreactive.library.mqtt.publishhandler2.PublishHandler2 b009;
    private com.bitreactive.library.mqtt.publisher.Publisher b010;
    private com.bitreactive.library.buffering.persistentbuffer.PersistentBuffer<com.bitreactive.library.mqtt.MQTTMessage> b011;
    private com.bitreactive.library.mqtt.publishpolicy.PublishPolicy b012;
    private com.bitreactive.library.mqtt.subscribehandler.SubscribeHandler b013;
    private com.bitreactive.library.mqtt.subscriber.Subscriber b014;
    private com.bitreactive.library.timers.timer2.Timer2 b015;
    private no.ntnu.item.arctis.library.speech.speech.Speech b016;
    private enum Com_bitreactive_library_mqtt_RobustMQTT {_IDLE, ACTIVE, INITIALIZING};
    private enum Com_bitreactive_library_mqtt_ConnHandler {_IDLE, ACTIVE, INITIALIZING};
    private enum Com_bitreactive_library_mqtt_PublishHandler {_IDLE, ACTIVE};
    private enum Com_bitreactive_library_buffering_BufferEager {_IDLE, ACTIVE, FIRSTITEMADDED, READY, STOPPING};
    private enum Com_bitreactive_library_mqtt_PublishHandler2 {_IDLE, ACTIVE, INITIALIZING};
    private enum Com_bitreactive_library_buffering_PersistentBuffer {_IDLE, ACTIVE, INITIALIZING, REMOVING};
    private enum Com_bitreactive_library_mqtt_Subscriber {_IDLE, ACTIVE};
    private enum Com_bitreactive_library_timers_Timer2 {_IDLE, ACTIVE};
    private enum No_ntnu_item_arctis_library_speech_Speech {_IDLE, ACTIVE, SPEAKING};
    private Com_bitreactive_library_mqtt_RobustMQTT b001_state;
    private Com_bitreactive_library_mqtt_ConnHandler b003_state;
    private Com_bitreactive_library_mqtt_PublishHandler b005_state;
    private Com_bitreactive_library_buffering_BufferEager b007_state;
    private Com_bitreactive_library_mqtt_PublishHandler2 b009_state;
    private Com_bitreactive_library_buffering_PersistentBuffer b011_state;
    private Com_bitreactive_library_mqtt_Subscriber b014_state;
    private Com_bitreactive_library_timers_Timer2 b015_state;
    private No_ntnu_item_arctis_library_speech_Speech b016_state;
    private enum Com_bitreactive_library_buffering_BufferEager_Stm {_IDLE, ACTIVE, CHECKCONTENTADDALL, FIRSTITEMADDED, HASROOM, HASROOMAFTERADDINGFIRST, HASROOMFORALL, HASROOMFORALLAFTERADDINGFIRST, HASROOMFORALLINITIAL, ISBUFFEREMPTY, ISEMPTYWHILEACTIVE, ISEMPTYWHILESTOPPING, READY, STOPPING};
    private Com_bitreactive_library_buffering_BufferEager_Stm b007_stm_state;
    private no.ntnu.item.arctis.runtime.IStateMachine.Timer _b0_c1_Conn_Handler_t0;
    private no.ntnu.item.arctis.runtime.IStateMachine.Timer _b0_c1_Conn_Handler_t1;
    private no.ntnu.item.arctis.runtime.IStateMachine.Break _b0_c2_Publish_Manager_t0;
    private no.ntnu.item.arctis.runtime.IStateMachine.Break _b0_c2_b0_Publish_Handler_t0;
    private com.bitreactive.library.mqtt.publisher.Publisher.Parameters _b0_c2_b0_Publish_Handler_t0_data;
    private no.ntnu.item.arctis.runtime.IStateMachine.Timer _b0_c2_b0_Publish_Handler_t2;
    private com.bitreactive.library.mqtt.MQTTMessage _b0_c2_b0_Publish_Handler_t2_data;
    private no.ntnu.item.arctis.runtime.IStateMachine.Break _b0_c2_b0_Publish_Handler_t3;
    private no.ntnu.item.arctis.runtime.IStateMachine.Break _b0_c2_b0_c1_Buffer_Eager_t0;
    private no.ntnu.item.arctis.runtime.IStateMachine.Timer _b0_c2_b1_Publish_Handler_2_t0;
    private no.ntnu.item.arctis.runtime.IStateMachine.Timer _b0_c2_b1_Publish_Handler_2_t1;
    private com.bitreactive.library.mqtt.MQTTMessage _b0_c2_b1_Publish_Handler_2_t1_data;
    private no.ntnu.item.arctis.runtime.IStateMachine.Break _b0_c2_b1_Publish_Handler_2_t2;
    private no.ntnu.item.arctis.runtime.IStateMachine.Break _b0_c2_b1_Publish_Handler_2_t3;
    private com.bitreactive.library.mqtt.publisher.Publisher.Parameters _b0_c2_b1_Publish_Handler_2_t3_data;
    private no.ntnu.item.arctis.runtime.IStateMachine.Break _b0_c3_Subscribe_Handler_t0;
    private no.ntnu.item.arctis.runtime.IStateMachine.Timer _b0_c3_c1_Timer_2_timer;
    private boolean b002_CONN_LOST_r0;
    private boolean b002_MSG_ARRIVED_r2;
    private boolean b003_INIT_OK_r0;
    private boolean b003_INIT_FAILED_r1;
    private boolean b003_RECONN_OK_r2;
    private boolean b003_RECONN_FAILED_r3;
    private boolean b008_PUB_OK_r0;
    private boolean b008_PUB_ERROR_r1;
    private boolean b010_PUB_OK_r0;
    private boolean b010_PUB_ERROR_r1;
    private boolean b011_REMOVED_r0;
    private boolean b011_INIT_r1;
    private boolean b014_SUBS_OK_r0;
    private boolean b014_SUBS_ERROR_r1;
    private boolean b016_SPEECH_READY_r0;
    private boolean b016_SPEECH_FAILED_r1;

    public ComponentSM(no.ntnu.item.arctis.runtime.Scheduler scheduler) {
        super(scheduler);
    }

    public int fireInitial() {
        b000 = new unit4.rpimqtt.component.Component();
        b000.setBlockID("b000", sessionID);
        b000.setRuntime(scheduler.getRuntime());
        b001 = new com.bitreactive.library.mqtt.robustmqtt.RobustMQTT();
        b001.setBlockID("b001", sessionID);
        b001.setRuntime(scheduler.getRuntime());
        b002 = new com.bitreactive.library.mqtt.createcallback.CreateCallback();
        b002.setBlockID("b002", sessionID);
        b002.setRuntime(scheduler.getRuntime());
        b003 = new com.bitreactive.library.mqtt.connhandler.ConnHandler();
        b003.setBlockID("b003", sessionID);
        b003.setRuntime(scheduler.getRuntime());
        b004 = new com.bitreactive.library.mqtt.publishmanager.PublishManager();
        b004.setBlockID("b004", sessionID);
        b004.setRuntime(scheduler.getRuntime());
        b005 = new com.bitreactive.library.mqtt.publishhandler.PublishHandler();
        b005.setBlockID("b005", sessionID);
        b005.setRuntime(scheduler.getRuntime());
        b006 = new com.bitreactive.library.mqtt.publishpolicy.PublishPolicy();
        b006.setBlockID("b006", sessionID);
        b006.setRuntime(scheduler.getRuntime());
        b007 = new com.bitreactive.library.buffering.buffereager.BufferEager<com.bitreactive.library.mqtt.MQTTMessage>(true, 100, true);
        b007.setBlockID("b007", sessionID);
        b007.setRuntime(scheduler.getRuntime());
        b008 = new com.bitreactive.library.mqtt.publisher.Publisher();
        b008.setBlockID("b008", sessionID);
        b008.setRuntime(scheduler.getRuntime());
        b009 = new com.bitreactive.library.mqtt.publishhandler2.PublishHandler2();
        b009.setBlockID("b009", sessionID);
        b009.setRuntime(scheduler.getRuntime());
        b010 = new com.bitreactive.library.mqtt.publisher.Publisher();
        b010.setBlockID("b010", sessionID);
        b010.setRuntime(scheduler.getRuntime());
        b011 = new com.bitreactive.library.buffering.persistentbuffer.PersistentBuffer<com.bitreactive.library.mqtt.MQTTMessage>();
        b011.setBlockID("b011", sessionID);
        b011.setRuntime(scheduler.getRuntime());
        b012 = new com.bitreactive.library.mqtt.publishpolicy.PublishPolicy();
        b012.setBlockID("b012", sessionID);
        b012.setRuntime(scheduler.getRuntime());
        b013 = new com.bitreactive.library.mqtt.subscribehandler.SubscribeHandler();
        b013.setBlockID("b013", sessionID);
        b013.setRuntime(scheduler.getRuntime());
        b014 = new com.bitreactive.library.mqtt.subscriber.Subscriber();
        b014.setBlockID("b014", sessionID);
        b014.setRuntime(scheduler.getRuntime());
        b015 = new com.bitreactive.library.timers.timer2.Timer2();
        b015.setBlockID("b015", sessionID);
        b015.setRuntime(scheduler.getRuntime());
        b016 = new no.ntnu.item.arctis.library.speech.speech.Speech();
        b016.setBlockID("b016", sessionID);
        b016.setRuntime(scheduler.getRuntime());
        b001_state = Com_bitreactive_library_mqtt_RobustMQTT._IDLE;
        b003_state = Com_bitreactive_library_mqtt_ConnHandler._IDLE;
        b005_state = Com_bitreactive_library_mqtt_PublishHandler._IDLE;
        b007_state = Com_bitreactive_library_buffering_BufferEager._IDLE;
        b009_state = Com_bitreactive_library_mqtt_PublishHandler2._IDLE;
        b011_state = Com_bitreactive_library_buffering_PersistentBuffer._IDLE;
        b014_state = Com_bitreactive_library_mqtt_Subscriber._IDLE;
        b015_state = Com_bitreactive_library_timers_Timer2._IDLE;
        b016_state = No_ntnu_item_arctis_library_speech_Speech._IDLE;
        b007_stm_state = Com_bitreactive_library_buffering_BufferEager_Stm._IDLE;
        _b0_c1_Conn_Handler_t0 = new no.ntnu.item.arctis.runtime.IStateMachine.Timer("_b0_c1_Conn_Handler_t0", this);
        _b0_c1_Conn_Handler_t1 = new no.ntnu.item.arctis.runtime.IStateMachine.Timer("_b0_c1_Conn_Handler_t1", this);
        _b0_c2_Publish_Manager_t0 = new no.ntnu.item.arctis.runtime.IStateMachine.Break("_b0_c2_Publish_Manager_t0", this);
        _b0_c2_b0_Publish_Handler_t0 = new no.ntnu.item.arctis.runtime.IStateMachine.Break("_b0_c2_b0_Publish_Handler_t0", this);
        _b0_c2_b0_Publish_Handler_t2 = new no.ntnu.item.arctis.runtime.IStateMachine.Timer(5000, "_b0_c2_b0_Publish_Handler_t2", this);
        _b0_c2_b0_Publish_Handler_t3 = new no.ntnu.item.arctis.runtime.IStateMachine.Break("_b0_c2_b0_Publish_Handler_t3", this);
        _b0_c2_b0_c1_Buffer_Eager_t0 = new no.ntnu.item.arctis.runtime.IStateMachine.Break("_b0_c2_b0_c1_Buffer_Eager_t0", this);
        _b0_c2_b1_Publish_Handler_2_t0 = new no.ntnu.item.arctis.runtime.IStateMachine.Timer("_b0_c2_b1_Publish_Handler_2_t0", this);
        _b0_c2_b1_Publish_Handler_2_t1 = new no.ntnu.item.arctis.runtime.IStateMachine.Timer(1000, "_b0_c2_b1_Publish_Handler_2_t1", this);
        _b0_c2_b1_Publish_Handler_2_t2 = new no.ntnu.item.arctis.runtime.IStateMachine.Break("_b0_c2_b1_Publish_Handler_2_t2", this);
        _b0_c2_b1_Publish_Handler_2_t3 = new no.ntnu.item.arctis.runtime.IStateMachine.Break("_b0_c2_b1_Publish_Handler_2_t3", this);
        _b0_c3_Subscribe_Handler_t0 = new no.ntnu.item.arctis.runtime.IStateMachine.Break("_b0_c3_Subscribe_Handler_t0", this);
        _b0_c3_c1_Timer_2_timer = new no.ntnu.item.arctis.runtime.IStateMachine.Timer("_b0_c3_c1_Timer_2_timer", this);
        com.sun.speech.freetts.Voice b016_o2 = b016.initVoice();
        if (b016_o2 == null) {
            // step 51969;
            return TERMINATE_MACHINE;
        } else {
            b016.myVoice = b016_o2;
            com.bitreactive.library.mqtt.robustmqtt.RobustMQTT.Parameters b000_o0 = b000.init();
            b001.p = b000_o0;
            com.bitreactive.library.mqtt.MQTTConfigParam b001_o0 = b001.getConfig();
            org.eclipse.paho.client.mqttv3.MqttCallback b002_o0 = b002.create(b001_o0);
            com.bitreactive.library.mqtt.connhandler.ConnHandler.Parameters b001_o1 = b001.startConn(b002_o0);
            b003.p = b001_o1;
            b003.start();
            b003.connect();
            b002_CONN_LOST_r0 = true;
            b002_MSG_ARRIVED_r2 = true;
            b003_INIT_OK_r0 = true;
            b003_INIT_FAILED_r1 = true;
            b001_state = Com_bitreactive_library_mqtt_RobustMQTT.INITIALIZING;
            b003_state = Com_bitreactive_library_mqtt_ConnHandler.INITIALIZING;
            b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
            // step 2a9ba;
            return CONSUME_SIGNAL;
        }
    }

    public int fireTimer(java.lang.String _timerID) {
        if (_timerID.equals("_b0_c1_Conn_Handler_t0")) {
            return handleTimer__b0_c1_Conn_Handler_t0();
        } else if (_timerID.equals("_b0_c1_Conn_Handler_t1")) {
            return handleTimer__b0_c1_Conn_Handler_t1();
        } else if (_timerID.equals("_b0_c2_Publish_Manager_t0")) {
            return handleTimer__b0_c2_Publish_Manager_t0();
        } else if (_timerID.equals("_b0_c2_b0_Publish_Handler_t0")) {
            return handleTimer__b0_c2_b0_Publish_Handler_t0();
        } else if (_timerID.equals("_b0_c2_b0_Publish_Handler_t2")) {
            return handleTimer__b0_c2_b0_Publish_Handler_t2();
        } else if (_timerID.equals("_b0_c2_b0_Publish_Handler_t3")) {
            return handleTimer__b0_c2_b0_Publish_Handler_t3();
        } else if (_timerID.equals("_b0_c2_b0_c1_Buffer_Eager_t0")) {
            return handleTimer__b0_c2_b0_c1_Buffer_Eager_t0();
        } else if (_timerID.equals("_b0_c2_b1_Publish_Handler_2_t0")) {
            return handleTimer__b0_c2_b1_Publish_Handler_2_t0();
        } else if (_timerID.equals("_b0_c2_b1_Publish_Handler_2_t1")) {
            return handleTimer__b0_c2_b1_Publish_Handler_2_t1();
        } else if (_timerID.equals("_b0_c2_b1_Publish_Handler_2_t2")) {
            return handleTimer__b0_c2_b1_Publish_Handler_2_t2();
        } else if (_timerID.equals("_b0_c2_b1_Publish_Handler_2_t3")) {
            return handleTimer__b0_c2_b1_Publish_Handler_2_t3();
        } else if (_timerID.equals("_b0_c3_Subscribe_Handler_t0")) {
            return handleTimer__b0_c3_Subscribe_Handler_t0();
        } else if (_timerID.equals("_b0_c3_c1_Timer_2_timer")) {
            return handleTimer__b0_c3_c1_Timer_2_timer();
        }
        return DISCARD_SIGNAL;
    }

    public int fire(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.String _signalID, java.lang.Object _data) {
        if (_signalID.equals("CONN_LOST_b002")) {
            return handleEvent_CONN_LOST_b002(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("MSG_ARRIVED_b002")) {
            return handleEvent_MSG_ARRIVED_b002(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("INIT_OK_b003")) {
            return handleEvent_INIT_OK_b003(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("INIT_FAILED_b003")) {
            return handleEvent_INIT_FAILED_b003(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("RECONN_OK_b003")) {
            return handleEvent_RECONN_OK_b003(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("RECONN_FAILED_b003")) {
            return handleEvent_RECONN_FAILED_b003(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("PUB_OK_b008")) {
            return handleEvent_PUB_OK_b008(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("PUB_ERROR_b008")) {
            return handleEvent_PUB_ERROR_b008(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("PUB_OK_b010")) {
            return handleEvent_PUB_OK_b010(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("PUB_ERROR_b010")) {
            return handleEvent_PUB_ERROR_b010(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("REMOVED_b011")) {
            return handleEvent_REMOVED_b011(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("INIT_b011")) {
            return handleEvent_INIT_b011(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("SUBS_OK_b014")) {
            return handleEvent_SUBS_OK_b014(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("SUBS_ERROR_b014")) {
            return handleEvent_SUBS_ERROR_b014(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("SPEECH_READY_b016")) {
            return handleEvent_SPEECH_READY_b016(_sender, receiverSessionID, _data);
        } else if (_signalID.equals("SPEECH_FAILED_b016")) {
            return handleEvent_SPEECH_FAILED_b016(_sender, receiverSessionID, _data);
        }
        return TRIGGER_UNKNOWN;
    }

    private int handleTimer__b0_c1_Conn_Handler_t0() {
        b003.reconnect();
        b003_RECONN_OK_r2 = true;
        b003_RECONN_FAILED_r3 = true;
        // step 61e31;
        return CONSUME_SIGNAL;
    }

    private int handleTimer__b0_c1_Conn_Handler_t1() {
        b003.connect();
        b003_INIT_OK_r0 = true;
        b003_INIT_FAILED_r1 = true;
        // step 33224;
        return CONSUME_SIGNAL;
    }

    private int handleTimer__b0_c2_Publish_Manager_t0() {
        b001_state = Com_bitreactive_library_mqtt_RobustMQTT.ACTIVE;
        // step a4202;
        return CONSUME_SIGNAL;
    }

    private int handleTimer__b0_c2_b0_Publish_Handler_t0() {
        b008.publish(_b0_c2_b0_Publish_Handler_t0_data);
        b008_PUB_OK_r0 = true;
        b008_PUB_ERROR_r1 = true;
        // step ab144;
        return CONSUME_SIGNAL;
    }

    private int handleTimer__b0_c2_b0_Publish_Handler_t2() {
        b006.msg = _b0_c2_b0_Publish_Handler_t2_data;
        if (b006.discardDueToFreshness()) {
            b006.getNext();
            scheduler.startBreak(_b0_c2_b0_Publish_Handler_t3);
            // step c62f0;
            return CONSUME_SIGNAL;
        } else {
            if (b006.isConnected()) {
                com.bitreactive.library.mqtt.publisher.Publisher.Parameters b006_o2 = b006.addClient();
                _b0_c2_b0_Publish_Handler_t0_data = b006_o2;
                scheduler.startBreak(_b0_c2_b0_Publish_Handler_t0);
                // step e7f42;
                return CONSUME_SIGNAL;
            } else {
                if (b006.discardDueToQos()) {
                    b006.getNext();
                    scheduler.startBreak(_b0_c2_b0_Publish_Handler_t3);
                    // step b1f92;
                    return CONSUME_SIGNAL;
                } else {
                    b006.toWait();
                    _b0_c2_b0_Publish_Handler_t2_data = b006.msg;
                    scheduler.startOrRestartTimer(_b0_c2_b0_Publish_Handler_t2);
                    // step e1bc7;
                    return CONSUME_SIGNAL;
                }
            }
        }
    }

    private int handleTimer__b0_c2_b0_Publish_Handler_t3() {
        if (b007.isEmpty()) {
            b007_stm_state = Com_bitreactive_library_buffering_BufferEager_Stm.READY;
            b007_state = Com_bitreactive_library_buffering_BufferEager.READY;
            // step f2f1e;
            return CONSUME_SIGNAL;
        } else {
            b007.getFromBuffer();
            b006.msg = b007.out;
            if (b006.discardDueToFreshness()) {
                b006.getNext();
                scheduler.startBreak(_b0_c2_b0_Publish_Handler_t3);
                // step 98543;
                return CONSUME_SIGNAL;
            } else {
                if (b006.isConnected()) {
                    com.bitreactive.library.mqtt.publisher.Publisher.Parameters b006_o2 = b006.addClient();
                    _b0_c2_b0_Publish_Handler_t0_data = b006_o2;
                    scheduler.startBreak(_b0_c2_b0_Publish_Handler_t0);
                    // step ea633;
                    return CONSUME_SIGNAL;
                } else {
                    if (b006.discardDueToQos()) {
                        b006.getNext();
                        scheduler.startBreak(_b0_c2_b0_Publish_Handler_t3);
                        // step 57ac8;
                        return CONSUME_SIGNAL;
                    } else {
                        b006.toWait();
                        _b0_c2_b0_Publish_Handler_t2_data = b006.msg;
                        scheduler.startOrRestartTimer(_b0_c2_b0_Publish_Handler_t2);
                        // step 95a1c;
                        return CONSUME_SIGNAL;
                    }
                }
            }
        }
    }

    private int handleTimer__b0_c2_b0_c1_Buffer_Eager_t0() {
        if (b007_state == Com_bitreactive_library_buffering_BufferEager.FIRSTITEMADDED) {
            if (b007_stm_state == Com_bitreactive_library_buffering_BufferEager_Stm.FIRSTITEMADDED) {
                b007.getFromBuffer();
                b007_stm_state = Com_bitreactive_library_buffering_BufferEager_Stm.ACTIVE;
                b006.msg = b007.out;
                if (b006.discardDueToFreshness()) {
                    b006.getNext();
                    scheduler.startBreak(_b0_c2_b0_Publish_Handler_t3);
                    b007_state = Com_bitreactive_library_buffering_BufferEager.ACTIVE;
                    // step 0966c;
                    return CONSUME_SIGNAL;
                } else {
                    if (b006.isConnected()) {
                        com.bitreactive.library.mqtt.publisher.Publisher.Parameters b006_o2 = b006.addClient();
                        _b0_c2_b0_Publish_Handler_t0_data = b006_o2;
                        scheduler.startBreak(_b0_c2_b0_Publish_Handler_t0);
                        b007_state = Com_bitreactive_library_buffering_BufferEager.ACTIVE;
                        // step 7d5af;
                        return CONSUME_SIGNAL;
                    } else {
                        if (b006.discardDueToQos()) {
                            b006.getNext();
                            scheduler.startBreak(_b0_c2_b0_Publish_Handler_t3);
                            b007_state = Com_bitreactive_library_buffering_BufferEager.ACTIVE;
                            // step d1a12;
                            return CONSUME_SIGNAL;
                        } else {
                            b006.toWait();
                            _b0_c2_b0_Publish_Handler_t2_data = b006.msg;
                            scheduler.startOrRestartTimer(_b0_c2_b0_Publish_Handler_t2);
                            b007_state = Com_bitreactive_library_buffering_BufferEager.ACTIVE;
                            // step d1e88;
                            return CONSUME_SIGNAL;
                        }
                    }
                }
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleTimer__b0_c2_b1_Publish_Handler_2_t0() {
        com.bitreactive.library.mqtt.MQTTMessage b011_o1 = b011.peek();
        if (b011_o1 == null) {
            b009.empty();
            int b009_o2 = b009.getDuration();
            scheduler.startOrRestartTimer(_b0_c2_b1_Publish_Handler_2_t0, b009_o2);
            // step 380a0;
            return CONSUME_SIGNAL;
        } else {
            b012.msg = b011_o1;
            if (b012.discardDueToFreshness()) {
                b012.getNext();
                scheduler.startBreak(_b0_c2_b1_Publish_Handler_2_t2);
                // step 35f70;
                return CONSUME_SIGNAL;
            } else {
                if (b012.isConnected()) {
                    com.bitreactive.library.mqtt.publisher.Publisher.Parameters b012_o2 = b012.addClient();
                    _b0_c2_b1_Publish_Handler_2_t3_data = b012_o2;
                    scheduler.startBreak(_b0_c2_b1_Publish_Handler_2_t3);
                    // step 1f5ff;
                    return CONSUME_SIGNAL;
                } else {
                    if (b012.discardDueToQos()) {
                        b012.getNext();
                        scheduler.startBreak(_b0_c2_b1_Publish_Handler_2_t2);
                        // step c6c88;
                        return CONSUME_SIGNAL;
                    } else {
                        b012.toWait();
                        _b0_c2_b1_Publish_Handler_2_t1_data = b012.msg;
                        scheduler.startOrRestartTimer(_b0_c2_b1_Publish_Handler_2_t1);
                        // step de7a7;
                        return CONSUME_SIGNAL;
                    }
                }
            }
        }
    }

    private int handleTimer__b0_c2_b1_Publish_Handler_2_t1() {
        b012.msg = _b0_c2_b1_Publish_Handler_2_t1_data;
        if (b012.discardDueToFreshness()) {
            b012.getNext();
            scheduler.startBreak(_b0_c2_b1_Publish_Handler_2_t2);
            // step 14e53;
            return CONSUME_SIGNAL;
        } else {
            if (b012.isConnected()) {
                com.bitreactive.library.mqtt.publisher.Publisher.Parameters b012_o2 = b012.addClient();
                _b0_c2_b1_Publish_Handler_2_t3_data = b012_o2;
                scheduler.startBreak(_b0_c2_b1_Publish_Handler_2_t3);
                // step 3d49e;
                return CONSUME_SIGNAL;
            } else {
                if (b012.discardDueToQos()) {
                    b012.getNext();
                    scheduler.startBreak(_b0_c2_b1_Publish_Handler_2_t2);
                    // step 448d0;
                    return CONSUME_SIGNAL;
                } else {
                    b012.toWait();
                    _b0_c2_b1_Publish_Handler_2_t1_data = b012.msg;
                    scheduler.startOrRestartTimer(_b0_c2_b1_Publish_Handler_2_t1);
                    // step abc3c;
                    return CONSUME_SIGNAL;
                }
            }
        }
    }

    private int handleTimer__b0_c2_b1_Publish_Handler_2_t2() {
        b011.remove();
        b011_REMOVED_r0 = true;
        b011_state = Com_bitreactive_library_buffering_PersistentBuffer.REMOVING;
        // step be560;
        return CONSUME_SIGNAL;
    }

    private int handleTimer__b0_c2_b1_Publish_Handler_2_t3() {
        b010.publish(_b0_c2_b1_Publish_Handler_2_t3_data);
        b010_PUB_OK_r0 = true;
        b010_PUB_ERROR_r1 = true;
        // step e81da;
        return CONSUME_SIGNAL;
    }

    private int handleTimer__b0_c3_Subscribe_Handler_t0() {
        b014.subscribe(b013.p);
        b014_SUBS_OK_r0 = true;
        b014_SUBS_ERROR_r1 = true;
        b014_state = Com_bitreactive_library_mqtt_Subscriber.ACTIVE;
        // step a613e;
        return CONSUME_SIGNAL;
    }

    private int handleTimer__b0_c3_c1_Timer_2_timer() {
        b014.subscribe(b013.p);
        b014_SUBS_OK_r0 = true;
        b014_SUBS_ERROR_r1 = true;
        b014_state = Com_bitreactive_library_mqtt_Subscriber.ACTIVE;
        b015_state = Com_bitreactive_library_timers_Timer2._IDLE;
        // step f9aff;
        return CONSUME_SIGNAL;
    }

    private int handleEvent_CONN_LOST_b002(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b002_CONN_LOST_r0) {
            b001.connLost(((java.lang.String) _data));
            if (b003_state == Com_bitreactive_library_mqtt_ConnHandler.ACTIVE) {
                boolean b003_o5 = b003.tryReconnect();
                if (b003_o5 == true) {
                    // step 6f1a5;
                    return CONSUME_SIGNAL;
                } else {
                    b003.reconnect();
                    b003_RECONN_OK_r2 = true;
                    b003_RECONN_FAILED_r3 = true;
                    // step 65d07;
                    return CONSUME_SIGNAL;
                }
            } else {
                // step 17609;
                return CONSUME_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_MSG_ARRIVED_b002(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b002_MSG_ARRIVED_r2) {
            if (b001_state == Com_bitreactive_library_mqtt_RobustMQTT.ACTIVE) {
                java.lang.String b000_o1 = b000.readMSG(((com.bitreactive.library.mqtt.MQTTMessage) _data));
                if (b016_state == No_ntnu_item_arctis_library_speech_Speech.SPEAKING) {
                    // step 8ab61;
                    return CONSUME_SIGNAL;
                } else if (b016_state == No_ntnu_item_arctis_library_speech_Speech.ACTIVE) {
                    b016.speak(b000_o1);
                    b016_SPEECH_READY_r0 = true;
                    b016_SPEECH_FAILED_r1 = true;
                    b016_state = No_ntnu_item_arctis_library_speech_Speech.SPEAKING;
                    // step 78154;
                    return CONSUME_SIGNAL;
                } else {
                    return DISCARD_SIGNAL;
                }
            } else {
                // step 18bc2;
                return CONSUME_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_INIT_OK_b003(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b003_INIT_OK_r0) {
            if (b003_state == Com_bitreactive_library_mqtt_ConnHandler.INITIALIZING) {
                b001.client = ((org.eclipse.paho.client.mqttv3.MqttClient) _data);
                com.bitreactive.library.mqtt.subscriber.Subscriber.Parameters b001_o2 = b001.getSubscribeParam();
                b013.p = b001_o2;
                if (b013.containTopic()) {
                    b014.stop();
                    com.bitreactive.library.mqtt.publishmanager.PublishManager.Parameters b001_o3 = b001.getPublishParam();
                    b004.p = b001_o3;
                    boolean b004_o0 = b004.usePersistent();
                    if (b004_o0 == true) {
                        com.bitreactive.library.mqtt.publishhandler2.PublishHandler2.Parameters b004_o2 = b004.createParam2();
                        b009.p = b004_o2;
                        java.lang.String b009_o0 = b009.getFilename();
                        com.bitreactive.library.mqtt.publishpolicy.PublishPolicy.Parameters b009_o5 = b009.getParams();
                        b011.init(b009_o0);
                        b012.p = b009_o5;
                        scheduler.stopTimer(_b0_c3_c1_Timer_2_timer);
                        scheduler.startBreak(_b0_c3_Subscribe_Handler_t0);
                        b003_INIT_OK_r0 = false;
                        b014_SUBS_OK_r0 = false;
                        scheduler.flushEventQueue(sessionID, "SUBS_OK_b014");
                        b014_SUBS_ERROR_r1 = false;
                        scheduler.flushEventQueue(sessionID, "SUBS_ERROR_b014");
                        b011_INIT_r1 = true;
                        b003_state = Com_bitreactive_library_mqtt_ConnHandler.ACTIVE;
                        b009_state = Com_bitreactive_library_mqtt_PublishHandler2.INITIALIZING;
                        b011_state = Com_bitreactive_library_buffering_PersistentBuffer.INITIALIZING;
                        // step 93f62;
                        return CONSUME_SIGNAL;
                    } else {
                        com.bitreactive.library.mqtt.publishpolicy.PublishPolicy.Parameters b004_o1 = b004.createParam();
                        b006.p = b004_o1;
                        b007.emptyBuffer();
                        b007_stm_state = Com_bitreactive_library_buffering_BufferEager_Stm.READY;
                        scheduler.stopTimer(_b0_c3_c1_Timer_2_timer);
                        scheduler.startBreak(_b0_c2_Publish_Manager_t0);
                        scheduler.startBreak(_b0_c3_Subscribe_Handler_t0);
                        b003_INIT_OK_r0 = false;
                        b014_SUBS_OK_r0 = false;
                        scheduler.flushEventQueue(sessionID, "SUBS_OK_b014");
                        b014_SUBS_ERROR_r1 = false;
                        scheduler.flushEventQueue(sessionID, "SUBS_ERROR_b014");
                        b003_state = Com_bitreactive_library_mqtt_ConnHandler.ACTIVE;
                        b005_state = Com_bitreactive_library_mqtt_PublishHandler.ACTIVE;
                        b007_state = Com_bitreactive_library_buffering_BufferEager.READY;
                        // step 79eab;
                        return CONSUME_SIGNAL;
                    }
                } else {
                    com.bitreactive.library.mqtt.publishmanager.PublishManager.Parameters b001_o3 = b001.getPublishParam();
                    b004.p = b001_o3;
                    boolean b004_o0 = b004.usePersistent();
                    if (b004_o0 == true) {
                        com.bitreactive.library.mqtt.publishhandler2.PublishHandler2.Parameters b004_o2 = b004.createParam2();
                        b009.p = b004_o2;
                        java.lang.String b009_o0 = b009.getFilename();
                        com.bitreactive.library.mqtt.publishpolicy.PublishPolicy.Parameters b009_o5 = b009.getParams();
                        b011.init(b009_o0);
                        b012.p = b009_o5;
                        b003_INIT_OK_r0 = false;
                        b011_INIT_r1 = true;
                        b003_state = Com_bitreactive_library_mqtt_ConnHandler.ACTIVE;
                        b009_state = Com_bitreactive_library_mqtt_PublishHandler2.INITIALIZING;
                        b011_state = Com_bitreactive_library_buffering_PersistentBuffer.INITIALIZING;
                        // step 18dfc;
                        return CONSUME_SIGNAL;
                    } else {
                        com.bitreactive.library.mqtt.publishpolicy.PublishPolicy.Parameters b004_o1 = b004.createParam();
                        b006.p = b004_o1;
                        b007.emptyBuffer();
                        b007_stm_state = Com_bitreactive_library_buffering_BufferEager_Stm.READY;
                        scheduler.startBreak(_b0_c2_Publish_Manager_t0);
                        b003_INIT_OK_r0 = false;
                        b003_state = Com_bitreactive_library_mqtt_ConnHandler.ACTIVE;
                        b005_state = Com_bitreactive_library_mqtt_PublishHandler.ACTIVE;
                        b007_state = Com_bitreactive_library_buffering_BufferEager.READY;
                        // step 3cbe3;
                        return CONSUME_SIGNAL;
                    }
                }
            } else {
                b003_INIT_OK_r0 = false;
                // step eec18;
                return CONSUME_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_INIT_FAILED_b003(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b003_INIT_FAILED_r1) {
            int b003_o4 = b003.getWaitingDuration();
            scheduler.startOrRestartTimer(_b0_c1_Conn_Handler_t1, b003_o4);
            b003_INIT_FAILED_r1 = false;
            // step 4dfd2;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_RECONN_OK_b003(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b003_RECONN_OK_r2) {
            if (b013.containTopic()) {
                if (b015_state == Com_bitreactive_library_timers_Timer2._IDLE) {
                    if (b014_state == Com_bitreactive_library_mqtt_Subscriber._IDLE) {
                        b014.stop();
                        scheduler.stopTimer(_b0_c3_c1_Timer_2_timer);
                        scheduler.startBreak(_b0_c3_Subscribe_Handler_t0);
                        b003_RECONN_OK_r2 = false;
                        b014_SUBS_OK_r0 = false;
                        scheduler.flushEventQueue(sessionID, "SUBS_OK_b014");
                        b014_SUBS_ERROR_r1 = false;
                        scheduler.flushEventQueue(sessionID, "SUBS_ERROR_b014");
                        // step 5a713;
                        return CONSUME_SIGNAL;
                    } else if (b014_state == Com_bitreactive_library_mqtt_Subscriber.ACTIVE) {
                        b014.stop();
                        scheduler.stopTimer(_b0_c3_c1_Timer_2_timer);
                        scheduler.startBreak(_b0_c3_Subscribe_Handler_t0);
                        b003_RECONN_OK_r2 = false;
                        b014_SUBS_OK_r0 = false;
                        scheduler.flushEventQueue(sessionID, "SUBS_OK_b014");
                        b014_SUBS_ERROR_r1 = false;
                        scheduler.flushEventQueue(sessionID, "SUBS_ERROR_b014");
                        b014_state = Com_bitreactive_library_mqtt_Subscriber._IDLE;
                        // step 00cb1;
                        return CONSUME_SIGNAL;
                    } else {
                        return DISCARD_SIGNAL;
                    }
                } else if (b015_state == Com_bitreactive_library_timers_Timer2.ACTIVE) {
                    b014.stop();
                    scheduler.stopTimer(_b0_c3_c1_Timer_2_timer);
                    scheduler.startBreak(_b0_c3_Subscribe_Handler_t0);
                    b003_RECONN_OK_r2 = false;
                    b014_SUBS_OK_r0 = false;
                    scheduler.flushEventQueue(sessionID, "SUBS_OK_b014");
                    b014_SUBS_ERROR_r1 = false;
                    scheduler.flushEventQueue(sessionID, "SUBS_ERROR_b014");
                    b015_state = Com_bitreactive_library_timers_Timer2._IDLE;
                    // step 3913f;
                    return CONSUME_SIGNAL;
                } else {
                    return DISCARD_SIGNAL;
                }
            } else {
                b003_RECONN_OK_r2 = false;
                // step 68500;
                return CONSUME_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_RECONN_FAILED_b003(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b003_RECONN_FAILED_r3) {
            int b003_o3 = b003.getWaitingDuration();
            scheduler.startOrRestartTimer(_b0_c1_Conn_Handler_t0, b003_o3);
            b003_RECONN_FAILED_r3 = false;
            // step 378ff;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_PUB_OK_b008(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b008_PUB_OK_r0) {
            if (b007.isEmpty()) {
                b007_stm_state = Com_bitreactive_library_buffering_BufferEager_Stm.READY;
                b008_PUB_OK_r0 = false;
                scheduler.flushEventQueue(sessionID, "PUB_OK_b008");
                b008_PUB_ERROR_r1 = false;
                scheduler.flushEventQueue(sessionID, "PUB_ERROR_b008");
                b007_state = Com_bitreactive_library_buffering_BufferEager.READY;
                // step 692f6;
                return CONSUME_SIGNAL;
            } else {
                b007.getFromBuffer();
                b006.msg = b007.out;
                if (b006.discardDueToFreshness()) {
                    b006.getNext();
                    scheduler.startBreak(_b0_c2_b0_Publish_Handler_t3);
                    b008_PUB_OK_r0 = false;
                    scheduler.flushEventQueue(sessionID, "PUB_OK_b008");
                    b008_PUB_ERROR_r1 = false;
                    scheduler.flushEventQueue(sessionID, "PUB_ERROR_b008");
                    // step 0c6a4;
                    return CONSUME_SIGNAL;
                } else {
                    if (b006.isConnected()) {
                        com.bitreactive.library.mqtt.publisher.Publisher.Parameters b006_o2 = b006.addClient();
                        _b0_c2_b0_Publish_Handler_t0_data = b006_o2;
                        scheduler.startBreak(_b0_c2_b0_Publish_Handler_t0);
                        b008_PUB_OK_r0 = false;
                        scheduler.flushEventQueue(sessionID, "PUB_OK_b008");
                        b008_PUB_ERROR_r1 = false;
                        scheduler.flushEventQueue(sessionID, "PUB_ERROR_b008");
                        // step b8e67;
                        return CONSUME_SIGNAL;
                    } else {
                        if (b006.discardDueToQos()) {
                            b006.getNext();
                            scheduler.startBreak(_b0_c2_b0_Publish_Handler_t3);
                            b008_PUB_OK_r0 = false;
                            scheduler.flushEventQueue(sessionID, "PUB_OK_b008");
                            b008_PUB_ERROR_r1 = false;
                            scheduler.flushEventQueue(sessionID, "PUB_ERROR_b008");
                            // step 1c58a;
                            return CONSUME_SIGNAL;
                        } else {
                            b006.toWait();
                            _b0_c2_b0_Publish_Handler_t2_data = b006.msg;
                            scheduler.startOrRestartTimer(_b0_c2_b0_Publish_Handler_t2);
                            b008_PUB_OK_r0 = false;
                            scheduler.flushEventQueue(sessionID, "PUB_OK_b008");
                            b008_PUB_ERROR_r1 = false;
                            scheduler.flushEventQueue(sessionID, "PUB_ERROR_b008");
                            // step be289;
                            return CONSUME_SIGNAL;
                        }
                    }
                }
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_PUB_ERROR_b008(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b008_PUB_ERROR_r1) {
            b006.msg = ((com.bitreactive.library.mqtt.MQTTMessage) _data);
            if (b006.discardDueToFreshness()) {
                b006.getNext();
                scheduler.startBreak(_b0_c2_b0_Publish_Handler_t3);
                b008_PUB_OK_r0 = false;
                scheduler.flushEventQueue(sessionID, "PUB_OK_b008");
                b008_PUB_ERROR_r1 = false;
                scheduler.flushEventQueue(sessionID, "PUB_ERROR_b008");
                // step 863ad;
                return CONSUME_SIGNAL;
            } else {
                if (b006.discardDueToQos()) {
                    b006.getNext();
                    scheduler.startBreak(_b0_c2_b0_Publish_Handler_t3);
                    b008_PUB_OK_r0 = false;
                    scheduler.flushEventQueue(sessionID, "PUB_OK_b008");
                    b008_PUB_ERROR_r1 = false;
                    scheduler.flushEventQueue(sessionID, "PUB_ERROR_b008");
                    // step 3d352;
                    return CONSUME_SIGNAL;
                } else {
                    com.bitreactive.library.mqtt.publisher.Publisher.Parameters b006_o2 = b006.addClient();
                    _b0_c2_b0_Publish_Handler_t0_data = b006_o2;
                    scheduler.startBreak(_b0_c2_b0_Publish_Handler_t0);
                    b008_PUB_OK_r0 = false;
                    scheduler.flushEventQueue(sessionID, "PUB_OK_b008");
                    b008_PUB_ERROR_r1 = false;
                    scheduler.flushEventQueue(sessionID, "PUB_ERROR_b008");
                    // step c9d37;
                    return CONSUME_SIGNAL;
                }
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_PUB_OK_b010(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b010_PUB_OK_r0) {
            b011.remove();
            b010_PUB_OK_r0 = false;
            scheduler.flushEventQueue(sessionID, "PUB_OK_b010");
            b010_PUB_ERROR_r1 = false;
            scheduler.flushEventQueue(sessionID, "PUB_ERROR_b010");
            b011_REMOVED_r0 = true;
            b011_state = Com_bitreactive_library_buffering_PersistentBuffer.REMOVING;
            // step d5722;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_PUB_ERROR_b010(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b010_PUB_ERROR_r1) {
            b012.msg = ((com.bitreactive.library.mqtt.MQTTMessage) _data);
            if (b012.discardDueToFreshness()) {
                b012.getNext();
                scheduler.startBreak(_b0_c2_b1_Publish_Handler_2_t2);
                b010_PUB_OK_r0 = false;
                scheduler.flushEventQueue(sessionID, "PUB_OK_b010");
                b010_PUB_ERROR_r1 = false;
                scheduler.flushEventQueue(sessionID, "PUB_ERROR_b010");
                // step 68e43;
                return CONSUME_SIGNAL;
            } else {
                if (b012.discardDueToQos()) {
                    b012.getNext();
                    scheduler.startBreak(_b0_c2_b1_Publish_Handler_2_t2);
                    b010_PUB_OK_r0 = false;
                    scheduler.flushEventQueue(sessionID, "PUB_OK_b010");
                    b010_PUB_ERROR_r1 = false;
                    scheduler.flushEventQueue(sessionID, "PUB_ERROR_b010");
                    // step b5053;
                    return CONSUME_SIGNAL;
                } else {
                    com.bitreactive.library.mqtt.publisher.Publisher.Parameters b012_o2 = b012.addClient();
                    _b0_c2_b1_Publish_Handler_2_t3_data = b012_o2;
                    scheduler.startBreak(_b0_c2_b1_Publish_Handler_2_t3);
                    b010_PUB_OK_r0 = false;
                    scheduler.flushEventQueue(sessionID, "PUB_OK_b010");
                    b010_PUB_ERROR_r1 = false;
                    scheduler.flushEventQueue(sessionID, "PUB_ERROR_b010");
                    // step 3d571;
                    return CONSUME_SIGNAL;
                }
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_REMOVED_b011(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b011_REMOVED_r0) {
            if (((com.bitreactive.library.mqtt.MQTTMessage) _data) == null) {
                b009.empty();
                int b009_o2 = b009.getDuration();
                scheduler.startOrRestartTimer(_b0_c2_b1_Publish_Handler_2_t0, b009_o2);
                b011_REMOVED_r0 = false;
                b011_state = Com_bitreactive_library_buffering_PersistentBuffer.ACTIVE;
                // step 181be;
                return CONSUME_SIGNAL;
            } else {
                b009.removed();
                int b009_o2 = b009.getDuration();
                scheduler.startOrRestartTimer(_b0_c2_b1_Publish_Handler_2_t0, b009_o2);
                b011_REMOVED_r0 = false;
                b011_state = Com_bitreactive_library_buffering_PersistentBuffer.ACTIVE;
                // step 0fd70;
                return CONSUME_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_INIT_b011(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b011_INIT_r1) {
            int b009_o2 = b009.getDuration();
            scheduler.startOrRestartTimer(_b0_c2_b1_Publish_Handler_2_t0, b009_o2);
            b011_INIT_r1 = false;
            b001_state = Com_bitreactive_library_mqtt_RobustMQTT.ACTIVE;
            b009_state = Com_bitreactive_library_mqtt_PublishHandler2.ACTIVE;
            b011_state = Com_bitreactive_library_buffering_PersistentBuffer.ACTIVE;
            // step 9c61c;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_SUBS_OK_b014(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b014_SUBS_OK_r0) {
            b014_SUBS_OK_r0 = false;
            scheduler.flushEventQueue(sessionID, "SUBS_OK_b014");
            b014_SUBS_ERROR_r1 = false;
            scheduler.flushEventQueue(sessionID, "SUBS_ERROR_b014");
            b014_state = Com_bitreactive_library_mqtt_Subscriber._IDLE;
            // step 83ba1;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_SUBS_ERROR_b014(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b014_SUBS_ERROR_r1) {
            int b013_o0 = b013.getDuration();
            b015.duration = b013_o0;
            scheduler.startOrRestartTimer(_b0_c3_c1_Timer_2_timer, b015.duration);
            b014_SUBS_OK_r0 = false;
            scheduler.flushEventQueue(sessionID, "SUBS_OK_b014");
            b014_SUBS_ERROR_r1 = false;
            scheduler.flushEventQueue(sessionID, "SUBS_ERROR_b014");
            b014_state = Com_bitreactive_library_mqtt_Subscriber._IDLE;
            b015_state = Com_bitreactive_library_timers_Timer2.ACTIVE;
            // step 2ff4f;
            return CONSUME_SIGNAL;
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_SPEECH_READY_b016(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b016_SPEECH_READY_r0) {
            if (b016_state == No_ntnu_item_arctis_library_speech_Speech.ACTIVE) {
                b016_SPEECH_READY_r0 = false;
                // step 4230b;
                return CONSUME_SIGNAL;
            } else if (b016_state == No_ntnu_item_arctis_library_speech_Speech.SPEAKING) {
                b000.CNF();
                com.bitreactive.library.mqtt.MQTTMessage b000_o2 = b000.createMSG(b000.speech_status);
                if (b009_state == Com_bitreactive_library_mqtt_PublishHandler2.ACTIVE) {
                    b012.msg = b000_o2;
                    if (b012.isConnected()) {
                        b012.buffer();
                        if (b011_state == Com_bitreactive_library_buffering_PersistentBuffer.ACTIVE) {
                            b011.add(b012.msg);
                            b016_SPEECH_READY_r0 = false;
                            b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                            // step 0f09f;
                            return CONSUME_SIGNAL;
                        } else if (b011_state == Com_bitreactive_library_buffering_PersistentBuffer.REMOVING) {
                            b011.add(b012.msg);
                            b016_SPEECH_READY_r0 = false;
                            b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                            // step 152ee;
                            return CONSUME_SIGNAL;
                        } else {
                            return DISCARD_SIGNAL;
                        }
                    } else {
                        if (b012.discardDueToQos()) {
                            b016_SPEECH_READY_r0 = false;
                            b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                            // step 21cbe;
                            return CONSUME_SIGNAL;
                        } else {
                            b012.buffer();
                            if (b011_state == Com_bitreactive_library_buffering_PersistentBuffer.ACTIVE) {
                                b011.add(b012.msg);
                                b016_SPEECH_READY_r0 = false;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step bdd4a;
                                return CONSUME_SIGNAL;
                            } else if (b011_state == Com_bitreactive_library_buffering_PersistentBuffer.REMOVING) {
                                b011.add(b012.msg);
                                b016_SPEECH_READY_r0 = false;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step 55fa6;
                                return CONSUME_SIGNAL;
                            } else {
                                return DISCARD_SIGNAL;
                            }
                        }
                    }
                } else if (b005_state == Com_bitreactive_library_mqtt_PublishHandler.ACTIVE) {
                    b006.msg = b000_o2;
                    if (b006.isConnected()) {
                        b006.buffer();
                        if (b007_state == Com_bitreactive_library_buffering_BufferEager.ACTIVE) {
                            b007.add = b006.msg;
                            if (b007.hasRoom()) {
                                b007.addToBuffer();
                                b016_SPEECH_READY_r0 = false;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step faa36;
                                return CONSUME_SIGNAL;
                            } else {
                                b005.overflow(b007.overflow);
                                b016_SPEECH_READY_r0 = false;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step c9234;
                                return CONSUME_SIGNAL;
                            }
                        } else if (b007_state == Com_bitreactive_library_buffering_BufferEager.FIRSTITEMADDED) {
                            b007.add = b006.msg;
                            if (b007.hasRoom()) {
                                b007.addToBuffer();
                                b016_SPEECH_READY_r0 = false;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step 677e0;
                                return CONSUME_SIGNAL;
                            } else {
                                b005.overflow(b007.overflow);
                                b016_SPEECH_READY_r0 = false;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step b5962;
                                return CONSUME_SIGNAL;
                            }
                        } else if (b007_state == Com_bitreactive_library_buffering_BufferEager.READY) {
                            b007.add = b006.msg;
                            b007.addToBuffer();
                            scheduler.startBreak(_b0_c2_b0_c1_Buffer_Eager_t0);
                            b007_stm_state = Com_bitreactive_library_buffering_BufferEager_Stm.FIRSTITEMADDED;
                            b016_SPEECH_READY_r0 = false;
                            b007_state = Com_bitreactive_library_buffering_BufferEager.FIRSTITEMADDED;
                            b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                            // step 39068;
                            return CONSUME_SIGNAL;
                        } else {
                            return DISCARD_SIGNAL;
                        }
                    } else {
                        if (b006.discardDueToQos()) {
                            b016_SPEECH_READY_r0 = false;
                            b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                            // step 844ba;
                            return CONSUME_SIGNAL;
                        } else {
                            b006.buffer();
                            if (b007_state == Com_bitreactive_library_buffering_BufferEager.ACTIVE) {
                                b007.add = b006.msg;
                                if (b007.hasRoom()) {
                                    b007.addToBuffer();
                                    b016_SPEECH_READY_r0 = false;
                                    b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                    // step fe7c5;
                                    return CONSUME_SIGNAL;
                                } else {
                                    b005.overflow(b007.overflow);
                                    b016_SPEECH_READY_r0 = false;
                                    b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                    // step db2d9;
                                    return CONSUME_SIGNAL;
                                }
                            } else if (b007_state == Com_bitreactive_library_buffering_BufferEager.FIRSTITEMADDED) {
                                b007.add = b006.msg;
                                if (b007.hasRoom()) {
                                    b007.addToBuffer();
                                    b016_SPEECH_READY_r0 = false;
                                    b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                    // step b25f9;
                                    return CONSUME_SIGNAL;
                                } else {
                                    b005.overflow(b007.overflow);
                                    b016_SPEECH_READY_r0 = false;
                                    b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                    // step 07281;
                                    return CONSUME_SIGNAL;
                                }
                            } else if (b007_state == Com_bitreactive_library_buffering_BufferEager.READY) {
                                b007.add = b006.msg;
                                b007.addToBuffer();
                                scheduler.startBreak(_b0_c2_b0_c1_Buffer_Eager_t0);
                                b007_stm_state = Com_bitreactive_library_buffering_BufferEager_Stm.FIRSTITEMADDED;
                                b016_SPEECH_READY_r0 = false;
                                b007_state = Com_bitreactive_library_buffering_BufferEager.FIRSTITEMADDED;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step 92597;
                                return CONSUME_SIGNAL;
                            } else {
                                return DISCARD_SIGNAL;
                            }
                        }
                    }
                } else {
                    return BLOCKING_CHOICE;
                }
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }

    private int handleEvent_SPEECH_FAILED_b016(java.lang.Object _sender, java.lang.Object receiverSessionID, java.lang.Object _data) {
        if (b016_SPEECH_FAILED_r1) {
            if (b016_state == No_ntnu_item_arctis_library_speech_Speech.ACTIVE) {
                b016_SPEECH_FAILED_r1 = false;
                // step 28235;
                return CONSUME_SIGNAL;
            } else if (b016_state == No_ntnu_item_arctis_library_speech_Speech.SPEAKING) {
                b000.NEG();
                com.bitreactive.library.mqtt.MQTTMessage b000_o2 = b000.createMSG(b000.speech_status);
                if (b009_state == Com_bitreactive_library_mqtt_PublishHandler2.ACTIVE) {
                    b012.msg = b000_o2;
                    if (b012.isConnected()) {
                        b012.buffer();
                        if (b011_state == Com_bitreactive_library_buffering_PersistentBuffer.ACTIVE) {
                            b011.add(b012.msg);
                            b016_SPEECH_FAILED_r1 = false;
                            b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                            // step 2c62b;
                            return CONSUME_SIGNAL;
                        } else if (b011_state == Com_bitreactive_library_buffering_PersistentBuffer.REMOVING) {
                            b011.add(b012.msg);
                            b016_SPEECH_FAILED_r1 = false;
                            b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                            // step 58bfe;
                            return CONSUME_SIGNAL;
                        } else {
                            return DISCARD_SIGNAL;
                        }
                    } else {
                        if (b012.discardDueToQos()) {
                            b016_SPEECH_FAILED_r1 = false;
                            b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                            // step b326f;
                            return CONSUME_SIGNAL;
                        } else {
                            b012.buffer();
                            if (b011_state == Com_bitreactive_library_buffering_PersistentBuffer.ACTIVE) {
                                b011.add(b012.msg);
                                b016_SPEECH_FAILED_r1 = false;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step cf91f;
                                return CONSUME_SIGNAL;
                            } else if (b011_state == Com_bitreactive_library_buffering_PersistentBuffer.REMOVING) {
                                b011.add(b012.msg);
                                b016_SPEECH_FAILED_r1 = false;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step fedf3;
                                return CONSUME_SIGNAL;
                            } else {
                                return DISCARD_SIGNAL;
                            }
                        }
                    }
                } else if (b005_state == Com_bitreactive_library_mqtt_PublishHandler.ACTIVE) {
                    b006.msg = b000_o2;
                    if (b006.isConnected()) {
                        b006.buffer();
                        if (b007_state == Com_bitreactive_library_buffering_BufferEager.ACTIVE) {
                            b007.add = b006.msg;
                            if (b007.hasRoom()) {
                                b007.addToBuffer();
                                b016_SPEECH_FAILED_r1 = false;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step 20c45;
                                return CONSUME_SIGNAL;
                            } else {
                                b005.overflow(b007.overflow);
                                b016_SPEECH_FAILED_r1 = false;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step a79ce;
                                return CONSUME_SIGNAL;
                            }
                        } else if (b007_state == Com_bitreactive_library_buffering_BufferEager.FIRSTITEMADDED) {
                            b007.add = b006.msg;
                            if (b007.hasRoom()) {
                                b007.addToBuffer();
                                b016_SPEECH_FAILED_r1 = false;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step f346e;
                                return CONSUME_SIGNAL;
                            } else {
                                b005.overflow(b007.overflow);
                                b016_SPEECH_FAILED_r1 = false;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step 72661;
                                return CONSUME_SIGNAL;
                            }
                        } else if (b007_state == Com_bitreactive_library_buffering_BufferEager.READY) {
                            b007.add = b006.msg;
                            b007.addToBuffer();
                            scheduler.startBreak(_b0_c2_b0_c1_Buffer_Eager_t0);
                            b007_stm_state = Com_bitreactive_library_buffering_BufferEager_Stm.FIRSTITEMADDED;
                            b016_SPEECH_FAILED_r1 = false;
                            b007_state = Com_bitreactive_library_buffering_BufferEager.FIRSTITEMADDED;
                            b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                            // step 5b652;
                            return CONSUME_SIGNAL;
                        } else {
                            return DISCARD_SIGNAL;
                        }
                    } else {
                        if (b006.discardDueToQos()) {
                            b016_SPEECH_FAILED_r1 = false;
                            b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                            // step bd384;
                            return CONSUME_SIGNAL;
                        } else {
                            b006.buffer();
                            if (b007_state == Com_bitreactive_library_buffering_BufferEager.ACTIVE) {
                                b007.add = b006.msg;
                                if (b007.hasRoom()) {
                                    b007.addToBuffer();
                                    b016_SPEECH_FAILED_r1 = false;
                                    b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                    // step 21577;
                                    return CONSUME_SIGNAL;
                                } else {
                                    b005.overflow(b007.overflow);
                                    b016_SPEECH_FAILED_r1 = false;
                                    b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                    // step 3b5fc;
                                    return CONSUME_SIGNAL;
                                }
                            } else if (b007_state == Com_bitreactive_library_buffering_BufferEager.FIRSTITEMADDED) {
                                b007.add = b006.msg;
                                if (b007.hasRoom()) {
                                    b007.addToBuffer();
                                    b016_SPEECH_FAILED_r1 = false;
                                    b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                    // step f90ca;
                                    return CONSUME_SIGNAL;
                                } else {
                                    b005.overflow(b007.overflow);
                                    b016_SPEECH_FAILED_r1 = false;
                                    b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                    // step c22bc;
                                    return CONSUME_SIGNAL;
                                }
                            } else if (b007_state == Com_bitreactive_library_buffering_BufferEager.READY) {
                                b007.add = b006.msg;
                                b007.addToBuffer();
                                scheduler.startBreak(_b0_c2_b0_c1_Buffer_Eager_t0);
                                b007_stm_state = Com_bitreactive_library_buffering_BufferEager_Stm.FIRSTITEMADDED;
                                b016_SPEECH_FAILED_r1 = false;
                                b007_state = Com_bitreactive_library_buffering_BufferEager.FIRSTITEMADDED;
                                b016_state = No_ntnu_item_arctis_library_speech_Speech.ACTIVE;
                                // step e8603;
                                return CONSUME_SIGNAL;
                            } else {
                                return DISCARD_SIGNAL;
                            }
                        }
                    }
                } else {
                    return BLOCKING_CHOICE;
                }
            } else {
                return DISCARD_SIGNAL;
            }
        } else {
            return DISCARD_SIGNAL;
        }
    }
}
