package buaa.group6.litcenter.container;

import buaa.group6.litcenter.model.User;

import java.util.List;

public class UserPaging {
    private int totalPage;
    private List<User> list;

    public List<User> getList() {
        return list;
    }
    public int getTotalPage() {
        return totalPage;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
