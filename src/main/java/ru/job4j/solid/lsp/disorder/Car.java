package ru.job4j.solid.lsp.disorder;

/**
 *  Не все классы этого интерфейса нуждаются в методе siren(),
 *  он нужен только для специализированных машин, поэтому метод
 *  лучше вынести в отдельный интерфейс.
 */
public interface Car {

    String move();
    String brake();
    String siren();
}

class PassengerCar implements Car {


    @Override
    public String move() {
        return "Машина едет!";
    }

    @Override
    public String brake() {

        return "Машина останавливается";
    }

    @Override
    public String siren() {
        throw new UnsupportedOperationException();
    }

}
