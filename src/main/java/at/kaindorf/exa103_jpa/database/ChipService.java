package at.kaindorf.exa103_jpa.database;

import at.kaindorf.exa103_jpa.pojos.Chip;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/chips")
public class ChipService {
    private final ChipRepository chipRepository;


    @GetMapping("/all")
    public ResponseEntity<Iterable<Chip>> getAllChips() {
        Sort sorting = Sort.by("type");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(chipRepository.findAllChips(sorting));
    }
}
