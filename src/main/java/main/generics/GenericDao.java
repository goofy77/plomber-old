package main.generics;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.mongodb.WriteResult;
import main.security.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class GenericDao<T> {

    @Autowired
    protected MongoTemplate mongoTemplate;

    private Class<T> clazz;

    public GenericDao(Class<T> implementingClass){
        this.clazz = implementingClass;
    }

    public Optional<T> findOne(String id){
        return Optional.ofNullable(mongoTemplate.findById(id, clazz));
    }

    public List<T> findAll(){
        return mongoTemplate.find(query(where("userId").is(CurrentUser.getName())), clazz);

    }

    public EntityDeleted remove(String id){
        WriteResult wr = mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), clazz);
        return new EntityDeleted(wr.getN() > 0);
    }

    public void save(T entity){
        mongoTemplate.save(entity);
    }

}
