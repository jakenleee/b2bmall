package priv.jesse.mall.service.impl;

import com.sun.tools.javac.util.Log;
import org.springframework.http.HttpRequest;
import priv.jesse.mall.entity.QueryForm;
import priv.jesse.mall.entity.User;
import priv.jesse.mall.service.QueryService;
import priv.jesse.mall.service.exception.LoginException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Date;


public class QueryServiceImpl implements QueryService {
    @Override
    @Transactional
    public void getQueryList(HttpRequest request) throws Exception{

    }

    @Override
    public void submitQueryList(Integer id, int productId, HttpServletRequest request
                                , HttpServletResponse response) throws Exception {
      Object user = request.getSession().getAttribute("user");
      if (user == null){
          throw new LoginException("请登录！");
      }
      User loginUser = (User) user;
        QueryForm queryForm = new QueryForm();
        queryForm.setId(id);
        queryForm.setProductId(productId);
        queryForm.getProductNum();
        queryForm.setState(STATE_NO_PAY);
        queryForm.setQueryFormTime(new Date());



    }
}
