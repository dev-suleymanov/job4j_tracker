package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя
 * Используется в банковской системе {@link BankService}
 *
 * @author RUSTAM SULEYMANOV
 * @version 1.0
 */
public class User {
    /**
     * Хранение данных пользователя
     */
    private String passport;
    private String username;

    /**
     * Конструктор с входными параметрами - паспорта и имя
     *
     * @param passport паспорт {@code String}
     * @param username имя {@code String}
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает номер паспорта
     *
     * @return номер паспорта {@code String}
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод принимает на вход номер паспорта
     * Устанавливает новое значание паспорту
     *
     * @param passport паспорт {@code String}
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает имя пользователя
     *
     * @return имя {@code String}
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод принимате на вход имя пользователя
     * Устанавливает новое значение имени
     *
     * @param username {@code String}
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод принимает на вход объект сравнения и возвращает результат
     * Проверяет на равенство ссылок, пустой объект и соответсвие классов
     *
     * @param o объект сравнения {@code Object}
     * @return результат сравнения {@code true : false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод возвращает хеш - код поля реквизита
     *
     * @return хеш - код {@code int}
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}