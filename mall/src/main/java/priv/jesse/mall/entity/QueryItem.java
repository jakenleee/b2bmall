package priv.jesse.mall.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 询价
 */

@Entity
@Table(name = "enquiry_item")
public class QueryItem implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    /**
     * 询价单ID
     */
    private int queryOrderId;

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

    /**
     *买家
     */
    @Column
    private Integer buyerId;

    /**
     * 总价
     */
    @Column
    private Double subTotal;


    @Transient
    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQueryOrderId() {
        return queryOrderId;
    }

    public void setQueryOrderId(int queryOrderId) {
        this.queryOrderId = queryOrderId;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getQueryFormTime() {
        return queryFormTime;
    }

    public void setQueryFormTime(Date queryFormTime) {
        this.queryFormTime = queryFormTime;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueryItem queryItem = (QueryItem) o;

        if (queryOrderId != queryItem.queryOrderId) return false;
        if (productId != queryItem.productId) return false;
        if (productNum != queryItem.productNum) return false;
        if (Double.compare(queryItem.marketPrice, marketPrice) != 0) return false;
        if (Double.compare(queryItem.shopPrice, shopPrice) != 0) return false;
        if (id != null ? !id.equals(queryItem.id) : queryItem.id != null) return false;
        if (productTitle != null ? !productTitle.equals(queryItem.productTitle) : queryItem.productTitle != null)
            return false;
        if (isOk != null ? !isOk.equals(queryItem.isOk) : queryItem.isOk != null) return false;
        if (state != null ? !state.equals(queryItem.state) : queryItem.state != null) return false;
        if (queryFormTime != null ? !queryFormTime.equals(queryItem.queryFormTime) : queryItem.queryFormTime != null)
            return false;
        if (buyerId != null ? !buyerId.equals(queryItem.buyerId) : queryItem.buyerId != null) return false;
        if (subTotal != null ? !subTotal.equals(queryItem.subTotal) : queryItem.subTotal != null) return false;
        return product != null ? product.equals(queryItem.product) : queryItem.product == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + queryOrderId;
        result = 31 * result + productId;
        result = 31 * result + (productTitle != null ? productTitle.hashCode() : 0);
        result = 31 * result + productNum;
        temp = Double.doubleToLongBits(marketPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(shopPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isOk != null ? isOk.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (queryFormTime != null ? queryFormTime.hashCode() : 0);
        result = 31 * result + (buyerId != null ? buyerId.hashCode() : 0);
        result = 31 * result + (subTotal != null ? subTotal.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    //返回一个jason格式的数据
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash=").append(hashCode());
        sb.append(", Id=").append(id);
        sb.append(", enquiryId=").append(queryOrderId);
        sb.append(", productiId=").append(productId);
        sb.append(", productTitle='").append(productTitle);
        sb.append(", productNum=").append(productNum);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", shopPrice=").append(marketPrice);
        sb.append(", isOk=").append(isOk);
        sb.append(", state=").append(state);
        sb.append(", queryFormTime=").append(queryFormTime);
        sb.append(", buyerId=").append(buyerId);
        sb.append("]");
        return sb.toString();
    }
}
