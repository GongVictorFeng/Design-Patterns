package org.example;

import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;
//Represents a request in our chain of responsibility
@Getter
public class LeaveApplication {
    public enum Type {Sick, PTO, LOP};
    public enum Status {Pending, Approved, Rejected};
    private final Type type;
    private final LocalDate from;
    private final LocalDate to;
    private String processedBy;
    private Status status;

    public LeaveApplication(Type type, LocalDate from, LocalDate to) {
        this.type = type;
        this.from = from;
        this.to = to;
        this.status = Status.Pending;
    }

    public int getNoOfDays() {
        return Period.between(from, to).getDays();
    }

    public void approve(String approverName) {
        this.status = Status.Approved;
        this.processedBy = approverName;
    }

    public void reject(String approverName) {
        this.status = Status.Rejected;
        this.processedBy = approverName;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return type + " leave for "+getNoOfDays()+" day(s) "+status
                + " by "+processedBy;
    }

    public static class Builder {
        private Type type;
        private LocalDate from;
        private LocalDate to;
        @Getter
        private LeaveApplication application;

        private Builder() {}

        public Builder withType(Type type) {
            this.type = type;
            return this;
        }

        public Builder from(LocalDate from) {
            this.from = from;
            return this;
        }

        public Builder to(LocalDate to) {
            this.to = to;
            return this;
        }

        public LeaveApplication build() {
            this.application = new LeaveApplication(type, from, to);
            return this.application;
        }

    }
}
