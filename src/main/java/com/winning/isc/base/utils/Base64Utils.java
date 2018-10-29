package com.winning.isc.base.utils;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/**
 * 编码
 *
 * @author ChenKuai
 * @create 2018-03-01 下午 6:36
 **/
public class Base64Utils {

    public static void main(String[] args) throws Exception {
        String blnr=
                "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";
        String decodeBlnr = unzipEmrXml(blnr);
        System.out.println(decodeBlnr);

    }

    /**
     * 解压解密EMR病历内容
     * @param emrContent
     * @return
     */
    public static String unzipEmrXml(String emrContent) throws IOException {
        if (emrContent.indexOf("winningemr") == 0 && emrContent.lastIndexOf("winningemr") == (emrContent.length() - 10))
            emrContent = emrContent.substring(10, emrContent.length() - 20 - 1);
        byte[] arr = Base64.decodeBase64(emrContent);
        ByteArrayInputStream ms = new ByteArrayInputStream(arr);
        InflaterInputStream inflater = new InflaterInputStream(ms, new Inflater(true));
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        int len = 0;
        byte[] part = new byte[1024];
        try {
            while (true) {
                len = inflater.read(part);
                if (len == -1) break;
                os.write(part, 0, len);
            }
            inflater.close();
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(os != null){
                os.close();
            }
        }
        Charset charset = Charset.forName("utf-8");
        return new String(os.toByteArray(), charset);
    }

    /**
     * BASE64解密
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

}