package com.sane.partake.service.intellisense;

import com.sane.partake.dao.intellisense.ThesaurusDao;
import com.sane.partake.entity.intellisense.Thesaurus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ThesaurusServiceImpl implements ThesaurusService{

    @Autowired
    private ThesaurusDao thesaurusDao;

    public List<Thesaurus> findAll(int maxNum) {
        return thesaurusDao.findAll(maxNum);
    }

    public void insert(Thesaurus thesaurus) {
        thesaurus.setValidFlag("1");
        thesaurus.setCreatedTime(new Date());
        thesaurus.setModifiedTime(new Date());
        thesaurus.setSpellCode("spell Code");

        thesaurusDao.insert(thesaurus);
    }
}
