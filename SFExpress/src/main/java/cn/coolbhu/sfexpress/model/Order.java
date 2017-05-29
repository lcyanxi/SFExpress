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

    public String getAddid() {
        return addid;
    }

    public void setAddid(String addid) {
        this.addid = addid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Date getOrdercreatetime() {
        return ordercreatetime;
    }

    public void setOrdercreatetime(Date ordercreatetime) {
        this.ordercreatetime = ordercreatetime;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getPaymark() {
        return paymark;
    }

    public void setPaymark(Integer paymark) {
        this.paymark = paymark;
    }

    public Integer getOrdermark() {
        return ordermark;
    }

    public void setOrdermark(Integer ordermark) {
        this.ordermark = ordermark;
    }
}