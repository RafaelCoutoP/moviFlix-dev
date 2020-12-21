package com.rafaeldev.moviflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafaeldev.moviflix.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
