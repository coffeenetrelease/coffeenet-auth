package de.synyx.selfservice.module;

import de.synyx.selfservice.event.Event;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by klem on 24.02.15.
 */
@Getter
@Setter
@Entity
public class ModuleActuator {

    @Id
    @GeneratedValue
    private Long id;

    private String endpoint;
}