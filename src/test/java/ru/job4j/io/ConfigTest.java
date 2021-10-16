package ru.job4j.io;

import org.checkerframework.checker.units.qual.A;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.lang.IllegalArgumentException;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenException() {
        String path = "./data/pair_without_key.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value(""), is("key"));

    }

    @Test
    public void whenPairContainsCommentsAndEmptyLines() {
        String path = "./data/pair_with_comments_and_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("#comments"), is(Matchers.nullValue()));
        assertThat(config.value(" "), is(Matchers.nullValue()));
    }
}
