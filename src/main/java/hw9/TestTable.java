package hw9;

import hw9.tableCreater.Column;
import hw9.tableCreater.Table;

@Table(title = "human")
public class TestTable {
    @Column(columnName = "name")
    private String name;

    @Column(columnName = "age")
    private int age;

    @Column(columnName = "color")
    private String color;

    public TestTable(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }


}
