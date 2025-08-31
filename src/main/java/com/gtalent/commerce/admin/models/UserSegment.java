package com.gtalent.commerce.admin.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.swing.text.Segment;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_segment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSegment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "segment_id")
    private Segment segment;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}
