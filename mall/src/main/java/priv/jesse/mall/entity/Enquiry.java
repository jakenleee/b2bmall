package priv.jesse.mall.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "enquiry")
public class Enquiry {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Integer id;
    /**
     * 商品标题
     */
    @Column
    private String title;
    /**
     * 市场价
     */
    @Column
    private Double marketPrice;
    /**
     * 商城价
     */
    @Column
    private Double shopPrice;

    /**
     * 描述
     */
    @Column(name = "`desc`", columnDefinition = "text")
    private String desc;
    /**
     * 是否热门商品
     */
    @Column
    private Integer isHot;

    /**
     * 商品创建日期
     */
    @Column
    private Date pdate;

    /**
     * 数量
     */
    @Column
    private Integer count;

    /**
     * 买家id
     */
    @Column
    private int buyer_id;

    /**
     * 商品类型
     * */
    private String productType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enquiry enquiry = (Enquiry) o;

        if (buyer_id != enquiry.buyer_id) return false;
        if (id != null ? !id.equals(enquiry.id) : enquiry.id != null) return false;
        if (title != null ? !title.equals(enquiry.title) : enquiry.title != null) return false;
        if (marketPrice != null ? !marketPrice.equals(enquiry.marketPrice) : enquiry.marketPrice != null) return false;
        if (shopPrice != null ? !shopPrice.equals(enquiry.shopPrice) : enquiry.shopPrice != null) return false;
        if (desc != null ? !desc.equals(enquiry.desc) : enquiry.desc != null) return false;
        if (isHot != null ? !isHot.equals(enquiry.isHot) : enquiry.isHot != null) return false;
        if (pdate != null ? !pdate.equals(enquiry.pdate) : enquiry.pdate != null) return false;
        return count != null ? count.equals(enquiry.count) : enquiry.count == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (marketPrice != null ? marketPrice.hashCode() : 0);
        result = 31 * result + (shopPrice != null ? shopPrice.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (isHot != null ? isHot.hashCode() : 0);
        result = 31 * result + (pdate != null ? pdate.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + buyer_id;
        return result;
    }

    @Override
    public String toString() {
        return "Enquiry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", marketPrice=" + marketPrice +
                ", shopPrice=" + shopPrice +
                ", desc='" + desc + '\'' +
                ", isHot=" + isHot +
                ", pdate=" + pdate +
                ", count=" + count +
                ", buyer_id=" + buyer_id +
                ", productType='" + productType + '\'' +
                '}';
    }
}
