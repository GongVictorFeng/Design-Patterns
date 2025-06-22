package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.*;

public class CallHistory {

    @AllArgsConstructor
    @Getter
    public static class Call {
        private Long subscriberId;
        private LocalDateTime begin;
        private long duration;
    }

    private static final Map<Long, List<Call>> CALLS = new HashMap<>();

    public synchronized static List<Call> getCurrentCalls(Long subscriberId) {
        return CALLS.getOrDefault(subscriberId, Collections.emptyList());
    }

    public synchronized static void addSession(Long subscriberId, LocalDateTime begin, long duration) {
        if (!CALLS.containsKey(subscriberId)) {
            CALLS.put(subscriberId, new LinkedList<>());
        }
        List<Call> calls = CALLS.get(subscriberId);
        calls.add(new Call(subscriberId, begin, duration));
    }
}
