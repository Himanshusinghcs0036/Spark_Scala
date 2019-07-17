
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

import org.apache.commons.codec.binary.Base64

object EncryptStr {
  def main(args: Array[String]): Unit = {

    if (args.length != 2) {
      println("Please Enter 16 digit Key & Password to Encrypt:")
    }  else {
      val key: Array[Byte] = args(0).getBytes()
      println(s" [KEY]--> ${args(0)} \n [ENCRYPTED PASSWORD]--> ${encrypt(key, args(1))}")
    }

    def encrypt(key: Array[Byte], value: String): String = {
      val cipher: Cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
      val secretKeySpec = new SecretKeySpec(key, "AES")
      cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec)
      Base64.encodeBase64String(cipher.doFinal(value.getBytes("UTF-8")))
    }

	  def decrypt(key: Array[Byte], encryptedValue: String): String = {
      val cipher: Cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING")
      val secretKeySpec = new SecretKeySpec(key, "AES")
      cipher.init(Cipher.DECRYPT_MODE, secretKeySpec)
      new String(cipher.doFinal(Base64.decodeBase64(encryptedValue)))
    }
  }


}
