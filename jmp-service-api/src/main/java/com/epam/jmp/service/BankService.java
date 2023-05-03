package com.epam.jmp.service;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;

import java.util.List;
import java.util.Optional;

public interface BankService {

    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);
    List<User> getAllUsers();

}
