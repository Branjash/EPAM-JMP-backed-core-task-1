package com.epam.jmp.jpa;

import com.epam.jmp.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
