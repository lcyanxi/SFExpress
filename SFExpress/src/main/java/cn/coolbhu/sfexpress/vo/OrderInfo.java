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
    private Date createtime;
    private String addname;
    private Double totalprice;
    private int paymark;
    private List img;
    private int num;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public List getImg() {
        return img;
    }

    public void setImg(List img) {
        this.img = img;
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
                ", createtime=" + createtime +
                ", addname='" + addname + '\'' +
                ", totalprice=" + totalprice +
                ", paymark=" + paymark +
                ", img=" + img +
                ", num=" + num +
                '}';
    }
}
