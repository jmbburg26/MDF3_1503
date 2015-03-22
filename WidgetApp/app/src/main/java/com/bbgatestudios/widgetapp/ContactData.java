package com.bbgatestudios.widgetapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john_brandenburg on 3/21/15.
 */
public class ContactData {
    private List<Contact> contacts = new ArrayList<Contact>();
    public List<Contact> getContacts() {
        return contacts;
    }

    public ContactData() {
        contacts.add(new Contact("John", "Brandenburg", "jmbburg26@gmail.com", "619-750-2219"));
        contacts.add(new Contact("Amanda", "Brandenburg", "mrsjmbburg@gmail.com", "619-2458-9854"));
        contacts.add(new Contact("Douglas", "Brandenburg", "papabnsd@gmail.com", "586-350-6021"));
    }
}
