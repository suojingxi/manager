package com.sonymm.manager.core.page;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/15 14:05
 */
public class Page {

    public static final String KEY_PAGE = "page.pageNo";
    public static final String KEY_PAGESIZE = "page.pageSize";

    public static int MAX_RECORDS = 1000000;//100W
    public static int DEFAULT_PAGESIZE = 10;

    private int resultCount;//总记录数，可写
    private int pageSize;//每页记录数，初始化时传入
    private int pageCount;//总页数
    private int pageNo;//当前页码，初始化时传入
    private int firstIndex;//当前页的第一条记录在所有记录中的位置
    private int lastIndex;//当前页的最后一条记录在所有记录中的位置
    private boolean firstPage;//当前页是否是第一页
    private boolean lastPage;//当前页是否是最后一页

    public Page(){
        this(1,DEFAULT_PAGESIZE);
        this.onResultCountChanged();
    }

    public Page(int pageNo, int pageSize){
        this.onResultCountChanged();
        this.pageNo = (pageNo < 1) ? 1 : pageNo;
        this.pageSize = (pageSize < 1 || pageSize > MAX_RECORDS) ? DEFAULT_PAGESIZE : pageSize;
    }

    private void onResultCountChanged(){
        //计算总页数
        if(resultCount > 0){
            if(resultCount % pageSize == 0){
                pageCount = resultCount / pageSize;
            }else{
                pageCount = resultCount / pageSize + 1;
            }
        }
        pageCount = (pageCount <= 0) ? 1 : pageCount;
        //调整当前页码
        pageNo = (pageNo > pageCount) ? pageCount : pageNo;
        //计算当前页的第一条记录在所有记录中的位置
        firstIndex = (pageNo - 1) * pageSize;
        lastIndex = pageNo * pageSize;
        firstPage = (pageNo == 1);
        lastPage = (pageNo == pageCount);
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
        onResultCountChanged();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if(pageSize < 1 || pageSize > MAX_RECORDS){
            return;
        }
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public static void setMaxRecords(int maxRecords) {
        MAX_RECORDS = maxRecords;
    }

    public static void setDefaultPagesize(int defaultPagesize) {
        DEFAULT_PAGESIZE = defaultPagesize;
    }
}
