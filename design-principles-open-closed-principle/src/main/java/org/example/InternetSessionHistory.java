package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.*;

public class InternetSessionHistory {

    @Getter
    @AllArgsConstructor
    public static class InternetSession {
        private Long subscriberId;
        private LocalDateTime begin;
        private Long dataUsed;
    }

    private static final Map<Long, List<InternetSession>> SESSIONS = new HashMap<>();

    public synchronized static List<InternetSession> getCurrentSessions(Long subscriberId) {
        return SESSIONS.getOrDefault(subscriberId, Collections.emptyList());
    }

    public synchronized static void addSession(Long subscriberId, LocalDateTime begin, long dataUsed) {
        if (!SESSIONS.containsKey(subscriberId)) SESSIONS.put(subscriberId, new LinkedList<>());
        List<InternetSession> sessions = SESSIONS.get(subscriberId);
        sessions.add(new InternetSession(subscriberId, begin, dataUsed));
    }
}
