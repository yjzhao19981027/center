package buaa.group6.litcenter.util;

import buaa.group6.litcenter.container.LITPaging;
import buaa.group6.litcenter.container.UserPaging;
import buaa.group6.litcenter.container.authorPaging;
import buaa.group6.litcenter.container.autoGenerate;
import buaa.group6.litcenter.model.Author;
import buaa.group6.litcenter.model.Literature;
import buaa.group6.litcenter.model.Magauthor;
import buaa.group6.litcenter.model.User;
import buaa.group6.litcenter.service.AuthorService;
import buaa.group6.litcenter.service.LITService;
import buaa.group6.litcenter.service.mongoRepository.LITRepository;
import buaa.group6.litcenter.service.mongoRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
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
    @Autowired
    LITRepository litRepository;
    @Autowired
    UserRepository userRepository;

    //文献排序
    //
    public LITPaging getSortedLITsByPaging (String type, String title, String page){
        LITPaging obj = new LITPaging();
        int pageNumber = Integer.parseInt(page);
        int onePage = 10; //每页显示个数，可调整
        List<Literature> list = litService.getTop100LITByTitle(title);
        if(type.equals("pos")){
            list.sort(Comparator.comparing(Literature::getN_citation).reversed());
        }
        else if(type.equals("inv")){
            list.sort(Comparator.comparing(Literature::getN_citation));
        }
        obj.setTotalPage((onePage - 1 + list.size()) / onePage);
        obj.setLITs(list.subList(onePage * (pageNumber - 1), Math.min(list.size(),onePage * pageNumber)));
        return obj;
    }

    //文献过滤
    //第一个参数是按什么过滤（发布时间，文献作者，学术领域、发布机构），第二个参数是要过滤的文献集
    public List<Literature> LITFilter(String keyword,List<Literature> LITs){

        return LITs;
    }

    //通过文献标题关键字获取
    //不分页
    public List<Literature> getLITByTitle(String title){
        return litService.getLITByTitle(title);
    }

    //通过文献ID获取
    public Literature getLITByID(String id){
        return litRepository.getById(id);
    }

    //通过作者的姓名的关键字获取
    //不分页
    public List<Magauthor> getAuthorByName(String name){
        return authorService.getAuthorByName(name);
    }

    //通过作者的姓名的关键字获取前五个
    public List<Magauthor> getTop5AuthorByName(String name){
        return authorService.getTop5AuthorByName(name);
    }

    //通过作者的ID获取
    public Magauthor getAuthorByID(String id){
        return authorService.getAuthorByID(id);
    }

    //作者和文献分页获取
    //type为true是文献调用，为false是作者调用
    //params为搜索栏的关键词
    //pageNumber为显示的页数
    //返回一个list，list中有两个对象，第一个符合该关键词的总页数，第二个是显示页的数据
    //正常每页数目固定，最后一页有几个显示几个
    public authorPaging getAuthorsByPaging(String name, String page){
        authorPaging obj = new authorPaging();
        int pageNumber = Integer.parseInt(page);
        int onePage = 10; //每页显示个数，可调整
        List<Magauthor> list = authorService.getAuthorByName(name);
        //List<Magauthor> list = authorService.getTop100AuthorByName(name);
        obj.setTotalPage((onePage - 1 + list.size()) / onePage);
        obj.setAuthors(list.subList(onePage * (pageNumber - 1), Math.min(list.size(),onePage * pageNumber)));
        return obj;
    }

    public LITPaging getLITsByPaging(String title, String page){
        LITPaging obj = new LITPaging();
        int pageNumber = Integer.parseInt(page);
        int onePage = 10; //每页显示个数，可调整
        List<Literature> list = litService.getLITByTitle(title);
        //List<Literature> list = litService.getTop100LITByTitle(title);
        obj.setTotalPage((onePage - 1 + list.size()) / onePage);
        obj.setLITs(list.subList(onePage * (pageNumber - 1), Math.min(list.size(),onePage * pageNumber)));
        return obj;
    }

    public UserPaging getUsersByPaging(String name, String page){
        UserPaging obj = new UserPaging();
        int pageNumber = Integer.parseInt(page);
        int onePage = 10; //每页显示个数，可调整
        List<User> list = userRepository.getByUsernameContaining(name);
        obj.setTotalPage((onePage - 1 + list.size()) / onePage);
        obj.setList(list.subList(onePage * (pageNumber - 1), Math.min(list.size(),onePage * pageNumber)));
        return obj;
    }

    public authorPaging getTop100AuthorsByPaging(String name, String page){
        authorPaging obj = new authorPaging();
        int pageNumber = Integer.parseInt(page);
        int onePage = 10; //每页显示个数，可调整
        //List<Magauthor> list = authorService.getAuthorByName(name);
        List<Magauthor> list = authorService.getTop100AuthorByName(name);
        obj.setTotalPage((onePage - 1 + list.size()) / onePage);
        obj.setAuthors(list.subList(onePage * (pageNumber - 1), Math.min(list.size(),onePage * pageNumber)));
        return obj;
    }

    public LITPaging getTop100LITsByPaging(String title, String page){
        LITPaging obj = new LITPaging();
        int pageNumber = Integer.parseInt(page);
        int onePage = 10; //每页显示个数，可调整
        //List<Literature> list = litService.getLITByTitle(title);
        List<Literature> list = litService.getTop100LITByTitle(title);
        obj.setTotalPage((onePage - 1 + list.size()) / onePage);
        obj.setLITs(list.subList(onePage * (pageNumber - 1), Math.min(list.size(),onePage * pageNumber)));
        return obj;
    }
    //搜索栏自动提示，三个或三个以内作者，三个或三个以内文献
    //返回的list中包含两个对象，作者的list和文献的list
    //作者/文献List结构： {作者数，作者集}/{文献数，文献集}
    public autoGenerate getBoth(String params){
        autoGenerate generate = new autoGenerate();
        List<Magauthor> authorList = authorService.getTop5AuthorByName(params);
        List<Literature> litList = litService.getTop5LITByTitle(params);
        int authorLen = Math.min(3,authorList.size());
        int litLen = Math.min(3,litList.size());
        generate.setAuthorLen(authorLen);
        generate.setAuthors(authorList.subList(0,authorLen));
        generate.setLITLen(litLen);
        generate.setLiterature(litList.subList(0,litLen));
        return generate;
    }
}
