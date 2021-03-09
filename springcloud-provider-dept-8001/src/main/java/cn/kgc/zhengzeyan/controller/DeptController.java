package cn.kgc.zhengzeyan.controller;

import cn.kgc.zhengzeyan.pojo.Dept;
import cn.kgc.zhengzeyan.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//提供RestFul服务！
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    // 这种写法不正确，只是为了演示,这样可以快速的获取一些配置的信息，得到具体的微服务
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{deptNo}")
    public Dept getDeptById(@PathVariable("deptNo") Long deptNo) {
        return deptService.getDeptById(deptNo);
    }


    @GetMapping("/dept/list")
    public List<Dept> getAllDept() {
        return deptService.getAllDept();
    }

    //注册进来的微服务通过服务发现可以获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表清单
        List<String> services = discoveryClient.getServices();
        System.out.println("discovery==>service:"+services);

        //得到一个具体的微服务信息，通过具体的微服务ID，即applicationName获取
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\n"+
                    instance.getPort()+"\n"+
                    instance.getUri()+"\n"+
                    instance.getInstanceId()
            );
        }
        return this.discoveryClient;
    }


}
