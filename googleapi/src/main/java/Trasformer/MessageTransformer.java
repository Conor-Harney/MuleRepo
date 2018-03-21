package Trasformer;

import org.mule.api.MuleMessage;

public class MessageTransformer {
	public MuleMessage processMessage (MuleMessage message){
		String myMessage=message.getPayload().toString();

		String[] parts = myMessage.split("64,");
		String part1 = parts[1];
		//String part2 = parts[1];
		String[] parts2=part1.split("=");
		String result= parts2[0];
		result= result + "=";
		result = result.replace(" ", "");

		message.setPayload(result);
		return message;
	}

}
