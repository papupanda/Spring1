package com.nt.dao;

public interface BankDAO {
    public   int withdraw(int acno,float amount);
    public   int deposite(int acno,float amount);
}
