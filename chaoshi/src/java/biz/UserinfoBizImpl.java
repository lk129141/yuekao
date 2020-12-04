package biz;

import dao.UserinfoDao;
import dao.UserinfoDaoImpl;
import entity.UserInfo;
import java.util.List;

public class  UserinfoBizImpl implements UserinfoBiz {
    //底层对象
    private UserinfoDao dao = new UserinfoDaoImpl();

    @Override
    public UserInfo isLogin(UserInfo userInfo) throws Exception {
        return dao.isLogin(userInfo);
    }

    @Override
    public int add(UserInfo userInfo) throws Exception {
        return dao.add(userInfo);
    }

    @Override
    public int del(String id) throws Exception {
        return 0;
    }

    @Override
    public int update(UserInfo userInfo) throws Exception {
        return dao.update(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return null;
    }

    @Override
    public List<UserInfo> all(Object... param) throws Exception {
        return dao.all(param);
    }
}
