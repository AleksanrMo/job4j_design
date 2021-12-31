package ru.job4j.solid.lsp.disorder;

/**
 * Много методов и не всем телефонам они нужны
 */
public interface Telephone {

    void call();
    void ring();
    void connectToInternet();
    void makePhoto();
    void recordVideo();
}
