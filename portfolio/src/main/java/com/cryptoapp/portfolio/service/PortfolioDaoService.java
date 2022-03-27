package com.cryptoapp.portfolio.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cryptoapp.portfolio.dto.Portfolio;

@Repository
public interface PortfolioDaoService extends JpaRepository<Portfolio,Long>{

}
