package Items.PetStoreItems;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ANIMAL")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "birth", nullable = false)
    private LocalDate birth;
    @Column(name = "couleur", nullable = false)
    private String couleur;

    //Add petstore
    @ManyToOne
    @JoinColumn(name = "id_pet", nullable = false)
    PetStore petstore;

    public Animal() {
    }

    public Animal(Long id, LocalDate birth, String couleur) {
        this.id = id;
        this.birth = birth;
        this.couleur = couleur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetstore() {
        return petstore;
    }


    public void setPetstore(PetStore petstore) {
        this.petstore = petstore;
    }
}
