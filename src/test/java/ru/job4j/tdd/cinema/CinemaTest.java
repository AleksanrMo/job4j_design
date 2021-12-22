package ru.job4j.tdd.cinema;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.tdd.cinema.Account;
import ru.job4j.tdd.cinema.Cinema;
import ru.job4j.tdd.cinema.Session;
import ru.job4j.tdd.cinema.Ticket;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Ignore
public class CinemaTest {

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test
    public void whenNoSuchSessions() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertNull(sessions);
    }


    @Test(expected = IllegalArgumentException.class)
    public void whenDateNotValid() {
        Cinema cinema = new Cinema3D();
        Account account = new AccountCinema();
        List<Session> sessions = cinema.find(session -> true);
        Calendar date = Calendar.getInstance();
        date.set(2028, 11, 10, 20, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPlaceIsBusy() {
        Cinema cinema = new Cinema3D();
        Account account = new AccountCinema();
        List<Session> sessions = cinema.find(session -> true);
        Calendar date = Calendar.getInstance();
        date.set(2020, 11, 10, 20, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPlaceNotValid() {
        Cinema cinema = new Cinema3D();
        Account account = new AccountCinema();
        List<Session> sessions = cinema.find(session -> true);
        Calendar date = Calendar.getInstance();
        date.set(2020, 11, 10, 20, 00);
        Ticket ticket = cinema.buy(account, 1022, 1, date);

    }
}