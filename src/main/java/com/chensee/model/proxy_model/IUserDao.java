package com.chensee.model.proxy_model;

public interface IUserDao {
    void save();
    void find();
    void delete(String userId);
}