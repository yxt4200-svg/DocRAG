# SmartPai 运行指南
## 前提
- 停止本地 MySQL80 的服务；
- 确保 3306 端口未被其他程序占用；
```bash
netstat -ano | findstr :3306
taskkill /F /PID XXXX
```
- 打开 Docker Desktop 并确保状态为绿色。

## 一、中间件
1. 打开ubuntu执行命令。
```bash
cd /mnt/d/Develop/DocRAG/docs
docker-compose up -d
docker ps
```

## 二、后端
1. 运行 `SmartPaiApplication`；
2. 看到 `Started SmartPaiApplication in X seconds` 且无报错。


## 三、前端
1. VS Code 打开前端项目文件夹 D:\Develop\DocRAG\frontend； 
2. 打开终端，执行命令：
```bash
pnpm dev  
```
3. 访问：`http://localhost:9527`。
