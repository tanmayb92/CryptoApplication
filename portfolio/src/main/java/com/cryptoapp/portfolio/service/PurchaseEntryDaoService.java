package com.cryptoapp.portfolio.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cryptoapp.portfolio.dto.PurchaseEntry;

@Repository
public interface PurchaseEntryDaoService extends JpaRepository<PurchaseEntry, Long>{

}
