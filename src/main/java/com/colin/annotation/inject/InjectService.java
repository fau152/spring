package com.colin.annotation.inject;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class InjectService {
    @Inject
    private InjectDao injectDao;

    public InjectService() {
    }

    @Inject
    public InjectService(InjectDao injectDao) {
        this.injectDao = injectDao;
    }

    @Inject
    public void setInjectDao(InjectDao injectDao) {
        this.injectDao = injectDao;
    }

    public void method() {
        injectDao.select();
    }
}
