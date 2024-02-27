package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

    private Integer number;
    private LocalDate start;
    private Double contractValue;

    private List<Installment> installment = new ArrayList<>();

    public Contract() {

    }

    public Contract(Integer number, LocalDate start, Double contractValue) {
        this.number = number;
        this.start = start;
        this.contractValue = contractValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public Double getContractValue() {
        return contractValue;
    }

    public void setContractValue(Double contractValue) {
        this.contractValue = contractValue;
    }

    public List<Installment> getInstallment() {
        return installment;
    }
}
