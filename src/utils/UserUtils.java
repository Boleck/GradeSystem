package utils;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class UserUtils {

    private static int saltLen = 32;
    private static int iterations = 20 * 1000;
    private static int desiredKeyLen = 256;

    public static String getSaltedHash(String password) {
        byte[] salt = new byte[0];
        try {
            salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(salt) + "$" + hash(password,salt);
    }
    public static boolean check(String password, String stored) {
        String[] saltAndPass = stored.split("\\$");
        String hashOfInput = hash(password,Base64.getDecoder().decode(saltAndPass[0]));
        return hashOfInput.equals(saltAndPass[1]);
    }
    private static String hash(String password, byte[] salt) {
        SecretKeyFactory f;
        SecretKey key = null;

        try {
            f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            key = f.generateSecret(new PBEKeySpec(password.toCharArray(),salt,iterations,desiredKeyLen));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(key.getEncoded());
    }


}
