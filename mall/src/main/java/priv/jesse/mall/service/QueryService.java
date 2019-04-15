package priv.jesse.mall.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import priv.jesse.mall.entity.Enquiry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@ComponentScan
public interface QueryService {

    /**
     * 订单状态 1:未付款 2:等待发货 3:等待收货 4:订单完成
     */
    int STATE_NO_PAY = 1;
    int STATE_WAITE_SEND = 2;
    int STATE_WAITE_RECEIVE = 3;
    int STATE_COMPLETE = 4;



    /**
     * 创建
     *
     * @param enquiry
     * @return
     * */

    int create(Enquiry enquiry);



    /**
     *获取询价单列表
     * */
     void getQueryList(HttpRequest request) throws Exception;


    /**
     * 提交询价单列表
     * */
     void submitQueryList(String name, String phone, String addr,
                                HttpServletRequest request, HttpServletResponse response) throws Exception;


    /**
     * 提交新的询价需求
     * */
    public String submitEnquiry(int productId, String productTitle,
                                String productType, int productNum,
                                String desc, HttpServletRequest request,
                                HttpServletResponse response) throws Exception;
}
