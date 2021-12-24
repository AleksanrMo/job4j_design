package ru.job4j.solid.ocr;

import java.io.File;

/**
 * Tут нарушено правели единственной ответственности , и также мы посоянно изменяем класс,
 * вместо того что бы наследоваться и расширять его другими классами.
 */

public class Save {

    public void saveToFile(String str) {
        System.out.println("file saved");
    }

    public void saveToDataBase(String str) {
        System.out.println("text saved in database");
    }

    public void sendEmail(String email, String later) {
        System.out.println("email sent");

    }


}
