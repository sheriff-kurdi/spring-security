package com.kurdi.springsecurity.repositories;

import com.kurdi.springsecurity.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authority, Integer> {
}
