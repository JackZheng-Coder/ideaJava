package com.Java核心技术;

import javax.crypto.Cipher;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class Util {
    /**
     * Use a cipher to transform the bytes in an input stream and sends the transformed bytes to an output stream
     *
     */

    public static void crypt(InputStream in, OutputStream out, Cipher cipher) throws Exception{
        int blockSize = cipher.getBlockSize();
        int outputSize = cipher.getOutputSize(blockSize);
        byte[] inBytes = new byte[blockSize];
        byte[] outBytes = new byte[outputSize];

        int inLength = 0;
        boolean more = true;
        while (more){
            inLength = in.read(inBytes);
            if (inLength == blockSize){
                int outLength = cipher.update(inBytes,0,blockSize,outBytes);
                out.write(outBytes,0,outLength);
            }
            else more = false;
        }
        if (inLength > 0) outBytes = cipher.doFinal(inBytes,0,inLength);
        else outBytes = cipher.doFinal();
        out.write(outBytes);
    }
}
