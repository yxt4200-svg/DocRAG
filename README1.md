# SmartPai 后续快速运行指南
## 前提
- 打开 Docker Desktop；

## 一、后端
1. 打开ubuntu；
2. 执行命令：
```bash
cd /mnt/d/Develop/DocRAG/docs
docker-compose -f docker-compose.yaml up -d
```

## 二、前端
1. 打开VS Code，打开前端项目文件夹；
2. 打开VS Code终端，执行命令：
```bash
npm run dev  
```
启动后访问：`http://localhost:9527/#/login`。
