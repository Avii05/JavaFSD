package com.example.smartmusicplaylist.repository;

import com.example.smartmusicplaylist.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
