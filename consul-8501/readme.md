# consul简介
consul是一个可以提供服务发现，健康检查，多数据中心，Key/Value存储等功能的分布式服务框架，用于实现分布式系统的服务发现与配置。与其他分布式服务注册与发现的方案，使用起来也较为简单。Consul用Golang实现，因此具有天然可移植性(支持Linux、Windows和Mac OS X)；安装包仅包含一个可执行文件，方便部署。
# consul安装与启动
1. 下载consul  https://www.consul.io/downloads
2. 直接解压到安装目录(尽量解压到全英文名字的目录)
3. 用cmd命令行进入到consul安装目录输入consul agent -dev打开consul
4. 访问consul的web服务端口 http://localhost:8500 ,默认端口是8500
# consul zookeeper eureka 区别
1. cap原理，这三个要素最多只能同时实现两点，不可能三者兼顾。
    * 一致性（Consistency）: 在分布式系统中的所有数据备份，在同一时刻是否同样的值。（等同于所有节点访问同一份最新的数据副本）
    * 可用性（Availability）：在集群中一部分节点故障后，集群整体是否还能响应客户端的读写请求。（对数据更新具备高可用性）
    * 分区容错性（Partition tolerance）：就是高可用性，一个节点崩了，并不影响其它的节点（100个节点，挂了几个，不影响服务，越多机器越好）
 
 2. Eureka特点 AP
    * Eureka中没有使用任何的数据强一致性算法保证不同集群间的Server的数据一致，仅通过数据拷贝的方式争取注册中心数据的最终一致性，虽然放弃数据强一致性但是换来了Server的可用性，降低了注册的代价，提高了集群运行的健壮性
    
 3. Consul特点  CP
    *  基于Raft算法，Consul提供强一致性的注册中心服务，但是由于Leader节点承担了所有的处理工作，势必加大了注册和发现的代价，降低了服务的可用性。通过Gossip协议，Consul可以很好地监控Consul集群的运行，同时可以方便通知各类事件，如Leader选择发生、Server地址变更
 
 4. zookeeper特点 CP
    * 基于Zab协议，Zookeeper可以用于构建具备数据强一致性的服务注册与发现中心，而与此相对地牺牲了服务的可用性和提高了注册需要的时间。