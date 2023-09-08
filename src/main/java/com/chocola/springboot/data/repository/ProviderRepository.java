package com.chocola.springboot.data.repository;

import com.chocola.springboot.data.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
