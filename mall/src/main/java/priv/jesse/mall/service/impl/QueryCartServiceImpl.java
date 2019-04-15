package priv.jesse.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.jesse.mall.entity.Product;
import priv.jesse.mall.entity.QueryItem;
import priv.jesse.mall.entity.User;
import priv.jesse.mall.service.ProductService;
import priv.jesse.mall.service.QueryCartService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class QueryCartServiceImpl implements QueryCartService {

    @Autowired
    private ProductService productService;
    /**
     * 加购物车
     * 将商品id保存到Session中List<Integer>中
     *
     * @param productId
     * @param request
     */
    @Override
    public void addQueryCart(int productId, HttpServletRequest request) throws Exception {
        User loginUser = (User) request.getSession().getAttribute("user");
        if (loginUser==null){
            throw new Exception("亲~未登录，请重新登陆!");
        }
        List productIds = (List) request.getSession().getAttribute(NAME_PREFIX+ loginUser.getId());
        if (productIds == null){
            productIds = new ArrayList<>();
            request.getSession().setAttribute(NAME_PREFIX + loginUser.getId(),productIds);
        }
        productIds.add(productId);
    }


    /**
     * 移除
     *
     * 移除session List中对应的商品Id
     *
     * @param productId
     * @param request
     */
    @Override
    public void removeQueryCart(int productId, HttpServletRequest request) throws Exception {
       User loginUser = (User) request.getSession().getAttribute("user");
        if (loginUser == null){
            throw new Exception("亲~未登录，请重新登陆");
        }
        List<Integer> productIds = (List<Integer>) request.getSession().getAttribute(NAME_PREFIX + loginUser.getId());
        Iterator<Integer> iterator = productIds.iterator();
        while (iterator.hasNext()){
            if (productId == iterator.next()){
                iterator.remove();
            }
        }
    }


    /**
     * 查看询价购物车
     *
     * 查询出session的List中所有的商品Id,并封装成List<queryItem>返回
     *
     * @param request
     * @return
     */
    @Override
    public List<QueryItem> listQueryCart(HttpServletRequest request) throws Exception {
        User loginUser = (User) request.getSession().getAttribute("user");
        if (loginUser == null)
            throw new Exception("亲~未登录，请重新登陆");
        List<Integer> productIds = (List) request.getSession().getAttribute(NAME_PREFIX + loginUser.getId());
        HashMap<Integer,QueryItem> productMap = new HashMap<>();
        if (productIds == null){
            return new ArrayList<>();
        }
        //遍历List中的商品Id，每个商品Id对应一个OrderItem，通过Map封装
        for (Integer productId: productIds) {
            if (productMap.get(productId) == null) {
                Product product = productService.findById(productId);
                QueryItem queryItem = new QueryItem();
                queryItem.setProduct(product);
                queryItem.setProductId(productId);
                queryItem.setProductNum(1);
                queryItem.setSubTotal(product.getShopPrice());
                productMap.put(productId, queryItem);
            }else {
                //遍历着将订单中已有的商品数量叠加，价格叠加
                QueryItem queryItem = productMap.get(productId);
                Double subTotal = queryItem.getSubTotal();
                queryItem.setSubTotal(queryItem.getSubTotal() + subTotal);
                int count = queryItem.getProductNum();
                queryItem.setProductNum(++count);
            }
        }
        ArrayList<QueryItem> queryItems = new ArrayList<>(productMap.values());
        return queryItems;
    }
}
