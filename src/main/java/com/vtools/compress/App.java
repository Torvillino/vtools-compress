package com.vtools.compress;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.apache.commons.codec.binary.Base64;

/**  */
public class App {
	
	public static void main(String[] args) throws UnsupportedEncodingException, DataFormatException {
        App m = new App();
        //String strToBeCompressed  = "{'CDF_userNatal':'17/03/1987','CDF_codActivation':'d17f25ecfbcc7857f7bebea469308be0b2580943e96d13a3ad98a13675c4bfc2'}";
        String strToBeCompressed  = "111111222alfredo";
        String compressedData  = m.compress(strToBeCompressed);
        String deCompressedString = m.decompressToString(compressedData);

        System.out.println("Original     :: " + strToBeCompressed.length() + " " + strToBeCompressed);
        System.out.println("Compressed   :: " + compressedData.toString().length() + " " +compressedData.toString());
        System.out.println("decompressed :: " + deCompressedString.length() + " " + deCompressedString);
        System.out.println("Base64 :: " + strToBeCompressed.getBytes("UTF-8").length + " " + strToBeCompressed.getBytes("UTF-8"));
    }
	
	private String compress(String stringToCompress) throws UnsupportedEncodingException{
        byte[] compressedData = new byte[1024];
        byte[] stringAsBytes = stringToCompress.getBytes("UTF-8");

        Deflater compressor = new Deflater();
        compressor.setInput(stringAsBytes);
        compressor.finish();
        int compressedDataLength = compressor.deflate(compressedData);

        byte[] bytes = Arrays.copyOf(compressedData, compressedDataLength);
        return Base64.encodeBase64String(bytes);
    }

	private String decompressToString(String base64String) throws UnsupportedEncodingException, DataFormatException {
        byte[] compressedData = Base64.decodeBase64(base64String);

        Inflater deCompressor = new Inflater();
        deCompressor.setInput(compressedData, 0, compressedData.length);
        byte[] output = new byte[1024];
        int decompressedDataLength = deCompressor.inflate(output);
        deCompressor.end();

        return new String(output, 0, decompressedDataLength, "UTF-8");
    }
}
