package priv.jesse.mall.service;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;

public interface QueryService {

@RequestMapping(value = "/getQueryList")
    public void getQueryList(HttpRequest request);

}
