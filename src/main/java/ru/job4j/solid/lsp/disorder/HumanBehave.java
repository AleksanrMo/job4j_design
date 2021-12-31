package ru.job4j.solid.lsp.disorder;

/**
 * В этом интерфейсе больше трех методов, что не очень хорошо, плюс если
 * му будем создавать класс мужчина и будем наследоваться от этого интерфейса
 * то метод giveBirth() будет лишним.
 */
public interface HumanBehave {

    void sleep();
    void eat();
    void sing();
    void giveBirth();
}



 class Man implements  HumanBehave {

     @Override
     public void sleep() {
         System.out.println("I can sleep");
     }

     @Override
     public void eat() {
         System.out.println("I can eat");
     }

     @Override
     public void sing() {
         System.out.println("I can sing");

     }

     @Override
     public void giveBirth() {
         throw new UnsupportedOperationException();
     }
 }