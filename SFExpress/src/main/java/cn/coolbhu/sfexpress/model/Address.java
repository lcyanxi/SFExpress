package cn.coolbhu.sfexpress.model;

import java.util.Date;

public class Address {
    private String addid;

    private String userid;

    private String addname;

    private String address;

    private String detailaddress;

    private String addphone;

    private Date addcreatetime;

    private Integer addmark;

    public String getAddid() {
        return addid;
    }

    public void setAddid(String addid) {
        this.addid = addid == null ? null : addid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getAddname() {
        return addname;
    }

    public void setAddname(String addname) {
        this.addname = addname == null ? null : addname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDetailaddress() {
        return detailaddress;
    }

    public void setDetailaddress(String detailaddress) {
        this.detailaddress = detailaddress == null ? null : detailaddress.trim();
    }

    public String getAddphone() {
        return addphone;
    }

    public void setAddphone(String addphone) {
        this.addphone = addphone == null ? null : addphone.trim();
    }

    public Date getAddcreatetime() {
        return addcreatetime;
    }

    public void setAddcreatetime(Date addcreatetime) {
        this.addcreatetime = addcreatetime;
    }

    public Integer getAddmark() {
        return addmark;
    }

    public void setAddmark(Integer addmark) {
        this.addmark = addmark;
    }
}