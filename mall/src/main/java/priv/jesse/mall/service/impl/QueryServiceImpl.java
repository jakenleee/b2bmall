package priv.jesse.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import priv.jesse.mall.dao.EnquiryDao;
import priv.jesse.mall.dao.QueryDao;
import priv.jesse.mall.dao.QueryItemDao;
import priv.jesse.mall.entity.*;
import priv.jesse.mall.service.QueryCartService;
import priv.jesse.mall.service.QueryService;
import priv.jesse.mall.service.exception.LoginException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {


    @Autowired
    private QueryCartService queryCartService;
    @Autowired
    private QueryDao queryDao;
    @Autowired
    private QueryItemDao queryItemDao;
    @Autowired
    private EnquiryDao enquiryDao;


    @Override
    public int create(Enquiry enquiry) {
        Enquiry enquiry1 = enquiryDao.save(enquiry);
        return 0;
    }

    @Override
    @Transactional
    public void getQueryList(HttpRequest request) throws Exception{

    }

    @Override
    public void submitQueryList(String name, String phone, String addr,
                                HttpServletRequest request, HttpServletResponse response) throws Exception {
      Object user = request.getSession().getAttribute("user");
      if (user == null){
          throw new LoginException("请登录！");
      }
      User loginUser = (User) user;
        QueryOrder queryOrder = new QueryOrder();
        queryOrder.setName(name);
        queryOrder.setPhone(phone);
        queryOrder.setAddress(addr);
        queryOrder.setQueryOrderTime(new Date());
        queryOrder.setUserId(loginUser.getId());
        queryOrder.setState(STATE_NO_PAY);
        List<QueryItem> queryItems = queryCartService.listQueryCart(request);
        Double total = 0.0;
        queryOrder.setTotal(total);
        queryOrder = queryDao.save(queryOrder);
        for (QueryItem queryItem : queryItems) {
            queryItem.setQueryOrderId(queryOrder.getId());
            total += queryItem.getSubTotal();
            queryItemDao.save(queryItem);
        }
        //获取询价单总价设置回queryOrder
        queryOrder.setTotal(total);
        queryDao.save(queryOrder);
        //重定向到询价单列表页面
        response.sendRedirect("/mall/");
    }

    @Override
    public String submitEnquiry(int productId, String productTitle,
                                String productType, int productNum,
                                String desc, String imgeUrl,HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user == null)
            throw new LoginException("请登录！");

        User loginUser = (User) user;

        Enquiry enquiry = new Enquiry();
        enquiry.setId(productId);
        enquiry.setTitle(productTitle);
        enquiry.setProductType(productType);
        enquiry.setCount(productNum);
        enquiry.setBuyer_id(loginUser.getId());
        enquiry.setDesc(desc);
        enquiry.setImgeUrl(imgeUrl);
        enquiry.setPdate(new Date());
        enquiryDao.save(enquiry);
        return null;
    }
}
