package com.myoi.exer6;

import java.util.*;

/**
 * @author myoi
 * @date 2021/12/16 - 11:14
 */
public class DaoTest {
    public static void main(String[] args) {
        Dao<User> userDao = new Dao<>();
        User u1 = new User(01, "wmw");
        User u2 = new User(02, "jack");
        User u3 = new User(03, "sr");
        User u4 = new User(04, "jf");
        userDao.save(u1.getId()+"",u1);
        userDao.save(u2.getId()+"",u2);
        userDao.save(u3.getId()+"",u3);
        userDao.save(u4.getId()+"",u4);
        System.out.println(userDao.getAll());
        System.out.println(userDao.get("1"));
        userDao.save("4", new User(4,"cl"));
        System.out.println(userDao.getAll());
        userDao.delete("2");
        System.out.println(userDao.getAll());
    }



}
class User{
    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class Dao<T>{
    private Map<String,T> map=new HashMap<>();


    public void save(String id,T t) {
        map.put(id, t);
    }

    public T get(String id) {
        return map.get(id);
    }

    public List<T> getAll() {
        Collection<T> values = map.values();
        List<T> list = new ArrayList<>();
        list.addAll(values);
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }
}
