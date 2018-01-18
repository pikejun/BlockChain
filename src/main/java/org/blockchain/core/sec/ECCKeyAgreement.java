package org.blockchain.core.sec;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;
import javax.crypto.KeyAgreement;

public class ECCKeyAgreement
{
    public static void main(String[] args) throws Exception
    {
        KeyPairGenerator kpg;
        kpg = KeyPairGenerator.getInstance("EC", "SunEC");
        ECGenParameterSpec ecsp;

        ecsp = new ECGenParameterSpec("secp192k1");
        kpg.initialize(ecsp);

        KeyPair kpU = kpg.genKeyPair();
        PrivateKey privKeyU = kpU.getPrivate();
        PublicKey pubKeyU = kpU.getPublic();
        System.out.println("privKeyU: " + privKeyU.toString());
        System.out.println("pubKeyU: " + pubKeyU.toString());

        KeyPair kpV = kpg.genKeyPair();
        PrivateKey privKeyV = kpV.getPrivate();
        PublicKey pubKeyV = kpV.getPublic();
        System.out.println("privKeyV V: " + privKeyV.toString());
        System.out.println("pubKeyV V: " + pubKeyV.toString());

        KeyAgreement ecdhU = KeyAgreement.getInstance("ECDH");
        ecdhU.init(privKeyU);
        ecdhU.doPhase(pubKeyV, true);

        KeyAgreement ecdhV = KeyAgreement.getInstance("ECDH");
        ecdhV.init(privKeyV);
        ecdhV.doPhase(pubKeyU, true);

        System.out.println("Secret computed by U: 0x" +
                (new BigInteger(1, ecdhU.generateSecret()).toString(16))
                        .toUpperCase());
        System.out.println("Secret computed by V: 0x" +
                (new BigInteger(1, ecdhV.generateSecret()).toString(16))
                        .toUpperCase());
    }
}