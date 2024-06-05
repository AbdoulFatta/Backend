package com.example.test9.service;

import java.util.*;


import com.example.test9.dtos.NotificationDto;
import com.example.test9.model.Contribuable;
import com.example.test9.model.Notification;
import com.example.test9.model.Reclamation;
import com.example.test9.repo.ContribuableRepository;
import com.example.test9.repo.NotificationRepository;
import com.example.test9.repo.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{


    @Autowired
    private ReclamationRepository reclamationrepo;
    @Autowired
    private NotificationRepository notificationRepo;
    @Autowired
    private SimpMessagingTemplate template ;
    @Autowired
    private ContribuableRepository contribuablerepo;

    @Override
    public void creatNotification(Long id, String Solution) {
        Optional<Reclamation> reclamation=reclamationrepo.findById(id);
        if(reclamation.isPresent()) {
            Notification notif=new Notification();
            notif.setDate_notification(new Date());
            notif.setChecked(false);
            notif.setDeleted(false);
            notif.setReclamation(reclamation.get());
            String matriculeFiscale = String.valueOf(reclamation.get().getContribuable().getMatriculefiscale());
            NotificationDto notification=new NotificationDto();
            notification.setDateReponse(notif.getDate_notification());
            notification.setIdReclamation(id);
            notification.setSolution(Solution);
            notification.setTitre(reclamation.get().getTitre());

            template.convertAndSendToUser(matriculeFiscale,"/queue/notification",notification);
            notificationRepo.save(notif);


        }

    }

    @Override
    public List<NotificationDto> getNotificationByMatricule(int matricule) {
        Optional<Contribuable> contribuable = contribuablerepo.findByMatriculeFiscale(matricule);
        if (contribuable.isPresent()) {
            List<Reclamation> reclamations = reclamationrepo.findByContribuable(contribuable.get());

            List<NotificationDto> notificationDtos = new ArrayList<>();

            // Loop through each reclamation to fetch the associated notifications
            for (Reclamation reclamation : reclamations) {
                List<Notification> notifications = notificationRepo.findByReclamation(reclamation);
                for (Notification notification : notifications) {
                    NotificationDto dto = new NotificationDto(
                            notification.getId_notification(),
                            reclamation.getId_reclamation(), // Assuming `getId()` returns the id of the reclamation
                            notification.getDate_notification(), // Assuming `getDateReponse()` returns the response date
                            notification.getReclamation().getTitre(), // Assuming `getTitre()` returns the title
                            notification.getReclamation().getSolution(),
                            notification.isChecked(),
                            notification.isDeleted()// Assuming `getSolution()` returns the solution
                    );
                    notificationDtos.add(dto);
                }
            }
            return notificationDtos;
        }
        return Collections.emptyList();
    }

    @Override
    public void updateNotification(Long id) {
        Optional<Notification> notif=notificationRepo.findById(id);
        if(notif.isPresent()) {
            notif.get().setChecked(true);
            notificationRepo.save(notif.get());
        }

    }

    @Override
    public void updateDeleted(long id) {
        Optional<Notification> notif=notificationRepo.findById(id);
        if(notif.isPresent()) {
            notif.get().setDeleted(true);
            notificationRepo.save(notif.get());
        }

    }


}
