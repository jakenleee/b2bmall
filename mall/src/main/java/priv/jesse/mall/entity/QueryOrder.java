package priv.jesse.mall.entity;


import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;


@Entity
@Table(name = "query_order")
public class QueryOrder {


    @Id
    @GeneratedValue
    @Column
    private Integer id;

    /**
     * 询价单总价
     * */
    @Column
    private Double total;

    /**
     * 询价单状态:1:未付款 2:等待发货 3:等待收货 4:订单完成
     * */
    @Column
    private Integer state;

    /**
     * 询价单时间
     * */
    @Column
    private Date queryOrderTime;

    /**
     * 收货人姓名
     * */
    @Column
    private String name;

    /**
     * 收获人联系电话
     * */
    @Column
    private String phone;

    /**
     * 收货地址
     * */
    @Column
    private String address;

    /**
     * 用户Id
     * */
    @Column
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getQueryOrderTime() {
        return queryOrderTime;
    }

    public void setQueryOrderTime(Date queryOrderTime) {
        this.queryOrderTime = queryOrderTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueryOrder that = (QueryOrder) o;

        if (!id.equals(that.id)) return false;
        if (!total.equals(that.total)) return false;
        if (!state.equals(that.state)) return false;
        if (!queryOrderTime.equals(that.queryOrderTime)) return false;
        if (!name.equals(that.name)) return false;
        if (!phone.equals(that.phone)) return false;
        if (!address.equals(that.address)) return false;
        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + total.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + queryOrderTime.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + userId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "QueryOrder{" +
                "id=" + id +
                ", total=" + total +
                ", state=" + state +
                ", queryOrderTime=" + queryOrderTime +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userId=" + userId +
                '}';
    }
}
