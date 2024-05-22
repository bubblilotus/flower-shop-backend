package com.flowershop.flowershop.dao;

import com.flowershop.flowershop.entity.Occasion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("http://ng-vera-flowers.s3-website.us-east-2.amazonaws.com")
@CrossOrigin("http://localhost:4200")

@RepositoryRestResource(collectionResourceRel = "occasion")
public interface OccationRepository extends JpaRepository<Occasion, Long> {
}
