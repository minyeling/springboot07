package school.minyeling.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import school.minyeling.domain.Fee;
import school.minyeling.domain.FeeExample;

@Repository
public interface FeeMapper {
    long countByExample(FeeExample example);

    int deleteByExample(FeeExample example);

    int insert(Fee record);

    int insertSelective(Fee record);

    List<Fee> selectByExampleWithBLOBs(FeeExample example);

    List<Fee> selectByExample(FeeExample example);

    int updateByExampleSelective(@Param("record") Fee record, @Param("example") FeeExample example);

    int updateByExampleWithBLOBs(@Param("record") Fee record, @Param("example") FeeExample example);

    int updateByExample(@Param("record") Fee record, @Param("example") FeeExample example);
}