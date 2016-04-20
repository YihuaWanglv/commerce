# commerce 开发计划与进度记录

## [todo]

接入邮件服务
公共业务：用户模块开发-用户注册登录
公共业务：商品模块开发-添加商品



## [done]
【2016.04.20】加入搜索功能
【2016.04.20】安装启动es
- 下载tar包，解压即可安装
-下载地址version1.5.2：https://download.elastic.co/elasticsearch/elasticsearch/elasticsearch-1.5.2.tar.gz
解压命令：tar xvf xxx.gz
- 创建elsearch用户组及elsearch用户
groupadd elsearch
useradd elsearch -g elsearch -p elasticsearch
- 更改elasticsearch文件夹及内部文件的所属用户及组为elsearch:elsearch
cd /opt
chown -R elsearch:elsearch  elasticsearch
- 切换到elsearch用户再启动
su elsearch cd elasticsearch/bin
./elasticsearch
【2016.04.19】使用redis message， 接入mq
【2016.04.18】把shiro做成公共模块，让所有web项目能简单接入
【2016.04.18】先用@Component的方式做到父模块，再去除@Component，使用springboot @bean的方式
【2016.04.15】- 实现web子域下的跨域单点登录
【2016.03.31】- 添加总体maven项目架构和soa项目群


