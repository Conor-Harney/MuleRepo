package com.qa.business;
import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;


public class ExtractUserDetails extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		String data = (String) message.getPayload();
		System.out.println("string version");
		System.out.println(data);
		data = data.substring(2,data.length() - 2);
		System.out.println("shortened string = " + data);
		String[] fields =  data.split(",");
		String nameField = fields[1];
		String name = nameField.split(":")[1];
		message.setProperty("userName", name, PropertyScope.SESSION);
		
		System.out.println("name = " + name);
		
		
		return message;
	}

}
