package com.ghc;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ghc.domain.Contact;
import com.ghc.service.jpa.ContactService;
import com.ghc.util.Log;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:root-context.xml");		
		ctx.registerShutdownHook();
		ctx.refresh();
		
		ContactService contactService = (ContactService)ctx.getBean("contactService");
		
		List<Contact> contacts = contactService.findAll();
		for (Contact contact : contacts) {
			Log.debug(contact.toString());
		}
    }
}
