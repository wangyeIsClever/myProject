package com.wangye.spboottransaction.mapper;


import com.wangye.spboottransaction.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getUserById1(@Param("id") Long id);

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
    User getUserById(@Param("id") Long id);

    @Insert({"<script>",
            "insert into",
            "   user",
            "(id,name,age) ",
            "values (",
            "   #{id},#{name},#{age}",
            ")",
            "</script>"})
    int addUser(User user);
}
