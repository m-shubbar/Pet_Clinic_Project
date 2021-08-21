package ca.shubbar.petclinic.services.map;

import ca.shubbar.petclinic.model.BaseEntity;

import java.util.*;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-16
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    // We will overwrite this because we don't know what will come here
    T save(T object) {
        if(object != null) {
            if(object.getId() == null) {
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }


    // implement id property setting
    private Long getNextId(){

        Long nextId = null;

        // cleaner?
        // return map.size() > 0 ? Collections.max(map.keySet()) + 1 : 1L;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch(NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }


}
