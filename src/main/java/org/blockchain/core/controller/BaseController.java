package org.blockchain.core.controller;

import org.blockchain.core.bean.MessageModel;
import org.blockchain.core.code.Code;
import org.blockchain.core.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
@RestController
public class BaseController
{
    @Resource
    private LogService logService;

    @PostMapping(path = "/sayHello.do")
    public Object sayHello(@RequestBody MessageModel model)
    {

        logService.info(model.getMessage());

        boolean success="admin".equals(model.getSendBy());

        return success ? Code.SUCCESS : Code.UNSUCCESS;
    }

    @GetMapping(path = "/test.do")
    public Object test()
    {

        logService.info("test.do");

        return  Code.SUCCESS;
    }

    @GetMapping(path = "/test2.do")
    public void test2(HttpServletRequest httpRequest,HttpServletResponse response)
    {

        logService.info("test.do getOrigin:"+ httpRequest.getRemoteAddr());

        logService.info(httpRequest.getServletPath());

        try
        {
            response.getWriter().write("{'code':1}");
            response.getWriter().close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
