package com.provider;

import com.consumers.Search;

import java.util.List;

public class FileSearch2 implements Search {
    @Override
    public List<String> searchDoc(String keyword) {
        System.out.println("文件搜索2 "+keyword);
        return null;
    }
}