package priv.jesse.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import priv.jesse.mall.entity.QueryOrder;

import javax.transaction.Transactional;

public interface QueryDao extends JpaRepository<QueryOrder,Integer> {

    @Modifying
    @Transactional
    @Query(value = "update `queryorder` qd set qd.state=?1 where qd.id=?2",nativeQuery = true)
    void updateQueryState(int state,int id);


}
