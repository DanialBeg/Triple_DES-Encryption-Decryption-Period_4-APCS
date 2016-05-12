import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Encryption implements Encryption_Decryption{

	public static void main(String[] args) throws Exception{
		Encryption_Decryption a = new Encryption();
		String b = a.encrypt("jarjar", "jarjarissnoke");
		System.out.println(b);
	}

	public String encrypt(String text, String key) throws Exception{
		MessageDigest msg = MessageDigest.getInstance("SHA-1");
		byte[] psw = msg.digest(key.getBytes("utf-8"));
		byte[] bytes = Arrays.copyOf(psw, 24);
		
		SecretKey keys = new SecretKeySpec(bytes, "DESede");
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, keys);
		
		byte[] plainTextBytes = text.getBytes("utf-8");
	        byte[] buf = cipher.doFinal(plainTextBytes);
	        byte [] base64Bytes = Base64.encodeBase64(buf);
	        String string = new String(base64Bytes);
	        return string;
	}

	public String decrypt(String text, String key) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
