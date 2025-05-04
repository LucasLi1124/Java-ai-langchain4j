package com.llf.java.ai.langchain4j.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llf.java.ai.langchain4j.entity.Appointment;
import com.llf.java.ai.langchain4j.mapper.AppointmentMapper;
import com.llf.java.ai.langchain4j.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment>
        implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;
    /**
     * 查询订单是否存在
     *
     * @param appointment
     * @return
     */
    @Override
    public Appointment getOne(Appointment appointment) {
        LambdaQueryWrapper<Appointment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Appointment::getUsername, appointment.getUsername());
        queryWrapper.eq(Appointment::getIdCard, appointment.getIdCard());
        queryWrapper.eq(Appointment::getDepartment, appointment.getDepartment());
        queryWrapper.eq(Appointment::getDate, appointment.getDate());
        queryWrapper.eq(Appointment::getTime, appointment.getTime());
        Appointment appointmentDB = baseMapper.selectOne(queryWrapper);
        return appointmentDB;
    }

    @Override
    public boolean isDoctorScheduled(String doctorName, String department, String date, String time) {
        return appointmentMapper.isDoctorScheduled(doctorName, department, date, time);
    }

    @Override
    public List<String> getDoctorsScheduled(String department, String date, String time) {
        return appointmentMapper.getDoctorsScheduled(department, date, time);
    }

    @Override
    public int countAppointments(String doctorName, String department, String date, String time) {
        return appointmentMapper.countAppointments(doctorName, department, date, time);
    }
}
