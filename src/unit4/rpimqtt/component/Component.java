package unit4.rpimqtt.component;

import com.bitreactive.library.mqtt.MQTTConfigParam;
import com.bitreactive.library.mqtt.MQTTMessage;
import com.bitreactive.library.mqtt.robustmqtt.RobustMQTT.Parameters;

import no.ntnu.item.arctis.runtime.Block;

public class Component extends Block {
	
	public java.lang.String speech_status;

	public Parameters init() {
		MQTTConfigParam p = new MQTTConfigParam("blocks2.bitreactive.com");
		p.addSubscribeTopic("forward");
		return new Parameters(p, 2);
	}
	
	public String readMSG(MQTTMessage m) { 
		String s;
		if (m == null) {
		s = "Error: Empty payload!";
		}
		else {
			s = new String(m.getPayload());
		}
		return s;
	}
	
	public MQTTMessage createMSG(String s) {
		String ms = s;
		byte[] b = ms.getBytes();
		MQTTMessage m = new MQTTMessage(b, "back");
		m.setQoS(2);
		return m;
	}
	
	public void CNF(){
		speech_status = "CNF";
	}
	
	public void NEG(){
		speech_status = "NEG";;
	}
	
	

}
