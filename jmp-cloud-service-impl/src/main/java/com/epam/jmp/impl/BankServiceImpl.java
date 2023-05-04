package com.epam.jmp.impl;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;
import com.epam.jmp.service.BankService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BankServiceImpl implements BankService {

    @Override
    public void subscribe(BankCard bankCard) {

    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
        Stream.of(1,2,3).reduce(0, (s,i) -> {return s + i;}).intValue();
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
