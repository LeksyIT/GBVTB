package hw9.tableCreater;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WorkWithTable {
    private static HashMap<Class, String> classToString = new HashMap<>();
    private static Connection connection = DBConfig.getConnection();
    private static ArrayList<Field> fieldArray = new ArrayList<>();
    private static String tableName;
    private static Boolean checker = true;

    static {
        classToString.put(int.class, "INTEGER");
        classToString.put(long.class, "BIGINT");
        classToString.put(double.class, "REAL");
        classToString.put(float.class, "REAL");
        classToString.put(String.class, "TEXT");
        classToString.put(char.class, "CHARACTER");
    }

    public static void createTable(Object obj) {
        if (Boolean.TRUE.equals(checker)) getAnnotations(obj);
        try {
            Statement createStatement = connection.createStatement();
            StringBuilder sqlRequest = new StringBuilder();
            sqlRequest.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (");

            for (Field field : fieldArray) {
                sqlRequest.append(field.getName())
                        .append(" ")
                        .append(classToString.get(field.getType()))
                        .append(",");
            }

            if (sqlRequest.charAt(sqlRequest.length() - 1) == ',') {
                sqlRequest.deleteCharAt(sqlRequest.length() - 1);
            }

            sqlRequest.append(");");
            System.out.println(sqlRequest);
            createStatement.executeUpdate(sqlRequest.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void getAnnotations(Object obj) {
        Class objClass = obj.getClass();

        Table annotationTable = (Table) objClass.getAnnotation(Table.class);
        tableName = annotationTable.title();

        Field[] fields = objClass.getDeclaredFields();
        Field[] array = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .toArray(Field[]::new);
        fieldArray.addAll(Arrays.asList(array));
        checker = false;
    }

    public static void appendToTable(Object obj) {
        if (Boolean.TRUE.equals(checker)) getAnnotations(obj);
        try {
            Statement createStatement = connection.createStatement();
            StringBuilder sqlRequest = new StringBuilder();
            sqlRequest.append("INSERT INTO ").append(tableName).append("(");

            for (Field field : fieldArray) {
                field.setAccessible(true);
                sqlRequest.append(field.getName()).append(" ,");
            }

            if (sqlRequest.charAt(sqlRequest.length() - 1) == ',') {
                sqlRequest.deleteCharAt(sqlRequest.length() - 1);
            }

            sqlRequest.append(")\nVALUES (");

            for (Field field : fieldArray) {
                field.setAccessible(true);
                sqlRequest.append(" '")
                        .append(field.get(obj).toString())
                        .append("',");
            }

            if (sqlRequest.charAt(sqlRequest.length() - 1) == ',') {
                sqlRequest.deleteCharAt(sqlRequest.length() - 1);
            }
            sqlRequest.append(");");
            System.out.println(sqlRequest.toString());
            createStatement.executeUpdate(sqlRequest.toString());
        } catch (SQLException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }
}
