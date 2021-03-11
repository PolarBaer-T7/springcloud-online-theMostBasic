package cn.kgc.zhengzeyan.mapper;

import cn.kgc.zhengzeyan.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    boolean addDept(Dept dept);

    Dept queryDeptById(Long deptNo);

    List<Dept> queryAllDept();
}
