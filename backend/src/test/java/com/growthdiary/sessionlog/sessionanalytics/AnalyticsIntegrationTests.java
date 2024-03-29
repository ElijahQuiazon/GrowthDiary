package com.growthdiary.sessionlog.sessionanalytics;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.growthdiary.sessionlog.analytics.*;
import com.growthdiary.sessionlog.history.HistoryRepository;
import com.growthdiary.sessionlog.tracker.models.Details;
import com.growthdiary.sessionlog.tracker.models.Feedback;
import com.growthdiary.sessionlog.tracker.models.Session;
import com.growthdiary.sessionlog.tracker.models.Time;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.growthdiary.sessionlog.analytics.ProductivityCategory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AnalyticsIntegrationTests {

    @Autowired
    private AnalyticsRepository analyticsRepository;

    @Autowired
    private AnalyticsService analyticsService;

    @Autowired
    private AnalyticsController analyticsController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    public static void insertTestValues(@Autowired HistoryRepository historyRepository) {

        Session testSession1 = new Session();
        testSession1.setDetails(new Details("Spring Boot", "Building backend API"));
        testSession1.setTime(new Time(LocalDate.of(2023,10,10), LocalTime.of(9, 0), 30L));
        testSession1.setFeedback(new Feedback(3, "Social media"));

        Session testSession2 = new Session();
        testSession2.setDetails(new Details("Quicksort", "Practising Leetcode"));
        testSession2.setTime(new Time(LocalDate.of(2023,10,10), LocalTime.of(11, 30), 45L));
        testSession2.setFeedback(new Feedback(4, "Overthinking"));

        historyRepository.save(testSession1);
        historyRepository.save(testSession2);
    }

    @AfterAll
    public static void clearTestValues(@Autowired HistoryRepository historyRepository) {
        historyRepository.deleteAll();
    }

    @Test
    public void testGetSessionStats() throws Exception {

        mockMvc.perform(get("/session/analytics"))
                .andExpect(status().isAccepted());
    }

    @Test
    public void testDurationCorrelation() throws Exception {

        mockMvc.perform(get("/session/analytics/productivity")
                .param("category", duration.toString()))
                .andExpect(status().isAccepted());
    }

    @Test
    public void testTimeCorrelation() throws Exception {

        mockMvc.perform(get("/session/analytics/productivity")
                        .param("category", time.toString()))
                .andExpect(status().isAccepted());
    }


    @Test
    public void testDistractionCorrelation() throws Exception {

        mockMvc.perform(get("/session/analytics/productivity")
                        .param("category", obstacle.toString()))
                .andExpect(status().isAccepted());
    }

    @Test
    public void testUnsupportedAttribute() throws Exception {
        mockMvc.perform(get("/session/analytics/productivity")
                .param("category", "unsupported"))
                .andExpect(status().isBadRequest());
    }
}
