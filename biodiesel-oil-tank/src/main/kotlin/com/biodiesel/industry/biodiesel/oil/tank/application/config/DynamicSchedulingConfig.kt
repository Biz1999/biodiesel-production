package com.biodiesel.industry.biodiesel.oil.tank.application.config

import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.SchedulingConfigurer
import org.springframework.scheduling.config.ScheduledTaskRegistrar


//@Configuration
//@EnableScheduling
class DynamicSchedulingConfig: SchedulingConfigurer {

    override fun configureTasks(taskRegistrar: ScheduledTaskRegistrar) {
        TODO("Not yet implemented")
    }

}