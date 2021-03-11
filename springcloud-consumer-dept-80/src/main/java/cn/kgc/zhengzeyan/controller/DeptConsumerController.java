package cn.kgc.zhengzeyan.controller;


import cn.kgc.zhengzeyan.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class DeptConsumerController {

    /*
     * 消费者不应该有Services层
     * spring支持RestFul风格，很多东西在spring中都有对应的XXXTemplate模板，
     * 里面有很多方法供我们直接调用，如果要使用方法必须把这些Template注册到Spring中
     * 这里需要我们手动配置了——>ConfigBean
     */

    @Autowired
    private RestTemplate restTemplate;
    /*
    现在就可以注入使用它了
    restTemplate里有一个核心的方法，有三个参数，(String url,请求（实体）,Class<T> responseType)
    一个是响应类型，一个是地址，中间需要一个请求，就是一个实体，实体一般用Map来实现
     */

    /*
    由于没有Service层，所以我们请求需要到刚才的URL上去，请求的的前缀都是固定的，所以我们需要一个常量来写死
     */
    /*
     * private static final String REST_URL_PREFIX ="http://localhost:8001";
     * Ribbon 我们这里的地址应该是一个变量 通过服务名来访问。
     */
    private static final String REST_URL_PREFIX = "localhost:8001";
    // private static final String REST_URL_PREFIX = "localhost:8001";


    @RequestMapping("/consumer/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }


    @RequestMapping("/consumer/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }


    @RequestMapping("/consumer/list")
    public List<Dept> getAll() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    /*
     什么是restTemplate?
     提供多种便捷访问远程HTTP服务的访问的一些方法
     它是一种简单的RestFul服务模板
     */

}
