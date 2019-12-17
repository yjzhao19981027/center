package buaa.group6.litcenter.model;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Array;
import java.util.List;

public class Literature {
    @Autowired
    private RestTemplate restTemplate;

    private String id;

    private String title;

    private List<Object> authors;

    private int year;
    // 领域
    private List<Object> venue;
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
    private String helps;

    public String getId(){ return this.id; }
    public String getTitle(){ return this.title; }
    public int getYear(){ return this.year; }
    public List<Object> getAuthors() { return this.authors; }
    public List<Object> getVenue() { return this.venue; }
    public int getN_citation() {return this.n_citation;}
    public String getPage_start() {return this.page_start;}
    public String getPage_end() {return this.page_end;}
    public String getDoc_type(){return this.doc_type;}
    public String getPublisher(){return  this.publisher;}
    public String getVolume(){return this.volume;}
    public String getIssue() {return this.issue; }
    public String getHelps(){return this.helps; }

    public void setId(String id){this.id = id;}
    public void setTitle(String title){this.title = title;}
    public void setAuthors(List<Object> authors){this.authors = authors;}
    public void setYear(int year){this.year = year;}
    public void setVenue(List<Object> venue){this.venue = venue;}
    public void setN_citation(int n_citation){this.n_citation = n_citation;}
    public void setPage_start(String page_start){this.page_start = page_start;}
    public void setPage_end(String page_end){this.page_end = page_end;}
    public void setDoc_type(String doc_type){this.doc_type = doc_type;}
    public void setPublisher(String publisher){this.publisher = publisher;}
    public void setVolume(String volume){this.volume = volume;}
    public void setIssue(String issue){this.issue = issue;}
    public void setHelps(String helps){this.helps = helps;}
}
