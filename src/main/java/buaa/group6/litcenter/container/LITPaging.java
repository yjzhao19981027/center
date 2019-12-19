package buaa.group6.litcenter.container;

import buaa.group6.litcenter.model.Literature;

import java.util.List;

public class LITPaging {
    private int totalPage;

    private List<Literature> LITs;

    public List<Literature> getLITs() {
        return LITs;
    }

    public void setLITs(List<Literature> LITs) {
        this.LITs = LITs;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
