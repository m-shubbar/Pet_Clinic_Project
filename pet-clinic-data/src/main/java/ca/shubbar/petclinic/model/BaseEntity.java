package ca.shubbar.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-15
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// With this annotation, JPA will not map this class into the db
@MappedSuperclass
public class BaseEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Hibernate recommend the use of Boxed type, not the primitive type
    private Long id;


}
