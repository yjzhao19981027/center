package buaa.group6.litcenter.container;

import buaa.group6.litcenter.model.Magauthor;

import java.util.List;

public class authorPaging {
    private int totalPage;

    private List<Magauthor> authors;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Magauthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Magauthor> authors) {
        this.authors = authors;
    }
}
