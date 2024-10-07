package com.example.shop.service;

import com.example.shop.repository.model.ProductCatalogue;
import com.example.shop.ui.model.FilterProductsModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductCatalogueFilterCriteria {
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public ProductCatalogueFilterCriteria(EntityManager entityManager){
        this.entityManager =  entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public List<ProductCatalogue> filterProducts(FilterProductsModel filterProductsModel){
        CriteriaQuery<ProductCatalogue> criteriaQuery = criteriaBuilder.createQuery(ProductCatalogue.class);
        Root<ProductCatalogue> root = criteriaQuery.from(ProductCatalogue.class);
        Predicate predicate = getPredicateForProduct(filterProductsModel, root);
        criteriaQuery.where(predicate);
        setOrder(criteriaQuery, root);
        List<ProductCatalogue> productCatalogueList = entityManager.createQuery(criteriaQuery).getResultList();
        return productCatalogueList;
    }

    private void setOrder(CriteriaQuery<ProductCatalogue> criteriaQuery, Root<ProductCatalogue> root) {
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("productId")));
    }

    private Predicate getPredicateForProduct(FilterProductsModel filterProductsModel, Root<ProductCatalogue> root) {
        List<Predicate> predicates = new ArrayList<>();

        if(Objects.nonNull(filterProductsModel.getProductName())){
            Predicate namePredicate = criteriaBuilder.like(root.get("productName"), "%" + filterProductsModel.getProductName() + "%" );
            predicates.add(namePredicate);
        }
        if (Objects.nonNull(filterProductsModel.getProductPriceLessThan()) && Objects.nonNull(filterProductsModel.getProductPriceMoreThan())){
            Predicate price = criteriaBuilder.between(root.get("productPrice"), filterProductsModel.getProductPriceLessThan(), filterProductsModel.getProductPriceMoreThan());
            predicates.add(price);
        }
        if (Objects.nonNull(filterProductsModel.getColorName())){
            Predicate color = criteriaBuilder.equal(root.get("colorName"), filterProductsModel.getColorName());
            predicates.add(color);
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
