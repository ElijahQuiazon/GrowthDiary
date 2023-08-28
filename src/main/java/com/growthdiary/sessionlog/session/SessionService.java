package com.growthdiary.sessionlog.session;

import com.growthdiary.sessionlog.feedback.Feedback;
import com.growthdiary.sessionlog.feedback.FeedbackRepository;
import com.growthdiary.sessionlog.feedback.FeedbackService;
import com.growthdiary.sessionlog.skill.Skill;
import com.growthdiary.sessionlog.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final FeedbackService feedbackService;
    private final SkillService skillService;

    @Autowired
    public SessionService(SessionRepository sessionRepository,
                          FeedbackService feedbackService,
                          SkillService skillService) {
        this.sessionRepository = sessionRepository;
        this.feedbackService = feedbackService;
        this.skillService = skillService;

    }

    public Session createSession(LocalDate startDate,
                                 LocalDate endDate,
                                 LocalTime startTime,
                                 LocalTime endTime,
                                 String topic,
                                 String category,
                                 Integer rating,
                                 String distraction,
                                 String emotion) {
        Skill skill = skillService.createSkill(topic, category);
        Feedback feedback = feedbackService.createFeedback(rating, distraction, emotion);

        Session session = new Session();
        session.setStartDate(startDate);
        session.setEndDate(endDate);
        session.setStartTime(startTime);
        session.setEndTime(endTime);
        session.setSkill(skill);
        session.setFeedback(feedback);

        sessionRepository.save(session);

        return session;
    }

}
