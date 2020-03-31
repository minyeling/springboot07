package school.minyeling.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import school.minyeling.domain.Class;
import school.minyeling.domain.ClassExample;
import school.minyeling.domain.ClassWithBLOBs;

@Repository
public interface ClassMapper {
    long countByExample(ClassExample example);

    int deleteByExample(ClassExample example);

    int insert(ClassWithBLOBs record);

    int insertSelective(ClassWithBLOBs record);

    List<ClassWithBLOBs> selectByExampleWithBLOBs(ClassExample example);

    List<Class> selectByExample(ClassExample example);

    int updateByExampleSelective(@Param("record") ClassWithBLOBs record, @Param("example") ClassExample example);

    int updateByExampleWithBLOBs(@Param("record") ClassWithBLOBs record, @Param("example") ClassExample example);

    int updateByExample(@Param("record") Class record, @Param("example") ClassExample example);
}