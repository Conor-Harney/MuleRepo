package com.qa.business;

import java.util.ArrayList;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

public class ExtractEmailDetails extends AbstractMessageTransformer{

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		String data = (String) message.getPayload();
		ArrayList<String> aryLstData =  processJsonString(data);
		String[] dtaInAry = aryLstData.toArray(new String[aryLstData.size()]);
		message.setProperty("userEmails", dtaInAry,PropertyScope.SESSION);
		return message;
	}
	
	public static String getNextElement(String jsonStr)
	{
		StringBuffer jsonStrBuffer = new StringBuffer(jsonStr);
		String newElement = (String) jsonStrBuffer.substring(jsonStrBuffer.indexOf("{") +1 , jsonStrBuffer.indexOf("}"));
		return newElement;
	}
	
	public static String removeNextElement(String jsonStr)
	{
		StringBuffer jsonStrBuffer = new StringBuffer(jsonStr);
		jsonStrBuffer.delete(jsonStrBuffer.indexOf("{") , jsonStrBuffer.indexOf("}")+1);
		return jsonStrBuffer.toString();
	}
	
	public static ArrayList<String> processJsonString(String jsonStr)
	{
		ArrayList<String> elems = new ArrayList<String>();
		jsonStr = jsonStr.replaceAll("\\s+","");
		while(jsonStr.length()> 3)
		{
			elems.add(getNextElement(jsonStr));
			jsonStr = removeNextElement(jsonStr);
		}
		
		return elems;
	}
	
}
