package Items.PetStoreItems;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "label", nullable = false)
    private String label;
    @Enumerated
    @Column(name = "type", nullable = false)
    private ProdType type;
    @Column(name = "price", nullable = false)
    private double price;

    //Add petstore list
    @ManyToMany
    @JoinTable(
            name = "service",
            joinColumns = @JoinColumn(name = "id_prod", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_pet", referencedColumnName = "id")
    )
    Set<PetStore> petstores = new HashSet<PetStore>();

    public Product() {

    }

    public Product(Long id, String code, String label, ProdType type, double price) {
        this.id = id;
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetstores() {
        return petstores;
    }

    public void addPetstore(PetStore petStore){
        this.petstores.add(petStore);
    }


    public void setPetstores(Set<PetStore> petstores) {
        this.petstores = petstores;
    }
}