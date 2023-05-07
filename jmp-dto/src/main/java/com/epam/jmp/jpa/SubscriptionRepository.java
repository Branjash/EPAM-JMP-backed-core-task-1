package com.epam.jmp.jpa;

import com.epam.jmp.dto.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository  extends CrudRepository<Subscription, Long> {
}
