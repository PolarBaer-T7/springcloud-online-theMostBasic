package cn.kgc.zhengzeyan.service;

import cn.kgc.zhengzeyan.pojo.Dept;

import java.util.List;

public interface DeptService {


    boolean addDept(Dept dept);

    Dept getDeptById(Long deptNo);

    List<Dept> getAllDept();

}
