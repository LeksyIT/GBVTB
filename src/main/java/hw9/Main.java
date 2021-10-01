package hw9;

import hw9.tableCreater.WorkWithTable;

public class Main {
    public static void main(String[] args) {
        TestTable t1 = new TestTable("Илья",23,"red");
        WorkWithTable.createTable(t1);
    }
}
