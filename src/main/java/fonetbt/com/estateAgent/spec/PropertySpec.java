package fonetbt.com.estateAgent.spec;

import fonetbt.com.estateAgent.model.Property;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=mr0ZB6QDz00
public class PropertySpec {
    public static Specification<Property> getSpec(int RoomCount,
                                                   String Size,
                                                   String FloorCount,
                                                   long PropertyTypeId,
                                                   long HeatingSystemTypeId,
                                                   long PropertyStatusId){
        return(((root, query, criteriaBuilder) -> {
            List<Predicate> predicates =new ArrayList<>();

            if (Size!=null){
                predicates.add(criteriaBuilder.equal(root.get("Size"),Size));
            }


            if (FloorCount!=null){
                predicates.add(criteriaBuilder.equal(root.get("FloorCount"),FloorCount));
            }

            predicates.add(criteriaBuilder.equal(root.get("RoomCount"),RoomCount));
            predicates.add(criteriaBuilder.equal(root.get("PropertyTypeId"),PropertyTypeId));
            predicates.add(criteriaBuilder.equal(root.get("HeatingSystemTypeId"),HeatingSystemTypeId));
            predicates.add(criteriaBuilder.equal(root.get("PropertyStatusId"),PropertyStatusId));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));


        }));
    }
}