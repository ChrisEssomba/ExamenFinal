package Items.PetStoreItems;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Cat extends Animal{
    private String chipid;

    public Cat() {
    }

    public Cat(Long id, LocalDate birth, String couleur, String chipid) {
        super(id, birth, couleur);
        this.chipid = chipid;
    }

    public String getChipid() {
        return chipid;
    }

    public void setChipid(String chipid) {
        this.chipid = chipid;
    }
}
