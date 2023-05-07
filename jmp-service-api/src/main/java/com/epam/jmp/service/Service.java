package com.epam.jmp.service;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;
import com.epam.jmp.exception.SubscriptionNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Service {

    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) throws SubscriptionNotFoundException;
    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition);
    List<User> getAllUsers();
    double getAverageUsersAge();


}
