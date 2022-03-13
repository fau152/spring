package com.colin.aop.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    private BlogDao blogDao;

    public void addBlog() {
        blogDao.insert();
    }

    public void removeBlog() {
        blogDao.delete();
    }

    public void modifyBlog() {
        blogDao.update();
    }

    public void findBlog() {
        blogDao.select();
    }
}
