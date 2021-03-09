package cn.kgc.zhengzeyan.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
    //Dept 实体类 ORM 对象关系映射 mysql--dept类 类表关系映射
    private Long deptNo;
    private String dname;


    //这个数据是存在哪个数据库的字段 微服务——一个服务对应一个数据库，同一个信息，可能存在不同的数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
    /*
    链式写法
    Dept dept = new Dept();
    dept.setDeptNo(20).setDname('刘宇');
     */
}
