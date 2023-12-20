package at.kaindorf.exa103_jpa.pojos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet implements Serializable {
    @Id
    private Integer petId;
    @NonNull
    private String name;
    @NonNull
    private String picture;
    @NonNull
    private String type;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "chip_id")
    @JsonManagedReference
    private Chip chip;
    @Enumerated(EnumType.STRING)
    @NonNull
    private Gender gender;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
