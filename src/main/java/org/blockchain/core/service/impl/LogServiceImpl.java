package org.blockchain.core.service.impl;

import org.blockchain.core.service.LogService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
@Service
public class LogServiceImpl implements LogService
{
    @Override
    public void info(String msg)
    {
        System.out.println("INFO:"+msg);
    }
}
