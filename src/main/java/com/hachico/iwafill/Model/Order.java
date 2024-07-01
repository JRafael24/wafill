package com.hachico.iwafill.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordertbl")
public class Order {

    @Id
    @GeneratedValue
    private Long orderid;
    private Long userid;
    private double totalamount;
    private String status;

    Order (){}

    public Order( long userid, double totalamount, String status){
        this.userid= userid;
        this.totalamount = totalamount;
        this.status = status;
    }

    public Long getOrderid() {
        return orderid;
    }

    public Long getUserid() {
        return userid;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public String getStatus() {
        return status;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
