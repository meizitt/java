package pers.c.domain;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
    private int currentPage;
    private int currentCount;
    private int totalCount;
    private int totalPage;
    private List<Record> recordList = new ArrayList<>();

    public PageBean() {}

    public PageBean(int currentPage, int currentCount, int totalCount, int totalPage, List<Record> recordList) {
        this.currentPage = currentPage;
        this.currentCount = currentCount;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.recordList = recordList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }
}
