package models;

import models.enums.InvoicePaidStatus;

import java.util.Date;

public class Invoice extends BaseModel{
    private Date exitTime;
    private Ticket ticket;
    private Operator operator;
    private double amount;
    private InvoicePaidStatus invoicePaidStatus;

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public InvoicePaidStatus getBillStatus() {
        return invoicePaidStatus;
    }

    public void setBillStatus(InvoicePaidStatus invoicePaidStatus) {
        this.invoicePaidStatus = invoicePaidStatus;
    }
}
