import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Encryption implements Encryption_Decryption{

	public String encrypt(String text, String key) throws Exception{
		MessageDigest msg = MessageDigest.getInstance("SHA-1");
		byte[] psw = msg.digest(key.getBytes("utf-8"));
		byte[] bytes = Arrays.copyOf(psw, 24);
		
		SecretKey keys = new SecretKeySpec(bytes, "DESede");
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, keys);
		
		byte[] plainTextBytes = text.getBytes("utf-8");
	        byte[] dec = cipher.doFinal(plainTextBytes);
	        byte [] bytes = Base64.encodeBase64(buf);
	        String string = new String(dec);
	        return string;
	}

	public String decrypt(String text, String key) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
