package at.kaindorf.exa103_jpa.database;

import at.kaindorf.exa103_jpa.pojos.Chip;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChipRepository extends JpaRepository<Chip,String> {
    @Query("SELECT c FROM Chip  c")
    List<Chip> findAllChips(Sort sorting);
}
