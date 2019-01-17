package com.sane.partake.service.intellisense;

import com.sane.partake.entity.intellisense.Thesaurus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThesaurusService {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Thesaurus> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM Thesaurus WHERE id < :maxNum", Thesaurus.class);
        query.setString("maxNum", "500");
        List<Thesaurus> thesauruses = query.list();
        session.getTransaction().commit();
        return thesauruses;
    }
}
