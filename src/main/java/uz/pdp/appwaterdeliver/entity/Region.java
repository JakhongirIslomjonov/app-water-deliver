package uz.pdp.appwaterdeliver.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appwaterdeliver.entity.abs.AbsEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Region extends AbsEntity {

    private String  name;
}
