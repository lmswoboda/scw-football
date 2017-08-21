
package org.launchcode.models.data;

import org.launchcode.models.GameRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by lynnstrauss on 8/21/17.
 */
@Repository
@Transactional
public interface GameRecordDao extends CrudRepository<GameRecord, Integer> {

}

