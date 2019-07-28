package com.wangye.spbootjtaautomatic.mapper1;



import com.wangye.spbootjtaautomatic.model1.User1;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper1 {

    User1 getUserById1(@Param("id") Long id);

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
    User1 getUserById(@Param("id") Long id);

    void addUser(User1 user1);
}
