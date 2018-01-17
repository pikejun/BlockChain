package org.blockchain.core.code;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public enum Code
{
    SUCCESS(1,"SUCCESS"),UNSUCCESS(-1,"UNSUCCESS");

    private int code;
    private String desc;
    Code(int code,String desc)
    {
        this.code=code;
        this.desc=desc;
    }

    public int getCode()
    {
        return code;
    }

    public String getDesc()
    {
        return desc;
    }

}
