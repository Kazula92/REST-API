package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskMapperTest {

    TaskMapper taskMapper= new TaskMapper();

    @Test
    public void shouldMapToTask() {
        //Given
        TaskDto taskDto= new TaskDto(1L, "title 1", "Content 1");

        //When
        Task task= taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getTitle(), task.getTitle());
        assertEquals(taskDto.getContent(), task.getContent());
    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        Task task= new Task(1L, "title 1", "Content 1");

        //When
        TaskDto taskDto= taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getTitle(), task.getTitle());
        assertEquals(taskDto.getContent(), task.getContent());
    }

    @Test
    public void shouldMapToTaskDtoList() {
        //Given
        Task task= new Task(1L, "title 1", "Content 1");
        List<Task> taskList= List.of(task);

        //When
        List<TaskDto> taskDto= taskMapper.mapToTaskDtoList(taskList);

        //then
        Task task1= taskList.get(0);
        TaskDto taskDto1= taskDto.get(0);
        assertEquals(taskDto1.getId(),task1.getId());
        assertEquals(taskDto1.getTitle(), task1.getTitle());
        assertEquals(taskDto1.getContent(), task1.getContent());

    }
}
