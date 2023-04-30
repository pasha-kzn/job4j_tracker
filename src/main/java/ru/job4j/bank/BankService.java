package ru.job4j;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public boolean deleteUser(String passport) {
        return users.remove(findByPassport(passport)) != null;
    }

    public void addAccount(String passport, Account account) {
        if (users.containsKey(findByPassport(passport)) && !getAccounts(findByPassport(passport)).contains(account)) {
            getAccounts(findByPassport(passport)).add(account);
            users.put(findByPassport(passport), getAccounts(findByPassport(passport)));
        }
    }

    public User findByPassport(String passport) {
        for (User u : users.keySet()) {
            if (passport.equals(u.getPassport())) {
                return u;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            for (Account account : getAccounts(findByPassport(passport))) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }

        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = findByRequisite(srcPassport, srcRequisite) != null
                && findByRequisite(destPassport, destRequisite) != null
                && findByRequisite(srcPassport, srcRequisite).getBalance() >= amount;
        if (rsl) {
            findByRequisite(srcPassport, srcRequisite).setBalance(findByRequisite(srcPassport, srcRequisite).getBalance() - amount);
            findByRequisite(destPassport, destRequisite).setBalance(findByRequisite(destPassport, destRequisite).getBalance() + amount);
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}