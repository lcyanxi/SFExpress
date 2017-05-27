package cn.coolbhu.sfexpress.model;

import java.util.Date;

public class Cart {
    private String cartid;

    private String userid;

    private String proid;

    private Integer num;

    private Double total;

    private Date cartcreatetime;

    private Date cartupdatetime;

    private Integer cartmark;

    public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid == null ? null : cartid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid == null ? null : proid.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getCartcreatetime() {
        return cartcreatetime;
    }

    public void setCartcreatetime(Date cartcreatetime) {
        this.cartcreatetime = cartcreatetime;
    }

    public Date getCartupdatetime() {
        return cartupdatetime;
    }

    public void setCartupdatetime(Date cartupdatetime) {
        this.cartupdatetime = cartupdatetime;
    }

    public Integer getCartmark() {
        return cartmark;
    }

    public void setCartmark(Integer cartmark) {
        this.cartmark = cartmark;
    }
}