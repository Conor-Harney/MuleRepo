package business;

import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

public class ConvertInsertDataParams extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		Map<String,String> data=(Map<String,String>) message.getPayload();
		message.setProperty("userName", data.get("userName"), PropertyScope.SESSION);
		message.setProperty("accountNumber", data.get("accountNumber"), PropertyScope.SESSION);
		message.setProperty("address", data.get("address"), PropertyScope.SESSION);
		message.setProperty("marks", data.get("marks"), PropertyScope.SESSION);
		
		return message;
	}

}
