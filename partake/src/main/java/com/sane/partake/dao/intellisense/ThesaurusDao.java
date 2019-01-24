package com.sane.partake.dao.intellisense;

import com.sane.partake.entity.intellisense.Thesaurus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

@Repository
public class ThesaurusDao {
    @PersistenceContext
    private EntityManager entityManage;

    public List<Thesaurus> findAll(int maxNum) {
        TypedQuery query = entityManage.createQuery("FROM Thesaurus WHERE id < :maxNum", Thesaurus.class);
        query.setParameter("maxNum", maxNum);
        List<Thesaurus> dataList = query.getResultList();
        return dataList;
    }

    @Transactional
    public void insert(Thesaurus thesaurus) {
        //entityManage.remove(thesaurus);
        entityManage.persist(thesaurus);
    }
}
