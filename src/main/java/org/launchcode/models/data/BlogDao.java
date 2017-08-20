package org.launchcode.models.data;

import org.launchcode.models.Blog;
import org.launchcode.models.Roster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by lynnstrauss on 8/20/17.
 */

@Repository
@Transactional
public interface BlogDao extends CrudRepository<Blog, Integer> {



}
