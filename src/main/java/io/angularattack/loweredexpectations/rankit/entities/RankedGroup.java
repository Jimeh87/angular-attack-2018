package io.angularattack.loweredexpectations.rankit.entities;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)
@Entity
@Table(name = "RANKED_GROUP")
public class RankedGroup {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "ID")
    private UUID id;

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

}
