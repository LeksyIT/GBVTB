package hw9.tableCreater;

import hw9.TestTable;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
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
    static {
        classToString.put(int.class, "INTEGER");
        classToString.put(long.class, "BIGINT");
        classToString.put(double.class, "REAL");
        classToString.put(float.class, "REAL");
        classToString.put(String.class, "TEXT");
        classToString.put(char.class, "CHARACTER");
    }

    public static void createTable(Object obj) {
        getAnnotations(obj);
        try {
            Statement createStatement = connection.createStatement();
            StringBuilder sqlRequest = new StringBuilder();
            sqlRequest.append("CREATE TABLE " + tableName + " (");

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
    private static void getAnnotations(Object obj){
        Class objClass = obj.getClass();

        Table annotationTable = (Table) objClass.getAnnotation(Table.class);
        tableName = annotationTable.title();

        Field[] fields = objClass.getDeclaredFields();
        Field[] array = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .toArray(Field[]::new);
        for (Field field:array) {
            fieldArray.add(field);
        }
    }
    public static void appendToTable(Object obj) {
        getAnnotations(obj);
        try {
            Statement createStatement = connection.createStatement();
            StringBuilder sqlRequest = new StringBuilder();
            sqlRequest.append("CREATE TABLE " + tableName + " (");

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
            createStatement.executeUpdate(sqlRequest.toString());
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static String getStingFields1(Class<? extends TestTable> cS) {
        StringBuilder str = new StringBuilder();
        Field[] classFields = cS.getDeclaredFields();
        for (Field field : classFields) {
            str.append(field.getName())
                    .append(", ");
        }

        if (str.charAt(str.length() - 2) == ',') {
            str.deleteCharAt(str.length() - 2);
            str.deleteCharAt(str.length() - 1);
        }

        return " (" + str + ")";
    }

    private static String getStingFields2(Object cS) {
        StringBuilder str = new StringBuilder();
        Field[] classFields = cS.getClass().getDeclaredFields();
        for (Field field : classFields) {
            try {
                field.setAccessible(true);
                Object kekw = field.get(cS);
                str.append(" '")
                        .append(field.get(cS))
                        .append("'")
                        .append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if (str.charAt(str.length() - 1) == ',') {
            str.deleteCharAt(str.length() - 1);
        }

        return " (" + str + ")";
    }
}
