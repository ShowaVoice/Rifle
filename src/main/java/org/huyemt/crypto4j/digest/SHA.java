package org.huyemt.crypto4j.digest;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/**
 * @author Huyemt
 */

public class SHA extends Digest {
    public SHA() {
        super("SHA-1");
    }

    public SHA(String type) {
        super(type.toLowerCase().startsWith("sha-") ? type : "SHA-" + type);
    }

    public String encrypt(String value) {
        return new BigInteger(1, digest.digest(value.getBytes(StandardCharsets.UTF_8))).toString(16);
    }
}
