package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель счёта пользователя
 * Используется в банковской системе {@link BankService}
 * @author RUSTAM SULEYMANOV
 * @version 1.0
 */
public class Account {
    /**
     * Хранение данных счёта
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор с входными данными - реквизит и баланс
     * @param requisite реквизит {@code String}
     * @param balance баланс {@code double}
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращает номер реквизита
     * @return реквизит {@code String}
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод принимает на вход номер реквизита
     * Устанавливает новый номер реквизиту
     * @param requisite реквизит {@code String}
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает значение баланса
     * @return баланс {@code double}
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод принимает на вход значение баланса
     * Устанавливает новое значание балансу
     * @param balance баланс {@code double}
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод принимает на вход объект сравнения и возвращает результат
     * Проверяет на равенство ссылок, пустой объект и соответсвие классов
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод возвращает хеш - код поля реквизита
     *
     * @return хеш - код {@code int}
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}