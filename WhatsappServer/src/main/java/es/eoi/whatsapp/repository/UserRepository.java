package es.eoi.whatsapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import es.eoi.whatsapp.entity.QUser;
import es.eoi.whatsapp.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>,QueryByExampleExecutor <User>,QuerydslPredicateExecutor<User>,QuerydslBinderCustomizer<QUser> {
	
	 @Override
	    default void customize(QuerydslBindings bindings, QUser user) {
	        // Make case-insensitive 'like' filter for all string properties 
	        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
	    }
	 
	 

}