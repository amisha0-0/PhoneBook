package com.adi.phonebook;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phonebook phonebook = new Phonebook();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("PhoneBook Menu: ");
			System.out.println("1: Add Contact");
			System.out.println("2: Search Contact");
			System.out.println("3: Update Contact");
			System.out.println("4: Delete Contact");
			System.out.println("5: Display All Contacts");
			System.out.println("6: Exit");
			System.out.println("Enter Your Choice: ");
			
			int choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				System.out.print("Enter Name: ");
				String name=sc.nextLine();
				System.out.print("Enter Phone Number: ");
				String number=sc.nextLine();
				phonebook.addContact(name, number);
				System.out.println("Contact has been added successfully!");
				break;
			case 2:
				System.out.println("Search by: ");
				System.out.println("1. Name: ");
				System.out.println("2. Number: ");
				System.out.print("Enter your choice: ");
				int choice2=sc.nextInt();
				sc.nextLine();
				
				String searchName;
				boolean searchNumber=false;
				if(choice2==1)
				{
					System.out.print("Enter Name: ");
					searchName=sc.nextLine();
				}
				else if(choice2==2) {
					System.out.print("Enter Number: ");
					searchName=sc.nextLine();
					searchNumber=true;
				}
				else {
					System.out.println("Invalid Entry!!!");
					continue;
				}
				List<Contact> searchResult=phonebook.searchContact(searchName, searchNumber);
				if(!searchResult.isEmpty()) {
					System.out.println("Search Results: ");
					for(Contact contact:searchResult) {
						System.out.println(contact);
					}
				}else {
					System.out.println("No Match Found!!");
				}
				break;
			case 3:
				System.out.print("Enter Name to Update Contact: ");
				String oldName=sc.nextLine();
				System.out.print("Enter new name: ");
				String newName=sc.nextLine();
				System.out.print("Enter new number: ");
				String newNumber=sc.nextLine();
				phonebook.updateContact(oldName, newName, newNumber);
				break;
			case 4:
				System.out.print("Enter name of contact to delete details: ");
				name=sc.nextLine();
				phonebook.removeContact(name);
				break;
			case 5:
				List<Contact> contacts=phonebook.getContact();
				if(!contacts.isEmpty()) {
					System.out.println("All Contacts: ");
					for(Contact contact : contacts) {
						System.out.println(contact);
					}
				}else {
					System.out.println("Empty PhoneBook");
				}
				break;
			case 6:
				System.out.println("Exit the Program");
				sc.close();
				return;
			default:
				System.out.println("Invalid Choice!!");
			}

	}

}
}
