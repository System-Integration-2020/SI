package dk.mh.si.rpcintegration;

public class Customer {

    private Long accnum;
    private String name;
    private Double amount;

    public Customer(Long accnum, String name, Double amount) {
        this.accnum = accnum;
        this.name = name;
        this.amount = amount;
    }

    public Long getAccnum() {
        return accnum;
    }

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAccnum(Long accnum) {
        this.accnum = accnum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
