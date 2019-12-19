package buaa.group6.litcenter.container;

import buaa.group6.litcenter.model.Literature;
import buaa.group6.litcenter.model.Magauthor;

import java.util.List;

public class autoGenerate {
    private int authorLen;

    private List<Magauthor> authors;

    private int LITLen;

    private List<Literature> literature;

    public List<Literature> getLiterature() {
        return literature;
    }
    public int getLITLen() {
        return LITLen;
    }
    public List<Magauthor> getAuthors() {
        return authors;
    }
    public int getAuthorLen() {
        return authorLen;
    }

    public void setLiterature(List<Literature> literature) {
        this.literature = literature;
    }
    public void setLITLen(int LITLen) {
        this.LITLen = LITLen;
    }
    public void setAuthors(List<Magauthor> authors) {
        this.authors = authors;
    }
    public void setAuthorLen(int authorLen) {
        this.authorLen = authorLen;
    }
}
