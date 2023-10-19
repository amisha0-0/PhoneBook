package com.adi.phonebook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Phonebook {
	private List<Contact> contacts;
	
	public Phonebook() {
		contacts= new ArrayList<>();
	}
	
	public void addContact(String name, String number) {
		Contact contact=new Contact(name, number);
		contacts.add(contact);
	}
	
	public List<Contact> getContact()
	{
		return contacts;
	}
	
	public void removeContact(String name)
	{
		Iterator<Contact> iterator=contacts.iterator();
		while (iterator.hasNext()) {
			Contact contact=iterator.next();
			if(contact.getName().toLowerCase().equals(name.toLowerCase()))
			{
				iterator.remove();
				System.out.println("Contact Removed Successfully:  "+contact);
				return;
			}
		}
		System.out.println("Contact not found!");
	}
	
	public List<Contact> searchContact(String searchName, Boolean searchNumber)
	{
		List<Contact> searchResult=new ArrayList<>();
		for(Contact contact:contacts)
		{
			if(searchNumber)
			{
				if(contact.getNumber().contains(searchName))
				{
					searchResult.add(contact);
				}
			}
			else
			{
				if(contact.getName().toLowerCase().contains(searchName.toLowerCase())) {
					searchResult.add(contact);
				}
			}
		}
		return searchResult;
	}
	public void updateContact(String oldName, String newName, String newNumber) {
		for(Contact contact: contacts) {
			if(contact.getName().toLowerCase().equals(oldName.toLowerCase()))
			{
				contact.setName(newName);
				contact.setNumber(newNumber);
				System.out.println("Contact Updated Successfully: "+ contact);
				return;
			}
		}
		System.out.println("Contact Not Found!");
	}
	
}
