package com.tiagocsoares.course.repositories;

import com.tiagocsoares.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}


