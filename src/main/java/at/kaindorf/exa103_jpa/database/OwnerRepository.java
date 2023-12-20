package at.kaindorf.exa103_jpa.database;

import at.kaindorf.exa103_jpa.pojos.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
