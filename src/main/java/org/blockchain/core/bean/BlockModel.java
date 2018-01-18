package org.blockchain.core.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public class BlockModel implements Serializable
{
    private  byte[]  magic_byte_01_4=new byte[]{(byte)0xF9,(byte)0xBE,(byte)0xB4,(byte)0xD9};//0xD9B4BEF9

    private  byte[]  block_size_02_4=new byte[4];//

    ///区块头 共 80 byte开始

    private  byte[] block_version_03_4=new byte[4];//version 1.0 {(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x00}

    private byte[]  parent_block_hash_04_32=new byte[32];

    private byte[]  merkel_root_05_32=new byte[32];

    private byte[]  timestamp_06_4=new byte[4];//1970-01-01起的秒数 单位秒

    private byte[]  difficulty_goal_07_4 =new byte[4];

    private byte[]  nonce_08_4=new byte[4];

    //区块头 结束


    private byte[] trade_times_09_9=new byte[9];//9个字节

    private byte[] trade_content_10_x;

    public byte[] getMagic_byte_01_4()
    {
        return magic_byte_01_4;
    }

    public void setMagic_byte_01_4(byte[] magic_byte_01_4)
    {
        this.magic_byte_01_4 = magic_byte_01_4;
    }

    public byte[] getBlock_size_02_4()
    {
        return block_size_02_4;
    }

    public void setBlock_size_02_4(byte[] block_size_02_4)
    {
        this.block_size_02_4 = block_size_02_4;
    }

    public byte[] getBlock_version_03_4()
    {
        return block_version_03_4;
    }

    public void setBlock_version_03_4(byte[] block_version_03_4)
    {
        this.block_version_03_4 = block_version_03_4;
    }

    public byte[] getParent_block_hash_04_32()
    {
        return parent_block_hash_04_32;
    }

    public void setParent_block_hash_04_32(byte[] parent_block_hash_04_32)
    {
        this.parent_block_hash_04_32 = parent_block_hash_04_32;
    }

    public byte[] getMerkel_root_05_32()
    {
        return merkel_root_05_32;
    }

    public void setMerkel_root_05_32(byte[] merkel_root_05_32)
    {
        this.merkel_root_05_32 = merkel_root_05_32;
    }

    public byte[] getTimestamp_06_4()
    {
        return timestamp_06_4;
    }

    public void setTimestamp_06_4(byte[] timestamp_06_4)
    {
        this.timestamp_06_4 = timestamp_06_4;
    }

    public byte[] getDifficulty_goal_07_4()
    {
        return difficulty_goal_07_4;
    }

    public void setDifficulty_goal_07_4(byte[] difficulty_goal_07_4)
    {
        this.difficulty_goal_07_4 = difficulty_goal_07_4;
    }

    public byte[] getNonce_08_4()
    {
        return nonce_08_4;
    }

    public void setNonce_08_4(byte[] nonce_08_4)
    {
        this.nonce_08_4 = nonce_08_4;
    }

    public byte[] getTrade_times_09_9()
    {
        return trade_times_09_9;
    }

    public void setTrade_times_09_9(byte[] trade_times_09_9)
    {
        this.trade_times_09_9 = trade_times_09_9;
    }

    public byte[] getTrade_content_10_x()
    {
        return trade_content_10_x;
    }

    public void setTrade_content_10_x(byte[] trade_content_10_x)
    {
        this.trade_content_10_x = trade_content_10_x;
    }
}
