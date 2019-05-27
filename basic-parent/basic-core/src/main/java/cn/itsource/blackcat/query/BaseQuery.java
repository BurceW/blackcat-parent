package cn.itsource.blackcat.query;

/**
 * @author wgb
 * @version V1.0
 * @className BaseQuery
 * @description 带条件的分页查询
 * @date 2019/5/16 0016
 */
public class BaseQuery {

    private Integer page = 1;
    private Integer size = 10;

    private String keyword;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "BaseQuery{" +
                "page=" + page +
                ", size=" + size +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
