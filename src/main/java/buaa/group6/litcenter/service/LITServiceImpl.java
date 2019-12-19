package buaa.group6.litcenter.service;

import buaa.group6.litcenter.model.Literature;
import buaa.group6.litcenter.service.mongoRepository.LITRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class LITServiceImpl implements LITService {
    @Autowired
    LITRepository litRepository;

    @Override
    public List<Literature> getLITByTitle(String title) {
        return litRepository.getByTitleContaining(title);
    }

    @Override
    public Literature getLITByID(String id) {
        return litRepository.getById(id);
    }

    @Override
    public List<Literature> getTop5LITByTitle(String title) {
        return litRepository.getTop5ByTitleStartingWith(title);
    }
}
