package com.sane.partake.service.intellisense;

import com.sane.partake.dao.intellisense.ThesaurusDao;
import com.sane.partake.entity.intellisense.Thesaurus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class ThesaurusService {

    @Autowired
    private ThesaurusDao thesaurusDao;

    public List<Thesaurus> findAll(int maxNum) {
        return thesaurusDao.findAll(maxNum);
    }
}
