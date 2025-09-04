package com.gtalent.commerce.admin.repositories;

import com.gtalent.commerce.admin.models.Segment;
import com.gtalent.commerce.admin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SegmentRepository  extends JpaRepository<Segment, Integer> {
    boolean existsByName(String name);
    Optional<Segment> findByName(String name);
}
