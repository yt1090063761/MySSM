package cn.ssm.po;

import java.util.Date;

public class Users {
    private Integer id;

    private String name;

    private Integer age;

    private Date brdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBrdate() {
        return brdate;
    }

    public void setBrdate(Date brdate) {
        this.brdate = brdate;
    }
}