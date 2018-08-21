package midknight.munch.dtable.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KODE
 */
public class CharacterUtil {
    
    
    public static List<Object> getCharacter(List<Object[]> datos) {
        List<Object> lista = new ArrayList<>();
        List<Object> data;        
        StringBuilder c;        
        for (Object[] d : datos) {
            data = new ArrayList<>();
            data.add(d[0]);
            data.add(d[1]);
            data.add(d[2]);
            data.add(d[3]);
            data.add(d[4]);
            data.add(d[5]);
            c = new StringBuilder("<td><div class=\"text-center\">");
            c.append("<a href=\"javascript:void(0);\" ");
            c.append("onclick=\"loadSheet(").append(d[5]).append(");\" ");
            //c.append("class=\"btn btn-primary\" >");
            c.append("class=\"btn btn-success \" >");
            c.append("<i class=\"fa fa-check ");
            c.append("load").append(d[5]).append("\" aria-hidden=\"true\"></i> </a>");
            c.append("</td></div>");
            data.add(c);
            lista.add(data);
        }
        lista.stream().forEach((o) -> {
            System.out.println(o.toString());
        });
        return lista;
    }
    
    public static String searchRegistry(String query){
        if(query.equals("")){
            return "";
        }
        String[] fields = {"c.character_name", "camp.campaign_name"};
        int index = 0;
        StringBuilder sql = new StringBuilder(" AND (");
        for (String f : fields) {
            index++;
            sql.append(f).append(" LIKE '%").append(query).append("%'");
            if (index < fields.length) {
                sql.append(" OR ");
            }
        }
        sql.append("))");
        return sql.toString();
    }
}
