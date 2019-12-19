package buaa.group6.litcenter.model;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Array;
import java.util.List;

@Document(collection = "magpapers")
public class Literature {
    @Id
    private String _id;

    private String id;

    private String title;

    private List<Author> authors;

    private int year;
    // 领域
    private venue venue;
    // 引用次数
    private int n_citation;

    private String page_start;

    private String page_end;

    private String doc_type;

    private String publisher;
    //浏览量
    private String volume;
    //发行
    private String issue;
    //好感度
    private String doi;

    public String get_id() {
        return _id;
    }
    public String getId(){ return this.id; }
    public String getTitle(){ return this.title; }
    public int getYear(){ return this.year; }
    public List<Author> getAuthors() { return this.authors; }
    public venue getVenue() { return this.venue; }
    public int getN_citation() {return this.n_citation;}
    public String getPage_start() {return this.page_start;}
    public String getPage_end() {return this.page_end;}
    public String getDoc_type(){return this.doc_type;}
    public String getPublisher(){return  this.publisher;}
    public String getVolume(){return this.volume;}
    public String getIssue() {return this.issue; }

    public void set_id(String _id) {
        this._id = _id;
    }
    public void setId(String id){this.id = id;}
    public void setTitle(String title){this.title = title;}
    public void setAuthors(List<Author> authors){this.authors = authors;}
    public void setYear(int year){this.year = year;}
    public void setVenue(venue venue){this.venue = venue;}
    public void setN_citation(int n_citation){this.n_citation = n_citation;}
    public void setPage_start(String page_start){this.page_start = page_start;}
    public void setPage_end(String page_end){this.page_end = page_end;}
    public void setDoc_type(String doc_type){this.doc_type = doc_type;}
    public void setPublisher(String publisher){this.publisher = publisher;}
    public void setVolume(String volume){this.volume = volume;}
    public void setIssue(String issue){this.issue = issue;}

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }
}
