package at.kaindorf.exa103_jpa.pojos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Owner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ownerId;
    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @JsonManagedReference
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Pet> petList;

    public void addPet(Pet pet) {
        petList.add(pet);
    }
}
