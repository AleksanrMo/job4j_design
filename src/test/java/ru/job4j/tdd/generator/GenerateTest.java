package ru.job4j.tdd.generator;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Ignore
public class GenerateTest {

    @Test
    public void whenOneKeyAndOneValueMatch() {
        Generator one = new Generate();
        Map<String, String> map = Map.of("name", " Ivan Petrov", "subject", "you");
        String str = "I am a ${name}, Who are ${subject}? ";
        String rst = "I am a Ivan Petrov, Who are you";
        assertThat(rst, is(one.produce(str, map)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenExtraKeyAndValue() {
        Generator one = new Generate();
        Map<String, String> map = Map.of("name", " Ivan Petrov", "subject",
                "you", "extraKey", "extraValue");
        String str = "I am a ${name}, Who are ${subject}? ";
        one.produce(str, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSomeKeysNotMatch() {
        Generator one = new Generate();
        Map<String, String> map = Map.of("name1", " Ivan Petrov", "subject", "you");
        String str = "I am a ${name}, Who are ${subject}? ";
        one.produce(str, map);
    }

}