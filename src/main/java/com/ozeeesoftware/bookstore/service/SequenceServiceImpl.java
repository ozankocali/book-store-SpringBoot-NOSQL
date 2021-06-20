package com.ozeeesoftware.bookstore.service;

import com.ozeeesoftware.bookstore.model.DatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;

@Service
public class SequenceServiceImpl implements SequenceService{

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Long getSequenceNumber(String sequenceName){

        Query query = new Query(Criteria.where("id").is(sequenceName));

        Update update = new Update().inc("seq", 1);

        DatabaseSequence sequence=mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DatabaseSequence.class);

        return !Objects.isNull(sequence)?sequence.getSeq():1;

    }

}
