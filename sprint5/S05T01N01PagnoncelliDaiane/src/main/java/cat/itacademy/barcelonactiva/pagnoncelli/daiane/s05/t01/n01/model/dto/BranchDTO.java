package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.dto;

public class BranchDTO {
    private Integer pk_BranchID;
    private String nameBranch;
    private String countryBranch;
    private String typeBranch;

    public BranchDTO() {
    }

    public BranchDTO(Integer pk_BranchID, String nameBranch, String countryBranch, String typeBranch) {
        this.pk_BranchID = pk_BranchID;
        this.nameBranch = nameBranch;
        this.countryBranch = countryBranch;
        this.typeBranch = typeBranch;
    }

    public Integer getPk_BranchID() {
        return pk_BranchID;
    }

    public void setPk_BranchID(Integer pk_BranchID) {
        this.pk_BranchID = pk_BranchID;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public String getCountryBranch() {
        return countryBranch;
    }

    public void setCountryBranch(String countryBranch) {
        this.countryBranch = countryBranch;
    }

    public String getTypeBranch() {
        return typeBranch;
    }

    public void setTypeBranch(String typeBranch) {
        this.typeBranch = typeBranch;
    }
}

