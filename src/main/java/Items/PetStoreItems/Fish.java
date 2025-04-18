package Items.PetStoreItems;

import java.time.LocalDate;
import java.util.Date;

public class Fish extends Animal{
    private FishLivEnv livingEnv;

    public Fish() {
    }

    public Fish(Long id, LocalDate birth, String couleur, FishLivEnv livingEnv) {
        super(id, birth, couleur);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
