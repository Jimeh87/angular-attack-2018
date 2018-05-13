package io.angularattack.loweredexpectations.rankit.repositories;

import io.angularattack.loweredexpectations.rankit.entities.RankedGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RankedGroupRepository extends JpaRepository<RankedGroup, UUID> {
	public RankedGroup findByShortCode(String shortCode);
}
