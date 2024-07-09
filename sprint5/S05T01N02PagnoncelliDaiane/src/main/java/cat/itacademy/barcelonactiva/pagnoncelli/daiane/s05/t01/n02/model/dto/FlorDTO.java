package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n02.model.dto;

import java.util.Arrays;
import java.util.List;

public class FlorDTO {

    private Integer pk_FlorID;
    private String nameFlower;
    private String paisFlor;
    private String flowerType;

    private static final List<String> EU_COUNTRIES = Arrays.asList(
            "Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic",
            "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland",
            "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland",
            "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden"
    );

    public FlorDTO(Integer pk_FlorID, String nameFlower, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nameFlower = nameFlower;
        this.paisFlor = paisFlor;
        this.flowerType = EU_COUNTRIES.contains(paisFlor) ? "EU" : "Non-EU";
    }


    public Integer getPk_FlorID() {
        return pk_FlorID;
    }

    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public String getNameFlower() {
        return nameFlower;
    }

    public void setNameFlower(String nameFlower) {
        this.nameFlower = nameFlower;
    }

    public String getPaisFlor() {
        return paisFlor;
    }

    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }
}
