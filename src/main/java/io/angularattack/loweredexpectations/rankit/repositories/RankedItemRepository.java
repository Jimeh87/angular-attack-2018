package io.angularattack.loweredexpectations.rankit.repositories;

import io.angularattack.loweredexpectations.rankit.entities.RankedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RankedItemRepository extends JpaRepository<RankedItem, UUID> {
}