package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу простейшего сервиса банковского приложения
 * @author Pavel Matveev
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение информации о клиенте и его счетах хранится в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в коллекцию пользователей, при
     * условии, что такого пользователя в коллекции еще нет
     * @param user пользователь, добавляемый в коллекцию
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход паспортные данные, определяет пользователя, и удаляет его из коллекции пользователей
     * @param passport паспортные данные
     * @return возвращает true при успешном удалении пользователя из коллекции пользователей
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод принимает на вход паспотрные данные с данными счета, и создает новый счет клиенту
     * @param passport паспортные данные
     * @param account данные счета, включающие реквизиты и баланс счета
     */
    public void addAccount(String passport, Account account) {
        var user = findByPassport(passport);
        if (user != null && !getAccounts(user).contains(account)) {
                getAccounts(user).add(account);
        }
    }

    /**
     * Метод принимает на вход паспортные данные и находит пользователя в системе, если он существует
     * @param passport паспортные данные
     * @return u/null пользователь, если он найден
     */
    public User findByPassport(String passport) {
        for (User u : users.keySet()) {
            if (passport.equals(u.getPassport())) {
                return u;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход паспортные данные и реквизиты и находит счет, если он существует
     * @param passport паспортные данные
     * @param requisite реквизиты
     * @return account/null счет если он найден
     */
    public Account findByRequisite(String passport, String requisite) {
        var user = findByPassport(passport);
        if (user != null) {
            for (Account account : getAccounts(user)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }

        return null;
    }

    /**
     * Метод принимает на вход паспортные данные и реквизиты счета отправителя/получателя, сумму перевода. При
     * корректных входящих данных перевод средств происходит с изменением сумм на счетах отправителя/получателя
     * @param srcPassport паспортные данные отправителя перевода
     * @param srcRequisite реквизиты счета списания
     * @param destPassport паспортные данные получателя перевода
     * @param destRequisite реквизиты счета пополнения
     * @param amount сумма перевода
     * @return rsl результат выполнения операции
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        var srcAccount = findByRequisite(srcPassport, srcRequisite);
        var destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = srcAccount != null
                && destAccount != null
                && srcAccount.getBalance() >= amount;
        if (rsl) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        return rsl;
    }

    /**
     * Метод принимает на вход пользователя и находит все счета пользователя
     * @param user пользователь
     * @return List<Account> список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}