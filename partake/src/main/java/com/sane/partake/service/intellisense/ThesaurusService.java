package com.sane.partake.service.intellisense;

import com.sane.partake.entity.intellisense.Thesaurus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ThesaurusService {
    List<Thesaurus> findAll(int maxNum);
}
