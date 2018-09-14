package org.launchcode.models.data;

import org.launchcode.models.Home;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by lynnstrauss on 8/21/18.
 */
@Repository
@Transactional
public interface HomeDao extends CrudRepository<Home, Integer> {

}
