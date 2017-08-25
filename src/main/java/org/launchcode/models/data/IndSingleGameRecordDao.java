package org.launchcode.models.data;

import org.launchcode.models.IndSingleGameRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


/**
 * Created by lynnstrauss on 8/25/17.
 */

@Repository
@Transactional
public interface IndSingleGameRecordDao extends CrudRepository<IndSingleGameRecord, Integer> {
}
