package ru.job4j.solid.lsp.disorder;


import java.util.List;

/**
 * В этом примере мы усиляем предусловия родительского класса, никто не ожидает что там еще и покупатель возникнет
 * с каким то рейтингом. Соответственно метод в наследнике будет вести себя иначе.
 */

public class Shop {

    boolean buy(List<Product> products) {
        return products.size() != 0;
    }
}
 class P extends Shop {

     @Override
     public boolean buy(List<Product> products) {
         Customer customer = new Customer(4);
         return  products.size() != 0 || customer.getRating() <= 5;

     }
 }

 class Product {

 }

 class Customer {
    private int rating;
    Customer(int rating) {
        this.rating = rating;
    }

     public int getRating() {
         return rating;
     }
 }


