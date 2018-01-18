package org.blockchain.core.sec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public class SecTools
{
    public static final byte[] ZERO_BYTE={0};

    public static final Random random=new Random(System.currentTimeMillis());


    //比特币私钥为一串256位的随机数取值范围在[1,n-1]之间其中n (order) = FFFFFFFF FFFFFFFF FFFFFFFF FFFFFFFE BAAEDCE6 AF48A03B BFD25E8C D0364141
    public static byte[] genOneRandomNewPrivateKey()
    {
        byte[] ret=new byte[32];

        for(int i=0;i<32;i++)
        {
            if(i==0)
            {
                ret[i]=(byte)random.nextInt(255);
            }
            else
            {
                ret[i]=(byte)random.nextInt(256);
            }
        }

        return ret;
    }

    /**
     * 私钥 小于 order 大于0 ;
     */
    private static byte[] order ={
            (byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,
            (byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFE,
            (byte)0xBA,(byte)0xAE,(byte)0xDC,(byte)0xE6,(byte)0xAF,(byte)0x48,(byte)0xA0,(byte)0x3B,
            (byte)0xBF,(byte)0xD2,(byte)0x5E,(byte)0x8C,(byte)0xD0,(byte)0x36,(byte)0x41,(byte)0x40
       };



    public static byte[] hash256(byte[] input)
    {
        if(null == input || input.length == 0)
        {
            return ZERO_BYTE;
        }
        else
        {
            return  SHA256(SHA256(input));
        }
    }

    public static byte[] hash160(byte[] input)
    {
        if(null == input || input.length == 0)
        {
            return ZERO_BYTE;
        }
        else
        {
            return  Ripemd160.getHash(SHA256(input));
        }
    }

    /**
     * 传入文本内容，返回 SHA-256 串
     *
     * @param strText
     * @return
     */
    public static String SHA256(final String strText)
    {
        return SHA(strText, "SHA-256");
    }

    public static byte[] SHA256(final byte[] strText)
    {
        return SHA(strText, "SHA-256");
    }

    /**
     * 传入文本内容，返回 SHA-512 串
     *
     * @param strText
     * @return
     */
    public static String SHA512(final String strText)
    {
        return SHA(strText, "SHA-512");
    }

    public static byte[] SHA512(final byte[] strText)
    {
        return SHA(strText, "SHA-512");
    }

    /**
     * 字符串 SHA 加密
     *
     * @param strText
     * @return
     */
    private static String SHA(final String strText, final String strType)
    {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0)
        {
            try
            {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到 byte 類型结果
                byte byteBuffer[] = messageDigest.digest();

                // 將 byte 轉換爲 string
                StringBuffer strHexString = new StringBuffer();
                // 遍歷 byte buffer
                for (int i = 0; i < byteBuffer.length; i++)
                {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1)
                    {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            }
            catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
        }

        return strResult;
    }

    private static byte[] SHA(final byte[] strText, final String strType)
    {
        // 是否是有效字符串
        if (strText != null && strText.length > 0)
        {
            try
            {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText);
                // 得到 byte 類型结果
                byte byteBuffer[] = messageDigest.digest();

                return byteBuffer;
            }
            catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
        }

        return ZERO_BYTE;
    }
}
