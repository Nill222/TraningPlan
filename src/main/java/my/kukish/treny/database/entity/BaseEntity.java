package my.kukish.treny.database.entity;

import java.io.Serializable;

public interface BaseEntity<T extends Serializable> {
    T getId();
}
