package ro.tuc.ds2020.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.entities.Activity;
import ro.tuc.ds2020.repositories.ActivityRepository;
import ro.tuc.ds2020.services.util.IActivityService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ActivityService implements IActivityService {
    private final long MILLISHOUR = 3600000;
    private final String SLEEP = "Sleeping";
    private final String LEAVE = "Leaving";
    private final String TOILET = "Toileting";

    private final ActivityRepository activityRepository;

    @Override
    public void processActivity(Activity activity) {
        activityRepository.save(activity);
        if (badActivity(activity)) {
            System.out.println(activity.toString());
        }
    }

    private boolean badActivity(Activity activity) {
        if (TOILET.equals(activity.getActivity())) {
            boolean toilet = activity.getTime_end() - activity.getTime_start() > 0.5 * MILLISHOUR;
            return toilet;
        }
        if (LEAVE.equals(activity.getActivity())) {
            boolean leave = activity.getTime_end() - activity.getTime_start() > 5 * MILLISHOUR;
            return leave;
        }
        if (SLEEP.equals(activity.getActivity())) {
            boolean sleep = activity.getTime_end() - activity.getTime_start() > 7 * MILLISHOUR;
            return sleep;
        }
        return false;
    }
}
