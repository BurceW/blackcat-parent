package cn.itsource.blackcat.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页数据类
 */
public class PageList<T> {

    private Long total;
    private List<T> rows = new ArrayList<T>();

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    public PageList() {
    }

    public PageList(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

}
