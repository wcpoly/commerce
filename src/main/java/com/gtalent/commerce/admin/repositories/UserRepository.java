package com.gtalent.commerce.admin.repositories;

import com.gtalent.commerce.admin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    // 前台註冊/登入、後台客服查詢用
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);

    // 註冊時避免重複
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

}
