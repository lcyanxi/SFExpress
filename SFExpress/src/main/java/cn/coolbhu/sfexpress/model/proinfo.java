package cn.coolbhu.sfexpress.model;

import java.util.Date;

public class proinfo {
    private String proinfoid;

    private String orderid;

    private String proid;

    private Date proinfocreatetime;

    private Integer proinfomark;

    public String getProinfoid() {
        return proinfoid;
    }

    public void setProinfoid(String proinfoid) {
        this.proinfoid = proinfoid == null ? null : proinfoid.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid == null ? null : proid.trim();
    }

    public Date getProinfocreatetime() {
        return proinfocreatetime;
    }

    public void setProinfocreatetime(Date proinfocreatetime) {
        this.proinfocreatetime = proinfocreatetime;
    }

    public Integer getProinfomark() {
        return proinfomark;
    }

    public void setProinfomark(Integer proinfomark) {
        this.proinfomark = proinfomark;
    }
}