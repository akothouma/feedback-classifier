
package com.AI.FeedbackClassifier.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.OffsetDateTime;
import java.math.BigDecimal;

/**
 * This class is a JPA Entity that maps to the "feedback" table in the database.
 * Lombok annotations are used to generate boilerplate code.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String feedbackText;

    private String category;
    @Column(precision = 3, scale = 2)
    private BigDecimal sentimentScore;
    private String title;

    @Column(name = "submission_date")
    private OffsetDateTime submissionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @PrePersist
    protected void onCreate() {
        submissionDate = OffsetDateTime.now();
    }
}