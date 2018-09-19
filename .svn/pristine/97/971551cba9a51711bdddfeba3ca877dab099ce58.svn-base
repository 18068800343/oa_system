package org.ldxx.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.PrjStaffAttendance;
import org.ldxx.bean.PrjStaffAttendanceExample;

public interface PrjStaffAttendanceMapper {
    int countByExample(PrjStaffAttendanceExample example);

    int deleteByExample(PrjStaffAttendanceExample example);

    int deleteByPrimaryKey(String psaId);

    int insert(PrjStaffAttendance record);

    int insertSelective(PrjStaffAttendance record);

    List<PrjStaffAttendance> selectByExample(PrjStaffAttendanceExample example);

    PrjStaffAttendance selectByPrimaryKey(String psaId);

    int updateByExampleSelective(@Param("record") PrjStaffAttendance record, @Param("example") PrjStaffAttendanceExample example);

    int updateByExample(@Param("record") PrjStaffAttendance record, @Param("example") PrjStaffAttendanceExample example);

    int updateByPrimaryKeySelective(PrjStaffAttendance record);

    int updateByPrimaryKey(PrjStaffAttendance record);
}