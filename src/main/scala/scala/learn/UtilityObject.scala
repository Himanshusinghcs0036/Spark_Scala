
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

import scala.io.Source

import org.apache.commons.codec.binary.Base64

//This Object contains util methods

object UtilityObject {
  def main(args: Array[String]): Unit = {
	  //ToDo
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
	
    def getDecryptedPassword(key: String):String={
      var encryptedPass=Source.fromURL(getClass.getResource("/conf.properties")).getLines().find(_.startsWith(key)).get.split("=")(1)
   }
	
}



