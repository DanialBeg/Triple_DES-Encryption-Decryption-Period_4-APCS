public class Runner {
	public static void main(String[] args) throws Exception {
		Encryption a = new Encryption();
		decryption b = new decryption();
		String message = "Battlefront";
		String key1 = "jarjar";
		String key2 = "KyloRen";
		String key3 = "GEnrealHux";
		String c = a.encrypt(message, key1);
		System.out.println(c);
		String d = b.decrypt(c, key2);
		String cipher = a.encrypt(d, key3);
		System.out.println(cipher);

	}

}
