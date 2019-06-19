package com.lovo.mybatisdb;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSession {
    public static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "mybaitsConfig.xml";
        InputStream input = null;

        try {
            input = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(input);
    }

    public static SqlSession creatSession(){
        return sqlSessionFactory.openSession();
    }
}
