package ru.job4j.io;

import java.io.Serializable;
import java.io.*;
import java.nio.file.Files;


public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                +
                "zipCode="
                + zipCode
                +
                ", phone='" + phone + '\''
                +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123, "+79132456789");
        File temp = Files.createTempFile(null, null).toFile();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temp))) {
            oos.writeObject(contact);
        }
        try (ObjectInputStream ois = new ObjectInputStream((new FileInputStream(temp)))) {
            final Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);
        }
    }
}