package com.qfedu.utils;

public class PageUtil {
    private int pageSize;//每页显示的数据
    private int pageCount;//总页数
    private int dataCount;//总条数
    private int pageNo;//当前页码

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        if(dataCount % pageSize == 0) {
            pageCount = dataCount / pageSize;

        } else {
            pageCount = dataCount / pageSize+1;
        }
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
