package com.yizhaoqi.smartpai.entity;

import lombok.Data;
import java.util.List;
import java.util.ArrayList; // 必须添加这个导入

@Data
public class SearchResult {
    private String fileMd5;
    private Integer chunkId;
    private String textContent;
    private Double score;
    private Integer rank;      // RRF 排名
    private List<String> sourceRoutes; // 来源路 (knn_route / text_route)
    private String fileName;
    private String userId;
    private String orgTag;
    private Boolean isPublic;

    // 构造函数 1: 适配最基础的 4 参数调用 (兼容旧方法)
    public SearchResult(String fileMd5, Integer chunkId, String textContent, Double score) {
        this.fileMd5 = fileMd5;
        this.chunkId = chunkId;
        this.textContent = textContent;
        this.score = score;
        this.sourceRoutes = new ArrayList<>(); // 解决 ArrayList 找不到符号的问题
    }

    // 构造函数 2: 适配权限过滤的 7 参数调用 (兼容 textOnlySearchWithPermission)
    public SearchResult(String fileMd5, Integer chunkId, String textContent, Double score, String userId, String orgTag, boolean isPublic) {
        this.fileMd5 = fileMd5;
        this.chunkId = chunkId;
        this.textContent = textContent;
        this.score = score;
        this.userId = userId;
        this.orgTag = orgTag;
        this.isPublic = isPublic;
        this.sourceRoutes = new ArrayList<>();
    }

    // 构造函数 3: 适配新的 RRF 调用 (主方法 searchWithPermission 使用)
    public SearchResult(String fileMd5, Integer chunkId, String textContent, Double score,
                        Integer rank, List<String> sourceRoutes, String userId,
                        String orgTag, Boolean isPublic, String fileName) {
        this.fileMd5 = fileMd5;
        this.chunkId = chunkId;
        this.textContent = textContent;
        this.score = score != null ? score : 0.0;
        this.rank = rank;
        this.sourceRoutes = sourceRoutes;
        this.userId = userId;
        this.orgTag = orgTag;
        this.isPublic = isPublic;
        this.fileName = fileName;
    }

    public String getSourceLabel() {
        if (sourceRoutes == null || sourceRoutes.isEmpty()) return "匹配";
        boolean hasKnn = sourceRoutes.contains("knn_route");
        boolean hasText = sourceRoutes.contains("text_route");
        if (hasKnn && hasText) return "双重精准匹配";
        if (hasKnn) return "AI 语义发现";
        return "关键词匹配";
    }
}