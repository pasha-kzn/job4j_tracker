package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 * Модель содержит поля: баланс и реквизиты
 */
public class Account {
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account account = (Account) obj;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}