package io.angularattack.loweredexpectations.rankit.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "RANKED_GROUP")
public class RankedGroup {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "SHORT_CODE", unique = true)
    private String shortCode;

    @Column(name = "NAME")
    private String name;

    @Setter(AccessLevel.NONE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "RANKED_GROUP_ID", nullable = false)
    private List<RankedItem> rankedItems = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID();
    }

    @CreatedDate
    @Setter(AccessLevel.NONE)
    @Column(name = "CREATED_DATE")
    private Instant createdDate;

    @Transient
    public RankedGroup addAllRankedItems(RankedItem... rankedItems) {
        this.rankedItems.addAll(Arrays.asList(rankedItems));
        return this;
    }

}
