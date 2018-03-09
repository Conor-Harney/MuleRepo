package abc.qac.com;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transformer.simple.SetPayloadTransformer;

public class ProcessRequests extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		
		ProcessMessage pm = new ProcessMessage();
		pm.processString(message);
		return message;
	}
	
}
