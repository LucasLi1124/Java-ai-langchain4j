package com.llf.java.ai.langchain4j.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llf.java.ai.langchain4j.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface AppointmentMapper extends BaseMapper<Appointment> {
    boolean isDoctorScheduled(@Param("doctorName") String doctorName,
                              @Param("department") String department,
                              @Param("date") String date,
                              @Param("time") String time);

    List<String> getDoctorsScheduled(@Param("department") String department,
                                     @Param("date") String date,
                                     @Param("time") String time);

    int countAppointments(@Param("doctorName") String doctorName,
                          @Param("department") String department,
                          @Param("date") String date,
                          @Param("time") String time);
}
