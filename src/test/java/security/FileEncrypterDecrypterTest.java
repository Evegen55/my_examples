package security;

import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FileEncrypterDecrypterTest {

    @Test
    public void whenEncryptingIntoFile_andDecryptingFileAgain_thenOriginalStringIsReturned()
            throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        String originalContent = "foobar";
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

        FileEncrypterDecrypter fileEncrypterDecrypter
                = new FileEncrypterDecrypter(secretKey, "AES/CBC/PKCS5Padding");

        fileEncrypterDecrypter.encrypt(originalContent, "baz.enc");

        String decryptedContent = fileEncrypterDecrypter.decrypt("baz.enc");
        assertThat(decryptedContent, is(originalContent));

        new File("baz.enc").delete(); // cleanup
    }

}