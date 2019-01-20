package jinyuanyuan.bw.com.jinyuanyuan0120.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *Author:Ahri_Love
 *Date:2019/1/20
 *
 */
@Entity
public class GoodsDataBean {
    private double bargainPrice;
    private String createtime;
    private String detailUrl;
    private String images;
    private int itemtype;
    private int pid;
    private double price;
    private int pscid;
    private int salenum;
    private int sellerid;
    private String subhead;
    private String title;

    @Generated(hash = 988316593)
    public GoodsDataBean(double bargainPrice, String createtime, String detailUrl,
            String images, int itemtype, int pid, double price, int pscid,
            int salenum, int sellerid, String subhead, String title) {
        this.bargainPrice = bargainPrice;
        this.createtime = createtime;
        this.detailUrl = detailUrl;
        this.images = images;
        this.itemtype = itemtype;
        this.pid = pid;
        this.price = price;
        this.pscid = pscid;
        this.salenum = salenum;
        this.sellerid = sellerid;
        this.subhead = subhead;
        this.title = title;
    }

    @Generated(hash = 1339012438)
    public GoodsDataBean() {
    }

    public double getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(double bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getItemtype() {
        return itemtype;
    }

    public void setItemtype(int itemtype) {
        this.itemtype = itemtype;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPscid() {
        return pscid;
    }

    public void setPscid(int pscid) {
        this.pscid = pscid;
    }

    public int getSalenum() {
        return salenum;
    }

    public void setSalenum(int salenum) {
        this.salenum = salenum;
    }

    public int getSellerid() {
        return sellerid;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
