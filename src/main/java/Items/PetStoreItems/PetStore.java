package Items.PetStoreItems;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PETSTORE")
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "managerName", nullable = false)
    private String managerName;

    //List of Products
    @ManyToMany(mappedBy = "petstores", cascade = CascadeType.ALL)
    Set<Product> products = new HashSet<Product>();

    //An address
    @OneToOne(mappedBy = "petstore", cascade = CascadeType.ALL)
    Address address;

    //List of animals
    @OneToMany(mappedBy = "petstore", cascade = CascadeType.ALL)
    Set<Animal> animals = new HashSet<Animal>();
    public PetStore() {

    }

    public PetStore(Long id, String name, String managerName) {
        this.id = id;
        this.name = name;
        this.managerName = managerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        this.products.add(product);
        product.addPetstore(this);
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        address.setPetstore(this);
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal){
        this.animals.add(animal);
        animal.setPetstore(this);
    }

}
