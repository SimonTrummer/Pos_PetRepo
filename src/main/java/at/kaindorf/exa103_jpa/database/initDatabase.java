package at.kaindorf.exa103_jpa.database;

import at.kaindorf.exa103_jpa.pojos.Owner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class initDatabase {

    private final PetRepository petRepository;
    private final ChipRepository chipRepository;
    private final OwnerRepository ownerRepository;
    @PostConstruct
    public void importPetsData(){
        List<Owner> owners = new ArrayList<>();

        InputStream is = initDatabase.class.getResourceAsStream("/Petshop.json");
        ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule());

        try {
            owners = om.readValue(is, new TypeReference<List<Owner>>() {
            });
            ownerRepository.saveAll(owners);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info(String.valueOf(ownerRepository.count()));
        log.info(String.valueOf(petRepository.count()));
        log.info(String.valueOf(chipRepository.count()));
    }
}
