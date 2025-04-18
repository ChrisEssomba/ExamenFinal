package Items;

import Items.PetStoreItems.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.time.LocalDate;
import java.util.List;

import static Items.PetStoreItems.ProdType.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); //First transaction
            //Create a product item
            Product croquette = new Product();
            croquette.setCode("A");
            croquette.setLabel("label1");
            croquette.setType(FOOD);
            croquette.setPrice(15.5);
            //Product 2
            Product jouet = new Product();
            jouet.setCode("A");
            jouet.setLabel("label2");
            jouet.setType(ACCESSORY);
            jouet.setPrice(5.5);
            //Product 3
            Product brosse = new Product();
            brosse.setCode("C");
            brosse.setLabel("label3");
            brosse.setType(CLEANING);
            brosse.setPrice(150.5);

            //Create a Petstore item
            PetStore lenjiStore = new PetStore();
            lenjiStore.setName("LenjiStore");
            lenjiStore.setManagerName("Chris");
            //store 2
            PetStore chrisStore = new PetStore();
            chrisStore.setName("ChrisStore");
            chrisStore.setManagerName("Lenji");
            //store 3
            PetStore manuelStore = new PetStore();
            manuelStore.setName("ManuelStore");
            manuelStore.setManagerName("Manuel");

            //Create an Adress item
            Address address = new Address();
            address.setNumber("45");
            address.setStreet("Rue de la joie");
            address.setZipCode("12");
            address.setCity("Paris");
            // Address 2
            Address address2 = new Address();
            address2.setNumber("03");
            address2.setStreet("Rue de la paie");
            address2.setZipCode("57");
            address2.setCity("Nice");
            // Address 3
            Address address3 = new Address();
            address3.setNumber("14");
            address3.setStreet("Rue des boeufs");
            address3.setZipCode("78");
            address3.setCity("Charlotte");

            //Create an Animal item
            Cat chat = new Cat();
            chat.setBirth(LocalDate.now());
            chat.setCouleur("blue");
            chat.setChipid("001");
            //Animal 2
            Cat chat2 = new Cat();
            chat2.setBirth(LocalDate.now());
            chat2.setCouleur("yellow");
            chat2.setChipid("002");
            // Animal 3
            Cat poisson = new Cat();
            poisson.setBirth(LocalDate.now());
            poisson.setCouleur("green");
            poisson.setChipid("003");

            //Remplir les stores
            //Remplir le store 1
            lenjiStore.setAddress(address);
            lenjiStore.addAnimal(chat);
            lenjiStore.addProduct(croquette);
            // Remplir le store  2
            manuelStore.setAddress(address3);
            manuelStore.addAnimal(chat2);
            manuelStore.addProduct(brosse);
            // Remplir le store 3
            chrisStore.setAddress(address2);
            chrisStore.addAnimal(poisson);
            chrisStore.addProduct(jouet);

            //Ajouter tous les stores dans la base de données
            em.persist(lenjiStore);
            em.persist(chrisStore);
            em.persist(manuelStore);




            //Fin de la deuxieme transaction
            em.getTransaction().commit();

            //Debut de la deuxieme transaction
            em.getTransaction().begin();

            //Réaliser une requête qui permet d’extraire tous les produits en fonction d’un code produit
            System.out.println("Liste des produits ayant le code" + croquette.getCode() + " : ");
            Query query = em.createQuery("SELECT p FROM Product p where p.code=:code_name ", Product.class);
            query.setParameter("code_name", croquette.getCode());
            List<Product> products = query.getResultList();
            products.forEach(product ->
                    System.out.println("- " + product));
            System.out.println("\n");


            //Réaliser une requête qui permet d’extraire tous les animaux d’une animalerie donnée (JPQL)
            System.out.println("Liste des animaux de l'animalerie " +chrisStore.getName()+" : " );
            Query query2 = em.createQuery("SELECT a FROM Animal a JOIN a.petstore p WHERE p.name = :petstore_name");
            query2.setParameter("petstore_name", chrisStore.getName());
            List<Animal> animals = query2.getResultList();
            animals.forEach(animal ->
                    System.out.println("- " + animal));

            //Fin de la deuxieme transaction
            em.getTransaction().commit();

        } finally {
            em.close();
            emf.close();
        }
    }
}