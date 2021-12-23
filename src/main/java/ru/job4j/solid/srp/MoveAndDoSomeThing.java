package ru.job4j.solid.srp;

/**
 * Интерфейс содержит два метода , которые не сильно свзязанны друг с другом.
 * Лучше будет создать другой еще один интерфейс.
 */
public interface MoveAndDoSomeThing {
     void move(String transport);
     String calculateTimeOfRest(double timeOfMove);
}
