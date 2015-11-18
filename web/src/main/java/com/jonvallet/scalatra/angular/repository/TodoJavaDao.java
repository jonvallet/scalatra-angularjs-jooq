package com.jonvallet.scalatra.angular.repository;

import com.jonvallet.scalatra.angular.database.DatabaseContext;

import java.util.List;

import static com.jonvallet.scalatra.angular.database.public_.tables.Todo.*;

/**
 * Created by jon on 18/11/15.
 */
public class TodoJavaDao {

    private DatabaseContext ctx;

    public TodoJavaDao(DatabaseContext ctx) {
        this.ctx = ctx;
    }

    public List<Todo> getAll() {
        return ctx.create().select().from(TODO).fetchInto(Todo.class);
    }

    public void updateDone(Integer id, Boolean done) {
        ctx.create().update(TODO).set(TODO.DONE, done).where(TODO.ID.eq(id)).execute();
    }

}
