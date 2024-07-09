package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n02.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_FlorID;
    private String nameFlower;
    private String paisFlor;

    public FlorEntity() {
    }

    public FlorEntity(Integer pk_FlorID, String nameFlower, String paisFlor) {
        this.pk_FlorID = pk_FlorID;
        this.nameFlower = nameFlower;
        this.paisFlor = paisFlor;
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
}
