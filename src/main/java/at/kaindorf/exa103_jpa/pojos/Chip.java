package at.kaindorf.exa103_jpa.pojos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chip implements Serializable {
    @Id
    private String chipId;
    @NonNull
    private String type;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonBackReference
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
