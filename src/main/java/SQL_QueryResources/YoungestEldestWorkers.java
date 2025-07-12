package SQL_QueryResources;

import java.sql.Date;

public class YoungestEldestWorkers {
    private String name;
    private Date birthday;

    public YoungestEldestWorkers(Date birthday, String name) {
        this.birthday = birthday;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Youngest Eldest Workers {Name = " + name + ", birthday = " + birthday + '}';
    }
}
