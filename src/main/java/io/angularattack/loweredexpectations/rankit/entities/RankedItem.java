package io.angularattack.loweredexpectations.rankit.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@Accessors(chain = true)
@Entity
@Table(name = "RANKED_ITEM")
public class RankedItem {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name= "SCORE")
    private Integer score;

    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID();
    }
}
