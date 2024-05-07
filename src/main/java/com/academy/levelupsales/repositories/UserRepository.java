package com.academy.levelupsales.repositories;

import com.academy.levelupsales.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
