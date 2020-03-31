package school.minyeling.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import school.minyeling.domain.Student;
import school.minyeling.domain.StudentExample;
import school.minyeling.domain.StudentWithBLOBs;

@Repository
public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StudentWithBLOBs record);

    int insertSelective(StudentWithBLOBs record);

    List<StudentWithBLOBs> selectByExampleWithBLOBs(StudentExample example);

    List<Student> selectByExample(StudentExample example);

    StudentWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StudentWithBLOBs record, @Param("example") StudentExample example);

    int updateByExampleWithBLOBs(@Param("record") StudentWithBLOBs record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(StudentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(StudentWithBLOBs record);

    int updateByPrimaryKey(Student record);
}