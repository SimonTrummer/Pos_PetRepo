package at.kaindorf.exa103_jpa.database;

import at.kaindorf.exa103_jpa.pojos.Pet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Integer> {

    @Query("SELECT p FROM Pet p where UPPER(p.type) = UPPER(:filter)")
    List<Pet> findAllPets(String filter, Pageable page);
    @Query("SELECT p FROM Pet p")
    List<Pet> findAllPets(Pageable page);

    @Query("SELECT DISTINCT p.type FROM Pet p")
    List<String> findAllTypes(Sort sorting);
}
