package com.qa.interaction;

import org.mule.api.MuleMessage;
import org.mule.api.transport.PropertyScope;

public class ProcessMessage {

	public void processString(MuleMessage message) {
		String DataReceived = message.getProperty("http.query.string", PropertyScope.INBOUND);

		String first = DataReceived.split("&")[0];
		String second = DataReceived.split("&")[1];
		String third = DataReceived.split("&")[2];
		
		String firstName = first.split("=")[1];
		String secondName = second.split("=")[1];
		String marks = third.split("=")[1];
		
		String retString = "First Name = " + firstName + ". Second name = " + secondName + ". Marks = " + marks;
		message.setPayload(retString);
	}

}
