package cn.coolbhu.sfexpress.model;

import java.util.Date;

public class Order {
    private String orderid;

    private String userid;

    private String addid;

    private Date ordercreatetime;

    private Double totalprice;

    private Integer paymark;

    private Integer ordermark;

    public String getOrderid() {
        return orderid;
    }

    public String getUserid() {
        return userid;
    }

    public String getAddid() {
        return addid;
    }

    public Date getOrdercreatetime() {
        return ordercreatetime;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public Integer getPaymark() {
        return paymark;
    }

    public Integer getOrdermark() {
        return ordermark;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setAddid(String addid) {
        this.addid = addid;
    }

    public void setOrdercreatetime(Date ordercreatetime) {
        this.ordercreatetime = ordercreatetime;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public void setPaymark(Integer paymark) {
        this.paymark = paymark;
    }

    public void setOrdermark(Integer ordermark) {
        this.ordermark = ordermark;
    }
}