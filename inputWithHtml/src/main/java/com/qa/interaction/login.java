package com.qa.interaction;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class login extends AbstractMessageTransformer{

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		//ProcessMessage pm = new ProcessMessage();
		//pm.processString(message);
		System.out.println("test");
		return message;
	}

}
