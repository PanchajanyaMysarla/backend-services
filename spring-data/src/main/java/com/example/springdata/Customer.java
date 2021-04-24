package com.example.springdata;

import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;

    @Formula("id * 10")
    private Long customerId;

    @Formula("case when start_date <= CURRENT_TIMESTAMP() and end_date >= CURRENT_TIMESTAMP() then 'Active' else 'Inactive' end")
    private String status;

    @Formula("case when start_date <= CURRENT_TIMESTAMP() and end_date >= CURRENT_TIMESTAMP() then 0 else 1 end")
    private long active;

    public Customer(){}

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, OffsetDateTime startDate, OffsetDateTime endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", customerId=" + customerId +
                ", status='" + status + '\'' +
                ", active=" + active +
                '}';
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
