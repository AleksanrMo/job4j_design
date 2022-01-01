package ru.job4j.solid.dip.disorder;

/**
 * В этом примере нарушение принципа инверсии зависимостей. Получается между классами у нас жесткая связка,
 * что если мы заходим данные на флешке например? В общем надо убирать такие зависимости путем внедрения интерфейса,
 * который будет реализован другими классами и в таком случае взаимодействие будет через интерфейс.
 */
public class Data {
    public void save(String data) {
        System.out.println("The data is saved on CD!");
    }
}

class User {

    public void saveUserData(String data) {
        Data dataSave =  new Data();
        dataSave.save(data);
    }
}
