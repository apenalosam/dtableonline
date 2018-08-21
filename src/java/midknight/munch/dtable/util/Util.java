/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midknight.munch.dtable.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author KODE
 */
public class Util {
    
    private static final Charset CHARSET = Charset.forName("UTF-8");
    
    public static String getStringValue(Object o) {
        if (o == null) {
            return "";
        }
        return (String) o;
    }

    public static Integer getIntegerValue(Object o) {
        if (o == null) {
            return 0;
        }
        return (Integer) o;
    }

    public static String getString(Object o) {
        if (o == null) {
            return "";
        }
        return String.valueOf(o);
    }
    
    public static String decode(String cadena) {
        try {
            byte[] bytes = cadena.getBytes("ISO-8859-1");
            return CHARSET.newDecoder().decode(ByteBuffer.wrap(bytes)).toString();
        } catch (CharacterCodingException e) {
            throw new IllegalArgumentException("Fallo al decodificar", e);
        } catch (UnsupportedEncodingException ex) {
            throw new IllegalArgumentException("Codificacion no soportada", ex);
        }
    }
    
    public static List<String> stringToList (String cadena){
        List<String> lista = new ArrayList<>();
        try{
            String[] data = cadena.split("@");
            lista.addAll(Arrays.asList(data));
        }
        catch(Exception e){
            lista = null;
        }
        return lista;
    }
    
    public static String listToString (List<String> lista){
        StringBuilder cadena = new StringBuilder("");
        String result;
        try{
            lista.stream().map((elemento) -> {
                cadena.append(elemento);
                return elemento;
            }).forEach((_item) -> {
                cadena.append("@");
            });
            result = cadena.toString();
            result = result.substring(0, result.length()-1);
        }
        catch(Exception e){
            result = null;
        }
        return result;
    }
    
    public static Calendar getCalendarFecha(String f) {
        Calendar fecha = Calendar.getInstance();
        if (f == null) {
            return fecha;
        }
        String[] v = f.split("/");
        fecha.set(Integer.parseInt(v[2]), (Integer.parseInt(v[1]) - 1), Integer.parseInt(v[0]));
        return fecha;
    }
    
//    public static List<String> updateLists (List<String> oldList, List<String> newList){
//        List<String> result = null;
//        List<String> tmp;
//        try{
//            tmp = oldList;
//            newList.forEach(tmp::remove);
//        }
//        catch(Exception e){
//            tmp = new ArrayList<>();
//        }
//        if(!tmp.isEmpty()){
//            
//        }
//        return result;
//    }
}
