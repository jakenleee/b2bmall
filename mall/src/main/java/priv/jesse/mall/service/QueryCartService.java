package priv.jesse.mall.service;

import org.apache.ibatis.annotations.Param;
import priv.jesse.mall.entity.OrderItem;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface QueryCartService {

    String NAME_PREFIX = "query_cart-";

    /**
     * 添加到询价购物车
     * @param
     */
    void addQueryCart(@Param("productId") int productId, @Param("request") HttpServletRequest request) throws Exception;

    /**
     * 移除出询价购物车
     * @param productId
     * @param request
     */
    void removeQueryCart(int productId, HttpServletRequest request) throws Exception;

    /**
     * 查看询价购物车
     * @param request
     * @return
     */
    List<OrderItem> listQueryCart(HttpServletRequest request) throws Exception;

}
