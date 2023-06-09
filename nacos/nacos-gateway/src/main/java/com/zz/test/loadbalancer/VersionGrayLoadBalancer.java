package com.zz.test.loadbalancer;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.reactive.DefaultResponse;
//import org.springframework.cloud.client.loadbalancer.reactive.EmptyResponse;
//import org.springframework.cloud.client.loadbalancer.reactive.Request;
//import org.springframework.cloud.client.loadbalancer.reactive.Response;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.NoopServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author zz
 * @date 2023-04-03
 */
public class VersionGrayLoadBalancer implements ReactorServiceInstanceLoadBalancer {

    private ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;
    private String serviceId;
    private final AtomicInteger position;


    public VersionGrayLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider, String serviceId) {
        this(serviceInstanceListSupplierProvider, serviceId, new Random().nextInt(1000));
    }

    public VersionGrayLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider, String serviceId, int seedPosition) {
        this.serviceId = serviceId;
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierProvider;
        this.position = new AtomicInteger(seedPosition);
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        HttpHeaders headers = (HttpHeaders) request.getContext();
        ServiceInstanceListSupplier supplier = this.serviceInstanceListSupplierProvider.getIfAvailable(NoopServiceInstanceListSupplier::new);
        //提供服务列表的Supplier
        return ((Flux) supplier.get()).next().map(list -> processInstanceResponse((List<ServiceInstance>) list, headers));
    }

    private Response<ServiceInstance> processInstanceResponse(List<ServiceInstance> serviceInstanceList, HttpHeaders headers) {
        if (serviceInstanceList.isEmpty()) {
            return new EmptyResponse();
        }
        String reqVersion = headers.getFirst("version");
        if (reqVersion==null || "".equals(reqVersion)) {
            return processRibbonInstanceResponse(serviceInstanceList);
        }
        for(ServiceInstance serviceInstance : serviceInstanceList) {
        	System.out.println("serviceInstance version="+serviceInstance.getMetadata().get("gray-version"));
        }
        List<ServiceInstance> serviceInstances = serviceInstanceList.stream()
                .filter(instance -> reqVersion.equals(instance.getMetadata().get("gray-version")))
                .collect(Collectors.toList());
        if (serviceInstances.size() > 0) {
            return processRibbonInstanceResponse(serviceInstances);
        }
        return processRibbonInstanceResponse(serviceInstanceList);
    }

    /**
     * 负载均衡器
     * 参考 org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer#getInstanceResponse
     *
     */
    private Response<ServiceInstance> processRibbonInstanceResponse(List<ServiceInstance> instances) {
        int pos = Math.abs(this.position.incrementAndGet());
        ServiceInstance instance = instances.get(pos % instances.size());
        return new DefaultResponse(instance);
    }
}