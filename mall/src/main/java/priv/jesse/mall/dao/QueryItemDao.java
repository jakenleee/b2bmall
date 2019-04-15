package priv.jesse.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.jesse.mall.entity.QueryItem;

import java.util.List;

public interface QueryItemDao extends JpaRepository<QueryItem,Integer> {
    /**
     * 根据订单id查询
     * @param enquiryOrderId
     * @return
     * */

   /* List<QueryItem> findByEnquiryOrderId(int enquiryOrderId);*/


}
