package ru.job4j.solid.dip.menu;




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements Show {


   private List<Show> list;

   public Menu() {
       list = new ArrayList<>();
   }


   public void add(Show task) {
       list.add(task);
   }
    public void show(Output output) {
        for (Show t: list) {
            t.show(output);
        }
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        output.println(str + " we can do any thing with this string");

      }

    public static void main(String[] args) {
        Menu menu =  new Menu();
        Task task1 = new Task("Задание 1");
        Task task2 = new Task("Задание 2");
        Task task1dot1 = new Task("--Задание 1.1");
        Task task1dot2 = new Task("--Задание 1.2");
        Task task1dot1dot2 = new Task("----Задание 1.1.2");
        task1.add(task1dot1);
        task1.add(task1dot2);
        task1dot1.add(task1dot1dot2);
        menu.add(task1);
        menu.add(task2);

       menu.show(new ConsoleOutput());


    }
}
