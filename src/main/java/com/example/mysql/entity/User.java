/**
 * MySQL中User的实体
 * 实体中不映射成列的字段需要加@Transient注解，不加注解也会被映射成列
 */
package com.example.mysql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable {
    // 实体类继承Serializable，需要有一个serialVersionUID
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="classid")
    private int classid;
    @Column(name="grade")
    private int grade;

    public int getId(){
        return id;
    }
    public void setId(int id){ this.id = id; }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getClassid(){ return classid; }
    public void setClassid(int classid){
        this.classid = classid;
    }

    public int getGrade(){
        return grade;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }
}
