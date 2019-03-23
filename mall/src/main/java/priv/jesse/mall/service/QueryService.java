package priv.jesse.mall.service;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface QueryService {

    /**
     * 订单状态 1:未付款 2:等待发货 3:等待收货 4:订单完成
     */
    int STATE_NO_PAY = 1;
    int STATE_WAITE_SEND = 2;
    int STATE_WAITE_RECEIVE = 3;
    int STATE_COMPLETE = 4;


    @RequestMapping(value = "/getQueryList", method = RequestMethod.GET)
    public void getQueryList(HttpRequest request) throws Exception;


    @RequestMapping(value = "/submitQueryList", method = RequestMethod.POST)
    public void submitQueryList(Integer id, int productId, HttpServletRequest request,
                                HttpServletResponse response) throws Exception;

}
