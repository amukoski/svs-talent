package com.amukoski;

import com.amukoski.manager.HumanManager;
import com.amukoski.robotoperator.HumanRobotOperator;
import com.amukoski.worker.HumanWorker;
import com.amukoski.worker.RobotWorker;

public class FactoryApplication {
    public static void main(String[] args) {
        new HumanManager().manage(new HumanWorker());
        new HumanRobotOperator().run(new RobotWorker());
    }
}
