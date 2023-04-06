package org.wzy.sqltemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 带标签sql处理为可执行sql
 */
public class SqlTemplateUtils {

    public static String sqlHandler(String sql, Object data) {
        Configuration configuration = new Configuration();

        SqlTemplate template = configuration
                .getTemplate(sql);
        return template.buildSql(data);
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap();
        map.put("userName", "ad");
        String sql = sqlHandler("select * from sys_user where 1=1 <if test=\"userName != null and userName != ''\">and user_name = '${userName}'</if>", map);
        System.out.println(sql);
    }

}