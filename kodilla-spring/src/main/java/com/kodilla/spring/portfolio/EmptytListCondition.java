package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class EmptytListCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        TaskList taskList = (TaskList) context.getBeanFactory().getBean("toDoList");
        return taskList.getTasks().isEmpty();
    }
}
