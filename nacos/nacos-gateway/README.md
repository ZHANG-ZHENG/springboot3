nacos-gateway

灰度发布的实现
1、首先编写自己的Predicate，实现指定用户匹配到指定的路由规则中；
2、动态修改请求，添加版本号信息，版本号信息可以放在HTTP Header中（此处可以通过原生AddRequestHeaderGatewayFilterFactory来实现，无需自己写代码）；
3、重写负载均衡算法，根据版本号信息从注册中心的服务实例上选择相应的服务版本进行请求的转发。
