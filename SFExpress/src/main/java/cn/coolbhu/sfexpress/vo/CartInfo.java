package cn.coolbhu.sfexpress.vo;

import cn.coolbhu.sfexpress.model.Cart;

/**
 * Created by brainy on 17-5-28.
 */
public class CartInfo extends Cart {

    private String img;

    private String price;

    private String proname;

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getImg() {
        return img;
    }

    public String getPrice() {
        return price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
