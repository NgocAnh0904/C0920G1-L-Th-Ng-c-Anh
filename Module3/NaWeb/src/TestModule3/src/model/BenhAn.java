package model;

public class BenhAn {
    private String idBenhAn;
    private String dateIn;
    private String dateOut;
    private String reasonIn;

    public BenhAn(){
    }

    public BenhAn(String idBenhAn, String dateIn, String dateOut, String reasonIn) {
        this.idBenhAn = idBenhAn;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.reasonIn = reasonIn;
    }

    public String getIdBenhAn() {
        return idBenhAn;
    }

    public void setIdBenhAn(String idBenhAn) {
        this.idBenhAn = idBenhAn;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getReasonIn() {
        return reasonIn;
    }

    public void setReasonIn(String reasonIn) {
        this.reasonIn = reasonIn;
    }
}