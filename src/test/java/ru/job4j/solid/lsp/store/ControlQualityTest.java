package ru.job4j.solid.lsp.store;

import org.junit.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ControlQualityTest {


    @Test
    public void whenFoodAddedToStorages() {
        Storage wareHouse = new WareHouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> list = Arrays.asList(wareHouse, shop, trash);
        ControlQuality controlQuality = new ControlQuality(list);
        Food food = new Food("1", LocalDate.of(2021, 12, 20),
                LocalDate.of(2022, 12, 29), 149, 0);
        Food food2 = new Food("2", LocalDate.of(2020, 12, 20),
                LocalDate.of(2022, 02, 28), 149, 0);
        Food food3 = new Food("3", LocalDate.of(2021, 12, 20),
                LocalDate.of(2021, 12, 29), 149, 0);
        controlQuality.sortFood(food);
        controlQuality.sortFood(food2);
        controlQuality.sortFood(food3);
        assertThat(list.get(0).getList().get(0), is(food));
        assertThat(list.get(1).getList().get(0), is(food2));
        assertThat(list.get(2).getList().get(0), is(food3));
    }

    @Test
    public void whenAllFoodResortedFromWareHouse() {
        Storage wareHouse = new WareHouse();
        Storage shop = new Shop();
        Storage trash = new Trash();

        Food food = new Food("1", LocalDate.of(2021, 12, 20),
                LocalDate.of(2022, 12, 29), 149, 0);
        Food food2 = new Food("2", LocalDate.of(2020, 12, 20),
                LocalDate.of(2022, 02, 28), 149, 0);
        Food food3 = new Food("3", LocalDate.of(2021, 12, 20),
                LocalDate.of(2021, 12, 29), 149, 0);
        wareHouse.getList().add(food);
        wareHouse.getList().add(food2);
        wareHouse.getList().add(food3);
        List<Storage> list = Arrays.asList(wareHouse, shop, trash);
        ControlQuality controlQuality = new ControlQuality(list);
        controlQuality.resort();
        assertThat(list.get(0).getList().get(0), is(food));
        assertThat(list.get(1).getList().get(0), is(food2));
        assertThat(list.get(2).getList().get(0), is(food3));
    }

    @Test
    public void whenAllFoodResortedToTrash() {
        Storage wareHouse = new WareHouse();
        Storage shop = new Shop();
        Storage trash = new Trash();

        Food food = new Food("1", LocalDate.of(2021, 12, 20),
                LocalDate.of(2021, 12, 29), 149, 0);
        Food food2 = new Food("2", LocalDate.of(2020, 12, 20),
                LocalDate.of(2021, 02, 28), 149, 0);
        Food food3 = new Food("3", LocalDate.of(2021, 12, 20),
                LocalDate.of(2021, 12, 25), 149, 0);
        wareHouse.getList().add(food);
        wareHouse.getList().add(food2);
        wareHouse.getList().add(food3);
        List<Storage> list = Arrays.asList(wareHouse, shop, trash);
        ControlQuality controlQuality = new ControlQuality(list);
        controlQuality.resort();
        assertTrue(list.get(0).getList().isEmpty());
        assertTrue(list.get(1).getList().isEmpty());
        assertThat(list.get(2).getList().size(), is(3));
    }
}