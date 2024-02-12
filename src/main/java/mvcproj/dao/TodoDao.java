package mvcproj.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mvcproj.model.Todo;

@Repository

public class TodoDao {
    @Autowired
    SessionFactory s1;

    @Transactional
    public int saveTodo(Todo t) {
        s1.getCurrentSession().merge(t);
        return 1;

    }

    @Transactional
    public List<Todo> getAllTodo() {

        List<Todo> list = s1.getCurrentSession().createQuery("from Todo", Todo.class).list();

        return list;

    }

}
