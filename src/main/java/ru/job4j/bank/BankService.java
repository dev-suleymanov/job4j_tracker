package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковскую систему с его функционалом
 *
 * @author RUSTAM SULEYMANOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных о пользователе
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя при его отсутсвии
     *
     * @param user пользователь {@code Object}
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет пользователя по номеру паспорта
     *
     * @param passport номер паспорта {@code String}
     * @return результат удаления {@code true : false}
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет аккаунт по номеру паспорта
     * Проверяет на наличие пользователя с этим аккаунтом
     *
     * @param passport номер паспорта {@code String}
     * @param account  аккаунт {@code Object}
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = getAccounts(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод находит пользователя по номеру паспорта
     * Проверяет по всему списку пользователей
     *
     * @param passport номер паспорта {@code String}
     * @return пользователя {@code Object : null}
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод возвращает аккаунт по номеру паспорта и номеру реквизита
     * Проверяеет, есть ли пользователь с данным паспортом
     *
     * @param passport  номер паспорта {@code String}
     * @param requisite номер реквизита {@code String}
     * @return аккаунт {@code Object : null}
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return getAccounts(user).stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод произвиодит перевод средств с одного счёта на другой
     * Проверяет, есть ли аккаунты с данными этих счетов
     *
     * @param srcPassport   номер паспорта отправителя {@code String}
     * @param srcRequisite  номер реквизита отправителя {@code String}
     * @param destPassport  номер паспорта получателя {@code String}
     * @param destRequisite номер реквизита получателя {@code String}
     * @param amount        размер средст {@code double}
     * @return результат отправки {@code true : false}
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && src.getBalance() >= amount && dest != null) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает все аккаунты пользователя
     *
     * @param user пользователь {@code Object}
     * @return аккаунты {@code List<Object>}
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}