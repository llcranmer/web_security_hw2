import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.BadPaddingException;
import java.security.MessageDigest;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
 
public class HW2 {    
  
  static void P1() throws Exception {
    // Has all ready been encrypted with 
    // Cipher cipher = Cipher.getInstance("AES/CBC/ISO0126Padding");
    // byte[] cipherText = cipher.doFinal(plainText)
    // Decrypt mode
    //  Key key = cipher.init(Cipher.DECRYPT_MODE, key);

    byte[] cipherText = Files.readAllBytes(Paths.get("cipher1.txt"));

    // BEGIN SOLUTION
    byte[] iv = new byte[] { 0, 0, 0, 0, 
                             0, 0, 0, 0, 
                             0, 0, 0, 0, 
                             0, 0, 0, 0 };

    byte[] key =  new byte[] { 0, 0, 0, 0, 
                               0, 0, 0, 0, 
                               0, 0, 0, 0, 
                               0, 0, 0, 0 };

    Cipher cipher = Cipher.getInstance("AES/CBC/ISO10126Padding");
    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
    byte[] plainText = cipher.doFinal(cipherText); 
    System.out.println(new String(plainText, StandardCharsets.UTF_8));
  }

  static void P2() throws Exception {    
    // BEGIN SOLUTION
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    for (int i = 0; i < 1000; i++) {
      byte[] message = Files.readAllBytes(Paths.get(String.format("/Users/toul/Desktop/F_2018/Web_Security/HW2/HW2/messages/plain2%d.txt", i)));
      byte[] encodedHash = digest.digest(message);
      if(encodedHash[0] == 3 && encodedHash[1] == 59){
        System.out.print("2"+i);
      }

    }
    // END SOLUTION
  }

  static void P3() throws Exception {
    byte[] cipherText = Files.readAllBytes(Paths.get("cipher3.txt"));
    
    // BEGIN SOLUTION
    byte[] iv = new byte[] { 0, 0, 0, 0, 
                             0, 0, 0, 0, 
                             0, 0, 0, 0, 
                             0, 0, 0, 0 };

    byte[] key =  new byte[] { 0, 0, 0, 0, 
                               0, 0, 0, 0, 
                               0, 0, 0, 0, 
                               0, 0, 0, 0 };

    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
    byte[] plainText = cipher.doFinal(cipherText);  

    // END SOLUTION
    
    System.out.println(new String(plainText, StandardCharsets.UTF_8));
  }

  static void P4() throws Exception {
    byte[] cipherText = Files.readAllBytes(Paths.get("cipher4.txt"));
    
    // BEGIN SOLUTION
    // The solution is to try all the possible values of keys
    // that have two different byte values in the array 
    // at indices [0] and [1]
    // 
    byte[] key = new byte[] {23,17,0,0,
                             0,0,0,0,
                             0,0,0,0,
                             0,0,0,0};
    // byte[] possible_keys = new byte[] { 0, 1, 2, 3, 4, 
    //                                     5, 6, 7, 8, 9, 
    //                                     10, 11, 12, 13, 14, 
    //                                     15, 16, 17, 18, 19, 
    //                                     20, 21, 22, 23, 24, 
    //                                     25, 26, 27, 28, 29, 30};
    // How I solved for the key
    // for( int i = 0; i < possible_keys.length; i++) {
    //   key[0] = possible_keys[i];
    //   for(int j = 0; j < i; j++){
    //     try{
    //     Cipher cipher = Cipher.getInstance("AES/ECB/ISO10126Padding");
    //     key[1] = possible_keys[j];
    //     cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
    //     byte[] plainText = cipher.doFinal(cipherText);  
    //     System.out.println(new String(plainText, StandardCharsets.UTF_8));
    //     System.out.print(i);
    //     System.out.print(j);
    //     } catch (BadPaddingException e) {
    //     }
    //   }
    // }
    // END SOLUTION
    // Solution after figuring out the key
    Cipher cipher = Cipher.getInstance("AES/ECB/ISO10126Padding");
    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
    byte[] plainText = cipher.doFinal(cipherText);  
    System.out.println(new String(plainText, StandardCharsets.UTF_8));
    
  }

  public static void main(String [] args) {
    try {  
       P1();
       P2();
       P3();
       P4();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
