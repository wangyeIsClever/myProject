package com.wangye.spbootmultidatasource.mapper2;


import com.wangye.spbootmultidatasource.model2.User2;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper2 {

    User2 getUserById1(@Param("id") Long id);

    @Select({"<script>",
            "select",
            "   id as id,",
            "   name as name,",
            "   age as age",
            "from",
            "   user",
            "<where>",
            "   <if test ='id != null'>",
            "   and",
            "       id = #{id}",
            "   </if>",
            "</where>",
            "</script>"})
    User2 getUserById(@Param("id") Long id);

    void addUser(User2 user2);
}
