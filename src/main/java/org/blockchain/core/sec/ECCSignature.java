package org.blockchain.core.sec;

import org.blockchain.core.util.CTools;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;

public class ECCSignature
{
    public static void main(String[] args) throws Exception
    {
        String t1="aaa bbb ccc ddd eee fff";

        KeyPair kp=ECCKeyGeneration.getECCKeyPair();

        String pk=CTools.hexToString(kp.getPrivate().getEncoded());
        System.out.println(pk + "_____"+pk.length()*4 );
        String signText=ECCKeyGeneration.getSignatureWithPrivateKey(kp.getPrivate(),t1);

        System.out.println(t1);
        System.out.println(signText+"________"+signText.length()*4);

        System.out.println("============================================================");

        System.out.println(ECCKeyGeneration.verifySignTextWithPublicKey(kp.getPublic(),signText,"aaa bbb ccc ddd eee fff"));
    }

    public static String sign(String content, String privateKey, String encode)
    {
        try
        {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                    Base64.decode(privateKey));

            KeyFactory keyf = KeyFactory.getInstance("ECC");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature =  Signature.getInstance("SHA1withECDSA", "SunEC");

            signature.initSign(priKey);
            signature.update(content.getBytes(encode));

            byte[] signed = signature.sign();

            return Base64.encode(signed);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}