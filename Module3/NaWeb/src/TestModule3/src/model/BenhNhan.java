package model;

public class BenhNhan {
    private String idBenhNhan;
    private String nameBenhNhan;

    public BenhNhan(){
    }

    public BenhNhan(String idBenhNhan, String nameBenhNhan) {
        this.idBenhNhan = idBenhNhan;
        this.nameBenhNhan = nameBenhNhan;
    }

    public String getIdBenhNhan() {
        return idBenhNhan;
    }

    public void setIdBenhNhan(String idBenhNhan) {
        this.idBenhNhan = idBenhNhan;
    }

    public String getNameBenhNhan() {
        return nameBenhNhan;
    }

    public void setNameBenhNhan(String nameBenhNhan) {
        this.nameBenhNhan = nameBenhNhan;
    }
}
