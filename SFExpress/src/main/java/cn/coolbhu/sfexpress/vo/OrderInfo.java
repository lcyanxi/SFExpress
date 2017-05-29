package cn.coolbhu.sfexpress.vo;

import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

/**
 * Created by lcyanxi on 17-5-29.
 */
@Alias("OrderInfo")
public class OrderInfo {
    private String orderid;
    private Date ordercreatetime;
    private String addname;
    private Double totalprice;
    private int paymark;
    private List<ProImgInfo> proImgInfos;
    private int num;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Date getOrdercreatetime() {
        return ordercreatetime;
    }

    public void setOrdercreatetime(Date ordercreatetime) {
        this.ordercreatetime = ordercreatetime;
    }

    public String getAddname() {
        return addname;
    }

    public void setAddname(String addname) {
        this.addname = addname;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public int getPaymark() {
        return paymark;
    }

    public void setPaymark(int paymark) {
        this.paymark = paymark;
    }

    public List<ProImgInfo> getProImgInfos() {
        return proImgInfos;
    }

    public void setProImgInfos(List<ProImgInfo> proImgInfos) {
        this.proImgInfos = proImgInfos;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderid='" + orderid + '\'' +
                ", ordercreatetime=" + ordercreatetime +
                ", addname='" + addname + '\'' +
                ", totalprice=" + totalprice +
                ", paymark=" + paymark +
                ", img=" + proImgInfos +
                ", num=" + num +
                '}';
    }
}
