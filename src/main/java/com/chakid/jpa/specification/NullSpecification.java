package com.chakid.jpa.specification;

import javax.persistence.criteria.*;

/**
 * @author by chakid
 * @date 2025/4/28 09:53
 * @description
 */
public class NullSpecification<T> extends AbstractSpecification<T> {
    private final String property;

    public NullSpecification(String property) {
        this.property = property;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        From from = getRoot(property, root);
        String field = getProperty(property);
        return from.get(field).isNull();
    }
}