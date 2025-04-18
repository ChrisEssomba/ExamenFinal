package Items.PetStoreItems;
/*
Les etapes sont :
1. creer et remplir les classes normallement
2.  Mettre en place les relations simplement
3.  Ajouter les @ sur les relations
4.  Ajouter les @ sur les variables
 */
import com.sun.source.tree.NewArrayTree;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "zipCode", nullable = false)
    private String zipCode;
    @Column(name = "city", nullable = false)
    private String city;

    //List of Petstores

    //Set<PetStore> petStores = new HashSet<PetStore>();

    //An Petstore
    @OneToOne
    @JoinColumn(name = "id_pet", nullable = false)
    PetStore petstore;

    public Address() {
    }

    public Address(Long id, String number, String street, String zipCode, String city) {
        this.id = id;
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PetStore getPetstore() {
        return petstore;
    }


    public void setPetstore(PetStore petstore) {
        this.petstore = petstore;
    }
}
