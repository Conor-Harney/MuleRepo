import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class MathDo extends AbstractMessageTransformer{

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		Map<String, String> data = (Map<String, String>)message.getPayload();
		
		int num1 = Integer.parseInt(data.get("num1"));
		int num2 = Integer.parseInt(data.get("num2"));
		data.put("total", Integer.toString(num1/num2));
		message.setPayload(data);
		return message;
	}

}
