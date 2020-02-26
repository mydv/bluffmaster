package com.psych.psychGame.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.StringIdGenerator.class,
        property = "id"
)
public abstract class Auditable  implements Serializable {
    // We tell the JPA to generate the id by itself
    @Id
    // make it a SEQUENCE
    @GeneratedValue(generator = "sequence",
            strategy = GenerationType.SEQUENCE)
    // & id will have 10 bits of size
    @SequenceGenerator(name = "sequence",
            allocationSize = 10)
    @Getter
    @Setter
    private Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date createdAt = new Date();

    @LastModifiedDate
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date updatedAt = new Date();
}
