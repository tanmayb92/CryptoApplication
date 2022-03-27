package com.cryptoapp.portfolio.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cryptoapp.portfolio.dto.User;

@Repository
public interface UserDaoService extends JpaRepository<User, Long> {

}
