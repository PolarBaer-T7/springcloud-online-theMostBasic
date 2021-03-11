package cn.kgc.zhengzeyan.service;

import cn.kgc.zhengzeyan.mapper.DeptMapper;
import cn.kgc.zhengzeyan.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptmapper;

    @Override
    public boolean addDept(Dept dept) {
        return deptmapper.addDept(dept);
    }

    @Override
    public Dept getDeptById(Long deptNo) {
        return deptmapper.queryDeptById(deptNo);
    }

    @Override
    public List<Dept> getAllDept() {
        return deptmapper.queryAllDept();
    }
}
