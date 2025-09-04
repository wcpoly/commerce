package com.gtalent.commerce.admin.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "segments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Segment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String name;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "segment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserSegment> userSegments;
}
