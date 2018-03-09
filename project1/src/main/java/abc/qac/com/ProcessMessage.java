package abc.qac.com;

import org.mule.api.MuleMessage;
import org.mule.api.transport.PropertyScope;

public class ProcessMessage {

	public void processString(MuleMessage message) {
		String DataReceived = message.getProperty("http.query.string", PropertyScope.INBOUND);

		String first = DataReceived.split("&")[0];
		String second = DataReceived.split("&")[1];
		int a = Integer.parseInt((DataReceived.split("&")[0]).split("=")[1]);
		int b = Integer.parseInt(second.split("=")[1]);
		int c = a + b;
		String total = Integer.toString(c);
		message.setPayload(total);
	}

}
