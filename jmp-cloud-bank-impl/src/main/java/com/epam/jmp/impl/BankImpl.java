package com.epam.jmp.impl;

import com.epam.jmp.api.Bank;
import com.epam.jmp.jpa.CreditBankCardRepository;
import com.epam.jmp.jpa.DebitBankCardRepository;
import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.CreditBankCard;
import com.epam.jmp.dto.DebitBankCard;
import com.epam.jmp.dto.User;

public class BankImpl implements Bank {

    private CreditBankCardRepository creditBankCardRepository;
    private DebitBankCardRepository debitBankCardRepository;

    public BankImpl(CreditBankCardRepository creditBankCardRepository, DebitBankCardRepository debitBankCardRepository) {
        this.creditBankCardRepository = creditBankCardRepository;
        this.debitBankCardRepository = debitBankCardRepository;
    }

    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        return bankCardType == BankCardType.CREDIT ? persistCreditBankCard(user) : persistDebitBankCard(user);
    }

    private CreditBankCard persistCreditBankCard(User user) {
        var card = new CreditBankCard();
        card.setUser(user);
        card.setNumber("testtesttest");
        return creditBankCardRepository.save(card);
    }
    private DebitBankCard persistDebitBankCard(User user){
        var card = new DebitBankCard();
        card.setUser(user);
        card.setNumber("testtesttest");
        return debitBankCardRepository.save(card);
    }
}
