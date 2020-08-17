package com.zcy.spring.dao;

import org.apache.ibatis.annotations.Param;

public interface AccountDao {

    int updateAccount(@Param("id") int id,@Param("money") float money);
}
