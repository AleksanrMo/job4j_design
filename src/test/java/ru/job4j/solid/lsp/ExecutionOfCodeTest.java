package ru.job4j.solid.lsp;

import org.junit.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ExecutionOfCodeTest {


    @Test
    public void whenFoodTransferFromWareHouseToShop() {
        Storage wareHouse = new WareHouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> list = Arrays.asList(wareHouse, shop, trash);
        List<Food> list1 = Arrays.asList(new Food("1", LocalDate.of(2021, 12, 20),
                LocalDate.of(2021, 12, 29), 149, 0));
        wareHouse.getList().addAll(list1);
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.rewriteLists(list);
        assertThat(list1, is(shop.getList()));
        assertTrue(wareHouse.getList().isEmpty());
        assertTrue(trash.getList().isEmpty());
    }

    @Test
    public void whenFoodTransferFromShopToTrash() {
        Storage wareHouse = new WareHouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> list = Arrays.asList(wareHouse, shop, trash);
        List<Food> list1 = Arrays.asList(new Food("1", LocalDate.of(2021, 12, 20),
                LocalDate.of(2021, 12, 27), 149, 0));
        wareHouse.getList().addAll(list1);
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.rewriteLists(list);
        assertThat(list1, is(trash.getList()));
        assertTrue(shop.getList().isEmpty());
        assertTrue(wareHouse.getList().isEmpty());
    }

    @Test
    public void whenFoodStayInWarehouse() {
        Storage wareHouse = new WareHouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> list = Arrays.asList(wareHouse, shop, trash);
        List<Food> list1 = Arrays.asList(new Food("1", LocalDate.of(2021, 12, 20),
                LocalDate.of(2022, 12, 29), 149, 0));
        wareHouse.getList().addAll(list1);
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.rewriteLists(list);
        assertThat(list1, is(wareHouse.getList()));
        assertTrue(shop.getList().isEmpty());
        assertTrue(trash.getList().isEmpty());
    }

    @Test
    public void whenFoodTransferFromWareHouseToShopChekDiscount() {
        Storage wareHouse = new WareHouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> list = Arrays.asList(wareHouse, shop, trash);
        List<Food> list1 = Arrays.asList(new Food("1", LocalDate.of(2021, 12, 20),
                LocalDate.of(2021, 12, 29), 149, 0));
        wareHouse.getList().addAll(list1);
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.rewriteLists(list);
        assertTrue(shop.getList().get(0).getDiscount() == 40);

    }
}