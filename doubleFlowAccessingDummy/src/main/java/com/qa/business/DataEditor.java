package com.qa.business;

import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.hazelcast.com.eclipsesource.json.JsonObject;
import com.qa.domain.Data;

public class DataEditor extends AbstractMessageTransformer {
	

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		
		
		Map<String,String> data=(Map<String,String>) message.getPayload();
		
		message.setProperty("site", data.get("site"),PropertyScope.SESSION);
		message.setProperty("recordID", data.get("recordID"),PropertyScope.SESSION);
		
	//	processData(message);
		
		return message;
	}
	
	public void processData(MuleMessage message)
	{
		String DataReceived = message.getProperty("http.query.string", PropertyScope.INBOUND);
		System.out.println(DataReceived);
	}
	
	
	

}
