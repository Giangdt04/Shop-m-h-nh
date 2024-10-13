package com.example.shopmohinh.repository;

import com.example.shopmohinh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByCode(String code);

    Optional<User> findByUsername(String username);

    @Query("""
            select u from User u where u.deleted = true
            """)
    List<User> getAll();

    Optional<User> findByCode(String code);
}
