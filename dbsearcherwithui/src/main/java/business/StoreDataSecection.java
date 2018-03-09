package business;

import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

public class StoreDataSecection extends AbstractMessageTransformer{

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		Map<String,String> data=(Map<String,String>) message.getPayload();
		message.setProperty("operator", data.get("operator"), PropertyScope.SESSION);
		message.setProperty("field", data.get("field"), PropertyScope.SESSION);
		message.setProperty("chosenVal", Integer.parseInt(data.get("chosenVal")), PropertyScope.SESSION);
		return message;
	}

}
