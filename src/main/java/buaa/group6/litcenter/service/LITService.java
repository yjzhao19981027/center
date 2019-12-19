package buaa.group6.litcenter.service;

import buaa.group6.litcenter.model.Literature;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.List;


public interface LITService {
    //标题查询
    List<Literature> getLITByTitle(String title);
    //作者查询
   // List<Literature> getLITByAuthor(String author);
    //ID查询
    Literature getLITByID(String id);

    List<Literature> getTop5LITByTitle(String title);

    List<Literature> getTop100LITByTitle(String title);
}
