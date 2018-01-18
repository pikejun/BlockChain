package org.blockchain.core.sec;


import org.blockchain.core.util.CTools;

import java.security.*;
import java.security.spec.*;

public class ECCKeyGeneration
{
    public static String getSignatureWithPrivateKey(PrivateKey privKey,String text)
    {
        Signature ecdsa=null;
        try
        {
            ecdsa = Signature.getInstance("SHA1withECDSA", "SunEC");
            ecdsa.initSign(privKey);
            ecdsa.update(text.getBytes());
            byte[] baSignature = ecdsa.sign();
            return CTools.hexToString(baSignature);
        }
        catch (Exception e)
        {
            e.getMessage();
        }

        return "";
    }

    public static boolean verifySignTextWithPublicKey(PublicKey publicKey,String signText,String text)
    {
        Signature signature=null;

        try
        {
            signature = Signature.getInstance("SHA1withECDSA", "SunEC");
            signature.initVerify(publicKey);
            signature.update(text.getBytes());
            boolean result = signature.verify(CTools.stringToHex(signText));

            return result;
        }
        catch (Exception e)
        {
            e.getMessage();
        }

        return false;
    }

    public static KeyPair getECCKeyPair()
    {
        KeyPairGenerator kpg;
        try
        {
            kpg = KeyPairGenerator.getInstance("EC", "SunEC");
            ECGenParameterSpec ecsp;
            ecsp = new ECGenParameterSpec("secp192r1");
            kpg.initialize(ecsp);
            return kpg.genKeyPair();
        }
        catch (Exception e)
        {
            e.getMessage();
        }

        return null;
    }

    public static void main(String[] args) throws Exception
    {
        KeyPair kp =getECCKeyPair();
        PrivateKey privKey = kp.getPrivate();
        PublicKey pubKey = kp.getPublic();

       // System.out.println(CTools.hexToString(privKey.getEncoded()));

       // System.out.println(privKey.toString());
        //System.out.println(privKey.getFormat());

        System.out.println(pubKey.toString());
    }
}