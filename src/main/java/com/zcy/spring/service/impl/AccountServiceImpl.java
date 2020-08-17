package com.zcy.spring.service.impl;

import com.zcy.spring.dao.AccountDao;
import com.zcy.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    /*
        propagation : 传播行为  事务是否可以嵌套
        isolation   : 隔离级别  两个sqlSession之间的数据 可以读取的级别(脏读、幻读、可重复读)
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @Override
    public boolean transMoney(int from, int to, float money) {
        accountDao.updateAccount(from, -money);

        int i = 1 / 0;

        accountDao.updateAccount(to, money);

        return false;
    }
}
