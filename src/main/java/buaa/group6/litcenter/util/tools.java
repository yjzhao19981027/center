package buaa.group6.litcenter.util;

import buaa.group6.litcenter.model.Author;
import buaa.group6.litcenter.model.Literature;
import buaa.group6.litcenter.service.AuthorService;
import buaa.group6.litcenter.service.LITService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service

public class tools {
    @Autowired
    LITService litService;
    @Autowired
    AuthorService authorService;

    //文献排序
    //第一个参数是按什么排序（发布时间、获得"有帮助"个数、浏览量、被引用量、），第二个参数就是要排序的文献集
    public List<Literature> LITSort(String keyword, List<Literature> LITs){
        if(keyword == "year")
            Collections.sort(LITs, Comparator.comparing(Literature::getYear));
        else if(keyword == "helps")
            Collections.sort(LITs,Comparator.comparing(Literature::getHelps));
        else if (keyword == "volume")
            Collections.sort(LITs,Comparator.comparing(Literature::getVolume));
        else if(keyword == "n_citation")
            Collections.sort(LITs,Comparator.comparing(Literature::getN_citation));
        return LITs;
    }

    //文献过滤
    //第一个参数是按什么过滤（发布时间，文献作者，学术领域、发布机构），第二个参数是要过滤的文献集
    public List<Literature> LITFilter(String keyword,List<Literature> LITs){

        return LITs;
    }

    //通过文献标题关键字获取
    //不分页
    public List<Literature> getLITByTitle(String params){
        return litService.getLITByTitle(params);
    }

    //通过文献ID获取
    public Literature getLITByID(String id){
        return litService.getLITByID(id);
    }

    //通过作者的姓名的关键字获取
    //不分页
    public List<Author> getAuthorByName(String params){
        return authorService.getAuthorByName(params);
    }

    //通过作者的ID获取
    public Author getAuthorByID(String id){
        return authorService.getAuthorByID(id);
    }

    //作者和文献分页获取
    //type为true是文献调用，为false是作者调用
    //params为搜索栏的关键词
    //pageNumber为显示的页数
    //返回一个list，list中有两个对象，第一个符合该关键词的总页数，第二个是显示页的数据
    //正常每页数目固定，最后一页有几个显示几个
    public List<Object> getByPaging(boolean type,String params,int pageNumber){
        List<Object> objectList = null;
        int onePage = 10; //每页显示个数，可调整
        if (type){
            List<Literature> list = litService.getLITByTitle(params);
            objectList.add(list.size() / onePage);
            objectList.add(list.subList(onePage * (pageNumber - 1), Math.min(list.size(),onePage * pageNumber)));
        }

        else{
            List<Author> list = authorService.getAuthorByName(params);
            objectList.add(list.size() / onePage);
            objectList.add(list.subList(onePage * (pageNumber - 1), Math.min(list.size(),onePage * pageNumber)));
        }
        return objectList;
    }

    //搜索栏自动提示，三个或三个以内作者，三个或三个以内文献
    //返回的list中包含两个对象，作者的list和文献的list
    //作者/文献List结构： {作者数，作者集}/{文献数，文献集}
    public List<Object> getBoth(String params){
        List<Object> list = null;
        List<Author> authorList = authorService.getAuthorByName(params);
        List<Literature> litList = litService.getLITByTitle(params);
        list.add(addObject(authorList,authorList.size()));
        list.add(addObject(litList,litList.size()));
        return list;
    }
    //辅助函数：作者list/文献list构造
    public List<Object> addObject(List obj,int len){
        List<Object> list = null;
        if (len > 3){
            list.add(3);
            list.add(obj.subList(0,3));
        }
        else if(len == 0){
            list.add(0);
            list.add(null);
        }
        else {
            list.add(len);
            list.add(obj);
        }
        return list;
    }
}
