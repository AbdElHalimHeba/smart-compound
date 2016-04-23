package com.ntg.smartCompound.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.ntg.smartCompound.service.ServiceImpl;

public class UserApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    public UserApplication() {
        singletons.add(new ServiceImpl());
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
} 