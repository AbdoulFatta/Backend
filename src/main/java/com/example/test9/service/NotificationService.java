package com.example.test9.service;

import java.util.List;


import com.example.test9.dtos.NotificationDto;

public interface NotificationService {

    void creatNotification(Long id,String Solution);
    List<NotificationDto> getNotificationByMatricule(int matricule);
    void updateNotification(Long id);
    void updateDeleted(long id);

}