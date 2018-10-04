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
<<<<<<< HEAD
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
    // END SOLUTION
=======
  
  // static void P1() throws Exception {
  //   byte[] cipherText = Files.readAllBytes(Paths.get("cipher1.txt"));
    
  //   // BEGIN SOLUTION
  //   byte[] iv = new byte[] { 0, 0, 0, 0, 
  //                            0, 0, 0, 0, 
  //                            0, 0, 0, 0, 
  //                            0, 0, 0, 0 };
  //   byte[] key;
  //   byte[] plainText = cipherText;    
  //   // END SOLUTION
>>>>>>> prob_2
    
  //   System.out.println(new String(plainText, StandardCharsets.UTF_8));
  // }

<<<<<<< HEAD
  // static void P2() throws Exception {    
  //   // BEGIN SOLUTION
  //   for (int i = 0; i < 1; i++) {
  //     byte[] message = Files.readAllBytes(Paths.get(String.format("messages/plain2%d.txt", i)));
  //   }
  //   // END SOLUTION
  // }
=======
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
>>>>>>> prob_2

  // static void P3() throws Exception {
  //   byte[] cipherText = Files.readAllBytes(Paths.get("cipher3.txt"));
    
  //   // BEGIN SOLUTION
  //   byte[] plainText = cipherText;    
  //   // END SOLUTION
    
  //   System.out.println(new String(plainText, StandardCharsets.UTF_8));
  // }

  // static void P4() throws Exception {
  //   byte[] iv = new byte[] { 0, 0, 0, 0, 
  //                            0, 0, 0, 0, 
  //                            0, 0, 0, 0, 
  //                            0, 0, 0, 0 };
  //   byte[] cipherText = Files.readAllBytes(Paths.get("cipher4.txt"));
    
  //   // BEGIN SOLUTION
  //   byte[] plainText = cipherText;    
  //   // END SOLUTION
    
  //   System.out.println(new String(plainText, StandardCharsets.UTF_8));
  // }

  public static void main(String [] args) {
    try {  
<<<<<<< HEAD
      P1();
      // P2();
=======
      //P1();
       P2();
>>>>>>> prob_2
      // P3();
      // P4();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
