package at.kaindorf.exa103_jpa.database;

import at.kaindorf.exa103_jpa.pojos.Pet;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/pets")
public class PetService {

    private final PetRepository petRepository;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Pet>> getAllPets(@RequestParam(name = "pageNo", required = true, defaultValue = "0") Integer pageNumber, @RequestParam(name = "pageSize", required = true, defaultValue = "10") Integer pageSize, @RequestParam(name = "petType", required = false,defaultValue = "null") String petType) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        if (petType.equals("null")){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(petRepository.findAllPets(pageable));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(petRepository.findAllPets(petType,pageable));
    }

    @GetMapping("/types")
    public ResponseEntity<Iterable<String>> getAllPetTypes() {
        Sort sorting = Sort.by("type");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(petRepository.findAllTypes(sorting));
    }
}
