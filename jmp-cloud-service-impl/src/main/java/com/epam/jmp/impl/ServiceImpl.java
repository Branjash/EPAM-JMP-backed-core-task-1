package com.epam.jmp.impl;

import com.epam.jmp.api.Bank;
import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;
import com.epam.jmp.exception.SubscriptionNotFoundException;
import com.epam.jmp.jpa.SubscriptionRepository;
import com.epam.jmp.jpa.UserRepository;
import com.epam.jmp.service.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ServiceImpl implements Service {

    private UserRepository userRepository;
    private SubscriptionRepository subscriptionRepository;
    private Bank bankService;

    public ServiceImpl(UserRepository userRepository, SubscriptionRepository subscriptionRepository, Bank bankService) {
        this.userRepository = userRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.bankService = bankService;
    }

    @Override
    public void subscribe(BankCard bankCard) {
        var subscription = new Subscription();
        subscription.setStartDate(LocalDate.now());
        subscription.setBankCard(bankCard.getNumber());
        subscriptionRepository.save(subscription);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) throws SubscriptionNotFoundException {
        return Optional.ofNullable(StreamSupport.stream(subscriptionRepository.findAll().spliterator(), false)
                .filter(c -> c.getBankCard().equals(cardNumber))
                .findFirst()
                .orElseThrow(() -> new SubscriptionNotFoundException("There is no subscription with this card number!")));
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> condition) {
        return StreamSupport.stream(subscriptionRepository.findAll().spliterator(), false)
                .filter(condition)
                .collect(Collectors.toList());
    }
    @Override
    public List<User> getAllUsers() {
        var usersIterable = userRepository.findAll();
        return StreamSupport.stream(usersIterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageUsersAge() {
        List<User> allUsers = getAllUsers();
        return allUsers.stream()
                .mapToLong(User::calculateAge)
                .reduce(0l,(total, age) -> total + age) / allUsers.size();
    }



}
