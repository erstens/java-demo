package com.demo.swing;

public class ExampleData {
    public static final String DAO = "<h1>DAO可用变量</h1>\n" +
            "\n" +
            "<p>\n" +
            "    columns\n" +
            "</p>\n" +
            "    <%\n" +
            "    for(map in columns){\n" +
            "    %>\n" +
            "        <p>以下是数据库自动生成</p>\n" +
            "        name,${map.name}\n" +
            "        comment,${map.comment}\n" +
            "        isNullable,${map.isNullable}\n" +
            "        type,${map.type}\n" +
            "        key,${map.key}\n" +
            "\n" +
            "        <p>以下是在DemoDecorate定义</p>\n" +
            "        javaType,${map.javaType}\n" +
            "        javaField,${map.javaField}\n" +
            "    <%}%>" ;
    public static final String ENTITY = "<h1>ENTITY可用变量</h1>\n" +
            "\n" +
            "<p>\n" +
            "    columns\n" +
            "</p>\n" +
            "    <%\n" +
            "    for(map in columns){\n" +
            "    %>\n" +
            "        <p>以下是数据库自动生成</p>\n" +
            "        name,${map.name}\n" +
            "        comment,${map.comment}\n" +
            "        isNullable,${map.isNullable}\n" +
            "        type,${map.type}\n" +
            "        key,${map.key}\n" +
            "\n" +
            "        <p>以下是在DemoDecorate定义</p>\n" +
            "        javaType,${map.javaType}\n" +
            "        javaField,${map.javaField}\n" +
            "    <%}%>";

    public static final String USER_DIR = System.getProperty("user.home") ;
}
