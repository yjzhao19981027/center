package buaa.group6.litcenter.util;

import buaa.group6.litcenter.model.Literature;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class tools {
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
}
