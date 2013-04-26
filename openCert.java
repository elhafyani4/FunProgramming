import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;


public class openCert {

  /**
	 * @param args
	 * @throws KeyStoreException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws CertificateException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException {
		
		try { 
			java.lang.reflect.Field field = 
		java.lang.Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted"); 
		field.setAccessible(true); 
		field.set(null, java.lang.Boolean.FALSE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		try {
	        KeyStore keystore = KeyStore.getInstance("PKCS12");
	        
	        keystore.load(new FileInputStream("XXXXX.p12"), "XXXXX".toCharArray());
	        Enumeration<String> aliases = keystore.aliases();
	        
	        
	        while(aliases.hasMoreElements()){
	            String alias = aliases.nextElement();
	            if(keystore.getCertificate(alias).getType().equals("X.509")){
	                System.out.println(alias + " expires " + ((X509Certificate) keystore.getCertificate(alias)).getNotAfter());
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}
	
	
	
	

}
