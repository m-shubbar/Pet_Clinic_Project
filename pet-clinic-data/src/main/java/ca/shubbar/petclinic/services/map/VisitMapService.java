package ca.shubbar.petclinic.services.map;

import ca.shubbar.petclinic.model.Visit;
import ca.shubbar.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-26
 */
@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {

        // basic defensive validation to ensure that we have a properly formed object
        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() ==null
            || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit");
        }

        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
