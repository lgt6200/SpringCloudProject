package cn.enjoy.controller;

import cn.enjoy.service.IProductClientService;
import cn.enjoy.vo.Product;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {


    @Resource
    private LoadBalancerClient loadBalancerClient;//消费方获取服务信息方式
    @Resource
    private IProductClientService iProductClientService;
    @RequestMapping("/product/get")
    public Object getProduct(long id) {
        return  iProductClientService.getProduct(id);
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
        return iProductClientService.listProduct();
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        return  iProductClientService.addPorduct(product);
    }
}
