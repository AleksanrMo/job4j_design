package ru.job4j.solid.lsp.disorder;

/**
 * В метод boil допустим захотим поставить наследника Stove (у нас это SpecialStove), результат будет не тот
 * который мы хотим. Хотя один класс наследуется от другого.
 */

public class Kettle {

    public void boil(Stove stove) {
       if (stove.getTemp() > 200) {
           System.out.println("Ставь чайник на плиту!");
       }
        System.out.println("Плита не работает!");
    }



}
 class Stove {
    int temp;

     public Stove(int temp) {
         this.temp = temp;
     }

     public int getTemp() {
         return temp;
     }

     public void setTemp(int temp) {
         this.temp = temp;
     }
 }

 class SpecialStove extends Stove {

     final int temp = 150;

     SpecialStove(int temp) {
         super(temp);
     }

     public int getTemp() {
         return this.temp;
     }
 }