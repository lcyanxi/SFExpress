package cn.coolbhu.sfexpress.vo;

import org.apache.ibatis.type.Alias;

/**
 * Created by lcyanxi on 17-5-29.
 */
@Alias("ProImgInfo")
public class ProImgInfo {

    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
