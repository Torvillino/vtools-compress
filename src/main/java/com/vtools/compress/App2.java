package com.vtools.compress;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class App2 {

	public static void main(String[] args) throws Exception {
//        String string = "I am what I am hhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
//                + "bjggujhhhhhhhhh"
//                + "rggggggggggggggggggggggggg"
//                + "esfffffffffffffffffffffffffffffff"
//                + "esffffffffffffffffffffffffffffffff"
//                + "esfekfgy enter code here`etd`enter code here wdd"
//                + "heljwidgutwdbwdq8d"
//                + "skdfgysrdsdnjsvfyekbdsgcu"
//                +"jbujsbjvugsduddbdj";
        String string = "{'CDF_userNatal':'21/06/2016','CDF_codActivation':'d17f25ecfbcc7857f7bebea469308be0b2580943e96d13a3ad98a13675c4bfc2'}";
        System.out.println("Comprimido:");
        byte[] compressed = compress(string);
        System.out.println(compressed);
        //System.out.println(new String(compressed));
        System.out.println("-----------------------------");
        System.out.println("Descomprimido:");
        String decomp = decompress(compressed);
        System.out.println(decomp);
    }


     public static byte[] compress(String str) throws Exception {
        
        System.out.println("String length : " + str.length());
        ByteArrayOutputStream obj=new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(obj);
        gzip.write(str.getBytes("UTF-8"));
        gzip.close();
        String outStr = obj.toString("UTF-8");
        System.out.println("Output String length : " + outStr.length());
        
        return obj.toByteArray();
     }

      public static String decompress(byte[] bytes) throws Exception {
        
        System.out.println("Input String length : " + new String(bytes).length());
        //System.out.println("Input String length : " + bytes.length);
        GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(bytes));
        BufferedReader bf = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
        String outStr = "";
        String line;
        while ((line=bf.readLine())!=null) {
          outStr += line;
        }
        System.out.println("Output String lenght : " + outStr.length());
        return outStr;
     }

}
