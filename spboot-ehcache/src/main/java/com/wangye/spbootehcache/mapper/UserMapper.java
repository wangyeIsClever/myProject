package com.wangye.spbootehcache.mapper;


import com.wangye.spbootehcache.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "userCache")
public interface UserMapper {

    @CachePut(value = "userCache",key = "#id")
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
    @Cacheable(key = "#id")
    User getUserById(@Param("id") Long id);

    @Insert({"<script>",
            "insert into user ",
            "(id,name,age) ",
            "values ",
            "(#{id},#{name},#age)",
            "</script>"})
    @CacheEvict(value = "userCache",allEntries=true)
    int save(User user);
}
