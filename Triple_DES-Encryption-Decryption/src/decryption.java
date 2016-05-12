import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class decryption implements Encryption_Decryption {
	public String decrypt(String text, String key) throws Exception {
		byte[] bits = Base64.decodeBase64(text.getBytes());
		MessageDigest msg = MessageDigest.getInstance("SHA-1");
		byte[] digestOfPassword = msg.digest(key.getBytes("utf-8"));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		SecretKey keys = new SecretKeySpec(keyBytes, "DESede");
		Cipher decipher = Cipher.getInstance("DESede");
		decipher.init(Cipher.DECRYPT_MODE, keys);

		byte[] plainText = decipher.doFinal(bits);

		return new String(plainText, "UTF-8");

	}

	public String encrypt(String text, String key) throws Exception {
		return null;
	}

	public static void main(String[] args) throws Exception {
		Encryption_Decryption a = new decryption();
		String ab = a.decrypt("nkYvPcZZjyeTTj3Kw6+5Pg==", "SecretKey");

		System.out.println(ab);
	}
}
