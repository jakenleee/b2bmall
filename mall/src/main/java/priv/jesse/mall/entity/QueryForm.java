package priv.jesse.mall.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Date;

/**
 * 询价
 */

@Entity
@Table(name = "enquiry")
public class QueryForm implements Serializable{

    /**
    * 询价单ID
    */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    /**
    *商品ID
    */

    @Column
    private int productId;

    /**
    *商品名称
    */

    @Column
    private String productTitle;

    /**
    * 商品数量
    */

    @Column
    private int productNum;

    /**
    * 市场价
    */

    @Column
    private double marketPrice;

   /**
    * 商城价格
    */
    @Column
    private double shopPrice;

    /**
    * 是否有存货
    */

    @Column
    private Integer isOk;

    /**
     * 订单状态 1:未付款 2:等待发货 3:等待收货 4:订单完成
     * */
    @Column
    private Integer state;
    /**
     * 询价单时间
     * */
    @Column
    private Date queryFormTime;





    public Date getQueryFormTime() {
        return queryFormTime;
    }

    public void setQueryFormTime(Date queryFormTime) {
        this.queryFormTime = queryFormTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @org.springframework.data.annotation.Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

        if (id != queryForm.id) return false;
        if (productId != queryForm.productId) return false;
        if (productNum != queryForm.productNum) return false;
        if (Double.compare(queryForm.marketPrice, marketPrice) != 0) return false;
        if (Double.compare(queryForm.shopPrice, shopPrice) != 0) return false;
        if (!productTitle.equals(queryForm.productTitle)) return false;
        if (!isOk.equals(queryForm.isOk)) return false;
        if (!state.equals(queryForm.state)) return false;
        return queryFormTime.equals(queryForm.queryFormTime);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + productId;
        result = 31 * result + productTitle.hashCode();
        result = 31 * result + productNum;
        temp = Double.doubleToLongBits(marketPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(shopPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + isOk.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + queryFormTime.hashCode();
        return result;
    }

    //返回一个jason格式的数据
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash=").append(hashCode());
        sb.append(", enquiryId=").append(id);
        sb.append(", productiId=").append(productId);
        sb.append(", productTitle='").append(productTitle);
        sb.append(", productNum=").append(productNum);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", shopPrice=").append(marketPrice);
        sb.append(", isOk=").append(isOk);
        sb.append(", state=").append(state);
        sb.append(", queryFormTime=").append(queryFormTime);
        sb.append("]");
        return sb.toString();
    }
}
