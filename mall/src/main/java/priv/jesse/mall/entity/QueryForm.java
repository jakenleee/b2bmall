package priv.jesse.mall.entity;





import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Objects;


/*
 * 询价
 * */
@Entity
@Table(name = "`Query`")
public class QueryForm {

    /*
    * 询价单ID
    * */
    @Id
    @GeneratedValue
    @Column
    private int enquiryId;

    /*
    *商品ID
    * */
    @Column
    private int productiId;

    /*
    *商品名称
    */
    @Column
    private String productTitle;

    /*
    * 商品数量
    * */
    @Column
    private int productNum;

    /*
    * 市场价
    * */
    @Column
    private double marketPrice;

    /*
    * 商城价格
    * */
    @Column
    private double shopPrice;

    /*
    * 是否有存货
    * */
    @Column
    private Integer isOk;

    public QueryForm(int productiId, String productTitle, int productNum, double marketPrice, double shopPrice, Integer isOk) {
        this.productiId = productiId;
        this.productTitle = productTitle;
        this.productNum = productNum;
        this.marketPrice = marketPrice;
        this.shopPrice = shopPrice;
        this.isOk = isOk;
    }

    public int getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(int enquiryId) {
        this.enquiryId = enquiryId;
    }

    public int getProductiId() {
        return productiId;
    }

    public void setProductiId(int productiId) {
        this.productiId = productiId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public Integer getIsOk() {
        return isOk;
    }

    public void setIsOk(Integer isOk) {
        this.isOk = isOk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryForm queryForm = (QueryForm) o;
        return enquiryId == queryForm.enquiryId &&
                productiId == queryForm.productiId &&
                productNum == queryForm.productNum &&
                Double.compare(queryForm.marketPrice, marketPrice) == 0 &&
                Double.compare(queryForm.shopPrice, shopPrice) == 0 &&
                productTitle.equals(queryForm.productTitle) &&
                isOk.equals(queryForm.isOk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enquiryId, productiId, productTitle, productNum, marketPrice, shopPrice, isOk);
    }


    //返回一个jason格式的数据
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash=").append(hashCode());
        sb.append(", enquiryId=").append(enquiryId);
        sb.append(", productiId=").append(productiId);
        sb.append(", productTitle='").append(productTitle);
        sb.append(", productNum=").append(productNum);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", shopPrice=").append(marketPrice);
        sb.append(", isOk=").append(isOk);
        sb.append("]");
        return sb.toString();
    }
}
