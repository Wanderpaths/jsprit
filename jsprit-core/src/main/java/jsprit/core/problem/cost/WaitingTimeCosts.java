package jsprit.core.problem.cost;

import jsprit.core.problem.driver.Driver;
import jsprit.core.problem.solution.route.activity.TourActivity;
import jsprit.core.problem.vehicle.Vehicle;

/**
 * Created by schroeder on 23/07/15.
 */
public class WaitingTimeCosts implements VehicleRoutingActivityCosts {

    @Override
    public double getActivityCost(TourActivity tourAct, double arrivalTime, Driver driver, Vehicle vehicle) {
        if (vehicle != null) {
            return vehicle.getType().getVehicleCostParams().perWaitingTimeUnit * Math.max(0., tourAct.getTheoreticalEarliestOperationStartTime() - arrivalTime);
        }
        return 0;
    }

}
