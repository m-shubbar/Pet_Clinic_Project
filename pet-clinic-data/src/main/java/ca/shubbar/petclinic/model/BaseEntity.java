package ca.shubbar.petclinic.model;

import java.io.Serializable;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-15
 */
public class BaseEntity implements Serializable {

    // Hibernate recommend the use of Boxed type, not the primitive type
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
