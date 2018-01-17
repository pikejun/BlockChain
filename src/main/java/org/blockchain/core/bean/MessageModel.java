package org.blockchain.core.bean;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public class MessageModel
{
    private String message;

    private String sendBy;

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getSendBy()
    {
        return sendBy;
    }

    public void setSendBy(String sendBy)
    {
        this.sendBy = sendBy;
    }
}
