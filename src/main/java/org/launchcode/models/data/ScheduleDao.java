package org.launchcode.models.data;

import org.launchcode.models.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode
 */
@Repository
@Transactional
public interface ScheduleDao extends CrudRepository<Schedule, Integer> {
}
