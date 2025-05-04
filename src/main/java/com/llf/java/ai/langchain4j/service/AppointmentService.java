package com.llf.java.ai.langchain4j.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.llf.java.ai.langchain4j.entity.Appointment;

import java.util.List;

public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
    // 判断某个医生是否在某时间排班
    boolean isDoctorScheduled(String doctorName, String department, String date, String time);

    // 获取指定时间段有排班的医生
    List<String> getDoctorsScheduled(String department, String date, String time);

    // 查询当前已预约数（判断是否约满）
    int countAppointments(String doctorName, String department, String date, String time);
}
