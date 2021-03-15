package icu.bitchigo.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.bitchigo.blog.pojo.DO.Clazz;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ClazzMapper extends BaseMapper<Clazz> {
}
