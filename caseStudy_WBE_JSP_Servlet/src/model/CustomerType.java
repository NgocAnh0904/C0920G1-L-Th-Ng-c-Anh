package model;

public class CustomerType {
    String idCustomerType;
    String nameCustomerType;

    public CustomerType(String idCustomerType, String nameCustomerType) {
        this.idCustomerType = idCustomerType;
        this.nameCustomerType = nameCustomerType;
    }

    public CustomerType() {
    }

    ;

    public String getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(String idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }
}