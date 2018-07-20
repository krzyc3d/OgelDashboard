package kp.ogel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String machine_name;
    private String variable_name;
    private LocalDateTime datetime_from;
    private LocalDateTime datetime_to;
    private Integer value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMachine_name() {
        return machine_name;
    }

    public void setMachine_name(String machine_name) {
        this.machine_name = machine_name;
    }

    public String getVariable_name() {
        return variable_name;
    }

    public void setVariable_name(String variable_name) {
        this.variable_name = variable_name;
    }

    public LocalDateTime getDatetime_from() {
        return datetime_from;
    }

    public void setDatetime_from(LocalDateTime datetime_from) {
        this.datetime_from = datetime_from;
    }

    public LocalDateTime getDatetime_to() {
        return datetime_to;
    }

    public void setDatetime_to(LocalDateTime datetime_to) {
        this.datetime_to = datetime_to;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
